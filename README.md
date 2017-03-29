# languages_to_rds_MySQL_over_SSL
simple apps in various programming languages to test ssl connection to mysql rds 

# AWS RDS SSL certificate
http://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/UsingWithRDS.SSL.html

to download it run:

wget https://s3.amazonaws.com/rds-downloads/rds-combined-ca-bundle.pem 

# Proof of SSL access to your RDS MySQL instance
mysql -u user -p -h some.mysql.rds.url.amazonaws.com 
           --ssl-ca=/root/rds-combined-ca-bundle.pem --ssl-verify-server-cert
           
mysql> status;

...

SSL:                    Cipher in use is AES256-SHA
