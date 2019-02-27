/usr/bin/time docker run --name openj9_baseline oj9d_openj9_baseline:latest && echo openJ9 Java 8 baseline && docker rm $(docker stop $(docker ps -a -q -f name=openj9_baseline)) &

/usr/bin/time docker run --name hotspot_baseline oj9d_hotspot_baseline:latest && echo hotspot Java 8 baseline && docker rm $(docker stop $(docker ps -a -q -f name=hotspot_baseline)) &

/usr/bin/time docker run --name openj9_11_baseline oj9d_openj9_11_baseline:latest && echo openJ9 Java 11 baseline && docker rm $(docker stop $(docker ps -a -q -f name=openj9_11_baseline)) &

/usr/bin/time docker run --name hotspot_11_baseline oj9d_hotspot_11_baseline:latest && echo hotspot Java 11 baseline && docker rm $(docker stop $(docker ps -a -q -f name=hotspot_11_baseline)) &
