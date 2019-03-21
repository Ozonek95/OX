#!/bin/bash
if [ "$#" == 1 ]; then
mvn clean install -DskipTests 
 
java -jar target/TicTacToe-0.1.jar $1 > test.output 

else 
	echo I need 1 argument
fi
