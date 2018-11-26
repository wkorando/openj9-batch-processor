/usr/bin/time docker run --name openj9_warm oj9d_openj9_quickstart_short_run_warm:latest > null && echo openJ9 warm && docker rm $(docker stop $(docker ps -a -q -f name=openj9_warm)) > null &

/usr/bin/time docker run --name openj9_cold oj9d_openj9_quickstart_short_run_cold:latest > null  && echo openJ9 cold && docker rm $(docker stop $(docker ps -a -q -f name=openj9_cold)) > null &

/usr/bin/time docker run --name openj9_shared_cache --mount source=java-shared-classes,target=/cache oj9d_openj9_quickstart_short_run_shared_cache:latest > null && echo openJ9 shared cache && docker rm $(docker stop $(docker ps -a -q -f name=openj9_shared_cache)) > null &
