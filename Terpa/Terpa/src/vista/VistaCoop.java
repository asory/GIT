package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;


import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import bean.JTextFieldValidator;

@SuppressWarnings("serial")
public class VistaCoop extends JFrame {

	private JPanel contentPane;
	private JTextFieldValidator textRif;
	private JTextFieldValidator texNombreC;
	JButton btnAgregar;
	JButton btnAgregarSocio;
	JButton btnSalir;

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

		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBackground(new Color(102, 204, 51));
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregar.setBounds(113, 264, 89, 23);
		panel.add(btnAgregar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
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
		lblNombre.setBounds(257, 159, 61, 20);
		panel.add(lblNombre);

		JTextFieldValidator textRif = new JTextFieldValidator();
		textRif.setFont(new Font("Dialog", Font.BOLD, 12));
		textRif.setTipoCaracteresPermitidos(JTextFieldValidator.LETRAS_Y_NUMEROS);
		textRif.setMaximaLongitud(10);
		textRif.setBounds(75, 160, 101, 20);
		panel.add(textRif);

		JTextFieldValidator textNombreC = new JTextFieldValidator();
		textNombreC.setFont(new Font("Dialog", Font.BOLD, 12));
		textNombreC
				.setTipoCaracteresPermitidos(JTextFieldValidator.LETRAS_ESPACIOS_Y_NUMEROS);
		textNombreC.setMaximaLongitud(30);
		textNombreC.setBounds(328, 160, 101, 20);
		panel.add(textNombreC);

		JButton btnAgregarSocio = new JButton("Agregar Socios");
		btnAgregarSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregarSocio.setForeground(Color.WHITE);
		btnAgregarSocio.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregarSocio.setBackground(new Color(102, 204, 51));
		btnAgregarSocio.setBounds(173, 312, 121, 25);
		btnAgregarSocio.setVisible(false);
		panel.add(btnAgregarSocio);
	}

	public void Limpiar() {
		textRif.setText("");
		texNombreC.setText("");
	}

	public JTextFieldValidator getTextRif() {
		return textRif;
	}

	public JTextFieldValidator getTexNombreC() {
		return texNombreC;
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

	public void setBtnAgregarSocio(JButton btnAgregarSocio) {
		this.btnAgregarSocio = btnAgregarSocio;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public void agregarListener(ActionListener e) {
		this.btnAgregar.addActionListener(e);
		this.btnAgregarSocio.addActionListener(e);
		this.btnSalir.addActionListener(e);
		
	}
}
