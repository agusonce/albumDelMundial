package albumDelMundial.frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import albumDelMundial.backend.Dato;
import albumDelMundial.backend.paquetes.PaqueteEstandar;
import albumDelMundial.backend.simulacion.SimulacionMultiParticipantes;

public class PantallaSimulacionCompleja extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5451437218662739249L;
	private JTextField textFieldEjecuciones;
	private JTextField textFieldParticipantes;
	private JButton btnEjecutar;
	private JButton btnActualizar;
	private Grafico grafico;
	private SimulacionMultiParticipantes simulacion;
	
	public PantallaSimulacionCompleja() {
		super();
		setBounds(100, 100, 800, 700);
		simulacion =  new  SimulacionMultiParticipantes(new PaqueteEstandar());

		inicializar();
	}

	private void inicializar() {
		JInternalFrame internalFrame = new JInternalFrame("");
		internalFrame.setBounds(0,30, 687, 500);
		getContentPane().add(internalFrame, BorderLayout.WEST);
		
		//grafico
		grafico = new Grafico();
		internalFrame.add(grafico);
		internalFrame.setVisible(true);
		
		JLabel lbEjecuciones = new JLabel("   Ejecuciones");
		lbEjecuciones.setBounds(0, 0, 100, 30);
		getContentPane().add(lbEjecuciones);
		textFieldEjecuciones = new JTextField();
		textFieldEjecuciones.setToolTipText("Ingrese cantidad de ejecuciones");
		textFieldEjecuciones.setBounds(100, 0, 100, 30);
		getContentPane().add(textFieldEjecuciones );
		
		//text field 
		JLabel lbParticipantes = new JLabel("   Participantes");
		lbParticipantes.setBounds(200, 0, 100, 30);
		getContentPane().add(lbParticipantes);
		textFieldParticipantes = new JTextField();
		textFieldParticipantes.setToolTipText("Ingrese cantidad de participantes");
		textFieldParticipantes.setBounds(300, 0, 100, 30);
		getContentPane().add(textFieldParticipantes );
		
		//boton Ejecutar
		btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.setBounds(400, 0, 100, 30);
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutar();
			}
		});
		getContentPane().add(btnEjecutar);
		
		//boton actualizar
		btnActualizar = new JButton("Actualizar grafico");
		btnActualizar.setBounds(500, 0, 200, 30);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar();
			}
		});
		getContentPane().add(btnActualizar);

	}
	
	public boolean validarDatosEjecucion() {
		//validaciones
		int vantSimulaciones = Integer.parseInt(textFieldEjecuciones.getText());
		if(vantSimulaciones<1){
			notificar("No se puede ejecutar la operacion, Ingrese un valor numerico positivo");
			return false;
		}
		return true;
	}
	public void ejecutar() {
		try {
			if(validarDatosEjecucion()){
				int cantSimulaciones = Integer.parseInt(textFieldEjecuciones.getText());
				int cantParticipantes = Integer.parseInt(textFieldParticipantes.getText());
				simulacion.setIteraciones(cantSimulaciones);
				simulacion.setCantParticipantes(cantParticipantes);
				simulacion.ejecutar();
				notificar("finalizo la ejecucio, ya puede actualizar el grafco");
			}
		}catch(IllegalArgumentException e) {
			notificar("No se puede ejecutar la operacion, Ingrese un valor numerico positivo");
		}
	}
	
	public void actualizar() {
		
		List<Dato> simulaciones = simulacion.getDatos();		
		
		//conseguir lista de puntos(cantidad de paquest comprado)
		List<Integer> puntos = new ArrayList<Integer>();
		for(Dato s : simulaciones) {
			puntos.add(s.getCantPaquetes());
		}

		grafico.setDatos(puntos);
		grafico.paint(grafico.getGraphics());
	}
	
	
	
	public void notificar(String ms) {
		JOptionPane.showMessageDialog(this,
				ms,
			    "WARNING.",
			    JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void notificar(String ms,int tipo) {
		JOptionPane.showMessageDialog(this,
				ms,
			    "WARNING.",
			    tipo);
	}
}
