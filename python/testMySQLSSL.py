#!/usr/bin/python
user=""
passwd=""
host=""
db=""
ssl={‘cert’: ‘/root/mysql-ssl/client-cert.pem’}
db = MySQLdb.connect(host=host, user=user, passwd=passwd, db=db, ssl=ssl)
cursor = db.cursor()
cursor.execute(‘SHOW STATUS like “Ssl_cipher”‘)
print cursor.fetchone()
db.close()
