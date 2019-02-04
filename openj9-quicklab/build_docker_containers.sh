docker build -f Dockerfile_openj9_tuned_v1 -t oj9d_openj9_tuned_v1 . &

docker build -f Dockerfile_openj9_tuned_v2 -t oj9d_openj9_tuned_v2 . &

docker build -f Dockerfile_hotspot_baseline -t oj9d_hotspot_baseline . &

docker build -f Dockerfile_corretto_baseline -t oj9d_corretto_baseline . &

docker build -f Dockerfile_graalvm_baseline -t oj9d_graalvm_baseline . &



