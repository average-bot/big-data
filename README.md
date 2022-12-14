# Big Data project with hadoop
## Determine the speeds in NYC
[Download the dataset here](https://www.kaggle.com/datasets/aadimator/nyc-realtime-traffic-speed-data "Dataset download") 

Prerequisites for running this project
 - Hadoop 3.3.0
 - Java 8
 - IntelliJ

Open command prompt as administratior
> cd C:\Hadoop-3.3.0\sbin
> start-dfs.cmd
> start-yarn.cmd

Create a new directory in hdfs
> hdfs dfs -mkdir /dirName
Upload file to hdfs 
> hdfs dfs -put <filepath on pc> /dirName

Import the hadoop libraries to the project
Create a jar of the java files and the libraries used in this repo
[IntelliJ jar tool](https://plugins.jetbrains.com/plugin/11438-handy-export-jar "IntelliJ export jar tool")

Run the jar file 
> hadoop jar <jar location> <packageName.ClassName> <filepath in hdfs> <output folder>

View the output
> hdfs dfs -cat /<outputfolder>/part-00000

To allow the audit logging add the following to your hadoop-env.cmd file located under C:\Hadoop-3.3.0\etc\hadoop
``` 
if not defined HDFS_AUDIT_LOGGER(
    set HDFS_AUDIT_LOGGER=INFO,RFAAUDIT
)
```
