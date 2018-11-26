cd ../../

docker build -f demos/quickstart-openj9/Dockerfile_openj9_quickstart_short_run_cold -t oj9d_hotspot_baseline_short_run . &

docker build -f demos/quickstart-openj9/Dockerfile_openj9_quickstart_short_run -t oj9d_openj9_quickstart_short_run . &

docker build -f demos/quickstart-openj9/Dockerfile_openj9_tuned_short_run -t oj9d_openj9_tuned_short_run . &