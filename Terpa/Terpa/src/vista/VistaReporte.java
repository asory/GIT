package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

import javax.swing.JButton;
import bean.JTextFieldValidator;

@SuppressWarnings("serial")
public class VistaReporte extends JFrame {

	private JPanel contentPane;
	private JTextField textFiltrar;
	private JComboBox<?> comboFiltro;
	private JTable table;
	private JLabel lblTituloListado;
	private JLabel lblID;
	JLabel lblRifCooperativa;
	private JButton btnGenerar;
	private DefaultComboBoxModel<?> jComboBoxModel;
	private JTextFieldValidator textvrif;
	private JButton btnCancelar;

	public VistaReporte() {
		setTitle("TERPA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 763, 451);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTituloListado = new JLabel("LISTADO ");
		lblTituloListado.setHorizontalTextPosition(SwingConstants.LEFT);
		lblTituloListado.setLabelFor(contentPane);
		lblTituloListado.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloListado.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTituloListado.setBounds(152, 23, 428, 14);
		contentPane.add(lblTituloListado);

		JLabel lblFiltrar = new JLabel("Listado de :");
		lblFiltrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFiltrar.setBounds(33, 63, 72, 15);
		contentPane.add(lblFiltrar);

		textFiltrar = new JTextField();
		textFiltrar.setBounds(472, 61, 94, 20);
		contentPane.add(textFiltrar);
		textFiltrar.setColumns(10);

		String[] items = { "SELECCIONE", "CHOFER", "UNIDAD", "MULTA" };
		comboFiltro = new JComboBox<Object>(items);
		comboFiltro.setSelectedIndex(0);
		comboFiltro.setBounds(111, 61, 89, 20);
		contentPane.add(comboFiltro);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 100, 700, 267);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setAutoCreateRowSorter(true);
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.LIGHT_GRAY);
		table.setEnabled(false);
		scrollPane.setViewportView(table);

		lblID = new JLabel("ID : ");
		lblID.setFont(new Font("Dialog", Font.BOLD, 15));
		lblID.setBounds(438, 62, 72, 14);
		contentPane.add(lblID);

		btnGenerar = new JButton("GENERAR");
		btnGenerar.setBounds(616, 60, 89, 23);
		contentPane.add(btnGenerar);

		textvrif = new JTextFieldValidator();
		textvrif.setBounds(321, 61, 94, 20);
		contentPane.add(textvrif);

		lblRifCooperativa = new JLabel("RIF Cooperativa");
		lblRifCooperativa.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRifCooperativa.setBounds(228, 62, 88, 16);
		contentPane.add(lblRifCooperativa);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(594, 378, 89, 23);
		contentPane.add(btnCancelar);

	}

	public void activarListener(ActionListener e) {
		comboFiltro.addActionListener(e);
		btnGenerar.addActionListener(e);
		btnCancelar.addActionListener(e);
	}

	public JTable getTable() {
		return table;
	}

	public String getTextFiltrar() {
		return textFiltrar.getText();
	}

	public JTextFieldValidator getTextvrif() {
		return textvrif;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JLabel getLblTituloListado() {
		return lblTituloListado;
	}

	public JButton getBtnGenerar() {
		return btnGenerar;
	}

	public void setLblTitulo(String titulo) {
		lblTituloListado.setText(titulo);
	}

	public void limpiar() {
		table.setModel(new DefaultTableModel());
		textFiltrar.setText("");
		textvrif.setText("");
	}

	public void desactivar() {
		lblID.setVisible(false);
		textFiltrar.setVisible(false);
	}

	public void activar() {
		lblID.setVisible(true);
		textFiltrar.setVisible(true);
	}

	// *******************MEtodos de combo*******************//

	public JComboBox<?> getComboFiltro() {
		return comboFiltro;
	}

	public String getStringCmbFiltro() {
		return (String) comboFiltro.getSelectedItem();
	}

	public int getindex() {

		return comboFiltro.getSelectedIndex();
	}
}
