docker swarm init

HOSTNAME=$docker-dashboard docker stack deploy -c docker-stack.yml prom