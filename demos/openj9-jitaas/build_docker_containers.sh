cd ../../

docker build -f demos/openj9-jitaas/Dockerfile_openj9_JITaaS -t oj9d_jitaas_server . &

docker build -f demos/openj9-jitaas/Dockerfile_openj9_nojit -t oj9d_jitaas_client . &
