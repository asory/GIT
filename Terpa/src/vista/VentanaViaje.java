package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.Action;
import java.awt.event.ActionListener;
import bean.JTextFieldValidator;

public class VentanaViaje extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaViaje frame = new VentanaViaje();
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
	public VentanaViaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 434, 262);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(289, 112, 91, 20);
		dateChooser.setToolTipText("");
		panel.add(dateChooser);
		
		JLabel label = new JLabel("Cooperativa:");
		label.setBounds(70, 81, 79, 17);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(label);
		
		JLabel label_1 = new JLabel("Fecha:");
		label_1.setBounds(245, 115, 41, 17);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(label_1);
		
		JButton button = new JButton("Asignar");
		button.setBounds(103, 186, 69, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Salir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		button_1.setAction(action);
		button_1.setBounds(245, 186, 91, 23);
		panel.add(button_1);
		
		JLabel label_2 = new JLabel("ASIGNAR VIAJES");
		label_2.setBounds(137, 29, 126, 20);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(label_2);
		
		JTextFieldValidator txtfldvldtrAsd = new JTextFieldValidator();
		txtfldvldtrAsd.setTipoCaracteresPermitidos(JTextFieldValidator.LETRAS_Y_NUMEROS);
		txtfldvldtrAsd.setText("RIF");
		txtfldvldtrAsd.setMaximaLongitud(10);
		txtfldvldtrAsd.setBounds(70, 112, 126, 20);
		panel.add(txtfldvldtrAsd);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
