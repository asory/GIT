package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollBar;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class VistaReporte extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFiltrar;
	private JComboBox comboFiltro;

	public VistaReporte() {
		setTitle("TERPA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloListado = new JLabel("Titulo ");
		lblTituloListado.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloListado.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTituloListado.setBounds(87, 22, 231, 14);
		contentPane.add(lblTituloListado);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 133, 17, 118);
		contentPane.add(scrollBar);
		
		JLabel lblFiltrar = new JLabel("Filtrar");
		lblFiltrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFiltrar.setBounds(28, 60, 61, 21);
		contentPane.add(lblFiltrar);
		
		textFiltrar = new JTextField();
	
		textFiltrar.setBounds(161, 61, 246, 20);
		contentPane.add(textFiltrar);
		textFiltrar.setColumns(10);
		
		comboFiltro = new JComboBox();
		comboFiltro.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Cooperativa", "Destino", "Unidad", "Chofer","Multa"}));
		comboFiltro.setBounds(72, 61, 79, 20);
		contentPane.add(comboFiltro);
		
		table = new JTable();
		table.setBounds(429, 258, -402, -150);
		table.setAutoCreateRowSorter(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Viaje","Cooperativa", "Destino", "Unidad", "Chofer", "Salida", "Retorno", "Status"
			}
		));
		contentPane.add(table);
	}

	public JTable getTable() {
		return table;
	}
	public JTextField getTextFiltrar() {
		return textFiltrar;
	}
	
	public void setTable(JTable table) {
		this.table = table;
	}
	private void LimpiarTabla(){
	   table.setModel(new DefaultTableModel());
	         
	       }

	public JComboBox getComboFiltro() {
		return comboFiltro;
	}
	
	public void activarListener(ActionListener e) {
		comboFiltro.addActionListener(e);
		
	}
	   }



