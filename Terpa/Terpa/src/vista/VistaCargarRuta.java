package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import bean.JTextFieldValidator;

@SuppressWarnings("serial")
public class VistaCargarRuta extends JFrame {

	private JPanel contentPane;
	private JLabel lblCargarRuta;
	private JLabel lblCdigo;
	private JLabel lblTipo;
	private JTextFieldValidator textCod;
	private JTextFieldValidator textDesc;
	private JComboBox<?> comboTipo;
	private JButton btnGuardar;
	private JButton btnSalir;
	private JButton btnBuscar;
	private JLabel lblDesc;
	private DefaultComboBoxModel<?> jComboBoxModel;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextField textRif;
	private JTextField textNombreCoop;

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

		lblCargarRuta = new JLabel("CARGAR RUTA");
		lblCargarRuta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargarRuta.setBounds(286, 12, 110, 15);
		contentPane.add(lblCargarRuta);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(102, 204, 51));
		btnBuscar.setBounds(384, 65, 117, 25);
		contentPane.add(btnBuscar);

		lblCdigo = new JLabel("Codigo:");
		lblCdigo.setBounds(131, 70, 60, 15);
		contentPane.add(lblCdigo);

		lblDesc = new JLabel("Descripcion:");
		lblDesc.setBounds(96, 255, 95, 15);
		contentPane.add(lblDesc);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(102, 204, 51));
		btnGuardar.setBounds(96, 344, 95, 25);
		contentPane.add(btnGuardar);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setBounds(474, 344, 95, 25);
		contentPane.add(btnSalir);

		
		String[] items = { "Seleccione", "Nacional", "Regional" };
		comboTipo = new JComboBox<Object>(items);
		comboTipo.setBackground(Color.WHITE);
		comboTipo.setBounds(209, 156, 117, 24);
		contentPane.add(comboTipo);

		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(131, 161, 70, 15);
		contentPane.add(lblTipo);

		textCod = new JTextFieldValidator();
		textCod.setBounds(209, 65, 135, 24);
		contentPane.add(textCod);
		textCod.setTipoCaracteresPermitidos(JTextFieldValidator.SOLO_NUMEROS);

		textDesc = new JTextFieldValidator();
		textDesc.setBounds(209, 250, 360, 24);
		contentPane.add(textDesc);
		textDesc.setTipoCaracteresPermitidos(JTextFieldValidator.CUALQUIER_CARACTER);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(new Color(102, 204, 51));
		btnModificar.setBounds(348, 345, 95, 25);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(102, 204, 51));
		btnEliminar.setBounds(222, 345, 95, 25);
		contentPane.add(btnEliminar);
		
		textRif = new JTextField();
		textRif.setBounds(370, 144, 131, 20);
		contentPane.add(textRif);
		textRif.setColumns(10);
		
		textNombreCoop = new JTextField();
		textNombreCoop.setColumns(10);
		textNombreCoop.setBounds(370, 175, 131, 20);
		contentPane.add(textNombreCoop);
	}

	public void activarListener(ActionListener accion) {
		btnBuscar.addActionListener(accion);
		btnGuardar.addActionListener(accion);
		btnSalir.addActionListener(accion);
		btnEliminar.addActionListener(accion);
		btnModificar.addActionListener(accion);
	}

	public String getRIF() {
		return textRif.getText();
	}

	public String getNombreCoop() {
		return textNombreCoop.getText();
	}

	public String getCod() {
		return textCod.getText();
	}

	public JTextField getTextNombreCoop() {
		return textNombreCoop;
	}

	public void setTextNombreCoop(JTextFieldValidator textNombreCoop) {
		this.textNombreCoop = textNombreCoop;
	}
	public void settexNombrecoop(String n){
		this.textNombreCoop.setText(n);
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
	public JComboBox<?> getcomboTipo() {
		return comboTipo;
	}
	public void blanquearCampos() {
		textCod.setText("");
		textRif.setText("");
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
	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public void setComboTipo(JComboBox<?> comboTipo) {
		this.comboTipo = comboTipo;
	}
	public JTextFieldValidator getTextDesc() {
		return textDesc;
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