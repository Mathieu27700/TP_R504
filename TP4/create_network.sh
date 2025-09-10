docker network create --driver bridge net-tp4

echo "Liste des réseaux"
docker network ls | grep net-tp4

