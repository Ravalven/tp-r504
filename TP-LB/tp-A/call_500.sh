#!/bin/bash

nginx1_count=0
nginx2_count=0

for ((i=1;i<=500;i++)); do 
    reponses=$(curl -s http://localhost:83)
    if [[ $reponses == *"Hello 1"* ]]; then
        nginx1_count=$((nginx1_count + 1))
    fi
    if [[ $reponses == *"Hello 2"* ]]; then
        nginx2_count=$((nginx2_count + 1))
    fi
done 

echo "call nginx1 = $nginx1_count"
echo "call nginx2 = $nginx2_count"