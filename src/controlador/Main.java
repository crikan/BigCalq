package controlador;

import vista.VentanaCalculadora;

public class Main {

	//creamos un objeto de cada clase y se la pasamos al otro como parámetro.
	public static void main(String[] args) {
		VentanaCalculadora miVentana = new VentanaCalculadora();
		GestorEventos gestor = new GestorEventos(miVentana);
		miVentana.establecerGestor(gestor);
	}
}
