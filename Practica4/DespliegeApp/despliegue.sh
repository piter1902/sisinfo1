#!/bin/bash

cd mariadb
sudo bash ./create_mariadb.sh
cd ..


cd tomcat
sh ./arranque_tomcat.sh
