package org.iesalandalus.programacion.peonajedrez;

import javax.naming.OperationNotSupportedException;

public class Peon {

	private Color color;
	private Posicion posicion;

	public Peon() {

		setColor(Color.NEGRO);
		setPosicion(new Posicion(7, 'd'));
	}

	public Peon(Color color) {
		setColor(color);
		if (color.equals(Color.BLANCO)) {
			setPosicion(new Posicion(2, 'd'));
		}
		if (color.equals(Color.NEGRO)) {
			setPosicion(new Posicion(7, 'd'));
		}
	}
	public Peon(Color color, char columna) {

		setColor(color);

		if (columna != 'd') {

			if (color.equals(Color.BLANCO)) {
				setPosicion(new Posicion(2, columna));
			}
			if (color.equals(Color.NEGRO)) {
				setPosicion(new Posicion(7, columna));
			}
		} else {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}

	}

	public Color getColor() {
		return color;
	}

	private void setColor(Color color) {
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		} else {
			this.color = color;
		}
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public void mover(int paso) throws OperationNotSupportedException {
		if (paso != 1 && paso != 2) {
			throw new OperationNotSupportedException("ERROR: El peón sólo se puede mover 1 o 2 pasos.");
		} else {

			switch (paso) {

			case 1:

				try {

					if (color.equals(Color.BLANCO))
						posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna()));

					if (color.equals(Color.NEGRO))
						posicion = new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna()));

				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
				break;

			case 2:
				if (posicion.getFila() != 2 && posicion.getFila() != 7) {
					throw new OperationNotSupportedException(
							"ERROR: El peón sólo se puede mover 2 pasos cuando se encuentra en la casilla inicial.");
				} else {

					if (color.equals(Color.BLANCO) && posicion.getFila() == 2)
						posicion = new Posicion(posicion.getFila() + 2, (char) (posicion.getColumna()));

					if (color.equals(Color.NEGRO) && posicion.getFila() == 7)
						posicion = new Posicion(posicion.getFila() - 2, (char) (posicion.getColumna()));

				}
				break;
			}
		}

	}

	public void mover(Direccion direccion) throws OperationNotSupportedException {

		if (direccion == null)
			throw new NullPointerException("ERROR: Mover el peón en una dirección nula no está permitido.");

		switch (direccion) {

		case DERECHA:
			try {
				if (color.equals(Color.BLANCO))
					posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() + 1));

				if (color.equals(Color.NEGRO))
					posicion = new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() + 1));

			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;

		case IZQUIERDA:
			try {
				if (color.equals(Color.BLANCO))
					posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() - 1));

				if (color.equals(Color.NEGRO))
					posicion = new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() - 1));

			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		}

	}


}