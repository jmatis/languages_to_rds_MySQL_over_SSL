#!/bin/bash

# first download and unpack mysql connector (if not already downloaded)
if [ ! -f "mysql-connector-java-5.1.41-bin.jar" ]; then
  wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.1.41.tar.gz
  tar xf mysql-connector-java-5.1.41.tar.gz mysql-connector-java-5.1.41/mysql-connector-java-5.1.41-bin.jar
  mv mysql-connector-java-5.1.41/mysql-connector-java-5.1.41-bin.jar ./
  rmdir mysql-connector-java-5.1.41
fi

# now compile our java code (i have tested this in java8
if [ ! -f "TestMySQLSSL.class" ]; then
  javac TestMySQLSSL.java
fi

# java -cp ".:mysql-connector-java-5.1.41-bin.jar" -Djavax.net.debug=ssl TestMySQLSSL
java -cp ".:mysql-connector-java-5.1.41-bin.jar" TestMySQLSSL

rm -f TestMySQLSSL.class
