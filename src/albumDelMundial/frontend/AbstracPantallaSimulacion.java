package albumDelMundial.frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import albumDelMundial.backend.Dato;
import albumDelMundial.backend.paquetes.PaqueteEstandar;
import albumDelMundial.backend.serializacion.JsonFile;
import albumDelMundial.backend.simulacion.ISimulacion;
import albumDelMundial.backend.simulacion.SimulacionMultiParticipantes;

public abstract class AbstracPantallaSimulacion extends JFrame{
	private SimulacionMultiParticipantes simulacion;
	public AbstracPantallaSimulacion() {
		

	}
	public void inicializar() {
	}
	

	public void ejecutar() {
	}
	
	public void actualizar() {
	}
	
	public void guardarDatos() {
		JsonFile file = new JsonFile();
		file.setDatos(simulacion.getDatos());
		file.guardarJson("CopiaDeSeguridad.json");
		notificar("se guardaron los datos existosamente");
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
