package vista;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

import modelo.Viaje;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import java.awt.Dimension;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;

@SuppressWarnings("serial")
public class VistaViaje extends JFrame {

	private JPanel contentPane;
	private JDateChooser dateChooser;
	private JButton btnGenerar;
	private JButton btnSalir;
	private JTextField TextvRif;
	private JTable table;
	//private JScrollPane scrollPane;

	public VistaViaje() {

		setTitle("TERPA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 624, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 598, 443);
		contentPane.add(panel);
		panel.setLayout(null);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(323, 62, 126, 20);
		dateChooser.getCalendarButton().setFont(
				new Font("Dialog", Font.BOLD, 12));
		dateChooser.getCalendarButton().setBackground(new Color(102, 204, 51));
		dateChooser.setToolTipText("");
		panel.add(dateChooser);

		JLabel lblCooperativaRif = new JLabel("Cooperativa Rif:");
		lblCooperativaRif.setBounds(10, 62, 103, 17);
		lblCooperativaRif.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(lblCooperativaRif);

		JLabel label_1 = new JLabel("Fecha:");
		label_1.setBounds(272, 62, 41, 17);
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(label_1);

		btnGenerar = new JButton("GENERAR");
		btnGenerar.setBounds(493, 59, 82, 23);
		btnGenerar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnGenerar.setBackground(new Color(102, 204, 51));
		btnGenerar.setForeground(Color.WHITE);
		panel.add(btnGenerar);

		JLabel lblAsignarViaje = new JLabel("Asignar Viaje");
		lblAsignarViaje.setBounds(185, 11, 115, 29);
		lblAsignarViaje.setFont(new Font("Dialog", Font.BOLD, 17));
		panel.add(lblAsignarViaje);

		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(486, 409, 89, 23);
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setForeground(Color.WHITE);
		panel.add(btnSalir);

		TextvRif = new JTextField();
		TextvRif.setBounds(107, 62, 103, 20);
		panel.add(TextvRif);
		TextvRif.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 131, 588, 267);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		table = new JTable();
		table.setMaximumSize(new Dimension(10, 0));
		table.setBounds(35, 129, 502, 251);
		scrollPane.setViewportView(table);
		
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
		
		JLabel lblViajesDeLa = new JLabel("VIAJES DE LA SEMANA");
		lblViajesDeLa.setFont(new Font("Dialog", Font.BOLD, 13));
		lblViajesDeLa.setBounds(202, 114, 176, 14);
		panel.add(lblViajesDeLa);
		
	
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

	public void setTable(JTable table) {
		this.table = table;
	}

	public void activarListener(ActionListener accion) {
		btnGenerar.addActionListener(accion);
		btnSalir.addActionListener(accion);

	}

	public void Limpiar() {
		TextvRif.setText("");
		JComponent.setDefaultLocale(getLocale());
	}
}
