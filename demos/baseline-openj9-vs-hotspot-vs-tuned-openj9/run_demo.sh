docker run --name openj9_baseline  oj9d_openj9_baseline_medium_run:latest &

docker run --name openj9_tuned --mount source=java-shared-classes,target=/cache oj9d_openj9_tuned_medium_run:latest &

docker run --name hotspot_baseline  oj9d_hotspot_baseline_medium_run:latest &