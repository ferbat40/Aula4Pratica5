@echo off
call mvn clean package
call docker build -t br/AulaPritica5 .
call docker rm -f AulaPritica5
call docker run -d -p 9080:9080 -p 9443:9443 --name AulaPritica5 br/AulaPritica5