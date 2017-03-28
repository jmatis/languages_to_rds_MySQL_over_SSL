# test_java_to_mysql_over_ssl
simple java app to test ssl connection to mysql rds 

test / prove ssl works over mysql client : 

mysql -u user -p -h some.mysql.rds.url.amazonaws.com 
           --ssl-ca=/root/rds-combined-ca-bundle.pem --ssl-verify-server-cert
           
mysql> status;

...

SSL:                    Cipher in use is AES256-SHA

java -cp ".:mysql-connector-java-5.1.41-bin.jar" -Djavax.net.debug=ssl TestMySQLSSL

or 

java -cp ".:mysql-connector-java-5.1.41-bin.jar" -Djavax.net.debug=ssl \
     -Djavax.net.ssl.keyStore=/etc/pki/ca-trust/extracted/java/cacerts \
     -Djavax.net.ssl.keyStorePassword=changeit -Djavax.net.ssl.trustStorePassword=changeit \
     -Djavax.net.ssl.keyStore=/etc/pki/ca-trust/extracted/java/cacerts TestMySQLSSL
