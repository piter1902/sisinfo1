#!/bin/bash

# Script que coge los ficheros de entrada (.csv) y los convierte 
#	a .csv separado por ; en lugar de por , .

dir_final="TRAFAIR_BIEN-CSV"

for fich in "$@"
do
	cat $fich | tr ',' ';' >"../$dir_final/$fich"
done

echo "Escritos $# ficheros en ../$dir_final"


