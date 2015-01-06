package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import bean.JTextFieldValidator;

import java.awt.TextField;


public class VistaSocio extends JFrame {

	private JPanel contentPane;
	private JButton btnBuscarCoop;//
	private JButton btnGuardarS;//
	private JButton btnSalir;//
	
	private JTextFieldValidator textRifCoop;
	private JTextFieldValidator textCoop;
	private JTextFieldValidator textCiS;
	private JTextFieldValidator textNombreS;
	private JTextFieldValidator textCargoS;
	private JTextFieldValidator textTelefonoS;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { VistaCoop frame = new VistaCoop();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 * 
	 * /** Create the frame.
	 */
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
		btnBuscarCoop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarCoop.setBounds(224, 78, 87, 23);
		panel.add(btnBuscarCoop);

		JLabel lblNombreS = new JLabel("Nombre :");
		lblNombreS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreS.setBounds(45, 172, 54, 14);
		panel.add(lblNombreS);

		JLabel lblCiS = new JLabel("Cedula :");
		lblCiS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCiS.setBounds(243, 172, 56, 14);
		panel.add(lblCiS);

		JLabel lblCargoS = new JLabel("Cargo :");
		lblCargoS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCargoS.setBounds(45, 215, 46, 18);
		panel.add(lblCargoS);

		JLabel lblTalefonoS = new JLabel("Telefono :");
		lblTalefonoS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTalefonoS.setBounds(243, 215, 56, 18);
		panel.add(lblTalefonoS);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					System.exit(DISPOSE_ON_CLOSE);
				}
			}
		});

		btnGuardarS = new JButton("Guardar");
		btnGuardarS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardarS.setForeground(Color.WHITE);
		btnGuardarS.setBackground(new Color(102, 204, 51));
		btnGuardarS.setFont(new Font("Dialog", Font.BOLD, 12));
		btnGuardarS.setBounds(116, 294, 89, 23);
		panel.add(btnGuardarS);
		btnSalir.setBounds(257, 294, 89, 23);
		panel.add(btnSalir);
		
		JTextFieldValidator textRifCoop = new JTextFieldValidator();
		textRifCoop.setBounds(112, 81, 102, 20);
		panel.add(textRifCoop);
		
		JTextFieldValidator textCoop = new JTextFieldValidator();
		textCoop.setBounds(333, 80, 102, 19);
		panel.add(textCoop);
		
		JTextFieldValidator textNombreS = new JTextFieldValidator();
		textNombreS.setBounds(98, 169, 104, 17);
		panel.add(textNombreS);
		
		JTextFieldValidator textCiS = new JTextFieldValidator();
		textCiS.setBounds(299, 169, 104, 23);
		panel.add(textCiS);
		
		JTextFieldValidator textCargoS = new JTextFieldValidator();
		textCargoS.setBounds(101, 215, 104, 20);
		panel.add(textCargoS);
		
		JTextFieldValidator textTelefonoS = new JTextFieldValidator();
		textTelefonoS.setBounds(299, 214, 104, 23);
		panel.add(textTelefonoS);
	}
	
///////////===========================================///////////////
	
public void activarListener(ActionListener accion) {
	btnBuscarCoop.addActionListener(accion);
	btnGuardarS.addActionListener(accion);
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

public String getCiS() {
	return textCiS.getText();
}

public  JTextFieldValidator getNombreS() {
	return textNombreS;
}

public  JTextFieldValidator getCargoS() {
	return textCargoS;
}

public  JTextFieldValidator getTelefonoS() {
	return textTelefonoS;
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
	textCargoS.setText("");
	textTelefonoS.setText("");
}

public void mostrarMensaje(String mensaje) {
	JOptionPane.showMessageDialog(this, mensaje);
}

}
