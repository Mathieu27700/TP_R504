#!/bin/bash

count1=0

n=500

for ((i=1;i<=n;i++)); do
    response=$(curl -s localhost:83)

    if [[ "$response" == "<h1>Hello 1</h1>" ]]; then
        ((count1++))
    fi
done

echo "Réponses Hello 1 : $count1"
