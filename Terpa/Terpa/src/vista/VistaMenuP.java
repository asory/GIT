package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import controlador.*;

public class VistaMenuP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JMenuItem mpCoop ;
	

	/**
	 * Launch the application.
	 */

	public VistaMenuP() {
		super();
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
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), " fff", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(45, 45, 45)));
		panel.setBackground(Color.WHITE);
		panel.setVerifyInputWhenFocusTarget(false);
		panel.setBounds(0, 0, 459, 384);
		contentPane.add(panel);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(102, 204, 51));
		menuBar.setBounds(0, 0, 459, 21);
		panel.add(menuBar);

		JMenu mnCargar = new JMenu("CARGAR                         ");
		mnCargar.setBackground(new Color(102, 204, 51));
		mnCargar.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.add(mnCargar);

		JMenuItem mpSocio = new JMenuItem("SOCIO");
		mpSocio.setBackground(new Color(153, 204, 102));
		mpSocio.setFont(new Font("Dialog", Font.BOLD, 12));
		mpSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String actionC = e.getActionCommand();
				if (actionC.equals("SOCIO")) {
					{
						new VistaCargarSocio();
					}
				}
			}
		});
		mnCargar.add(mpSocio);

		JMenuItem mpChofer = new JMenuItem("CHOFER");
		mpChofer.setBackground(new Color(153, 204, 102));
		mpChofer.setFont(new Font("Dialog", Font.BOLD, 12));
		mpChofer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String actionC = e.getActionCommand();
				if (actionC.equals("CHOFER")) {
					{
						VistaCargarChofer vccho = new VistaCargarChofer();
						vccho.setVisible(true);
						vccho.setLocationRelativeTo(rootPane);
					}
				}
			}
		});

		mnCargar.add(mpChofer);

		JMenuItem mpUnidad = new JMenuItem("UNIDAD");
		mpUnidad.setBackground(new Color(153, 204, 102));
		mpUnidad.setFont(new Font("Dialog", Font.BOLD, 12));
		mnCargar.add(mpUnidad);

		JMenuItem mpFeriado = new JMenuItem("FERIADO");
		mpFeriado.setBackground(new Color(153, 204, 102));
		mpFeriado.setFont(new Font("Dialog", Font.BOLD, 12));
		mnCargar.add(mpFeriado);

		JMenuItem mpRuta = new JMenuItem("RUTA");
		mpRuta.setBackground(new Color(153, 204, 102));
		mpRuta.setFont(new Font("Dialog", Font.BOLD, 12));
		mnCargar.add(mpRuta);

		JMenu mnConsulta = new JMenu("CONSULTAR           ");
		mnConsulta.setBackground(new Color(102, 204, 51));
		mnConsulta.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.add(mnConsulta);

		JMenuItem mpunidades = new JMenuItem("UNIDADES");
		mpunidades.setBackground(new Color(153, 204, 102));
		mpunidades.setFont(new Font("Dialog", Font.BOLD, 12));
		mnConsulta.add(mpunidades);

		JMenuItem mpChoferes = new JMenuItem("CHOFERES");
		mpChoferes.setBackground(new Color(153, 204, 102));
		mpChoferes.setFont(new Font("Dialog", Font.BOLD, 12));
		mnConsulta.add(mpChoferes);

		JMenuItem mpMultas = new JMenuItem("MULTAS");
		mpMultas.setBackground(new Color(153, 204, 102));
		mpMultas.setFont(new Font("Dialog", Font.BOLD, 12));
		mnConsulta.add(mpMultas);

		JMenuItem mpViajes = new JMenuItem("VIAJES");
		mpViajes.setBackground(new Color(153, 204, 102));
		mpViajes.setFont(new Font("Dialog", Font.BOLD, 12));
		mpViajes.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String actionC = e.getActionCommand();
				if (actionC.equals("VIAJES")) {
					{
						new ControladorVistaViaje();
					}
				}
			}
		});

		mnConsulta.add(mpViajes);

		JMenuItem mpCoop = new JMenuItem("COOPERATIVA");
		mpCoop.setBackground(new Color(153, 204, 102));
		mpCoop.setFont(new Font("Dialog", Font.BOLD, 12));
		mpCoop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String actionC = e.getActionCommand();
				if (actionC.equals("COOPERATIVA")) {
					{
					  new ControladorVistaCoop();
					}
				}
			}
		});  
		mnCargar.add(mpCoop);
		
				JMenuItem mnAsignar_1 = new JMenuItem("ASIGNAR");
				mnAsignar_1.setBackground(new Color(102, 204, 51));
				mnAsignar_1.setFont(new Font("Dialog", Font.BOLD, 12));
				menuBar.add(mnAsignar_1);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(102, 204, 51));
	/*	btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String actionC = e.getActionCommand();
				if (actionC.equals("Salir")) {
					System.exit(0);
				}
			}
		});
*/
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnSalir.setBounds(257, 294, 89, 23);
		panel.add(btnSalir);
	}
	 public void agregarListener (java.awt.event.ActionEvent e){
		 this.mpCoop.addActionListener((ActionListener) e);
		 
	
	 }
	 
	 
	public JMenuItem getMpCoop() {
		return mpCoop;
	}

	
	
	
	

}
