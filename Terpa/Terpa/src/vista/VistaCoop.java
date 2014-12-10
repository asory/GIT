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
import java.io.*;

public class VistaCoop extends JFrame {

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
					VistaCoop frame = new VistaCoop();
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

		textRif = new JTextField();
		textRif.setFont(new Font("Dialog", Font.BOLD, 12));
		textRif.setBounds(66, 159, 102, 20);
		panel.add(textRif);
		textRif.setColumns(10);

		textNombreCoop = new JTextField();
		textNombreCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		textNombreCoop.setBounds(320, 159, 102, 20);
		panel.add(textNombreCoop);
		textNombreCoop.setColumns(10);

		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBackground(new Color(102, 204, 51));
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregar.setBounds(116, 294, 89, 23);
		panel.add(btnAgregar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				;
			}
		});
		btnSalir.setBounds(257, 294, 89, 23);
		panel.add(btnSalir);
		JLabel lblAsignarViaje = new JLabel("CARGAR COOPERATIVA");
		lblAsignarViaje.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAsignarViaje.setBounds(157, 11, 140, 50);
		panel.add(lblAsignarViaje);

		JLabel lblRif = new JLabel("Rif :");
		lblRif.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRif.setBounds(33, 161, 32, 17);
		panel.add(lblRif);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombre.setBounds(257, 159, 61, 20);
		panel.add(lblNombre);
	}
}
