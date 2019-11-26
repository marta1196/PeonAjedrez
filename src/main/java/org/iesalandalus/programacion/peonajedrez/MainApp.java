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

}
