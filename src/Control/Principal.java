package Control;

import java.awt.EventQueue;

import Vista.buscaminasUi;

public class Principal {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParaUI frame = new ParaUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

//   FALLOS:
// problema con la recursividad
// el reinicio me abre nueva ventana
// al pisar mina se me queda en blanco el cuadrado
// al pulsar una casilla desvelada hay que desvelar las de su alrededor, no lo hace
// meter dificultad
// meter el tamaño del lado del tablero



