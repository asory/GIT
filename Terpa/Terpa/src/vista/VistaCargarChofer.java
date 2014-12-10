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
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;

public class VistaCargarChofer extends javax.swing.JFrame {//
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

	// public CargarChofer() {
	// super();
	// initGUI();
	// }

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCargarChofer frame = new VistaCargarChofer();
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
	public VistaCargarChofer() {
		setTitle("TERPA");
		// Le indicamos que finalice la aplicacion cuando se haga click
		// en la X (Cerrar) de la Ventana
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
		lblRifCoop.setBounds(10, 82, 104, 14);
		panel.add(lblRifCoop);

		textRifCoop = new JTextField();
		textRifCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		textRifCoop.setBounds(112, 79, 102, 20);
		panel.add(textRifCoop);
		textRifCoop.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBackground(new Color(102, 204, 51));
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 12));
		// getContentPane().add(btnBuscar);///
		// btnBuscar.setText("Buscar");;///
		btnBuscar.setBounds(224, 78, 87, 23);
		// btnBuscar.setActionCommand("Buscar");///
		panel.add(btnBuscar);

		textCoop = new JTextField();
		textCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		textCoop.setBounds(332, 79, 102, 20);
		panel.add(textCoop);
		textCoop.setColumns(10);

		JLabel lblNombreC = new JLabel("Nombre :");
		lblNombreC.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreC.setBounds(45, 172, 54, 14);
		panel.add(lblNombreC);

		textNombreC = new JTextField();
		textNombreC.setFont(new Font("Dialog", Font.BOLD, 12));
		textNombreC.setBounds(98, 169, 104, 20);
		panel.add(textNombreC);
		textNombreC.setColumns(10);

		JLabel lblApellidoC = new JLabel("Apellido :");
		lblApellidoC.setFont(new Font("Dialog", Font.BOLD, 12));
		lblApellidoC.setBounds(243, 172, 56, 14);
		panel.add(lblApellidoC);

		textApellidoC = new JTextField();
		textApellidoC.setFont(new Font("Dialog", Font.BOLD, 12));
		textApellidoC.setBounds(299, 169, 104, 20);
		panel.add(textApellidoC);
		textApellidoC.setColumns(10);

		JLabel lblCiC = new JLabel("Cedula :");
		lblCiC.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCiC.setBounds(45, 215, 46, 18);
		panel.add(lblCiC);

		textCiC = new JTextField();
		textCiC.setFont(new Font("Dialog", Font.BOLD, 12));
		textCiC.setBounds(98, 213, 104, 21);
		panel.add(textCiC);
		textCiC.setColumns(10);

		JLabel lblTelefonoC = new JLabel("Telefono :");
		lblTelefonoC.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTelefonoC.setBounds(243, 215, 56, 18);
		panel.add(lblTelefonoC);

		textTelefonoC = new JTextField();
		textTelefonoC.setFont(new Font("Dialog", Font.BOLD, 12));
		textTelefonoC.setBounds(299, 213, 104, 21);
		panel.add(textTelefonoC);
		textTelefonoC.setColumns(10);

		JButton btnGuardarC = new JButton("Guardar");
		btnGuardarC.setForeground(Color.WHITE);
		btnGuardarC.setBackground(new Color(102, 204, 51));
		btnGuardarC.setFont(new Font("Dialog", Font.BOLD, 12));
		btnGuardarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaCargarChofer vccho = new VistaCargarChofer();
				vccho.limpiarPropietario();
			}
		});
		btnGuardarC.setBounds(116, 294, 89, 23);
		panel.add(btnGuardarC);
		// btnGuardarC.setActionCommand("GuardarC");////////////////
		// /////////////////////
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaCargarChofer vccho = new VistaCargarChofer();
				vccho.dispose();
				vccho.setVisible(false);

			}
		});
		// getContentPane().add(btnSalir); //
		// btnSalir.setText("Salir"); //
		btnSalir.setBounds(257, 294, 89, 23);
		// btnSalir.setActionCommand("salir"); //
		panel.add(btnSalir);
	}

	// /////////===========================================
	public String getCiC() {
		return textCiC.getText();
	}

	public String getNombreC() {
		return textNombreC.getText();
	}

	public String getApellidoC() {
		return textApellidoC.getText();
	}

	public String getTelefonoC() {
		return textTelefonoC.getText();
	}

	public void limpiarPropietario() {
		textCiC.setText("");
		textNombreC.setText("");
		textApellidoC.setText("");
		textTelefonoC.setText("");
		textCiC.requestFocusInWindow();
	}
	// /////////////////==========================================
}
