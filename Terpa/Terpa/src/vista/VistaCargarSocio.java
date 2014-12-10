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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCargarSocio = new JLabel("CARGAR SOCIO");
		lblCargarSocio.setBounds(213, 11, 86, 14);
		panel.add(lblCargarSocio);

		JLabel lblRifCoop = new JLabel("Rif Cooperativa :");
		lblRifCoop.setBounds(13, 51, 86, 14);
		panel.add(lblRifCoop);

		textRifCoop = new JTextField();
		textRifCoop.setColumns(10);
		textRifCoop.setBounds(98, 48, 86, 20);
		panel.add(textRifCoop);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(194, 47, 65, 23);
		panel.add(btnBuscar);

		textCoop = new JTextField();
		textCoop.setColumns(10);
		textCoop.setBounds(299, 48, 86, 20);
		panel.add(textCoop);

		JLabel lblNombreS = new JLabel("Nombre :");
		lblNombreS.setBounds(45, 103, 54, 14);
		panel.add(lblNombreS);

		textNombreS = new JTextField();
		textNombreS.setColumns(10);
		textNombreS.setBounds(98, 100, 86, 20);
		panel.add(textNombreS);

		JLabel lblCiS = new JLabel("Cedula :");
		lblCiS.setBounds(253, 103, 46, 14);
		panel.add(lblCiS);

		textCiS = new JTextField();
		textCiS.setColumns(10);
		textCiS.setBounds(299, 100, 86, 20);
		panel.add(textCiS);

		JLabel lblCargoS = new JLabel("Cargo :");
		lblCargoS.setBounds(55, 137, 56, 14);
		panel.add(lblCargoS);

		textCargoS = new JTextField();
		textCargoS.setColumns(10);
		textCargoS.setBounds(98, 134, 86, 20);
		panel.add(textCargoS);

		JLabel lblTalefonoS = new JLabel("Telefono :");
		lblTalefonoS.setBounds(243, 134, 56, 14);
		panel.add(lblTalefonoS);

		textTelefonoS = new JTextField();
		textTelefonoS.setColumns(10);
		textTelefonoS.setBounds(299, 131, 86, 20);
		panel.add(textTelefonoS);

		JButton btnCargarTxtS = new JButton("Cargar por Archivo txt");
		btnCargarTxtS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCargarTxtS.setBounds(10, 178, 141, 23);
		panel.add(btnCargarTxtS);

		JButton btnAgregarOtroS = new JButton("Agregar Otro");
		btnAgregarOtroS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregarOtroS.setBounds(194, 178, 97, 23);
		panel.add(btnAgregarOtroS);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					VistaCargarSocio v = new VistaCargarSocio();
					v.dispose();
				}
			}
		});

		JButton btnGuardarS = new JButton("Guardar");
		btnGuardarS.setBounds(338, 178, 89, 23);
		panel.add(btnGuardarS);
		btnSalir.setBounds(202, 212, 89, 23);
		panel.add(btnSalir);
	}

}
