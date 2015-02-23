package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import bean.JTextFieldValidator;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class VistaCargarFeriado extends JFrame {

	private JPanel contentPane;
	private JLabel lblCargarDaFeriado;
	private JLabel lblFecha;
	private JLabel lblDescripcion;
	private JTextFieldValidator textDesc;
	private JDateChooser dateChooser1;
	private JButton btnGuardar;
	private JButton btnSalir;

	// SINGLETON
	private static VistaCargarFeriado instancia;

	public static VistaCargarFeriado getInstancia() {
		if (instancia == null) {
			instancia = new VistaCargarFeriado();
		}
		return instancia;
	}

	// SINGLETON
	
	public VistaCargarFeriado() {
		setBackground(Color.WHITE);
		setTitle("TERPA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 455);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(new Color(102, 204, 51));
		btnGuardar.setBounds(207, 310, 95, 25);
		contentPane.add(btnGuardar);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(new Color(102, 204, 51));
		btnSalir.setBounds(494, 310, 95, 25);
		contentPane.add(btnSalir);

		lblCargarDaFeriado = new JLabel("CARGAR DIA FERIADO");
		lblCargarDaFeriado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargarDaFeriado.setBounds(291, 28, 153, 15);
		contentPane.add(lblCargarDaFeriado);

		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(117, 108, 67, 15);
		contentPane.add(lblFecha);

		lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(117, 215, 95, 15);
		contentPane.add(lblDescripcion);

		textDesc = new JTextFieldValidator();
		textDesc.setBounds(227, 210, 365, 25);
		contentPane.add(textDesc);
		textDesc.setTipoCaracteresPermitidos(JTextFieldValidator.LETRAS_Y_ESPACIOS);

		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(227, 104, 167, 19);
		contentPane.add(dateChooser1);

	}

	public void activarListener(ActionListener accion) {
		btnGuardar.addActionListener(accion);
		btnSalir.addActionListener(accion);
	}

	public String getDesc() {
		return textDesc.getText();
	}

	public void setFecha(Date fecha) {
		this.dateChooser1.setDate(fecha);
	}

	public Date getFecha() {
		return this.dateChooser1.getDate();
	}

	public void blanquearCampos() {
		textDesc.setText("");
		dateChooser1.setDate(null);
	}

	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
