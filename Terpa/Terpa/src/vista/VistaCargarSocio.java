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

public class VistaCargarSocio extends JFrame {

	private JPanel contentPane;
	private JTextField textRifCoop;
	private JTextField textCoop;
	private JTextField textNombreS;
	private JTextField textCargoS;
	private JTextField textCiS;
	private JTextField textTelefonoS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCargarSocio frame = new VistaCargarSocio();
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
	public VistaCargarSocio() {
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

		textRifCoop = new JTextField();
		textRifCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		textRifCoop.setColumns(10);
		textRifCoop.setBounds(112, 79, 102, 20);
		panel.add(textRifCoop);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(102, 204, 51));
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(224, 78, 87, 23);
		panel.add(btnBuscar);

		textCoop = new JTextField();
		textCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		textCoop.setColumns(10);
		textCoop.setBounds(332, 79, 102, 20);
		panel.add(textCoop);

		JLabel lblNombreS = new JLabel("Nombre :");
		lblNombreS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombreS.setBounds(45, 172, 54, 14);
		panel.add(lblNombreS);

		textNombreS = new JTextField();
		textNombreS.setFont(new Font("Dialog", Font.BOLD, 12));
		textNombreS.setColumns(10);
		textNombreS.setBounds(98, 169, 104, 20);
		panel.add(textNombreS);

		JLabel lblCiS = new JLabel("Cedula :");
		lblCiS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCiS.setBounds(243, 172, 56, 14);
		panel.add(lblCiS);

		textCiS = new JTextField();
		textCiS.setFont(new Font("Dialog", Font.BOLD, 12));
		textCiS.setColumns(10);
		textCiS.setBounds(299, 169, 104, 20);
		panel.add(textCiS);

		JLabel lblCargoS = new JLabel("Cargo :");
		lblCargoS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCargoS.setBounds(45, 215, 46, 18);
		panel.add(lblCargoS);

		textCargoS = new JTextField();
		textCargoS.setFont(new Font("Dialog", Font.BOLD, 12));
		textCargoS.setColumns(10);
		textCargoS.setBounds(98, 213, 104, 20);
		panel.add(textCargoS);

		JLabel lblTalefonoS = new JLabel("Telefono :");
		lblTalefonoS.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTalefonoS.setBounds(243, 215, 56, 18);
		panel.add(lblTalefonoS);

		textTelefonoS = new JTextField();
		textTelefonoS.setFont(new Font("Dialog", Font.BOLD, 12));
		textTelefonoS.setColumns(10);
		textTelefonoS.setBounds(299, 213, 104, 21);
		panel.add(textTelefonoS);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					VistaCargarSocio v = new VistaCargarSocio();
					v.dispose();
				}
			}
		});

		JButton btnGuardarS = new JButton("Guardar");
		btnGuardarS.setForeground(Color.WHITE);
		btnGuardarS.setBackground(new Color(102, 204, 51));
		btnGuardarS.setFont(new Font("Dialog", Font.BOLD, 12));
		btnGuardarS.setBounds(116, 294, 89, 23);
		panel.add(btnGuardarS);
		btnSalir.setBounds(257, 294, 89, 23);
		panel.add(btnSalir);
	}
}
