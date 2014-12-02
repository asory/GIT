package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCoop extends JFrame {

	private JPanel contentPane;
	private JTextField textRif;
	private JTextField textNombreCoop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCoop frame = new VentanaCoop();
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
	public VentanaCoop() {
		setTitle("TERPA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 429, 262);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textRif = new JTextField();
		textRif.setBounds(87, 96, 86, 20);
		panel.add(textRif);
		textRif.setColumns(10);
		
		textNombreCoop = new JTextField();
		textNombreCoop.setBounds(282, 96, 86, 20);
		panel.add(textNombreCoop);
		textNombreCoop.setColumns(10);
		
		JButton btnCargarArchivo = new JButton("Cargar Archivo");
		btnCargarArchivo.setBounds(41, 189, 105, 23);
		panel.add(btnCargarArchivo);
		
		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.setBounds(170, 189, 89, 23);
		panel.add(btnAgregar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		btnSalir.setBounds(291, 189, 89, 23);
		panel.add(btnSalir);
		JLabel lblAsignarViaje = new JLabel("Cooperativa");
		lblAsignarViaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAsignarViaje.setBounds(157, 11, 86, 50);
		panel.add(lblAsignarViaje);
		
		JLabel lblRif = new JLabel("RIF");
		lblRif.setBounds(41, 81, 128, 50);
		panel.add(lblRif);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(225, 81, 68, 50);
		panel.add(lblNombre);
	}
}
