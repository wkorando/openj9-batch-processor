# OpenJ9 Batch Processor

**NOTE:** To view the original version of this project, checkout the [v1.0.0 branch](https://github.com/wkorando/openj9-batch-processor/tree/v1.0.0)

This project demonstrates the performance benefits of running Java applications on [Eclipse OpenJ9](https://www.eclipse.org/openj9/). 

Eclipse OpenJ9 is a fully compatible opensource JVM that is free for both download **and use** from [AdoptOpenJDK](https://adoptopenjdk.net/).

## Presentation

This demo is used in the presentation **OpenJ9 a Lean, Mean, Java Virtual Machine**

Slides to the presentation are available here: [https://ibm.biz/Bd2umZ](https://ibm.biz/Bd2umZ)

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

### Disclaimer

This project and presentation have ongoing improvements made to them. They might change a bit over time, but always with the intent of improving upon the content to make it more informative, helpful, easier to use, and give a more accurate representation of OpenJ9's performance relative to other available JVM implementations. 