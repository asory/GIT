package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class VistaCoop extends JFrame {

	private JPanel contentPane;
	private JButton btnAgregar;
	private JButton btnAgregarSocio;
	private JButton btnCancelar;
	private JFormattedTextField textRif;
    private JFormattedTextField textNombreC;
	private JButton btnBuscar;
    private JButton btnEliminar;
	private JButton btnModificar;

	// SINGLETON
	private static VistaCoop instancia;

	public static VistaCoop getInstancia() {
		if (instancia == null) {
			instancia = new VistaCoop();
		}
		return instancia;
	}

	public VistaCoop() {
		setTitle("TERPA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 599, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 583, 438);
		contentPane.add(panel);
		panel.setLayout(null);

		btnAgregar = new JButton("Guardar");
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBackground(new Color(102, 204, 51));
		btnAgregar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregar.setBounds(63, 298, 89, 23);
		panel.add(btnAgregar);

		btnCancelar = new JButton("Salir");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(102, 204, 51));
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCancelar.setBounds(447, 298, 89, 23);
		panel.add(btnCancelar);

		JLabel lblAsignarViaje = new JLabel(" AGREGAR COOPERATIVA");
		lblAsignarViaje.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAsignarViaje.setBounds(233, 11, 189, 52);
		panel.add(lblAsignarViaje);

		JLabel lblRif = new JLabel("Rif :");
		lblRif.setFont(new Font("Dialog", Font.BOLD, 12));
		lblRif.setBounds(99, 144, 32, 17);
		panel.add(lblRif);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombre.setBounds(99, 219, 61, 20);
		panel.add(lblNombre);

		btnAgregarSocio = new JButton("Agregar Socios");
		btnAgregarSocio.setForeground(Color.WHITE);
		btnAgregarSocio.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAgregarSocio.setBackground(new Color(102, 204, 51));
		btnAgregarSocio.setBounds(243, 358, 121, 25);
		btnAgregarSocio.setVisible(false);
		panel.add(btnAgregarSocio);
		
		textRif = new JFormattedTextField();
		textRif.setBounds(170, 143, 126, 20);
		panel.add(textRif);
		
		textNombreC = new JFormattedTextField();
		textNombreC.setBounds(170, 220, 297, 20);
		panel.add(textNombreC);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBuscar.setBackground(new Color(102, 204, 51));
		btnBuscar.setBounds(322, 141, 89, 23);
		panel.add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnEliminar.setBackground(new Color(102, 204, 51));
		btnEliminar.setBounds(191, 298, 89, 23);
		panel.add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnModificar.setBackground(new Color(102, 204, 51));
		btnModificar.setBounds(322, 298, 89, 23);
		panel.add(btnModificar);
	}

	public void activarListener(ActionListener accion) {
		btnAgregar.addActionListener(accion);
		btnAgregarSocio.addActionListener(accion);
		btnCancelar.addActionListener(accion);
		btnEliminar.addActionListener(accion);
		btnModificar.addActionListener(accion);
		btnBuscar.addActionListener(accion);

	}
	public void Limpiar() {
		textRif.setText("");
		textNombreC.setText("");
	}

	public String getTextRif() {
		return textRif.getText();
	}

	public String getTexNombreC() {
		return textNombreC.getText();
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnAgregarSocio() {
		return btnAgregarSocio;
	}

	public JButton getBtnSalir() {
		return btnCancelar;
	}
    public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
    public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public void setTextRif(JFormattedTextField textRif) {
		this.textRif = textRif;
	}
    public JFormattedTextField getTextNombreC() {
		return textNombreC;
	}

}


/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */
