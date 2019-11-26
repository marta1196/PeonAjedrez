package org.iesalandalus.programacion.peonajedrez;



public class Peon {

	private Color color;
	private Posicion posicion;

	public Peon() {

		setColor(Color.NEGRO);
		setPosicion(new Posicion(7, 'd'));
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



}