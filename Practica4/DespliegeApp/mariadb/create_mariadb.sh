#!/bin/bash



PORTAL_PATH=$HOME/sisinf
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

if [ ! -d $PORTAL_PATH ]; then
    mkdir $PORTAL_PATH
    chmod 755 $PORTAL_PATH
fi

if [ ! -d $PORTAL_PATH/mysql ]; then
    sudo mkdir $PORTAL_PATH/mysql
    sudo chmod 777 $PORTAL_PATH/mysql
fi
 
sudo rm -R -f $PORTAL_PATH/*
#unzip -X -o -d $PORTAL_PATH sisinf.zip
sudo chown -R 1001:root $PORTAL_PATH

docker stop ecobicizara-mariadb
docker rm ecobicizara-mariadb

sudo docker run -d --name ecobicizara-mariadb \
    -e MARIADB_ROOT_PASSWORD=sis_info_1920 \
    -e MARIADB_DATABASE=ecobicizara  \
    -p 3306:3306 \
    bitnami/mariadb:latest
#    -v $PORTAL_PATH/mysql:/bitnami/mariadb \

    

