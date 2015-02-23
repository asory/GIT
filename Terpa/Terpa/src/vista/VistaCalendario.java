package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class VistaCalendario extends JFrame {

	private JPanel contentPane;
	private JLabel lblCalendario;
	private JLabel lblFDesde;
	private JLabel lblFHasta;
	private JTable table;
	private JDateChooser dateChooser1;
	private JDateChooser dateChooser2;
	private JButton btnConsultarOtrasFechas;
	private JButton btnGenerarCalendario;
	private JButton btnSalir;

	// SINGLETON
	private static VistaCalendario instancia;

	public static VistaCalendario getInstancia() {
		if (instancia == null) {
			instancia = new VistaCalendario();
		}
		return instancia;
	}

	public VistaCalendario() {
		setBackground(Color.WHITE);
		setTitle("TERPA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 723, 453);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCalendario = new JLabel("CALENDARIO DE ASIGNACIONES");
		lblCalendario.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalendario.setBounds(240, 32, 225, 15);
		contentPane.add(lblCalendario);

		lblFDesde = new JLabel("Desde:");
		lblFDesde.setBounds(74, 80, 70, 15);
		contentPane.add(lblFDesde);

		lblFHasta = new JLabel("Hasta:");
		lblFHasta.setBounds(380, 80, 70, 15);
		contentPane.add(lblFHasta);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 700, 267);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setEditingColumn(0);
		table.setEditingRow(0);
		table.setEnabled(false);
		table.computeVisibleRect(getBounds());
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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

		btnConsultarOtrasFechas = new JButton("Consultar Otro");
		btnConsultarOtrasFechas.setForeground(Color.WHITE);
		btnConsultarOtrasFechas.setBackground(new Color(102, 204, 51));
		btnConsultarOtrasFechas.setBounds(74, 396, 139, 25);
		contentPane.add(btnConsultarOtrasFechas);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setBounds(505, 396, 117, 25);
		contentPane.add(btnSalir);

		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(151, 76, 167, 19);
		contentPane.add(dateChooser1);

		dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(468, 76, 167, 19);
		contentPane.add(dateChooser2);

		btnGenerarCalendario = new JButton("Generar Calendario");
		btnGenerarCalendario.setForeground(Color.WHITE);
		btnGenerarCalendario.setBackground(new Color(102, 204, 51));
		btnGenerarCalendario.setBounds(269, 396, 181, 25);
		contentPane.add(btnGenerarCalendario);
	}

	public void activarListener(ActionListener accion) {
		btnConsultarOtrasFechas.addActionListener(accion);
		btnGenerarCalendario.addActionListener(accion);
		btnSalir.addActionListener(accion);
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnGenerarCalendario() {
		return btnGenerarCalendario;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setFechaDesde(Date fecha) {
		this.dateChooser1.setDate(fecha);
	}

	public Date getFechaDesde() {
		return this.dateChooser1.getDate();
	}

	public void setFechaHasta(Date fecha) {
		this.dateChooser2.setDate(fecha);
	}

	public Date getFechaHasta() {
		return this.dateChooser2.getDate();
	}

	public void blanquearCampos() {
		dateChooser1.setDate(null);
		dateChooser2.setDate(null);

	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
