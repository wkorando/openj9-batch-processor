cd ../../

docker build -f demos/baseline-openj9-vs-hotspot-vs-tuned-openj9/Dockerfile_hotspot_baseline_long_running -t oj9d_hotspot_baseline_long_running . &

docker build -f demos/baseline-openj9-vs-hotspot-vs-tuned-openj9/Dockerfile_openj9_baseline_long_running -t oj9d_openj9_baseline_long_running . &

docker build -f demos/baseline-openj9-vs-hotspot-vs-tuned-openj9/Dockerfile_openj9_tuned_long_running -t oj9d_openj9_tuned_long_running . &