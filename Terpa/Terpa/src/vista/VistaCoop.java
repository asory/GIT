package vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;



import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import bean.JTextFieldValidator;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class VistaCoop extends JFrame {

	private JPanel contentPane;
	private JButton btnAgregar;
	private JButton btnAgregarSocio;
	private JButton btnSalir;
	private JFormattedTextField textRif;
    private JFormattedTextField textNombreC;

	public VistaCoop() {
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

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBackground(new Color(102, 204, 51));
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregar.setBounds(113, 264, 89, 23);
		panel.add(btnAgregar);

		btnSalir = new JButton("SALIR");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.setBounds(257, 264, 89, 23);
		panel.add(btnSalir);
		
		
		JLabel lblAsignarViaje = new JLabel(" AGREGAR COOPERATIVA");
		lblAsignarViaje.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAsignarViaje.setBounds(157, 11, 189, 52);
		panel.add(lblAsignarViaje);

		JLabel lblRif = new JLabel("Rif :");
		lblRif.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRif.setBounds(33, 161, 32, 17);
		panel.add(lblRif);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombre.setBounds(243, 159, 61, 20);
		panel.add(lblNombre);

		btnAgregarSocio = new JButton("Agregar Socios");
		btnAgregarSocio.setForeground(Color.WHITE);
		btnAgregarSocio.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregarSocio.setBackground(new Color(102, 204, 51));
		btnAgregarSocio.setBounds(173, 312, 121, 25);
		btnAgregarSocio.setVisible(false);
		panel.add(btnAgregarSocio);
		
		textRif = new JFormattedTextField();
		textRif.setBounds(72, 160, 101, 20);
		panel.add(textRif);
		
		textNombreC = new JFormattedTextField();
		textNombreC.setBounds(300, 160, 115, 20);
		panel.add(textNombreC);
	}

	public void activarListener(ActionListener accion) {
		btnAgregar.addActionListener(accion);
		btnAgregarSocio.addActionListener(accion);
		btnSalir.addActionListener(accion);
		
	}
	public void Limpiar() {
		textRif.setText("");
		textNombreC.setText("");
	}

	public String getTextRif() {
		return textRif.getText();
	}

	public String getTexNombreC() {
		return textNombreC.getText();
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnAgregarSocio() {
		return btnAgregarSocio;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void mostrarMensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
