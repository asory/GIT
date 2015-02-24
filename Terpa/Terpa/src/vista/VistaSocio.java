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
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class VistaSocio extends JFrame {

	private JPanel contentPane;
	private JButton btnBuscar;//
	private JButton btnGuardarS;//
	private JButton btnSalir;//
	private JButton btnAgregarUnidad;
	private JButton btnAgregarCho;
	private JTextFieldValidator textCiS;
	private JTextFieldValidator textNombreS;
	private JTextFieldValidator textTelefonoS;
	private JTextFieldValidator textID;	
	private JTextFieldValidator textApellidoS;
	
	
	private JComboBox comboCargo;
	private DefaultComboBoxModel<?> jComboBoxModel;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTextField textIDCoop;

	// SINGLETON

	private static VistaSocio instancia;

	public static VistaSocio getInstancia() {
		if (instancia == null) {
			instancia = new VistaSocio();
		}
		return instancia;
	}

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

		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(102, 204, 51));
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBuscar.setBounds(245, 78, 87, 23);
		panel.add(btnBuscar);

		JLabel lblNombreS = new JLabel("Nombre :");
		lblNombreS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreS.setBounds(45, 128, 54, 14);
		panel.add(lblNombreS);

		JLabel lblCiS = new JLabel("Cedula :");
		lblCiS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCiS.setBounds(245, 180, 46, 14);
		panel.add(lblCiS);

		JLabel lblCargoS = new JLabel("Cargo :");
		lblCargoS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCargoS.setBounds(45, 178, 46, 18);
		panel.add(lblCargoS);

		JLabel lblTalefonoS = new JLabel("Telefono :");
		lblTalefonoS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTalefonoS.setBounds(45, 230, 56, 18);
		panel.add(lblTalefonoS);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.setBounds(344, 280, 89, 23);
		panel.add(btnSalir);
		
		btnGuardarS = new JButton("Guardar");
		btnGuardarS.setForeground(Color.WHITE);
		btnGuardarS.setBackground(new Color(102, 204, 51));
		btnGuardarS.setFont(new Font("Dialog", Font.BOLD, 12));
		btnGuardarS.setBounds(45, 280, 89, 23);
		panel.add(btnGuardarS);

		textNombreS = new JTextFieldValidator();
		textNombreS.setBounds(109, 125, 117, 23);
		panel.add(textNombreS);
		textNombreS.setTipoCaracteresPermitidos(JTextFieldValidator.LETRAS_ESPACIOS_Y_NUMEROS);
		
		textCiS = new JTextFieldValidator();
		textCiS.setBounds(311, 177, 104, 23);
		panel.add(textCiS);
		textCiS.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_NUMEROS);

		textTelefonoS = new JTextFieldValidator();
		textTelefonoS.setBounds(111, 229, 115, 23);
		panel.add(textTelefonoS);
		textTelefonoS.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_NUMEROS);

		JLabel IDS = new JLabel("ID :");
		IDS.setFont(new Font("Dialog", Font.BOLD, 12));
		IDS.setBounds(45, 82, 25, 14);
		panel.add(IDS);
		
		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido.setFont(new Font("Dialog", Font.BOLD, 12));
		lblApellido.setBounds(245, 127, 51, 16);
		panel.add(lblApellido);
		
	    textApellidoS = new JTextFieldValidator();
		textApellidoS.setBounds(311, 125, 104, 23);
		panel.add(textApellidoS);
		textApellidoS.setTipoCaracteresPermitidos(JTextFieldValidator.LETRAS_ESPACIOS_Y_NUMEROS);
		
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
		btnAgregarUnidad.setBounds(275, 314, 121, 25);
		panel.add(btnAgregarUnidad);
		
		String[] items =  {"Seleccione", "Presidente", "Vice Presidente", "Tesorero", "Secretario", "Sin Cargo "};
		comboCargo = new JComboBox<Object>(items);
		comboCargo.setBackground(Color.WHITE);
		comboCargo.setFont(new Font("Dialog", Font.BOLD, 12));
		comboCargo.setBounds(111, 177, 104, 20);
		panel.add(comboCargo);
		
		textID = new JTextFieldValidator();
		textID.setToolTipText("S xx");
		textID.setBounds(109, 79, 117, 23);
		panel.add(textID);
		textID.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEliminar.setBackground(new Color(102, 204, 51));
		btnEliminar.setBounds(144, 281, 89, 23);
		panel.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnModificar.setBackground(new Color(102, 204, 51));
		btnModificar.setBounds(245, 281, 89, 23);
		panel.add(btnModificar);
		
		JLabel lblIdCoop = new JLabel("RIF Coop.:");
		lblIdCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIdCoop.setBounds(245, 230, 61, 18);
		panel.add(lblIdCoop);
		
		textIDCoop = new JTextField();
		textIDCoop.setBounds(311, 230, 104, 20);
		panel.add(textIDCoop);
		textIDCoop.setColumns(10);

	}

	// /////////===========================================///////////////

	public void activarListener(ActionListener accion) {
		btnBuscar.addActionListener(accion);
		btnGuardarS.addActionListener(accion);
		btnSalir.addActionListener(accion);
		btnAgregarUnidad.addActionListener(accion);
		btnAgregarCho.addActionListener(accion);
		comboCargo.addActionListener(accion);
	}

	
	public String getCiS() {
		return textCiS.getText();
	}

	public String getNombreS() {
		return textNombreS.getText();
	}


	public JButton getBtnAgregarUnidad() {
		return btnAgregarUnidad;
	}

	public JButton getBtnAgregarCho() {
		return btnAgregarCho;
	}

	public String getApellidoS() {
		return textApellidoS.getText();
	}

	public String getTelefonoS() {
		return textTelefonoS.getText();
	}
	
	public String getID() {
		return textID.getText();
	}
	public String getRifCoop() {
		return textIDCoop.getText();
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnGuardarS() {
		return btnGuardarS;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public void blanquearCampos() {

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
	public JComboBox<?> getcomboCargo() {
		return comboCargo;
	}
	public int getIndiceCombo() {
		return comboCargo.getSelectedIndex();
	}
	public JTextFieldValidator getTextCiS() {
		return textCiS;
	}
	public JTextFieldValidator getTextNombreS() {
		return textNombreS;
	}
	public JTextFieldValidator getTextTelefonoS() {
		return textTelefonoS;
	}
	public JTextFieldValidator getTextID() {
		return textID;
	}
	public JTextFieldValidator getTextApellidoS() {
		return textApellidoS;
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
