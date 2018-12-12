###OpenJ9 Batch Processor

-

This is a project designed to show off the performance benefits of OpenJ9 when compared to Hotspot (comparisons to GraalVM and Amazon Corretto in the works). 

To compare the JVMs a Spring Boot application, that runs a Spring Batch job is used. 

The following steps are executed in the batch job:

* Reading records from a CSV file
* Perform a data transform on record to another object type
* Write to in-memory database using JPA
* Create a hash
* Perform some simple checks on records (simple logic and regexes)
* Transform object to JSON and print to console

The number of records read can be modified with the "run-type" property. Values are short (read 200 records), medium (read 10K records), long (default, read ~20K records). 

The code for the application is located under the "batch-processor" folder.

**Requirements:** Docker, Java 8, maven

Under the demos folder are a number of different scenarios:

**Scenario:** baseline openj9 vs hotspot

**Description:** Comparing the performance of the base Java 8 docker images of openJ9 and hotspot when running the above demo

**Scenario:** baseline openj9 vs tuned openj9 vs hotspot

**Description:** Comparing the performance of the base Java 8 docker images of openJ9 and hotspot to a tuned openJ9 JVM when running the above demo

**Scenario:** quickstart openJ9

**Description:** Showing the performance of OpenJ9 with quickstart enabled

**Scenario:** OpenJ9 JITaaS

**Description:** Showing the performance of OpenJ9 when using JIT as a Service (indevelopment)

**Scenario:** Shareclasses Demo

**Description:** Comparing the performance benefits of two different methods of using OpenJ9's class sharing feature with a "base" OpenJ9 JVM 
