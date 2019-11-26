package org.iesalandalus.programacion.peonajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Peon peon;

	public static void main(String[] args) {

	}

	private static void mostrarPeon() {
		System.out.println(peon.toString());
	}

	private static void mostrarMenu() {
		System.out.println("Introduca una opción: ");
		System.out.println("1.crear un peón por defecto");
		System.out.println("2.crear un peón de un color");
		System.out.println("3.crear un peón de un color en una columna inicial dada");
		System.out.println("4.mover el peón ");
		System.out.println("5.salir");
	}

	private static int elegirOpcion() {
		int menu;
		do {
			menu = Entrada.entero();
		} while (menu < 1 || menu > 5);

		return menu;

	}

	private static void crearPeonDefecto() {
		peon = new Peon();
	}

	private static void crearPeonColor() {
		peon = new Peon(elegirColor());
	}

	private static Color elegirColor() {
		Color color = null;
		int menuColor;

		do {
			System.out.println("Introduzca un número para elegir color del peón: 1.blanco, 2.negro");
			menuColor = Entrada.entero();

		} while (menuColor < 1 || menuColor > 2);

		switch (menuColor) {

		case 1:
			return Color.BLANCO;
		case 2:
			return Color.NEGRO;
		}

		return null;
	}

	private static void crearPeonColorColumna() {
		peon = new Peon(elegirColor(), elegirColumnaInicial());
	}

	private static char elegirColumnaInicial() {
		char columna;

		do {
			System.out.println("¿cuál es su columna inicial?de la a hasta la h");
			columna = Entrada.caracter();

		} while (columna < 'a' || columna > 'h');

		return columna;

	}

	private static void mover() {
		mostrarMenuMovimientos();
		realizarMovimiento(elegirMovimiento());

	}


	private static void mostrarMenuMovimientos() {
		System.out.println("Introduca un opción para el movimiento del peón: ");
		System.out.println("1.avanzar peón un paso");
		System.out.println("2.avanzar peón dos pasos");
		System.out.println("3.avanzar peón hacia la izquierda ");
		System.out.println("4.avanzar peón hacia la derecha");
	}

	private static int elegirMovimiento() {
		int menu;
		do {
			menu = Entrada.entero();
		} while (menu < 1 || menu > 4);

		return menu;
	}

	private static void realizarMovimiento(int opcionMovimiento) {

		try {
			switch (opcionMovimiento) {
			case 1:

				peon.mover(1);
				break;

			case 2:

				peon.mover(2);
				break;

			case 3:

				peon.mover(Direccion.IZQUIERDA);
				break;

			case 4:

				peon.mover(Direccion.DERECHA);

				break;

			default:
				break;
			}
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}
}
