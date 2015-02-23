package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import bean.JTextFieldValidator;

public class VistaUnidad extends javax.swing.JFrame {

	private JPanel contentPane;
	private JButton btnAgregar;
	private JButton btnSalir;
	private JButton btnBuscar;

	private JTextFieldValidator textRif;
	private JTextFieldValidator textNombre;
	private JTextFieldValidator textNumero;
	private JTextFieldValidator textSocio;
	private JTextFieldValidator textPlaca;
	private JTextFieldValidator textCapacidad;
	private JComboBox<?> comboTipo;
	private DefaultComboBoxModel<?> jComboBoxModel;

	//SINGLETON
	private static VistaUnidad instancia;
		public static VistaUnidad getInstancia(){
			if (instancia == null){
				instancia = new VistaUnidad();
			}
			return instancia;
		}
		
	
	public VistaUnidad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(-10, 11, 595, 459);
		contentPane.add(panel);
		panel.setLayout(null);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(102, 204, 51));
		btnBuscar.setBounds(371, 57, 89, 23);
		panel.add(btnBuscar);

		JLabel lblRifCoop = new JLabel("RIF. de cooperativa:");
		lblRifCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRifCoop.setBounds(37, 52, 130, 32);
		panel.add(lblRifCoop);

		JLabel lblCoop = new JLabel("Cooperativa:");
		lblCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCoop.setBounds(37, 108, 80, 32);
		panel.add(lblCoop);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNumero.setBounds(62, 168, 52, 38);
		panel.add(lblNumero);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPlaca.setBounds(74, 266, 43, 32);
		panel.add(lblPlaca);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTipo.setBounds(74, 217, 43, 38);
		panel.add(lblTipo);

		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCapacidad.setBounds(309, 220, 68, 32);
		panel.add(lblCapacidad);

		JLabel lblSociodueo = new JLabel("IdSocio(Due\u00F1o):");
		lblSociodueo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSociodueo.setBounds(299, 168, 89, 38);
		panel.add(lblSociodueo);

		btnAgregar = new JButton("Agregar Otro");
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBackground(new Color(102, 204, 51));
		btnAgregar.setBounds(47, 317, 113, 23);
		panel.add(btnAgregar);

		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setBounds(428, 317, 89, 23);
		panel.add(btnSalir);

		JLabel lblCargarUnidad = new JLabel("CARGAR UNIDAD");
		lblCargarUnidad.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCargarUnidad.setBounds(195, 2, 102, 50);
		panel.add(lblCargarUnidad);

		String[] items = { "Seleccione", "Carro", "Ranchera", "Vans", "Encava",
				"Buseta ", "Bus", "Buscama" };
		comboTipo = new JComboBox<Object>(items);
		comboTipo.setBounds(127, 227, 149, 23);
		panel.add(comboTipo);

		textNumero = new JTextFieldValidator();
		textNumero.setFont(new Font("Dialog", Font.BOLD, 12));
		textNumero.setBounds(129, 177, 147, 23);
		panel.add(textNumero);
		textNumero.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_NUMEROS);
		
		textPlaca = new JTextFieldValidator();
		textPlaca.setFont(new Font("Dialog", Font.BOLD, 12));
		textPlaca.setBounds(127, 273, 149, 20);
		panel.add(textPlaca);
		textPlaca.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);
		
		textCapacidad = new JTextFieldValidator();
		textCapacidad.setFont(new Font("Dialog", Font.BOLD, 12));
		textCapacidad.setText(" ");
		textCapacidad.setBounds(398, 227, 130, 23);
		panel.add(textCapacidad);
		textCapacidad.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_NUMEROS);
		
		textSocio = new JTextFieldValidator();
		textSocio.setFont(new Font("Dialog", Font.BOLD, 12));
		textSocio.setBounds(398, 178, 130, 23);      
		panel.add(textSocio);
		textSocio.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);
		
		textNombre = new JTextFieldValidator();
		textNombre.setText("  ");
		textNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		textNombre.setBounds(131, 112, 386, 23);
		panel.add(textNombre);
		textNombre.setTipoCaracteresPermitidos(JTextFieldValidator.LETRAS_ESPACIOS_Y_NUMEROS);
		
		textRif = new JTextFieldValidator();
		textRif.setFont(new Font("Dialog", Font.BOLD, 12));
		textRif.setBounds(153, 58, 205, 23);
		panel.add(textRif);
		textRif.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);
		
		
	}
	
	// /////////////////////////////////////////////////////////////////////////////////////////
	public void activarListener(ActionListener accion) {
		btnBuscar.addActionListener(accion);
		btnAgregar.addActionListener(accion);
		btnSalir.addActionListener(accion);
	}

	public void Limpiar() {
		textRif.setText("");
		textNombre.setText("");
		textNumero.setText("");
		textSocio.setText("");
		textPlaca.setText("");
		textCapacidad.setText("");
	}

	public String getTextRif() {
		return textRif.getText();
	}

	public JTextFieldValidator getTextNombre() {
		return textNombre;
	}

	public String getTextNumero() {
		return textNumero.getText();
	}

	public String getTextSocio() {
		return textSocio.getText();
	}

	public String getTextPlaca() {
		return textPlaca.getText();
	}

	public JTextFieldValidator getTextCapacidad() {
		return textCapacidad;
	}

	public String getcomboTipo() {
		return (String) comboTipo.getSelectedItem();
	}

	public int getIndiceComboTipo() {
		return comboTipo.getSelectedIndex();
	}

	public JButton getbtnAgregar() {
		return btnAgregar;
	}

	public JButton getbtnBuscar() {
		return btnBuscar;
	}

	public JButton getbtnSalir() {
		return btnSalir;
	}


	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
