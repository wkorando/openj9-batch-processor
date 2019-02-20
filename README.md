# OpenJ9 Batch Processor

--

This project demonstrates the performance benefits of running Java applications on [Eclipse OpenJ9](https://www.eclipse.org/openj9/). 

Eclipse OpenJ9 is a fully compatible opensource JVM that is free for both download **and use** from [AdoptOpenJDK](https://adoptopenjdk.net/).

## About the Demo 

A [Spring Batch](https://spring.io/projects/spring-batch) application is used as a test article for comparing the JVMs to one another. At a high level the batch application performs the following actions: 

1. Read from CSV (number of records read is)
2. Perform data transform
3. Write to in-memory database (H2) using JPA
4. Performe SHA hashes on records
5. Performe checks on records 
6. Simple logic and regexes
7. Print to console
8. Transform and print object as JSON string to console

The source code for the application is avaliable [here](https://github.com/wkorando/openj9-batch-processor/tree/master/batch-processor).

Feedback is welcome on the design of a demo to properly compare JVMs to one another. The goal of this demo was to be able to easily compare throughput and minimize dependencies on external (to the JVM) dependencies. 

## Running the Demo