#!/bin/bash

docker stop nginx1 nginx2 loadbalancer

docker network rm tplb