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
	private JTextFieldValidator textNumero;
	private JTextFieldValidator textSocio;
	private JTextFieldValidator textPlaca;
	private JTextFieldValidator textCapacidad;
	private JComboBox<?> comboTipo;
	private DefaultComboBoxModel<?> jComboBoxModel;
	private JButton btnEliminar;
	private JButton btnModificar;

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
		btnBuscar.setBounds(322, 57, 89, 23);
		panel.add(btnBuscar);

		JLabel lblRifCoop = new JLabel("RIF Cop.:");
		lblRifCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRifCoop.setBounds(65, 171, 130, 32);
		panel.add(lblRifCoop);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNumero.setBounds(65, 49, 52, 38);
		panel.add(lblNumero);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPlaca.setBounds(65, 112, 43, 32);
		panel.add(lblPlaca);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTipo.setBounds(65, 233, 43, 38);
		panel.add(lblTipo);

		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCapacidad.setBounds(322, 236, 68, 32);
		panel.add(lblCapacidad);

		JLabel lblSociodueo = new JLabel("IdSocio(Due\u00F1o):");
		lblSociodueo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSociodueo.setBounds(322, 168, 89, 38);
		panel.add(lblSociodueo);

		btnAgregar = new JButton("Guardar");
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBackground(new Color(102, 204, 51));
		btnAgregar.setBounds(65, 317, 113, 23);
		panel.add(btnAgregar);

		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setBounds(462, 317, 89, 23);
		panel.add(btnSalir);

		JLabel lblCargarUnidad = new JLabel("CARGAR UNIDAD");
		lblCargarUnidad.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCargarUnidad.setBounds(195, 2, 102, 50);
		panel.add(lblCargarUnidad);

		String[] items = { "Seleccione", "Carro", "Ranchera", "Vans", "Encava",
				"Buseta ", "Bus", "Buscama" };
		comboTipo = new JComboBox<Object>(items);
		comboTipo.setBounds(127, 242, 162, 23);
		panel.add(comboTipo);

		textNumero = new JTextFieldValidator();
		textNumero.setFont(new Font("Dialog", Font.BOLD, 12));
		textNumero.setBounds(127, 57, 162, 23);
		panel.add(textNumero);
		textNumero.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_NUMEROS);
		
		textPlaca = new JTextFieldValidator();
		textPlaca.setFont(new Font("Dialog", Font.BOLD, 12));
		textPlaca.setBounds(127, 115, 162, 23);
		panel.add(textPlaca);
		textPlaca.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);
		
		textCapacidad = new JTextFieldValidator();
		textCapacidad.setFont(new Font("Dialog", Font.BOLD, 12));
		textCapacidad.setText(" ");
		textCapacidad.setBounds(421, 241, 130, 23);
		panel.add(textCapacidad);
		textCapacidad.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_NUMEROS);
		
		textSocio = new JTextFieldValidator();
		textSocio.setFont(new Font("Dialog", Font.BOLD, 12));
		textSocio.setBounds(421, 176, 130, 23);      
		panel.add(textSocio);
		textSocio.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);
		
		textRif = new JTextFieldValidator();
		textRif.setFont(new Font("Dialog", Font.BOLD, 12));
		textRif.setBounds(127, 176, 162, 23);
		panel.add(textRif);
		textRif.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEliminar.setBackground(new Color(102, 204, 51));
		btnEliminar.setBounds(195, 317, 113, 23);
		panel.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnModificar.setBackground(new Color(102, 204, 51));
		btnModificar.setBounds(325, 317, 113, 23);
		panel.add(btnModificar);
		
		
	}
	
	// /////////////////////////////////////////////////////////////////////////////////////////
	public void activarListener(ActionListener accion) {
		btnBuscar.addActionListener(accion);
		btnAgregar.addActionListener(accion);
		btnSalir.addActionListener(accion);
		btnEliminar.addActionListener(accion);
		btnModificar.addActionListener(accion);
	}

	public void Limpiar() {
		textRif.setText("");
		textNumero.setText("");
		textSocio.setText("");
		textPlaca.setText("");
		textCapacidad.setText("");
	}

	public String getRif() {
		return textRif.getText();
	}

	public String getNumero() {
		return textNumero.getText();
	}

	public String getSocio() {
		return textSocio.getText();
	}

	public String getPlaca() {
		return textPlaca.getText();
	}

	public JTextFieldValidator getTextCapacidad() {
		return textCapacidad;
	}

	public String getComboTipo() {
		return (String) comboTipo.getSelectedItem();
	}

	public int getIndiceComboTipo() {
		return comboTipo.getSelectedIndex();
	}
	public JComboBox<?> getcomboTipo() {
		return comboTipo;
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
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public JTextFieldValidator getTextRif() {
		return textRif;
	}

	public JTextFieldValidator getTextNumero() {
		return textNumero;
	}

	public JTextFieldValidator getTextSocio() {
		return textSocio;
	}

	public JTextFieldValidator getTextPlaca() {
		return textPlaca;
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}



/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */