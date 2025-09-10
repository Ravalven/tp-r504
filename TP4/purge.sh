docker rm -f $(docker ps -a -q)
docker volume prune -f
docker network prune -f
