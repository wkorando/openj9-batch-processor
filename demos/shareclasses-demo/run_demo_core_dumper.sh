docker run --name openj9_warm --mount source=java-core-dump,target=/coredump oj9d_openj9_quickstart_short_run_warm:latest && echo openJ9 warm && docker rm $(docker stop $(docker ps -a -q -f name=openj9_warm)) > null &

docker run --name openj9_cold --mount source=java-core-dump,target=/coredump oj9d_openj9_quickstart_short_run_cold:latest > null  && echo openJ9 cold && docker rm $(docker stop $(docker ps -a -q -f name=openj9_cold)) > null &

docker run --name openj9_shared_cache --mount source=java-shared-classes,target=/cache --mount source=java-core-dump,target=/coredump oj9d_openj9_quickstart_short_run_shared_cache:latest > null && echo openJ9 shared cache && docker rm $(docker stop $(docker ps -a -q -f name=openj9_shared_cache)) > null &

sleep 4

docker exec -it $(docker ps -a -q -f name=openj9_warm) kill -3 1

docker exec -it $(docker ps -a -q -f name=openj9_shared_cache) kill -3 1

docker exec -it $(docker ps -a -q -f name=openj9_cold) kill -3 1
