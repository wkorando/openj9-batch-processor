docker run --network=host -p 38400:38400 --network=host --name openj9_jitaas_server  oj9d_jitaas_server:latest &

sleep 2

docker run --name openj9_jitaas_client_1 oj9d_jitaas_client:latest &

docker run --name openj9_jitaas_client_2 oj9d_jitaas_client:latest &