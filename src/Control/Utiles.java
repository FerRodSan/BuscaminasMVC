package Control;

import java.awt.Component;

public class Utiles {

	/**
	 * obtenemos la coordenada de cada boton introduciendola en un array de dos posiciones
	 * @param component
	 * @return
	 */
	public int[] obtenerCoordenada(Component component) {
		String name = component.getName();
		int[] coordenada={Integer.valueOf(name.substring(0, 1)),Integer.valueOf(name.substring(1, 2))};
		return coordenada;
	}

}
