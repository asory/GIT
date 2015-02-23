package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import bean.JTextFieldValidator;

@SuppressWarnings("serial")
public class VistaCargarRuta extends JFrame {

	private JPanel contentPane;
	private JLabel lblRifCooperativa;
	private JLabel lblCargarRuta;
	private JLabel lblCdigo;
	private JLabel lblTipo;
	private JLabel lblNombreCoop;
	private JTextFieldValidator textRIF;
	private JTextFieldValidator textNombreCoop;
	private JTextFieldValidator textCod;
	private JTextFieldValidator textDesc;
	private JComboBox<?> comboTipo;
	private JButton btnGuardar;
	private JButton btnSalir;
	private JButton btnBuscar;
	private JLabel lblDesc;
	private DefaultComboBoxModel<?> jComboBoxModel;

	//SINGLETON
	private static VistaCargarRuta instancia;
	
	
	public static  VistaCargarRuta getInstancia(){
			if (instancia == null){
				instancia = new VistaCargarRuta() ;
			}
			return instancia;
		}
		
	
	public VistaCargarRuta() {
		setTitle("TERPA");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 456);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRifCooperativa = new JLabel("RIF Cooperativa:");
		lblRifCooperativa.setBounds(68, 70, 123, 15);
		contentPane.add(lblRifCooperativa);

		lblCargarRuta = new JLabel("CARGAR RUTA");
		lblCargarRuta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargarRuta.setBounds(286, 12, 110, 15);
		contentPane.add(lblCargarRuta);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(102, 204, 51));
		btnBuscar.setBounds(452, 65, 117, 25);
		contentPane.add(btnBuscar);

		lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(131, 208, 60, 15);
		contentPane.add(lblCdigo);

		lblDesc = new JLabel("Descripción:");
		lblDesc.setBounds(96, 275, 95, 15);
		contentPane.add(lblDesc);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(102, 204, 51));
		btnGuardar.setBounds(209, 344, 95, 25);
		contentPane.add(btnGuardar);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setBounds(474, 344, 95, 25);
		contentPane.add(btnSalir);

		
		String[] items = { "Seleccione", "Nacional", "Regional" };
		comboTipo = new JComboBox<Object>(items);
		comboTipo.setBackground(Color.WHITE);
		comboTipo.setBounds(452, 203, 117, 24);
		contentPane.add(comboTipo);

		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(398, 208, 70, 15);
		contentPane.add(lblTipo);

		lblNombreCoop = new JLabel("Nombre Cooperativa:");
		lblNombreCoop.setBounds(41, 138, 150, 15);
		contentPane.add(lblNombreCoop);

		textRIF = new JTextFieldValidator();
		textRIF.setBounds(209, 68, 187, 24);
		contentPane.add(textRIF);
		textRIF.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);

		textNombreCoop = new JTextFieldValidator();
		textNombreCoop.setBounds(209, 136, 360, 24);
		contentPane.add(textNombreCoop);
		textNombreCoop
				.setTipoCaracteresPermitidos(JTextFieldValidator.LETRAS_ESPACIOS_Y_NUMEROS);

		textCod = new JTextFieldValidator();
		textCod.setBounds(209, 206, 135, 24);
		contentPane.add(textCod);
		textCod.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_NUMEROS);

		textDesc = new JTextFieldValidator();
		textDesc.setBounds(209, 273, 360, 24);
		contentPane.add(textDesc);
		textDesc.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);
	}

	public void activarListener(ActionListener accion) {
		btnBuscar.addActionListener(accion);
		btnGuardar.addActionListener(accion);
		btnSalir.addActionListener(accion);
	}

	public String getRIF() {
		return textRIF.getText();
	}

	public String getNombreCoop() {
		return textNombreCoop.getText();
	}

	public String getCod() {
		return textCod.getText();
	}

	public JTextFieldValidator getTextNombreCoop() {
		return textNombreCoop;
	}

	public void setTextNombreCoop(JTextFieldValidator textNombreCoop) {
		this.textNombreCoop = textNombreCoop;
	}

	public String getDesc() {
		return textDesc.getText();
	}

	public String getComboTipo() {
		return (String)comboTipo.getSelectedItem();
	}

	public int getIndiceCombo() {
		return comboTipo.getSelectedIndex();
	}

	public void blanquearCampos() {
		textCod.setText("");
		textRIF.setText("");
		textNombreCoop.setText("");
		textDesc.setText("");
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}