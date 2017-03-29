#!/usr/bin/python2.7
import MySQLdb
user=""
passwd=""
host=""
db=""
ssl={'ca': '/root/rds-combined-ca-bundle.pem', 'verify_cert': True}
db = MySQLdb.connect(host=host, user=user, passwd=passwd, db=db, ssl=ssl)
cursor = db.cursor()
cursor.execute('SHOW STATUS like "Ssl_cipher"')
print cursor.fetchone()
db.close()
