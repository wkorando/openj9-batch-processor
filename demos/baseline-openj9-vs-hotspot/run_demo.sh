docker run --name openj9_baseline oj9d_openj9_baseline:latest &

docker run --name hotspot_baseline oj9d_hotspot_baseline:latest

docker rm $(docker stop -t 30 $(docker ps -a -q -f name=openj9))

docker rm $(docker stop -t 30 $(docker ps -a -q -f name=hotspot))