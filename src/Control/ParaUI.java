package Control;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import Vista.buscaminasUi;
import Modelo.Abanderar;
import Modelo.Casilla;
import Modelo.Desvelar;
import Modelo.Tablero;

public class ParaUI extends buscaminasUi {

	int tamano = 10;
	Tablero tablero = new Tablero(tamano);
	Casilla casilla = new Casilla();
	Desvelar desvelar = new Desvelar();
	Abanderar abanderar=new Abanderar();

	public ParaUI() {
		Component[] components = panelBotones.getComponents();
		for (Component component : components) {
			((JButton) component).addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					/**
					 * si se pusa el boton izquierdo del raton para desvelar casilla
					 */
					if (SwingUtilities.isLeftMouseButton(e)) {
						desvelar.comprobarCasilla((JButton) e.getSource(), tablero);
					}
					/**
					 * si se pulsa el boton derecho del raton para marcar bandera
					 */
					if (SwingUtilities.isRightMouseButton(e)) {
						System.out.println("derecha");
						abanderar.colocarBandera((JButton) e.getSource(),tablero);
					}
					/**
					 * si se ha pisado una mina
					 */
					if (tablero.isPerdedor()) {
						desvelar.explotarMinas(tablero);
						lblTexto.setText("Pisaste una mina, Ooooohh!!!");
						lblTexto.setForeground(Color.RED);
						//panelBotones.setEnabled(false);
						panelBotones.removeAll();
					}
					/**
					 * si todas las casillas estan desveladas menos las minas
					 */
					if (desvelar.comprobarGanador(boton, tablero, contentPane, components) && (!tablero.isPerdedor())) {
						tablero.setGanador(true);
						if (tablero.isGanador()) {
							lblTexto.setText("Ganasteeeeee");
							lblTexto.setForeground(Color.GREEN);
						}
					}
				}
			});
		}
	}
}