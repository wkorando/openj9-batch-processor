docker swarm init

HOSTNAME=$docker-dashboard docker stack deploy -c ../prometheus/docker-stack.yml prom