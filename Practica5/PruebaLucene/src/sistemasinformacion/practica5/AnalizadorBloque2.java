package sistemasinformacion.practica5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.lucene.store.Directory;

public class AnalizadorBloque2 {
		private Collection <String> ficheros;
		
		public AnalizadorBloque2() {
			 ficheros = new ArrayList <String>();
		}
		
		public void indexarDirectorio(String directorio) {
			File dir = new File(directorio);
			if(dir.isDirectory()) {
				procesarFicheros(dir);
				System.out.println("Ficheros indexados correctamente.");
			}else {
				System.out.println("ERROR: El archivo indicado no existe o no es un directorio.");
			}
		}
		
		private void procesarFicheros(File directorio) {
			// Obtenemos todos los archivos del directorio
			File[] ficherosDirectorio = directorio.listFiles();
			// Recorremos el array de ficheros del directorio indicado
			for (File fich : ficherosDirectorio) {
				if(fich.isDirectory()) {
					procesarFicheros(fich);
				}else {
					ficheros.add(fich.getName());
				}
			}
		}
		
		public void AgnadirDocumentoIndice(String documento) {
			File docu = new File(documento);
			// Comprobamos si realmente existe y no es un directorio
			if(docu.isFile() && !docu.isDirectory()) {
				ficheros.add(docu.getName()); // Añadimos el archivo al conjunto de ficheros
				System.out.println("Fichero indexados correctamente.");
			}else {
				System.out.println("ERROR: El archivo indicado no existe o es un directorio.");
			}
			
		}
		
		public void buscarTermino(String termino) throws IOException {
			Collection<String> queries = new ArrayList<String>();
			queries.add(termino);
			// Creamos el idexador / buscador
			IndexadorYBuscador ejemplo = new IndexadorYBuscador(ficheros, queries);

			// Indexamos los ficheros
			Directory directorioDelIndiceCreado = ejemplo.crearIndiceEnUnDirectorio();

			// Abrimos un ficher indexado previamente
			// Directory directorioDelIndiceCreado =
			// MMapDirectory.open(Paths.get(INDEXDIR));

			// Ejecutamos la búsqueda de las palabras clave
			ejemplo.buscarQueries(directorioDelIndiceCreado, ficheros.size(), 1);
		}
}
