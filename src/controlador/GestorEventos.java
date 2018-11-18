package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import vista.VentanaCalculadora;
import vista.VentanaRaizCuadrada; 

public class GestorEventos implements ActionListener {

	private VentanaCalculadora ventana;// referencia para el objeto VentanaCalculadora
	private VentanaRaizCuadrada ventana2 = null; // referencia para el JDialog modal personalizado
	
	// constructor al que pasamos la ventana
	public GestorEventos(VentanaCalculadora ventana) {
		this.ventana = ventana;
		// con esta línea creamos una nueva ventana JDialog 
		ventana2 = new VentanaRaizCuadrada(ventana, true, this);
	}

	// método obligatorio donde irá la lógica del programa
	@Override
	public void actionPerformed(ActionEvent e) throws IllegalArgumentException {

	
	 // ASÍ SERÍA EL CÓDIGO PARA UN JOPTIONPANE DE AVISO PREDEFINIDO. 
	 //	DESCOMENTAR PARA PROBAR Y COMENTAR LAS DOS SENTENCIAS SIGUIENTES
	 // if (e.getSource() == ventana.getBotonRaizCuadrada()) {
	 //		JOptionPane.showMessageDialog(null, "FUNCIONALIDAD NO DISPONIBLE", "¡Aviso!", JOptionPane.WARNING_MESSAGE);
	 
		// al pulsar la raíz cuadrada, hacemos visible la ventana JDialog
		if (e.getSource() == ventana.getBotonRaizCuadrada()) {
			ventana2.setVisible(true);	
		
		// al pulsar sobre el botón volver del JDialog cerramos esa ventana pero la aplicación continúa.
		} else if (e.getSource() == ventana2.getVolver()) {
			ventana2.dispose(); 

		// al pulsar la raíz cúbica nos saltará un JOptionPane predefinido que nos pedirá una contraseña 
		// que luego compararemos, y si es correcta continuará la siguiente sentencia
		} else if (e.getSource() == ventana.getBotonRaizCubica()) {
			String pass = JOptionPane.showInputDialog("Introduce la contraseña");
			if (pass.equals("123")) {

	    // comprobamos en cuál de las cajas de texto hay contenido y lo usamos para hacer la operación de raíz cúbica
				try {
					float resultado = 0;
					if (ventana.getCaja1().getText().isEmpty()) {
						float numero2 = Float.parseFloat(ventana.getCaja2().getText());
						resultado = (float) Math.pow(numero2, 1.0 / 3.0);
					} else {
						float numero1 = Float.parseFloat(ventana.getCaja1().getText());
						resultado = (float) Math.pow(numero1, 1.0 / 3.0);
					}
					ventana.getEtiquetaResultado().setText("resultado:    " + resultado);
				} catch (NumberFormatException ex) {
					ventana.getEtiquetaResultado().setText("escribe algún número");
				}
			} else {
				JOptionPane.showMessageDialog(null, "¡CONTRASEÑA INCORRECTA!", "¡Error!", JOptionPane.ERROR_MESSAGE);
			}
		
		// comprobamos que haya contenido en las dos cajas de texto
		} else if (ventana.getCaja1().getText().isEmpty()) {
			ventana.getEtiquetaResultado().setText("falta el primer número");
		} else if (ventana.getCaja2().getText().isEmpty()) {
			ventana.getEtiquetaResultado().setText("falta el segundo número");

		} else {
			try {
				// conseguimos el contenido de las cajas de texto y, tras convertirlo a flotantes,
				// lo volcamos sobre sus correspondientes referencias.
				float numero1 = Float.parseFloat(ventana.getCaja1().getText());
				float numero2 = Float.parseFloat(ventana.getCaja2().getText());
				// en la variable operacion vuelco el texto del boton que hubiera sido apretado
				String operacion = ((JButton) e.getSource()).getText();
				float resultado = 0;
				// he optado por un switch-case al que le paso la variable operacion
				switch (operacion) {
				case "sumar":
					resultado = numero1 + numero2;
					break;
				case "restar":
					resultado = numero1 - numero2;
					break;
				case "multiplicar":
					resultado = numero1 * numero2;
					break;
				case "dividir": // si el segundo número es 0, lanzo la excepción
					if (numero2 == 0) {
						throw new IllegalArgumentException("no puedes dividir entre cero");
					} else {
						resultado = numero1 / numero2;
					}
					break;
				}
				// cambio la etiqueta del resultado una vez hecho el cálculo
				ventana.getEtiquetaResultado().setText("resultado:    " + resultado);
				
			// excepción que controla que lo que hay en las cajas sea un número o 
			// que estén ambas cajas rellenas de contenido
			} catch (NumberFormatException ex) {
				ventana.getEtiquetaResultado().setText("¡escribe dos NÚMEROS, melón!");
			} catch (IllegalArgumentException exc) {
				ventana.getEtiquetaResultado().setText("no puedes dividir entre cero");
			}
			// coloco el foco sobre la primera caja de texto
			ventana.getCaja1().requestFocus();
		}
	}
}
