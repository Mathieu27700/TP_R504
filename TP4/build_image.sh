docker build -t im-tp4 -f Dockerfile2 .
docker run -it -p 5000:5000 -v "$(pwd)/srv:/srv" im-tp4
