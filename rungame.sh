#!/bin/bash

mvn clean install -DskipTests
java -jar target/TicTacToe-0.1.jar
