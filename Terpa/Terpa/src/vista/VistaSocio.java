package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

import bean.JTextFieldValidator;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


@SuppressWarnings("serial")
public class VistaSocio extends JFrame {

	private JPanel contentPane;
	private JButton btnBuscarCoop;//
	private JButton btnGuardarS;//
	private JButton btnSalir;//
	private JButton btnAgregarUnidad;
	private JButton btnAgregarCho;

	private JTextFieldValidator textRifCoop;
	private JTextFieldValidator textCoop;
	private JTextFieldValidator textCiS;
	private JTextFieldValidator textNombreS;
	private JTextFieldValidator textTelefonoS;
	private JTextFieldValidator textID;	
	private JTextFieldValidator textApellidoS;
	
	
	private JComboBox comboCargo;
	private DefaultComboBoxModel<?> jComboBoxModel;



	public VistaSocio() {
		setTitle("TERPA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 459, 384);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCargarSocio = new JLabel("CARGAR SOCIO");
		lblCargarSocio.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCargarSocio.setBounds(187, 32, 104, 14);
		panel.add(lblCargarSocio);

		JLabel lblRifCoop = new JLabel("Rif Cooperativa :");
		lblRifCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRifCoop.setBounds(10, 82, 104, 14);
		panel.add(lblRifCoop);

		btnBuscarCoop = new JButton("Buscar");
		btnBuscarCoop.setForeground(Color.WHITE);
		btnBuscarCoop.setBackground(new Color(102, 204, 51));
		btnBuscarCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBuscarCoop.setBounds(224, 78, 87, 23);
		panel.add(btnBuscarCoop);

		JLabel lblNombreS = new JLabel("Nombre :");
		lblNombreS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreS.setBounds(45, 148, 54, 14);
		panel.add(lblNombreS);

		JLabel lblCiS = new JLabel("Cedula :");
		lblCiS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCiS.setBounds(245, 183, 46, 14);
		panel.add(lblCiS);

		JLabel lblCargoS = new JLabel("Cargo :");
		lblCargoS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCargoS.setBounds(53, 191, 46, 18);
		panel.add(lblCargoS);

		JLabel lblTalefonoS = new JLabel("Telefono :");
		lblTalefonoS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTalefonoS.setBounds(243, 226, 56, 18);
		panel.add(lblTalefonoS);

		btnSalir = new JButton("Cancelar");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));

		btnGuardarS = new JButton("Guardar");
		btnGuardarS.setForeground(Color.WHITE);
		btnGuardarS.setBackground(new Color(102, 204, 51));
		btnGuardarS.setFont(new Font("Dialog", Font.BOLD, 12));
		btnGuardarS.setBounds(113, 280, 89, 23);
		panel.add(btnGuardarS);
		btnSalir.setBounds(259, 280, 89, 23);
		panel.add(btnSalir);

		textRifCoop = new JTextFieldValidator();
		textRifCoop.setToolTipText("J1234");
		textRifCoop.setBounds(112, 81, 102, 20);
		panel.add(textRifCoop);

		textCoop = new JTextFieldValidator();
		textCoop.setBounds(333, 80, 102, 19);
		panel.add(textCoop);

		textNombreS = new JTextFieldValidator();
		textNombreS.setBounds(98, 147, 104, 17);
		panel.add(textNombreS);

		textCiS = new JTextFieldValidator();
		textCiS.setBounds(299, 180, 104, 23);
		panel.add(textCiS);

		textTelefonoS = new JTextFieldValidator();
		textTelefonoS.setBounds(299, 225, 104, 23);
		panel.add(textTelefonoS);
	
		JLabel IDS = new JLabel("ID :");
		IDS.setFont(new Font("Dialog", Font.BOLD, 12));
		IDS.setBounds(74, 230, 25, 14);
		panel.add(IDS);
		
		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido.setFont(new Font("Dialog", Font.BOLD, 12));
		lblApellido.setBounds(243, 145, 51, 16);
		panel.add(lblApellido);
		
	    textApellidoS = new JTextFieldValidator();
		textApellidoS.setBounds(299, 146, 104, 20);
		panel.add(textApellidoS);
		
		btnAgregarCho = new JButton("Agregar Chofer");
		btnAgregarCho.setVisible(false);
		btnAgregarCho.setForeground(Color.WHITE);
		btnAgregarCho.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregarCho.setBackground(new Color(102, 204, 51));
		btnAgregarCho.setBounds(83, 314, 119, 25);
		panel.add(btnAgregarCho);
		
		btnAgregarUnidad = new JButton("Agregar Unidad");
		btnAgregarUnidad.setVisible(false);
		btnAgregarUnidad.setForeground(Color.WHITE);
		btnAgregarUnidad.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregarUnidad.setBackground(new Color(102, 204, 51));
		btnAgregarUnidad.setBounds(250, 314, 121, 25);
		panel.add(btnAgregarUnidad);
		
		String[] items =  {"Seleccione", "Presidente", "Vice Presidente", "Tesorero", "Secretario", "Sin Cargo "};
		comboCargo = new JComboBox<Object>(items);
		comboCargo.setBackground(Color.WHITE);
		comboCargo.setFont(new Font("Dialog", Font.BOLD, 12));
		comboCargo.setBounds(98, 191, 104, 20);
		panel.add(comboCargo);
		
		textID = new JTextFieldValidator();
		textID.setToolTipText("S xx");
		textID.setBounds(98, 226, 104, 20);
		panel.add(textID);
	}

	// /////////===========================================///////////////

	public void activarListener(ActionListener accion) {
		btnBuscarCoop.addActionListener(accion);
		btnGuardarS.addActionListener(accion);
		btnSalir.addActionListener(accion);
		btnAgregarUnidad.addActionListener(accion);
		btnAgregarCho.addActionListener(accion);
		comboCargo.addActionListener(accion);
	}

	public String getRifCoop() {
		return textRifCoop.getText();
	}

	public JTextFieldValidator getCoop() {
		return textCoop;
	}

	public String getCiS() {
		return textCiS.getText();
	}

	public JTextFieldValidator getNombreS() {
		return textNombreS;
	}


	public JButton getBtnAgregarUnidad() {
		return btnAgregarUnidad;
	}

	public JButton getBtnAgregarCho() {
		return btnAgregarCho;
	}

	public JTextFieldValidator getTextApellidoS() {
		return textApellidoS;
	}

	public JTextFieldValidator getTelefonoS() {
		return textTelefonoS;
	}
	
	public JTextFieldValidator getTextID() {
		return textID;
	}


	public JButton getBtnBuscarCoop() {
		return btnBuscarCoop;
	}

	public JButton getBtnGuardarS() {
		return btnGuardarS;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void blanquearCampos() {
		textRifCoop.setText("");
		textCoop.setText("");
		textNombreS.setText("");
		textCiS.setText("");
		textTelefonoS.setText("");
		textID.setText("");
		textApellidoS.setText("");
		comboCargo.setSelectedIndex(0);
		
	}
	
	public String getComboCargo() {
		return (String)comboCargo.getSelectedItem();
	}

	public int getIndiceCombo() {
		return comboCargo.getSelectedIndex();
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
