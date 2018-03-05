package Modelo;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Control.Utiles;

public class Desvelar {

	/**
	 * comprobamos que tiene la casilla, si es mina o si esta velada
	 * 
	 * @param boton
	 * @param tablero
	 */

	public void comprobarCasilla(JButton boton, Tablero tablero) {
		int[] temp = new Utiles().obtenerCoordenada(boton);
		Casilla casilla = tablero.getCasilla(temp);
		if (casilla.isMina()) {
			desvelarMina(boton);
			tablero.setPerdedor(true);
		} else if (casilla.isVelada()) {
			if (casilla.isMarcada()) {
				//Abanderar.quitarBandera(boton);
			}
			casilla.setVelada(false);
			cambiarVistaCasilla(boton);
			introducirNumeroMina(boton, tablero, casilla);
		}
	}

	/**
	 * al ser mina la casilla la desvelamos y hacemos algunos cambios
	 * 
	 * @param boton
	 */
	private void desvelarMina(JButton boton) {
		boton.setBackground(Color.RED);
		boton.setBorder(new LineBorder(new Color(0, 0, 0)));
		boton.setEnabled(false);
		boton.setText("Mina");
	}

	/**
	 * hacemos cambios en la casilla que hemos cliqueado
	 * 
	 * @param boton
	 * @param tablero
	 */
	private void cambiarVistaCasilla(JButton boton) {
		boton.setEnabled(false);
		boton.setBackground(new Color(0, 0, 32));
		boton.setBorder(new LineBorder(new Color(50, 50, 125)));
	}

	/**
	 * introducimos el numero de la casilla seleccionada dependiendo del numero de
	 * minas a su alrededor
	 * 
	 * @param boton
	 * @param tablero
	 * @param casilla
	 */
	private void introducirNumeroMina(JButton boton, Tablero tablero, Casilla casilla) {
		int numeroMinas = casilla.getMinasAlrededor();
		boton.setText(String.valueOf(numeroMinas));
		if (casilla.getMinasAlrededor() == 0) {
			metodoRecursivo(casilla, boton, tablero);
		}
	}

	private void metodoRecursivo(Casilla casilla, JButton boton, Tablero tablero) {
		// TODO Auto-generated method stub
	}

	/**
	 * comprobamos si todos los componentes estan desvelados menos las minas
	 * 
	 * @param boton
	 * @param tablero
	 * @param contentPane
	 * @param components
	 * @return
	 */
	public boolean comprobarGanador(JButton boton, Tablero tablero, JPanel contentPane, Component[] components) {
		boolean ganador = true;
		int[] temp = new Utiles().obtenerCoordenada(boton);
		Casilla casilla = tablero.getCasilla(temp);
		components = contentPane.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (casilla.isVelada()) {
				if (!casilla.isMina()) {
					ganador = false;
				}
			}
		}
		return ganador;
	}

	/**
	 * mostramos todas las minas en el tablero
	 * 
	 * @param tablero
	 */
	public void explotarMinas(Tablero tablero) {
		Casilla[][] casillas = tablero.getCasilla();
		for (Casilla[] casillas2 : casillas) {
			for (Casilla casilla : casillas2) {
				if (casilla.isMina()) {
					casilla.setVelada(false);
				}
			}
		}
	}
}
