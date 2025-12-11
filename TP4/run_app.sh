#!/bin/bash

#Ancienne app en lien avec Dockerfile1
# docker run -d \
#     --name tp4-app \
#     --network net-tp4 \
#     -p 5000:5000 \
#     im-tp4

#App actuelle en lien avec Dcokerfile2
docker run -d \
   --name tp4-app-bindmount \
   --network net-tp4 \
   -p 5000:5000 \
   -v $(pwd)/srv:/srv \
   im-tp4-bindmount
