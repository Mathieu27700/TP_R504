#!/bin/bash

echo "[a] Création du réseau Docker interne..."
docker network create tplb 2>/dev/null

echo "[b] Construction de l'image im-nginx-lb..."
if ! docker build -t im-nginx-lb ./tp-A ; then
    echo " Erreur : impossible de construire l'image im-nginx-lb"
    exit 1
fi

echo "[c] Création des dossiers shared1 et shared2..."
mkdir -p shared1 shared2

echo "[d] Création des fichiers index.html..."
echo "<h1>Hello 1</h1>" > shared1/index.html
echo "<h1>Hello 2</h1>" > shared2/index.html

echo "[e] Lancement des conteneurs nginx1 et nginx2..."
docker run -d --rm \
    --name nginx1 \
    -p 81:80 \
    --network tplb \
    -v "$(pwd)/shared1:/usr/share/nginx/html" \
    nginx

docker run -d --rm \
    --name nginx2 \
    -p 82:80 \
    --network tplb \
    -v "$(pwd)/shared2:/usr/share/nginx/html" \
    nginx

echo "[f] Lancement du conteneur load-balancer..."
docker run -d --rm \
    --name nginx-lb \
    -p 83:80 \
    --network tplb \
    im-nginx-lb


