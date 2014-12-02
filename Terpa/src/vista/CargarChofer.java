package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CargarChofer extends javax.swing.JFrame {//
	private JPanel contentPane;
	private JTextField textRifCoop;
	private JTextField textCoop;
	private JTextField textNombreC;
	private JTextField textCiC;
	private JTextField textTelefonoC;
	private JTextField textApellidoC;
	
	private JButton btnBuscar;//
	private JButton btnCargarTxt;//
	private JButton btnAgregarOtroC;//
	private JButton btnGuardarC;//
	private JButton btnSalir;//
	/**
	 * Launch the application.
	 */
	
	//public CargarChofer() {
	//	super();
	//	initGUI();		
	//}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarChofer frame = new CargarChofer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CargarChofer() {
		setTitle("TERPA");
		// Le indicamos que finalice la aplicacion cuando se haga click
		// en la X (Cerrar) de la Ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 251);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCargarChofer = new JLabel("CARGAR CHOFER");
		lblCargarChofer.setBounds(158, 11, 86, 14);
		panel.add(lblCargarChofer);
		
		JLabel lblRifCoop = new JLabel("Rif Cooperativa :");
		lblRifCoop.setBounds(13, 51, 86, 14);
		panel.add(lblRifCoop);
		
		textRifCoop = new JTextField();
		textRifCoop.setBounds(98, 48, 86, 20);
		panel.add(textRifCoop);
		textRifCoop.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		//getContentPane().add(btnBuscar);///
		//btnBuscar.setText("Buscar");;///
		btnBuscar.setBounds(194, 47, 65, 23);
		//btnBuscar.setActionCommand("Buscar");///
		panel.add(btnBuscar);
		
		textCoop = new JTextField();
		textCoop.setBounds(286, 48, 86, 20);
		panel.add(textCoop);
		textCoop.setColumns(10);
		
		JLabel lblNombreC = new JLabel("Nombre :");
		lblNombreC.setBounds(45, 103, 54, 14);
		panel.add(lblNombreC);
		
		textNombreC = new JTextField();
		textNombreC.setBounds(98, 100, 86, 20);
		panel.add(textNombreC);
		textNombreC.setColumns(10);
		
		JLabel lblApellidoC = new JLabel("Apellido :");
		lblApellidoC.setBounds(243, 103, 56, 14);
		panel.add(lblApellidoC);
		
		textApellidoC = new JTextField();
		textApellidoC.setBounds(299, 100, 86, 20);
		panel.add(textApellidoC);
		textApellidoC.setColumns(10);
		
		JLabel lblCiC = new JLabel("Cedula :");
		lblCiC.setBounds(45, 134, 46, 14);
		panel.add(lblCiC);
		
		textCiC = new JTextField();
		textCiC.setBounds(98, 131, 86, 20);
		panel.add(textCiC);
		textCiC.setColumns(10);
		
		JLabel lblTelefonoC = new JLabel("Telefono :");
		lblTelefonoC.setBounds(243, 134, 56, 14);
		panel.add(lblTelefonoC);
		
		textTelefonoC = new JTextField();
		textTelefonoC.setBounds(299, 131, 86, 20);
		panel.add(textTelefonoC);
		textTelefonoC.setColumns(10);
		
		JButton btnCargarTxtC = new JButton("Cargar por Archivo txt");
		btnCargarTxtC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCargarTxtC.setBounds(29, 178, 141, 23);
		panel.add(btnCargarTxtC);
		
		JButton btnAgregarOtroC = new JButton("Agregar Otro");
		btnAgregarOtroC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			
		});
		btnAgregarOtroC.setBounds(194, 178, 97, 23);
		panel.add(btnAgregarOtroC);
		
		JButton btnGuardarC = new JButton("Guardar");
		btnGuardarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardarC.setBounds(325, 178, 89, 23);
		panel.add(btnGuardarC);
		//btnGuardarC.setActionCommand("GuardarC");////////////////
		///////////////////////
		JButton btnSalir = new JButton("Salir");
		//getContentPane().add(btnSalir); //
		//btnSalir.setText("Salir"); //
		btnSalir.setBounds(202, 212, 89, 23);
		//btnSalir.setActionCommand("salir"); //
		panel.add(btnSalir);
	}

	
	///////////===========================================
	public String getCiC(){
		return textCiC.getText();
	}
	
	public String getNombreC(){
		return textNombreC.getText();
	}
	
	public String getApellidoC(){
		return textApellidoC.getText();
	}
	
	public String getTelefonoC(){
		return textTelefonoC.getText();
	}
	
	
	public void limpiarPropietario(){
		textCiC.setText("");
		textNombreC.setText("");
		textApellidoC.setText("");
		textTelefonoC.setText("");
		textCiC.requestFocusInWindow();
	}
	///////////////////==========================================
}
