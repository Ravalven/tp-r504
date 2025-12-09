# Créer un réseau interne
docker network create tplb > /dev/null 2>&1

# Construire l’image im-nginx-lb
docker build -t im-nginx-lb -f tp-A/Dockerfile .

# Créer les dossiers shared1 et shared2
mkdir -p shared1 shared2

# Générer les index.html
echo "
Hello 1
" > shared1/index.html
echo "
Hello 2
" > shared2/index.html

# Lancer les conteneurs nginx1 et nginx2
docker run -d --rm --name nginx1 --network tplb -p 81:80 -v $(pwd)/shared1:/usr/share/nginx/html nginx

docker run -d --rm --name nginx2 --network tplb -p 82:80 -v $(pwd)/shared2:/usr/share/nginx/html nginx
# Lancer le conteneur load-balancer
docker run -d --rm --name nginx-lb --network tplb -p 83:80 im-nginx-lb
