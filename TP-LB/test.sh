for i in {1..20}; do
    echo -n "Requête $i : "
    curl -s http://localhost:83
done