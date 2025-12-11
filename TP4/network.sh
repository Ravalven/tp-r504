#!/bin/bash

echo "Création du network"
docker network create --driver bridge net-tp4 2>/dev/null 
    || echo "Network créé"

echo "Affichage des network :"
docker network ls