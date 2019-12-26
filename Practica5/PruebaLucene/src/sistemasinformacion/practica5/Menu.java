package sistemasinformacion.practica5;

import java.io.Closeable;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu implements Closeable{
	
	private Scanner S;

	public Menu() {
		this.S = new Scanner(System.in);
	}
	
	@Override
	public void close() throws IOException {
		S.close();		
	}

	public static void main(String[] args) {
		int op = 0;
		Menu menu = new Menu();
		do {
			menu.mostrarOptions();
			op = menu.elegirOption();
			switch (op) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				// No deberias estar aqui nunca
				System.exit(-1);
			}
			System.out.println(String.format("Ha seleccionado usted %d", op));
		} while (op != 4);
		// Final de la operativa. Cerramos el objeto
		try {
			menu.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int elegirOption() {
		// Usamos Scanner como metodo de lectura
		int n;
		do {
			try {
				n = S.nextInt();
			} catch (InputMismatchException ime) {
				// El tipo de dato introducido no era un int
				// Limpiamos la entrada de Scanner hasta el fin de linea
				S.nextLine();
				// n = -1 -> Se cumple la condicion del bucle.
				n = -1;
			}
		} while (n < 1 || n > 4);
		return n;
	}

	private void mostrarOptions() {
		System.out.println("Elige una opcion:");
		System.out.println(String.format("%3s.-\t%s", "1", "Indexar un documento"));
		System.out.println(String.format("%3s.-\t%s", "2", "Añadir un documento al índice"));
		System.out.println(String.format("%3s.-\t%s", "3", "Buscar un término"));
		System.out.println(String.format("%3s.-\t%s", "4", "Salir"));
	}
}
