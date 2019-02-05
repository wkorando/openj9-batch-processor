# Introducing Eclipse OpenJ9

OpenJ9 is an open source JVM implementation backed by IBM and the Eclipse Foundation. 

OpenJ9 is a free to use JVM dual licensed under the EPLv2 with CE and Apache License. 

In this demo we compare OpenJ9 to the other prominent JVM implementations of Hotspot, Amazon Corretto, and GraalVM. 

## The Demo

In this demo we are running a Spring-Boot batch application. 

The batch application is:

1. Reading in a 20,000 record file
2. Performing a transform on the record
3. Performing a few simple checks including a regex
4. Writing the records to an in-memory (H2) database
5. Transforming the records to JSON

## The JVMs

In the demo we are comparing the baselines (i.e. no JVM tuning) of Hotspot, GraalVM, and Amazon Corretto to a tuned OpenJ9 JVM. 

The JVM args being used to tune OpenJ9 are:

-Xms128m (setting initial heap space to 128 MBs)
-Xshareclasses:cacheDir=/cache,readOnly (reading from a share classes cache)
-XX:-UseContainerSupport (turning off container support) 

---

# Running the demo

In the terminal under the directory `~/Documents/openj9-batch-processor/openj9-quicklab`, execute `./run-demo.sh`

Demo takes approx. 2 minutes to complete and it will take ~10 seconds before the graph starts populating. 

If grafana stops working under above directory execute `docker swarm leave --force` and then `./start-grafana.sh` 

If you want to make changes to the Dockerfiles, once done execute `./build-containers.sh` to rebuild and properly name the docker containers. 