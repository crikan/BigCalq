package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.GestorEventos;

public class VentanaCalculadora extends JFrame {

	// componentes
	private JLabel etiquetaNum1, etiquetaNum2, etiquetaResultado, nombreApp, logo;
	private JTextField caja1, caja2;
	private JButton botonSuma, botonResta, botonMultiplica, botonDivide, botonRaizCuadrada, botonRaizCubica;

	// constructor para la ventana
	public VentanaCalculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// al cerrar se termina el programa
		setTitle("Calculadora");// título de la ventana
		setSize(300, 460);// tamaño de la ventana
		setResizable(false);// impedimos que se pueda cambiar el tamaño
		setLocationRelativeTo(null); // la centramos en la pantalla
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/myCalq.png"));
		setLayout(null);// eliminamos el layout por defecto
		inicializarComponentes(); // método que inicializa los componentes
		setVisible(true); // hacemos la ventana visible, esto va siempre al final del constructor

	}

	// este es el método para inicializar los componentes.
	// Tiene tres fases: 1 crear el componente
	// 2: posicionar el componente y 3: añadirlo a la ventana
	private void inicializarComponentes() {

		getContentPane().setBackground(new Color(37, 35, 30)); // damos el color al panel de la ventana

		// fuente personalizada para el nombre de la app
		// creo la fuente, invoco a la clase y, como recurso, le paso el archivo ttf de mi paquete.
		try {
			Font fuente = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("NovaFlat.ttf"));
			nombreApp = new JLabel("BigCalq"); // texto de la etiqueta
			nombreApp.setFont(fuente.deriveFont(Font.BOLD, 45f)); // configuro mi fuente personalizada
			nombreApp.setBounds(20, 40, 200, 80);// lo posiciono
			nombreApp.setForeground(new Color(255, 167, 15));// le doy color
			add(nombreApp);// añado la etiqueta a la ventana

		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// logo:
		// creo un objeto imagen y le asigno el archivo .png, le paso el objeto
        // img escalandolo al tamaño que me parezca adecuado
		Image img = new ImageIcon("imagenes/myCalq.png").getImage();
		logo = new JLabel(new ImageIcon(img.getScaledInstance(70, 70, Image.SCALE_SMOOTH)));																					
		logo.setBounds(200, 40, 70, 70); // posiciono el logo. El tamaño es el mismo       
										                                                    
		add(logo);// añado el logo
		
		// Etiquetas y botones:
		etiquetaNum1 = new JLabel("número 1");// label de la etiqueta
		etiquetaNum1.setBounds(40, 140, 100, 30);// posicionamiento
		etiquetaNum1.setForeground(new Color(255, 167, 15)); // cambiamos el color de las letras del label
		etiquetaNum1.setFont(new Font("century gothic", Font.BOLD, 16));// cambiamos el tipo de letra

		caja1 = new JTextField(); // creamos la caja de texto
		caja1.setBounds(120, 140, 130, 25);// le damos tamaño y la posicionamos
		caja1.setForeground(new Color(94, 94, 94));// este es el color de las letras del contenido
		caja1.setFont(new Font("century gothic", Font.BOLD, 16));// tipo de letra del texto

		etiquetaNum2 = new JLabel("número 2");
		etiquetaNum2.setBounds(40, 180, 100, 30);
		etiquetaNum2.setForeground(new Color(255, 167, 15));
		etiquetaNum2.setFont(new Font("century gothic", Font.BOLD, 16));

		caja2 = new JTextField();
		caja2.setBounds(120, 180, 130, 25);
		caja2.setForeground(new Color(94, 94, 94));
		caja2.setFont(new Font("century gothic", Font.BOLD, 16));

		botonSuma = new JButton("sumar");// texto del botón
		botonSuma.setBounds(30, 220, 110, 40);// posicionamiento y tamaño
		botonSuma.setBackground(new Color(255, 167, 15));// color del fondo del botón
		botonSuma.setForeground(new Color(37, 35, 30));// color de las letras del botón
		botonSuma.setFont(new Font("century gothic", Font.BOLD, 14));// tipo de letra del botón

		botonResta = new JButton("restar");
		botonResta.setBounds(150, 220, 110, 40);
		botonResta.setBackground(new Color(255, 167, 15));
		botonResta.setForeground(new Color(37, 35, 30));
		botonResta.setFont(new Font("century gothic", Font.BOLD, 14));

		botonMultiplica = new JButton("multiplicar");
		botonMultiplica.setBounds(30, 270, 110, 40);
		botonMultiplica.setBackground(new Color(255, 167, 15));
		botonMultiplica.setForeground(new Color(37, 35, 30));
		botonMultiplica.setFont(new Font("century gothic", Font.BOLD, 14));

		botonDivide = new JButton("dividir");
		botonDivide.setBounds(150, 270, 110, 40);
		botonDivide.setBackground(new Color(255, 167, 15));
		botonDivide.setForeground(new Color(37, 35, 30));
		botonDivide.setFont(new Font("century gothic", Font.BOLD, 14));
		
		botonRaizCuadrada = new JButton("raíz cuadrada");
		botonRaizCuadrada.setBounds(30, 320, 110, 40);
		botonRaizCuadrada.setBackground(new Color(255, 167, 15));
		botonRaizCuadrada.setForeground(new Color(37, 35, 30));
		botonRaizCuadrada.setFont(new Font("century gothic", Font.BOLD, 11));

		botonRaizCubica = new JButton("raíz cúbica");
		botonRaizCubica.setBounds(150, 320, 110, 40);
		botonRaizCubica.setBackground(new Color(255, 167, 15));
		botonRaizCubica.setForeground(new Color(37, 35, 30));
		botonRaizCubica.setFont(new Font("century gothic", Font.BOLD, 11));

		etiquetaResultado = new JLabel("el resultado es "); //texto de la etiqueta, va variando.
		etiquetaResultado.setHorizontalAlignment(SwingConstants.CENTER);// centramos el texto
		etiquetaResultado.setBounds(0, 380, 300, 30);// hacemos que la etiqueta ocupe todo el ancho de la ventana
		etiquetaResultado.setForeground(new Color(255, 167, 15)); //color de las letras
		etiquetaResultado.setFont(new Font("century gothic", Font.BOLD, 16)); // fuente de las letras

		// añado las etiquetas, campos de texto y botones
		add(etiquetaNum1);
		add(etiquetaNum2);
		add(caja1);
		add(caja2);
		add(botonSuma);
		add(botonResta);
		add(botonMultiplica);
		add(botonDivide);
		add(botonRaizCuadrada);
		add(botonRaizCubica);
		add(etiquetaResultado);
	}
	
	// método para dar funcionalidad a los botones. Le paso como parámetro un objeto GestorEventos
	public void establecerGestor(GestorEventos gestor) {
		botonSuma.addActionListener(gestor);
		botonResta.addActionListener(gestor);
		botonMultiplica.addActionListener(gestor);
		botonDivide.addActionListener(gestor);
		botonRaizCuadrada.addActionListener(gestor);
		botonRaizCubica.addActionListener(gestor);
	}

	// getters
	public JLabel getEtiquetaResultado() {
		return etiquetaResultado;
	}

	public JTextField getCaja1() {
		return caja1;
	}

	public JTextField getCaja2() {
		return caja2;
	}

	public JButton getBotonSuma() {
		return botonSuma;
	}

	public JButton getBotonResta() {
		return botonResta;
	}

	public JButton getBotonMultiplica() {
		return botonMultiplica;
	}

	public JButton getBotonDivide() {
		return botonDivide;
	}

	public JButton getBotonRaizCuadrada() {
		return botonRaizCuadrada;
	}

	public JButton getBotonRaizCubica() {
		return botonRaizCubica;
	}

}
