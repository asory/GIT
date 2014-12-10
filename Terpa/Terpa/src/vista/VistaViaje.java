package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.ComponentListener;

import javax.swing.Action;

import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import bean.JTextFieldValidator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class VistaViaje extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private JTextFieldValidator txtvRif;
	private JDateChooser dateChooser;
	private JButton btnAsignar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaViaje frame = new VistaViaje();
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
	public VistaViaje() {
		setTitle("TERPA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 795, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 779, 491);
		contentPane.add(panel);
		panel.setLayout(null);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(404, 112, 126, 20);
		dateChooser.setToolTipText("");
		panel.add(dateChooser);

		JLabel label = new JLabel("Cooperativa:");
		label.setBounds(75, 115, 79, 17);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(label);

		JLabel label_1 = new JLabel("Fecha:");
		label_1.setBounds(339, 115, 41, 17);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(label_1);
		// ***********************************************************************
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.setBackground(new Color(153, 204, 102));
		btnAsignar.setForeground(Color.black);
		btnAsignar.setBounds(569, 112, 71, 23);
		panel.add(btnAsignar);
		// *************************************************************************
		JLabel label_2 = new JLabel("ASIGNAR VIAJES");
		label_2.setBounds(287, 25, 126, 20);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(label_2);

		JTextFieldValidator txtvRif = new JTextFieldValidator();
		txtvRif.setTipoCaracteresPermitidos(JTextFieldValidator.LETRAS_Y_NUMEROS);
		txtvRif.setText("RIF");
		txtvRif.setMaximaLongitud(10);
		txtvRif.setBounds(189, 112, 126, 20);
		panel.add(txtvRif);
		// *************************************************************************
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setForeground(Color.DARK_GRAY);
		btnSalir.setBounds(549, 26, 89, 23);
		panel.add(btnSalir);

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(DISPOSE_ON_CLOSE);
			}
		});
		// *************************************************************************
		table = new JTable();
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setShowGrid(true);
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(getFilas(), getColumnas()));
	}

	;

	public JTable getTable() {
		return table;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public String getRif() {
		return txtvRif.getText();
	}

	public Date getFechaI() {
		return dateChooser.getDate();
	}

	// Encabezados de la tabla
	public String[] getColumnas() {
		String columna[] = new String[] { "A", "B", "C", "D" };
		return columna;
	}

	// Datos de las filas JTable
	public Object[][] getFilas() {
		table.setAutoCreateRowSorter(isResizable());
		Object fila[][] = new Object[][] { { "a1", "b1", "c1", "d1" },
				{ "a2", "b2", "c2", "d2" }, { "a3", "b3", "c3", "d3" } };
		return fila;
	}
	
////**************filtra y muestra solo los campos que coinciden ******************
	public void sort(){
		table.getSelectionModel().addListSelectionListener(
		        new ListSelectionListener() {
		            public void valueChanged(ListSelectionEvent event) {
		                int viewRow = table.getSelectedRow();
		                if (viewRow < 0) {
		                    //Selection got filtered away.
		                    statusText.setText("");
		                } else {
		                    int modelRow = 
		                        table.convertRowIndexToModel(viewRow);
		                    statusText.setText(
		                        String.format("Selected Row in view: %d. " +
		                            "Selected Row in model: %d.", 
		                            viewRow, modelRow));
		                }
		            }
		        }
		);
	}
}
