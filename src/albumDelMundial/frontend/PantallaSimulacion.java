package albumDelMundial.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import albumDelMundial.backend.serializacion.DatosSimulacion;
import albumDelMundial.backend.simulator.Simulacion;

public class PantallaSimulacion extends JFrame{
	private JButton btnEjecutar;
	private JButton btnActualizar;
	private Example grafico;
	
	DatosSimulacion datosSimulacion = DatosSimulacion.getInstance();
	
	public PantallaSimulacion() {
		super();
		setBounds(100, 100, 700, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JInternalFrame internalFrame = new JInternalFrame("");
		internalFrame.setBounds(0,30, 687, 500);
		getContentPane().add(internalFrame, BorderLayout.WEST);
		
		grafico = new Example();
		internalFrame.add(grafico);
		internalFrame.setVisible(true);
		
//		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		inicializar();
	}

	private void inicializar() {
		//frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.setBounds(0, 0, 100, 30);
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutar();
			}
		});
		
		getContentPane().add(btnEjecutar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(100, 0, 100, 30);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar();
			}
		});
		
		getContentPane().add(btnActualizar);


		
	}
	
	public void ejecutar() {
		Simulacion simulacion =  new  Simulacion(810);
		//usar try
		simulacion.ejecutar();
		System.out.print("finalizo la ejecucio");
	}
	
	public void actualizar() {
		
		List<DatosSimulacion.Dato> simulaciones = datosSimulacion.getSimulaciones();		
		
		//conseguir lista de puntos(cantidad de paquest comprado)
		List<Integer> puntos = new ArrayList<Integer>();
		for(DatosSimulacion.Dato s : simulaciones) {
			puntos.add(s.getCantPaquetes());
		}

		grafico.setDatos(puntos);
		grafico.paint(grafico.getGraphics());
	}
}
