docker run --name openj9_warm --mount source=java-core-dump,target=/coredump oj9d_openj9_quickstart_short_run_warm:latest &

docker rm $(docker stop $(docker ps -a -q -f name=openj9_warm)) > null 