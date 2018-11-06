docker rm $(docker stop -t 120 $(docker ps -a -q -f name=openj9)) &

docker rm $(docker stop $(docker ps -a -q -f name=hotspot))