/usr/bin/time docker run --name openj9_baseline oj9d_openj9_baseline:latest && echo openJ9 Java 8 baseline && docker rm $(docker stop $(docker ps -a -q -f name=openj9_baseline)) &

/usr/bin/time docker run --name openj9_tuned oj9d_openj9_tuned:latest && echo openJ9 tuned && docker rm $(docker stop $(docker ps -a -q -f name=openj9_tuned)) &