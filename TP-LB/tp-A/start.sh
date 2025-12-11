#!/bin/bash

docker network create tplb > /dev/null 2>&1 

docker build -t im-nginx-lb .

mkdir -p shared1 shared2

echo "<h1>Hello 1" > shared1/index.html
echo "<h1>Hello 2" > shared2/index.html

docker run -d \
    --name nginx1 \
    -p 81:80 \
    -v $PWD/shared1:/usr/share/nginx/html \
    --network tplb \
    --rm \
    nginx

docker run -d \
    --name nginx2 \
    -p 82:80 \
    -v $PWD/shared2:/usr/share/nginx/html \
    --network tplb \
    --rm \
    nginx

docker run -d \
    --name loadbalancer \
    --network tplb \
    -p 83:80 \
    --rm \
    im-nginx-lb
