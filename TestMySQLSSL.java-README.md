# test_java_to_mysql_over_ssl
simple java app to test ssl connection to mysql rds 

I presume you have spinned up simple AWS ec2 instance with for example Amazon Linux AMI release 2016.09

prerequisites: 
1. java and javac
yum -y install java-1.8.0-openjdk java-1.8.0-openjdk-devel
2. wget
yum -y install wget
3. AWS RDS certificate properly imported to java keystore (https://gist.github.com/steini/d40a59ae4a9036c4d5a4) 
./import-rds-certs.sh
