#!/bin/bash

# lancement serveur sql
docker run --rm -d \
    --name tp4-sql \
    --env MYSQL_ROOT_PASSWORD=foo \
    --network net-tp4 \
    -p 3307:3306 \
    -v vol-sql-demo:/var/lib/mysql \
    mysql:8.0