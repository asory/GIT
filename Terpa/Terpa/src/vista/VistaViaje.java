package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import bean.JTextFieldValidator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.components.JSpinField;

@SuppressWarnings("serial")
public class VistaViaje extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private JTextFieldValidator TextvRif;
	private JDateChooser dateChooser;
	private JButton btnGenerar;
	private JButton btnSalir;
	
	public VistaViaje()  {
		
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

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(
				new Font("Dialog", Font.BOLD, 12));
		dateChooser.getCalendarButton().setBackground(new Color(102, 204, 51));
		dateChooser.setBounds(233, 59, 126, 20);
		dateChooser.setToolTipText("");
		panel.add(dateChooser);

		JLabel lblCooperativaRif = new JLabel("Cooperativa Rif:");
		lblCooperativaRif.setBounds(10, 62, 103, 17);
		lblCooperativaRif.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(lblCooperativaRif);

		JLabel label_1 = new JLabel("Fecha:");
		label_1.setBounds(192, 62, 41, 17);
		label_1.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(label_1);

		btnGenerar = new JButton("GENERAR");
		btnGenerar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnGenerar.setBackground(new Color(102, 204, 51));
		btnGenerar.setForeground(Color.WHITE);
		btnGenerar.setBounds(369, 59, 82, 23);
		panel.add(btnGenerar);

		JLabel lblAsignarViaje = new JLabel("Asignar Viaje");
		lblAsignarViaje.setBounds(187, 32, 82, 14);
		lblAsignarViaje.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(lblAsignarViaje);

		TextvRif = new JTextFieldValidator();
		TextvRif.setFont(new Font("Dialog", Font.BOLD, 12));
		TextvRif.setTipoCaracteresPermitidos(JTextFieldValidator.LETRAS_Y_NUMEROS);
		TextvRif.setMaximaLongitud(3);
		TextvRif.setBounds(100, 59, 89, 20);
		panel.add(TextvRif);
       
		
		btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBounds(360, 350, 89, 23);
		panel.add(btnSalir);

		table = new JTable();
		table.setBackground(Color.BLACK);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setShowGrid(true);
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "ID Viaje", "Destino", "Unidad", "Chofer", "Salida",
				"Retorno", "Status" }));
		;
		table.setBounds(661, 465, -621, -248);
		panel.add(table);
	}

	// Encabezados de la tabla
	public String[] getColumnas() {
		String columna[] = new String[] { "A", "B", "C", "D" };
		return columna;
	}

	// Datos de las filas JTable
	public Object[][] getFilas() {
		Object fila[][] = new Object[][] { { "a1", "b1", "c1", "d1" },
				{ "a2", "b2", "c2", "d2" }, { "a3", "b3", "c3", "d3" } };
		return fila;
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
}
