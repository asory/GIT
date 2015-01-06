package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;

import bean.JTextFieldValidator;

import java.awt.TextField;

public class VistaChofer extends javax.swing.JFrame {//
	
	private JPanel contentPane;
	private JButton btnBuscarCoop;//
	private JButton btnGuardarC;//
	private JButton btnSalir;//
	
	private JTextFieldValidator textRifCoop;
	private JTextFieldValidator textCoop;
	private JTextFieldValidator textCiC;
	private JTextFieldValidator textNombreC;
	private JTextFieldValidator textApellidoC;
	private JTextFieldValidator textTelefonoC;
	private JTextFieldValidator textSocioC;
	/**
	 * Launch the application.
	 */
	// public CargarChofer() {
	// super();
	// initGUI();
	// }

	//public static void main(String[] args) {
   // JEventQueue.invokeLater(new Runnable(){
	//		public void run() {
	//			try {
	//				VistaChofer frame = new VistaChofer();
	//				frame.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the frame.
	 */
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
		lblRifCoop.setBounds(10, 82, 104, 14);
		panel.add(lblRifCoop);
		
		JTextFieldValidator textRifCoop = new JTextFieldValidator();
		textRifCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		textRifCoop.setBounds(110, 80, 104, 20);
		panel.add(textRifCoop);
		
		//JButton 
		btnBuscarCoop = new JButton("Buscar");
		btnBuscarCoop.setForeground(Color.WHITE);
		btnBuscarCoop.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
		});
		btnBuscarCoop.setBackground(new Color(102, 204, 51));
		btnBuscarCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBuscarCoop.setBounds(224, 78, 87, 23);
		panel.add(btnBuscarCoop);
		
		JTextFieldValidator textCoop = new JTextFieldValidator();
		textCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		textCoop.setBounds(332, 79, 102, 23);
		panel.add(textCoop);

		JLabel lblNombreC = new JLabel("Nombre :");
		lblNombreC.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreC.setBounds(52, 162, 54, 14);
		panel.add(lblNombreC);
		
		JTextFieldValidator textNombreC = new JTextFieldValidator();
		textNombreC.setFont(new Font("Dialog", Font.BOLD, 12));
		textNombreC.setBounds(105, 159, 104, 23);
		panel.add(textNombreC);

		JLabel lblApellidoC = new JLabel("Apellido :");
		lblApellidoC.setFont(new Font("Dialog", Font.BOLD, 12));
		lblApellidoC.setBounds(250, 162, 56, 14);
		panel.add(lblApellidoC);
		
		JTextFieldValidator textApellidoC_1 = new JTextFieldValidator();
		textApellidoC_1.setFont(new Font("Dialog", Font.BOLD, 12));
		textApellidoC_1.setBounds(306, 160, 104, 23);
		panel.add(textApellidoC_1);

		JLabel lblCiC = new JLabel("Cedula :");
		lblCiC.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCiC.setBounds(52, 205, 46, 18);
		panel.add(lblCiC);
		
		JTextFieldValidator textCiC = new JTextFieldValidator();
		textCiC.setFont(new Font("Dialog", Font.BOLD, 12));
		textCiC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textCiC.setBounds(105, 205, 104, 23);
		panel.add(textCiC);

		JLabel lblTelefonoC = new JLabel("Telefono :");
		lblTelefonoC.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTelefonoC.setBounds(250, 205, 56, 18);
		panel.add(lblTelefonoC);
		
		JTextFieldValidator textTelefonoC = new JTextFieldValidator();
		textTelefonoC.setFont(new Font("Dialog", Font.BOLD, 12));
		textTelefonoC.setBounds(306, 204, 104, 23);
		panel.add(textTelefonoC);
		
		JLabel lblSocio = new JLabel("Socio :");
		lblSocio.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSocio.setBounds(52, 247, 46, 14);
		panel.add(lblSocio);
		
		JTextFieldValidator textSocioC = new JTextFieldValidator();
		textSocioC.setFont(new Font("Dialog", Font.BOLD, 12));
		textSocioC.setBounds(103, 243, 102, 23);
		panel.add(textSocioC);

		//JButton 
		btnGuardarC = new JButton("Guardar");
		btnGuardarC.setForeground(Color.WHITE);
		btnGuardarC.setBackground(new Color(102, 204, 51));
		btnGuardarC.setFont(new Font("Dialog", Font.BOLD, 12));
		btnGuardarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaChofer vccho = new VistaChofer();
				vccho.blanquearCampos();
			}
		});
		
		btnGuardarC.setBounds(116, 294, 89, 23);
		panel.add(btnGuardarC);
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaChofer vccho = new VistaChofer();
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

	///////////===========================================///////////////
	
	public void activarListener(ActionListener accion) {
		btnBuscarCoop.addActionListener(accion);
		btnGuardarC.addActionListener(accion);
		btnSalir.addActionListener(accion);
		
		
	}
	
	public String getRifCoop() {
		return textRifCoop.getText();
	}
	
	public JTextFieldValidator getCoop() {
		return textCoop;
	}
	
	public void setCoop(JTextFieldValidator textCoop) {
		this.textCoop  = textCoop;
	}
	
	public String getCiC() {
		return textCiC.getText();
	}

	public  JTextFieldValidator getNombreC() {
		return textNombreC;
	}

	public  JTextFieldValidator getApellidoC() {
		return textApellidoC;
	}

	public  JTextFieldValidator getTelefonoC() {
		return textTelefonoC;
	}
	
	public  String getSocioC() {
		return textSocioC.getText();
	}
	
	public JButton getBtnBuscarCoop() {
		return btnBuscarCoop;
	}
	
	public JButton getBtnGuardarC() {
		return btnGuardarC;
	}
	
	public JButton getBtnSalir() {
		return btnSalir;
	}
	
	public void blanquearCampos() {
		textRifCoop.setText("");
		textCoop.setText("");
		textCiC.setText("");
		textNombreC.setText("");
		textApellidoC.setText("");
		textTelefonoC.setText("");
		textSocioC.setText("");
		//textCiC.requestFocusInWindow();
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
}
