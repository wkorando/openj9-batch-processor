/usr/bin/time docker run --name openj9_tuned oj9d_openj9_tuned:latest && echo openJ9 tuned && docker rm $(docker stop $(docker ps -a -q -f name=openj9_tuned)) &

/usr/bin/time docker run --name hotspot_baseline oj9d_hotspot_baseline:latest && echo hotspot baseline && docker rm $(docker stop $(docker ps -a -q -f name=hotspot_baseline)) &

/usr/bin/time docker run --name corretto_baseline oj9d_corretto_baseline:latest && echo corretto baseline && docker rm $(docker stop $(docker ps -a -q -f name=corretto_baseline)) &

/usr/bin/time docker run --name graalvm_baseline oj9d_graalvm_baseline:latest && echo graalvm baseline && docker rm $(docker stop $(docker ps -a -q -f name=graalvm_baseline)) &


