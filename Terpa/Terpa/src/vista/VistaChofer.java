package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;

import bean.JTextFieldValidator;

@SuppressWarnings("serial")
public class VistaChofer extends javax.swing.JFrame {//
	
	private JPanel contentPane;
	private JButton btnBuscarCho;//
	private JButton btnGuardarC;//
	private JButton btnSalir;//
	private JButton btnEliminarC;
	private JButton btnModificarC;
	
	private JTextFieldValidator textRifCoop;
	private JTextFieldValidator textCiC;
	private JTextFieldValidator textNombreC;
	private JTextFieldValidator textApellidoC;
	private JTextFieldValidator textTelefonoC;
	private JTextFieldValidator textSocioC;
	private JTextFieldValidator textIdC;

	// SINGLETON
	private static VistaChofer instancia;

	public static VistaChofer getInstancia() {
		if (instancia == null) {
			instancia = new VistaChofer();
		}
		return instancia;
	}

	public VistaChofer() {
		setTitle("TERPA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 458, 384);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCargarChofer = new JLabel("CARGAR CHOFER");
		lblCargarChofer.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCargarChofer.setBounds(187, 32, 104, 14);
		panel.add(lblCargarChofer);

		JLabel lblRifCoop = new JLabel("Rif Cooperativa :");
		lblRifCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRifCoop.setBounds(10, 132, 104, 14);
		panel.add(lblRifCoop);
		
		textRifCoop = new JTextFieldValidator();
		textRifCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		textRifCoop.setBounds(110, 129, 104, 20);
		panel.add(textRifCoop);
		textRifCoop.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);
		
		//JButton 
		btnBuscarCho = new JButton("Buscar");
		btnBuscarCho.setForeground(Color.WHITE);
		btnBuscarCho.setBackground(new Color(102, 204, 51));
		btnBuscarCho.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBuscarCho.setBounds(235, 78, 87, 23);
		panel.add(btnBuscarCho);

		JLabel lblNombreC = new JLabel("Nombre :");
		lblNombreC.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreC.setBounds(52, 188, 54, 14);
		panel.add(lblNombreC);
		
		textNombreC = new JTextFieldValidator();
		textNombreC.setFont(new Font("Dialog", Font.BOLD, 12));
		textNombreC.setBounds(110, 185, 104, 23);
		panel.add(textNombreC);
		textNombreC.setTipoCaracteresPermitidos(JTextFieldValidator.LETRAS_ESPACIOS_Y_NUMEROS);

		JLabel lblApellidoC = new JLabel("Apellido :");
		lblApellidoC.setFont(new Font("Dialog", Font.BOLD, 12));
		lblApellidoC.setBounds(266, 188, 56, 14);
		panel.add(lblApellidoC);
		
		textApellidoC = new JTextFieldValidator();
		textApellidoC.setFont(new Font("Dialog", Font.BOLD, 12));
		textApellidoC.setBounds(332, 184, 102, 23);
		panel.add(textApellidoC);
		textApellidoC.setTipoCaracteresPermitidos(JTextFieldValidator.LETRAS_ESPACIOS_Y_NUMEROS);

		JLabel lblCiC = new JLabel("Cedula :");
		lblCiC.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCiC.setBounds(52, 233, 46, 18);
		panel.add(lblCiC);
		
		textCiC = new JTextFieldValidator();
		textCiC.setFont(new Font("Dialog", Font.BOLD, 12));
		textCiC.setBounds(110, 231, 104, 23);
		panel.add(textCiC);
		textCiC.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_NUMEROS);


		JLabel lblTelefonoC = new JLabel("Telefono :");
		lblTelefonoC.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTelefonoC.setBounds(266, 233, 56, 18);
		panel.add(lblTelefonoC);
		
		textTelefonoC = new JTextFieldValidator();
		textTelefonoC.setFont(new Font("Dialog", Font.BOLD, 12));
		textTelefonoC.setBounds(332, 231, 102, 23);
		panel.add(textTelefonoC);
		textTelefonoC.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_NUMEROS);
		
		JLabel lblSocio = new JLabel("ID Socio :");
		lblSocio.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSocio.setBounds(52, 279, 54, 14);
		panel.add(lblSocio);
		
		textSocioC = new JTextFieldValidator();
		textSocioC.setFont(new Font("Dialog", Font.BOLD, 12));
		textSocioC.setBounds(110, 275, 104, 23);
		panel.add(textSocioC);
		textSocioC.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);

		//JButton 
		btnGuardarC = new JButton("Guardar");
		btnGuardarC.setForeground(Color.WHITE);
		btnGuardarC.setBackground(new Color(102, 204, 51));
		btnGuardarC.setFont(new Font("Dialog", Font.BOLD, 12));
		btnGuardarC.setBounds(52, 320, 89, 23);
		panel.add(btnGuardarC);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.setBounds(345, 320, 89, 23);
		panel.add(btnSalir);
		
		JLabel lblIdChofer = new JLabel("ID Chofer :");
		lblIdChofer.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIdChofer.setBounds(41, 82, 65, 14);
		panel.add(lblIdChofer);
		
		textIdC = new JTextFieldValidator();
		textIdC.setFont(new Font("Dialog", Font.BOLD, 12));
		textIdC.setBounds(110, 79, 104, 20);
		panel.add(textIdC);
		textIdC.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);
		
		btnEliminarC = new JButton("Eliminar");
		btnEliminarC.setForeground(Color.WHITE);
		btnEliminarC.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEliminarC.setBackground(new Color(102, 204, 51));
		btnEliminarC.setBounds(151, 320, 89, 23);
		panel.add(btnEliminarC);
		
		btnModificarC = new JButton("Modificar");
		btnModificarC.setForeground(Color.WHITE);
		btnModificarC.setFont(new Font("Dialog", Font.BOLD, 12));
		btnModificarC.setBackground(new Color(102, 204, 51));
		btnModificarC.setBounds(246, 321, 89, 23);
		panel.add(btnModificarC);

	
	}

	///////////===========================================///////////////
	
	public void activarListener(ActionListener accion) {
		btnBuscarCho.addActionListener(accion);
		btnGuardarC.addActionListener(accion);
		btnSalir.addActionListener(accion);
		btnEliminarC.addActionListener(accion);
		btnModificarC.addActionListener(accion);
	}
	
	public String getRifCoop() {
		return textRifCoop.getText();
	}
	
	public String getCiC() {
		return textCiC.getText();
	}

	public  String getNombreC() {
		return textNombreC.getText();
	}

	public  String getApellidoC() {
		return textApellidoC.getText();
	}

	public  String getTelefonoC() {
		return textTelefonoC.getText();
	}
	
	public  String getSocioC() {
		return textSocioC.getText();
	}
	
	public  String getIdC() {
		return textIdC.getText();
	}
	
	public JButton getBtnBuscarCho() {
		return btnBuscarCho;
	}
	
	public JButton getBtnGuardarC() {
		return btnGuardarC;
	}
	
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JButton getBtnEliminar() {
		return btnEliminarC;
	}
	public JButton getBtnModificar() {
		return btnModificarC;
	}
	public JTextFieldValidator getTextNombreC() {
		return textNombreC;
	}
	public JTextFieldValidator getTextCiC() {
		return textCiC;
	}
	public JTextFieldValidator getTextApellidoC() {
		return textApellidoC;
	}
	public JTextFieldValidator getTextTelefonoC() {
		return textTelefonoC;
	}
	public JTextFieldValidator getTextSocioC() {
		return textSocioC;
	}

	public void blanquearCampos() {
		textRifCoop.setText("");
		textCiC.setText("");
		textNombreC.setText("");
		textApellidoC.setText("");
		textTelefonoC.setText("");
		textSocioC.setText("");
		textIdC.setText("");
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
