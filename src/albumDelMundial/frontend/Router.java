package albumDelMundial.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import albumDelMundial.backend.paquetes.PaqueteEstandar;

public class Router extends JFrame{

	public Router() {
		super();
		getContentPane().setLayout(null);
		
		setVisible(true);
		setBounds(500, 100, 255, 310);
		inicializacion();
	}
	
	
	public void inicializacion() {
		
		//text field 
		JLabel lbParticipantes = new JLabel("Seleccione el tipo de simulacion");
		lbParticipantes.setBounds(20, 0, 200, 100);
		lbParticipantes.setHorizontalTextPosition(JLabel.CENTER);
		getContentPane().add(lbParticipantes);
		
		//boton Ejecutar
		JButton btnOpcion1 = new JButton("Simulacion con un usuario");
		btnOpcion1.setBounds(0, 90, 250, 90);
		btnOpcion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaSimulacion f= new PantallaSimulacion();
				f.getContentPane().setLayout(null);
				
		        f.setVisible(true); 
			}
		});
		getContentPane().add(btnOpcion1);
		
		//boton Ejecutar
		JButton btnOpecion2 = new JButton("simulacion con multi-usuarios");
		btnOpecion2.setBounds(0, 180, 250, 90);
		btnOpecion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaSimulacionCompleja pSimulacionCompleja= new PantallaSimulacionCompleja();
				pSimulacionCompleja.getContentPane().setLayout(null);
				
				pSimulacionCompleja.setVisible(true);
			}
		});
		getContentPane().add(btnOpecion2);
		
		
	}
		
}
