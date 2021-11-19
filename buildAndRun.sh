#!/bin/sh
mvn clean package && docker build -t br/AulaPritica5 .
docker rm -f AulaPritica5 || true && docker run -d -p 9080:9080 -p 9443:9443 --name AulaPritica5 br/AulaPritica5