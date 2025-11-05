#!/bin/bash


ID_FILE="liste-id.txt"


while read -r artifact_id; do
    echo "Téléchargement de l'artefact $artifact_id..."

    
    curl -L \
        -H "Accept: application/vnd.github+json" \
        -H "Authorization: Bearer $(cat ~/token.gh)" \
        -H "X-GitHub-Api-Version: 2022-11-28" \
        "https://api.github.com/repos/Mathieu27700/TP_R504/actions/artifacts/$artifact_id/zip" \
        --output "artifact_$artifact_id.zip"

  
    unzip -o "artifact_$artifact_id.zip" -d "artifact_$artifact_id"

done < "$ID_FILE"

#jq -r '.artifacts[] | .id' gh-artifacts.json > liste-id.txt | executer la commande avant de jouer le script


