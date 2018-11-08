clear

docker stats --format "table {{.Name}}\t{{.CPUPerc}}\t{{.MemUsage}}" $(docker ps -a -q -f name=hotspot) $(docker ps -a -q -f name=openj9)