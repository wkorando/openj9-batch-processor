docker restart $(docker ps -a -q -f name=openj9) $(docker ps -a -q -f name=hotspot)