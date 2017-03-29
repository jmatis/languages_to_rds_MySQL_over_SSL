#!/bin/bash


git clone https://github.com/go-sql-driver/mysql.git src/github.com/go-sql-driver/mysql
GOPATH=$(pwd)
go build testMySQLSSL.go
