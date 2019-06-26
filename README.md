# Kafka Stream Unit Testing Failure
This repo is a minimal example to reproduce an error when attempting to
unit test a processor with an `InMemoryWindowStore` which is leading
to a `ClassCastException` when it attempts to cast a `MockProcessorContext`
to an `InternalProcessorContext`.

`mvn --version` outputs:
```
Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-03T13:39:06-06:00)
Maven home: ~/opt/apache-maven-3.5.0
Java version: 1.8.0_212, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-8-openjdk-amd64/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.15.0-52-generic", arch: "amd64", family: "unix"
```
