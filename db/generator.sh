#!/bin/bash

function vocalizer() {
  input=$1
  output=""
  vowels=(a e i o u)
  for (( i=0; i<${#input}; i++ )); do
    char=${input:$i:1}
    output="${output}${char}"
    if [[ "$i" -ne $((${#input}-1)) ]]; then
      nextchar=${input:$(($i+1)):1}
      if [[ "${vowels[*]}" =~ "${char}" || "${vowels[*]}" =~ "${nextchar}" ]]; then
        output="${output}"
      else
        output="${output}a"
      fi
    fi
  done
  echo $output
}

function random_firstname() {
    firstname=$(cat /dev/urandom | tr -dc 'a-z' | fold -w 5 | head -n 1)
    echo "$(vocalizer ${firstname^})"
}

# function to generate random surname
function random_surname() {
    surname=$(cat /dev/urandom | tr -dc 'a-z' | fold -w 10 | head -n 1)
    echo "$(random_firstname)ovich"
}

function random_lastname() {
    lastname=$(cat /dev/urandom | tr -dc 'a-z' | fold -w 5 | head -n 1)
    echo "$(vocalizer ${lastname^})ov"
}

for i in {1..20}; do
    firstname=$(random_firstname)
    surname=$(random_surname)
    lastname=$(random_lastname)

    mysql -uroot -p"$MYSQL_ROOT_PASSWORD" -D "$MYSQL_DATABASE" -e "INSERT INTO persons (first_name, sur_name, last_name) VALUES ('$firstname', '$surname', '$lastname')"
done

mysql -uroot -p"$MYSQL_ROOT_PASSWORD" -D "$MYSQL_DATABASE" -e "INSERT INTO learners (person_id, status_id, degree_id) SELECT person_id, FLOOR(RAND() * 3) + 1, FLOOR(RAND() * 3) + 1 FROM persons ORDER BY RAND() LIMIT 20;"

