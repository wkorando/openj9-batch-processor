cd ../../

docker build -f demos/shareclasses-demo/Dockerfile_openj9_quickstart_short_run_cold -t oj9d_shareclasses_cold . &

docker build -f demos/shareclasses-demo/Dockerfile_openj9_quickstart_short_run_warm -t oj9d_shareclasses_warm . &

docker build -f demos/shareclasses-demo/Dockerfile_openj9_quickstart_short_run_shared_cache -t oj9d_shareclasses_shared_cache . &