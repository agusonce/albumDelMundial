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
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import albumDelMundial.backend.Dato;
import albumDelMundial.backend.serializacion.JsonFile;
import albumDelMundial.backend.simulacion.Simulacion;

public class PantallaSimulacion extends JFrame{
	private JTextField textFieldEjecuciones;
	private JButton btnEjecutar;
	private JButton btnActualizar;
	private JButton btnGuardar;
	private Grafico grafico;
	
	Simulacion simulacion =  new  Simulacion();
	
	public PantallaSimulacion() {
		super();
		setBounds(100, 100, 800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JInternalFrame internalFrame = new JInternalFrame("");
		internalFrame.setBounds(0,30, 687, 500);
		getContentPane().add(internalFrame, BorderLayout.WEST);
		
		grafico = new Grafico();
		internalFrame.add(grafico);
		internalFrame.setVisible(true);
		
//		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		inicializar();
	}

	private void inicializar() {
		
		textFieldEjecuciones = new JTextField();
		textFieldEjecuciones.setBounds(0, 0, 100, 30);
		getContentPane().add(textFieldEjecuciones );
		

		btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.setBounds(100, 0, 100, 30);
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutar();
			}
		});
		
		getContentPane().add(btnEjecutar);
		getContentPane().add(btnEjecutar);
		getContentPane().add(btnEjecutar);
		getContentPane().add(btnEjecutar);
		getContentPane().add(btnEjecutar);

		btnActualizar = new JButton("Actualizar grafico");
		btnActualizar.setBounds(200, 0, 200, 30);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar();
			}
		});
		
		getContentPane().add(btnActualizar);


		//BTN para guardar Datos
		btnGuardar = new JButton("guardar");
		btnGuardar.setComponentPopupMenu(new JPopupMenu("guarda los datos del grafico, reescribiendo los datos anteriores"));
		btnGuardar.setBounds(400, 0, 100, 30);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarDatos();
			}
		});
		
		getContentPane().add(btnGuardar);
	}
	
	public void ejecutar() {
		try {
			int vantSimulaciones = Integer.parseInt(textFieldEjecuciones.getText());
			if(vantSimulaciones<Grafico.ANCHO_DEL_GRAFICO){
				notificar("No se puede ejecutar la operacion, Ingrese un valor mayor a "+ Grafico.ANCHO_DEL_GRAFICO);
			}else {
				//Simulacion simulacion =  new  Simulacion(vantSimulaciones);
				simulacion.setIteraciones(vantSimulaciones);
				simulacion.ejecutar();
				notificar("finalizo la ejecucio, ya puede actualizar el grafco");
			}
		}catch(IllegalArgumentException e) {
			notificar("No se puede ejecutar la operacion, Ingrese un valor mayor a 600");
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
	
	public void guardarDatos() {
		JsonFile file = new JsonFile();
		file.setDatos(simulacion.getDatos());
		file.guardarJson("CopiaDeSeguridad.json");
		notificar("se guardaron lso datos existosamente");
	}
	public void notificar(String ms) {
		JOptionPane.showMessageDialog(this,
				ms,
			    "WARNING.",
			    JOptionPane.INFORMATION_MESSAGE);
	}
}
