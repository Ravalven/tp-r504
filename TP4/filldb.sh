#!/bin/bash

# mysql -u root -p'foo' -h 127.0.0.1 --port=3307 -e "SELECET COUNT(*) FROM myTable;" demosql
#     || mysql -u root -p'foo' -h 127.0.0.1 --port=3307 < data.sql

mysql -u root -p'foo' -h 127.0.0.1 --port=3307 < data.sql