#!/bin/bash

count1=0
count2=0
n=500

for ((i=1;i<=n;i++)); do
    response=$(curl -s localhost:83)

    if [[ "$response" == "<h1>Hello 1</h1>" ]]; then
        ((count1++))
    elif [[ "$response" == "<h1>Hello 2</h1>" ]]; then
        ((count2++))
    else
        echo "Réponse inattendue : $response"
    fi
done

echo "Réponses Hello 1 : $count1"
echo "Réponses Hello 2 : $count2"

percent1=$((count1 * 100 / n))
percent2=$((count2 * 100 / n))

echo "Répartition : Hello 1 = $percent1%, Hello 2 = $percent2%"
