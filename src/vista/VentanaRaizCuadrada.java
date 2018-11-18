package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controlador.GestorEventos;

public class VentanaRaizCuadrada extends JDialog {
	
	//referencias para los componentes:
	private JLabel aviso, error; //etiquetas para un icono de error y el texto informativo
	private JButton volver; //botón de retorno que cierra la ventana modal 
	private GestorEventos controlador;//para que funcione la llamada a la ventana modal debemos pasarle el objeto Gestor Eventos a su constructor
	
	//constructor:
	//para que la ventana JDialog funcione de modo dependiente de la ventana principal y la bloquee, le 
	//pasamos la ventana principal, y la propiedad true que hará de modal, finalmente le pasamos
	//este mismo objeto gestor para que funcione el action listener
	public VentanaRaizCuadrada(VentanaCalculadora ventana, boolean modal, GestorEventos controlador) {
		super(ventana, modal); //enviamos al constructor padre, los parámetros de este.
		this.controlador = controlador; //vinculamos el objeto controlador que hemos pasado por parámetro a su referencia
		
		//características de ventana:
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);// al cerrar se cierra la ventana pero no el programa
		setTitle("¡Aviso!");// título de la ventana
		setSize(300, 200);// tamaño de la ventana
		setLocationRelativeTo(null); // la centramos en la pantalla
		setResizable(false);// impedimos que se pueda cambiar el tamaño
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/myCalq.png")); //icono de la ventana
		setLayout(null);// eliminamos el layout por defecto
		inicializarComponentes(); // método que inicializa los componentes
	}
	//método para inicializar los componentes
	private void inicializarComponentes() {
		getContentPane().setBackground(new Color(37, 35, 30)); // damos el color al panel de la ventana
		//imagen de error
		Image img = new ImageIcon("imagenes/error.png").getImage();
		error = new JLabel(new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		error.setBounds(125, 20, 50, 50); 								                                              
		add(error);
		//etiqueta de texto
		aviso = new JLabel("FUNCIÓN NO DISPONIBLE");
		aviso.setHorizontalAlignment(SwingConstants.CENTER);
		aviso.setBounds(0, 70, 300, 30);
		aviso.setForeground(new Color(255, 167, 15));
		aviso.setFont(new Font("century gothic", Font.BOLD, 16));
		add(aviso);
		//botón de retorno
		volver = new JButton("volver");
		volver.addActionListener(controlador);
		volver.setBounds(100, 120, 100, 30);
		volver.setBackground(new Color(255, 167, 15));
		volver.setForeground(new Color(37, 35, 30));
		volver.setFont(new Font("century gothic", Font.BOLD, 14));
		add(volver);
	}
	// getter para el botón Volver
	public JButton getVolver() {
		return volver;
	}
}


