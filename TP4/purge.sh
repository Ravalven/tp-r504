#!/bin/bash

containers=$(docker ps -aq)

read -p "Do you want to remote all your containers ? [y/N] " answer

answer=${answer,,}

if [[ "$answer" == "y" ]]; then
    echo "Suppression des conteneurs..."
    if [ -n "$containers" ]; then
        docker stop $containers >/dev/null 2>&1
        docker rm $containers >/dev/null 2>&1
        echo "Tous les conteneurs ont été supprimés"
    fi
fi

docker system prune -a --volumes
exit 0