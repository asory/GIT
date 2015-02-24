package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import bean.Login3;

@SuppressWarnings("serial")
public class VistaMenuP extends JFrame {

	private JPanel contentPane ;
	JMenuItem mpCoop ;
	JMenuItem mpRuta;
	JMenuItem mpChofer;
	JMenuItem mpSocio;
	JMenuItem mpUnidad;
	JMenuItem mpFeriado;
	JMenuItem mpViajes;
	JMenuItem mpCalendario;
	JButton btnAsignar;
	JButton btnSalir;
	JButton btnEntrar;
	Login3 login3_1;
	
	
	// SINGLETON
	private static VistaMenuP instancia;
	

	public static VistaMenuP getInstancia() {
		if (instancia == null) {
			instancia = new VistaMenuP();
		}
		return instancia;
	}

	public VistaMenuP() {
		Login3.main(null);		
		
		try {
			setTitle("TERPA");
			setForeground(Color.WHITE);
			setBackground(Color.WHITE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 475, 422);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"), " fff",
					TitledBorder.CENTER, TitledBorder.TOP, null, new Color(45,
							45, 45)));
			panel.setBackground(Color.WHITE);
			panel.setVerifyInputWhenFocusTarget(false);
			panel.setBounds(0, 0, 459, 384);
			contentPane.add(panel);
			panel.setLayout(null);

			JMenuBar menuBar = new JMenuBar();
			menuBar.setBackground(new Color(102, 204, 51));
			menuBar.setBounds(0, 0, 459, 27);
			panel.add(menuBar);

			JMenu mnCargar = new JMenu("AGREGAR");
			mnCargar.setDelay(0);
			mnCargar.setBackground(new Color(102, 204, 51));
			mnCargar.setFont(new Font("Dialog", Font.BOLD, 12));
			menuBar.add(mnCargar);

			mpCoop = new JMenuItem("COOPERATIVA");
			mpCoop.setBackground(new Color(153, 204, 102));
			mpCoop.setFont(new Font("Dialog", Font.BOLD, 12));
			mnCargar.add(mpCoop);

			mpRuta = new JMenuItem("RUTA");
			mpRuta.setBackground(new Color(153, 204, 102));
			mpRuta.setFont(new Font("Dialog", Font.BOLD, 12));
			mnCargar.add(mpRuta);

			mpSocio = new JMenuItem("SOCIO");

			mpSocio.setBackground(new Color(153, 204, 102));
			mpSocio.setFont(new Font("Dialog", Font.BOLD, 12));
			mnCargar.add(mpSocio);

			mpChofer = new JMenuItem("CHOFER");
			mpChofer.setBackground(new Color(153, 204, 102));
			mpChofer.setFont(new Font("Dialog", Font.BOLD, 12));
			mnCargar.add(mpChofer);

			mpUnidad = new JMenuItem("UNIDAD");
			mpUnidad.setBackground(new Color(153, 204, 102));
			mpUnidad.setFont(new Font("Dialog", Font.BOLD, 12));
			mnCargar.add(mpUnidad);

			mpFeriado = new JMenuItem("FERIADO");
			mpFeriado.setBackground(new Color(153, 204, 102));
			mpFeriado.setFont(new Font("Dialog", Font.BOLD, 12));
			mnCargar.add(mpFeriado);

			JMenu mnConsulta = new JMenu("CONSULTAR ");
			menuBar.add(mnConsulta);
			mnConsulta.setHorizontalTextPosition(SwingConstants.CENTER);
			mnConsulta.setBackground(new Color(102, 204, 51));
			mnConsulta.setFont(new Font("Dialog", Font.BOLD, 12));

			mpViajes = new JMenuItem("LISTADOS");
			mpViajes.setBackground(new Color(153, 204, 102));
			mpViajes.setFont(new Font("Dialog", Font.BOLD, 12));
			mnConsulta.add(mpViajes);

			mpCalendario = new JMenuItem("CALENDARIO");
			mpCalendario.setFont(new Font("Dialog", Font.BOLD, 12));
			mpCalendario.setActionCommand("");
			mnConsulta.add(mpCalendario);

			btnAsignar = new JButton("ASIGNAR VIAJES ");
			btnAsignar.setBackground(Color.WHITE);
			menuBar.add(btnAsignar);
			btnAsignar.setFont(new Font("Dialog", Font.BOLD, 12));

			btnSalir = new JButton("SALIR");
			btnSalir.setBackground(new Color(102, 204, 51));
			btnSalir.setForeground(Color.BLACK);
			btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
			btnSalir.setBounds(360, 350, 89, 23);
			panel.add(btnSalir);
			
			login3_1 = new Login3();
			login3_1.setBounds(0, 0, 104, 18);
			contentPane.add(login3_1);
			login3_1.setAlwaysOnTop(true);
			login3_1.setAutoRequestFocus(true);
			login3_1.setModal(true);
			login3_1.setUndecorated(false);
			login3_1.setResizable(false);
			
			
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	public void activarListener(ActionListener accion) {
		btnAsignar.addActionListener(accion);
		btnSalir.addActionListener(accion);
		mpCoop.addActionListener(accion);
		mpRuta.addActionListener(accion);
		mpSocio.addActionListener(accion);
		mpChofer.addActionListener(accion);
		mpUnidad.addActionListener(accion);
		mpFeriado.addActionListener(accion);
		mpCalendario.addActionListener(accion);
		mpViajes.addActionListener(accion);
	}

	public JMenuItem getMpCoop() {
		return mpCoop;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JMenuItem getMpRuta() {
		return mpRuta;
	}

	public JMenuItem getMpChofer() {
		return mpChofer;
	}

	public JMenuItem getMpSocio() {
		return mpSocio;
	}

	public JMenuItem getMpUnidad() {
		return mpUnidad;
	}

	public JMenuItem getMpFeriado() {
		return mpFeriado;
	}

	public JMenuItem getMpViajes() {
		return mpViajes;
	}

	public JMenuItem getMpCalendario() {
		return mpCalendario;
	}

	public JButton getBtnAsignar() {
		return btnAsignar;
	}
}



/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */
