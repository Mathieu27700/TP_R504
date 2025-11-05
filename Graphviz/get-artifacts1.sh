#!/bin/bash
curl -L \
 -H "Accept: application/vnd.github+json" \
 -H "Authorization: Bearer $(cat ~/token.gh)" \
 -H "X-GitHub-Api-Version: 2022-11-28" \
 https://api.github.com/repos/Mathieu27700/TP_R504/actions/artifacts \
 > gh-artifacts.json

curl -L \
 -H "Accept: application/vnd.github+json" \
 -H "Authorization: Bearer $(cat ~/token.gh)" \
 -H "X-GitHub-Api-Version: 2022-11-28" \
 "https://api.github.com/repos/Mathieu27700/TP_R504/actions/artifacts/4472114083/zip" \
 --output artifact.zip

unzip artifact.zip
