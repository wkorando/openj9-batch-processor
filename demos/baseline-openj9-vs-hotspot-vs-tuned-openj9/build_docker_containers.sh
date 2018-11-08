cd ../../

docker build -f demos/baseline-openj9-vs-hotspot-vs-tuned-openj9/Dockerfile_hotspot_baseline_medium_run -t oj9d_hotspot_baseline_medium_run . &

docker build -f demos/baseline-openj9-vs-hotspot-vs-tuned-openj9/Dockerfile_openj9_baseline_medium_run -t oj9d_openj9_baseline_medium_run . &

docker build -f demos/baseline-openj9-vs-hotspot-vs-tuned-openj9/Dockerfile_openj9_tuned_medium_run -t oj9d_openj9_tuned_medium_run . &