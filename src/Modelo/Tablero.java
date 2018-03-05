package Modelo;

import Modelo.Casilla;

public class Tablero {

	private int numeroMinas = 10;
	private Casilla[][] casilla;
	private boolean ganador = false;
	private boolean perdedor = false;

	public Tablero(int tamano) {
		super();
		generaTablero(tamano);
		colocarMinas();
		colocarNumeros();
	}
	
	public int length() {
		return casilla.length;
	}

	public boolean isGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	public boolean isPerdedor() {
		return perdedor;
	}

	public void setPerdedor(boolean perdedor) {
		this.perdedor = perdedor;
	}

	/**
	 * Colocamos numeros en cada casilla
	 */
	private void colocarNumeros() {
		for (int filas = 0; filas < casilla.length; filas++) {
			for (int columnas = 0; columnas < casilla[0].length; columnas++) {
				if (casilla[filas][columnas].isMina()) {
					incrementarNumerosAlrededor(filas, columnas);
				}
			}
		}
	}

	/**
	 * incrementamos el numero de cada casilla segun las minas a su alrededor
	 * @param filas
	 * @param columnas
	 */
	private void incrementarNumerosAlrededor(int filas, int columnas) {
		for (int i = 0; i < 8; i++) {
			int[] coordenada = getCoordenadaAlrededor(filas, columnas, i);
			if (validarCoordenada(coordenada)) {
				incrementarValor(coordenada);
			}
		}
	}

	private void incrementarValor(int[] coordenada) {
		casilla[coordenada[0]][coordenada[1]]
				.setMinasAlrededor(casilla[coordenada[0]][coordenada[1]].getMinasAlrededor() + 1);
	}

	private boolean validarCoordenada(int[] coordenada) {
		return comprobarLimites(coordenada[0], 0, casilla.length)
				&& comprobarLimites(coordenada[1], 0, casilla[0].length);
	}

	private boolean comprobarLimites(int valor, int minimo, int maximo) {
		return valor >= minimo && valor < maximo;
	}

	/**
	 * sacamos todas las coordenadas alrededor de la casilla
	 * @param filas
	 * @param columnas
	 * @param i
	 * @return
	 */
	private int[] getCoordenadaAlrededor(int filas, int columnas, int i) {
		int[][] alrededor = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
		int[] coordenada = { filas + alrededor[i][0], columnas + alrededor[i][1] };
		return coordenada;
	}

	/**
	 * colocamos las minas en el tablero en posiciones automaticas
	 */
	private void colocarMinas() {
		for (int i = 0; i < numeroMinas; i++) {
			colocarUnaMina();
		}
	}

	private void colocarUnaMina() {
		int posX, posY;
		do {
			posX = (int) (Math.random() * casilla.length);
			posY = (int) (Math.random() * casilla.length);
		} while (casilla[posX][posY].isMina());
		casilla[posX][posY].setMina(true);
	}

	/**
	 * generar tablero nuevo
	 * @param tamano
	 */
	public void generaTablero(int tamano) {
		casilla = new Casilla[tamano][tamano];
		for (int i = 0; i < casilla.length; i++) {
			for (int j = 0; j < casilla[i].length; j++) {
				casilla[i][j] = new Casilla();
			}
		}
	}

	public Casilla[][] getCasilla() {
		return casilla;
	}

	public void setCasilla(Casilla[][] casilla) {
		this.casilla = casilla;
	}

	public Casilla getCasilla(int[] coordenada) {
		return casilla[coordenada[0]][coordenada[1]];
	}
}
