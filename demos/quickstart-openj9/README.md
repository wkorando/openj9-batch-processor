Tuning Guide

"-Xtune:virtualized", #Optimizes the VM for virtualized environments
"-Xshareclasses", #Allows JVMs to share ROM classes
"-Xscmx=50M", #Sets the size of the shareclasses cache to 50M
"-XX:+IdleTuningCompactOnIdle", #Compacts the heap (like defragmenting a hard drive), makes the below step more effective
"-XX:+IdleTuningGcOnIdle", #Releases unused heap memory back to the system
"-XX:IdleTuningMinIdleWaitTime=5", #Wait 5 seconds once in idle to perform idle GC operations
"-XX:+UseContainerSupport", #Tells the VM to aggressively use all available memory as applications in containers typically only thing running
"batch-processor-0.0.1-SNAPSHOT.jar",
"--spring.main.web-application-type=NONE" #Will keep the Java application running to demonstrate idle GC improvements 