#!/bin/bash

mvn -f config/pom.xml clean package
mvn -f discovery/pom.xml clean package
mvn -f gateway/pom.xml clean package
mvn -f product-service/pom.xml clean package
mvn -f customer-service/pom.xml clean package
mvn -f order-service/pom.xml clean package
