simple python script to test ssl connection to mysql rds

I presume you have spinned up simple AWS ec2 instance with for example Amazon Linux AMI release 2016.09

# Prerequisites:
1. python2.7 and MySQL-python27

yum -y install MySQL-python27

2. AWS RDS SSL certificate 

wget https://s3.amazonaws.com/rds-downloads/rds-combined-ca-bundle.pem

# To run this you need:
1. update testMySQLSSL.py to contain correct content for variables user, passwd, host and db

2. run it
