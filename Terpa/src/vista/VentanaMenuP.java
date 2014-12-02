package vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaMenuP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mnCargar;
	private JMenuItem mnConsultar;
	private JMenuItem mnAsignar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenuP frame = new VentanaMenuP();
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
	public VentanaMenuP() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		contentPane.add(panel);
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar);
		
		JMenu mnCargar = new JMenu("CARGAR");
		menuBar.add(mnCargar);
		
		JMenuItem mpCooperativa = new JMenuItem("COOPERATIVA");
		mpCooperativa.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				;
				
				
				
			}
		});
		mnCargar.add(mpCooperativa);
		
		JMenuItem mpSocio = new JMenuItem("SOCIO");
		mnCargar.add(mpSocio);
		
		JMenuItem mpChofer = new JMenuItem("CHOFER");
		mnCargar.add(mpChofer);
		
		JMenuItem mpUnidad = new JMenuItem("UNIDAD");
		mnCargar.add(mpUnidad);
		
		JMenuItem mpFeriado = new JMenuItem("FERIADO");
		mnCargar.add(mpFeriado);
		
		JMenuItem mpRuta = new JMenuItem("RUTA");
		mnCargar.add(mpRuta);
		
		JMenu mnConsulta = new JMenu("CONSULTAR");
		menuBar.add(mnConsulta);
		
		JMenuItem mpunidades = new JMenuItem("UNIDADES");
		mnConsulta.add(mpunidades);
		
		JMenuItem mpChoferes = new JMenuItem("CHOFERES");
		mnConsulta.add(mpChoferes);
		
		JMenuItem mpMultas = new JMenuItem("MULTAS");
		mnConsulta.add(mpMultas);
		
		JMenuItem mpViajes = new JMenuItem("VIAJES");
		mnConsulta.add(mpViajes);
		
		JMenuItem mnAsignar = new JMenuItem("ASIGNAR");
		menuBar.add(mnAsignar);
	}
public void addListener(ActionListener actionListener){
	mnCargar.addActionListener(actionListener);
	mnAsignar.addActionListener(actionListener);
	mnConsultar.addActionListener(actionListener);
	}
}
