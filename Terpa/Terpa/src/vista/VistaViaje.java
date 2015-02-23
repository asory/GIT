package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import bean.JTextFieldValidator;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;



@SuppressWarnings("serial")
public class VistaViaje extends JFrame {

	private JPanel contentPane;
	private JDateChooser dateChooser;
	private JButton btnGenerar;
	private JButton btnSalir;
	private JTextField TextvRif;
	private JTextFieldValidator textDias;
	private JTextFieldValidator textCantidad;
	private JTable table;
	

	// SINGLETON
	private static VistaViaje instancia;

	public static VistaViaje getInstancia() {
		if (instancia == null) {
			instancia = new VistaViaje();
		}
		return instancia;
	}

	public VistaViaje() {

		setTitle("TERPA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 775, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 739, 437);
		contentPane.add(panel);
		panel.setLayout(null);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(337, 65, 126, 20);
		dateChooser.getCalendarButton().setFont(
				new Font("Dialog", Font.BOLD, 12));
		dateChooser.getCalendarButton().setBackground(new Color(102, 204, 51));
		dateChooser.setToolTipText("");
		panel.add(dateChooser);

		JLabel lblCooperativaRif = new JLabel("Cooperativa Rif:");
		lblCooperativaRif.setBounds(38, 65, 103, 17);
		lblCooperativaRif.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(lblCooperativaRif);

		JLabel label_1 = new JLabel("Fecha:");
		label_1.setBounds(286, 65, 41, 17);
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(label_1);

		btnGenerar = new JButton("GENERAR");
		btnGenerar.setBounds(600, 65, 87, 25);
		btnGenerar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnGenerar.setBackground(new Color(102, 204, 51));
		btnGenerar.setForeground(Color.WHITE);
		panel.add(btnGenerar);

		JLabel lblAsignarViaje = new JLabel("Asignar Viaje");
		lblAsignarViaje.setBounds(304, 11, 115, 29);
		lblAsignarViaje.setFont(new Font("Dialog", Font.BOLD, 17));
		panel.add(lblAsignarViaje);

		btnSalir = new JButton("Nuevo");
		btnSalir.setBounds(621, 403, 89, 23);
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setForeground(Color.WHITE);
		panel.add(btnSalir);

		TextvRif = new JTextField();
		TextvRif.setToolTipText("J1234");
		TextvRif.setBounds(136, 62, 103, 20);
		panel.add(TextvRif);
		TextvRif.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 700, 267);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEditingColumn(0);
		table.setEditingRow(0);
		table.setEnabled(false);
		table.computeVisibleRect(getBounds());
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFont(new Font("Arial", Font.BOLD, 12));
		table.setName("Viajes");
		table.setSelectionBackground(Color.DARK_GRAY);
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setGridColor(Color.BLACK);
		table.setAutoCreateRowSorter(true);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.LIGHT_GRAY);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setShowGrid(true);
		table.setAutoscrolls(true);// *
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setForeground(Color.WHITE);

		JLabel lblViajesDeLa = new JLabel("VIAJES ");
		lblViajesDeLa.setFont(new Font("Dialog", Font.BOLD, 13));
		lblViajesDeLa.setBounds(256, 116, 176, 14);
		panel.add(lblViajesDeLa);

		textDias = new JTextFieldValidator();
		textDias.setToolTipText("Para cuantos dias desea generar los viajes (empezando desde la fecha seleccionada ) ");
		textDias.setTipoCaracteresPermitidos(textDias.SOLO_NUMEROS);
		textDias.setBounds(539, 47, 41, 20);
		panel.add(textDias);

		textCantidad = new JTextFieldValidator();
		textCantidad.setToolTipText("Nro de viaje a generar");
		textCantidad.setTipoCaracteresPermitidos(textCantidad.SOLO_NUMEROS);
		textCantidad.setBounds(539, 79, 41, 20);
		panel.add(textCantidad);

		JLabel lblDias = new JLabel("Dias ");
		lblDias.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDias.setBounds(496, 46, 33, 20);
		panel.add(lblDias);

		JLabel lblNewLabel = new JLabel("Cantidad");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(488, 80, 75, 16);
		panel.add(lblNewLabel);
		
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnGenerar() {
		return btnGenerar;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public String getRif() {
		return TextvRif.getText();
	}

	public Date getFechaI() {
		return dateChooser.getDate();
	}

	public JTextFieldValidator getTextDias() {
		return textDias;
	}

	public JTextFieldValidator getTextCantidad() {
		return textCantidad;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void activarListener(ActionListener accion) {
		btnGenerar.addActionListener(accion);
		btnSalir.addActionListener(accion);

	}

	public void Limpiar() {
		TextvRif.setText("");
		textCantidad.setText("");
		textDias.setText("");

	}

}
