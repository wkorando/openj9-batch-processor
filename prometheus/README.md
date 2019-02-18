# Introducing Eclipse OpenJ9

OpenJ9 is an open source JVM implementation backed by IBM and the Eclipse Foundation. 

OpenJ9 is a free to use JVM dual licensed under the EPLv2 with CE and Apache License. 

In this demo we compare OpenJ9 to the other prominent JVM implementations of Hotspot, Amazon Corretto, and GraalVM. 


---

# Running the demo

In the terminal under the directory `~/Documents/openj9-batch-processor/openj9-quicklab`, execute `./run-demo.sh`

Demo takes approx. 2 minutes to complete and it will take ~10 seconds before the graph starts populating. 

If grafana stops working under above directory execute `docker swarm leave --force` and then `./start-grafana.sh` 

If you want to make changes to the Dockerfiles, once done execute `./build-containers.sh` to rebuild and properly name the docker containers. 