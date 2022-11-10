package albumDelMundial.backend.simulator;

import java.util.Date;
import java.util.List;

import albumDelMundial.backend.IPaquete;
import albumDelMundial.backend.JsonFile;
import albumDelMundial.backend.PaqueteEstandar;
import albumDelMundial.backend.Participante;
import albumDelMundial.backend.serializacion.DatosSimulacion;

public class Simulacion {
	private Participante participante;
	private IPaquete paquete = new PaqueteEstandar();
	private int cantPaquetes;
	private int iteraciones;
	public Simulacion() {
		 paquete = new PaqueteEstandar();
		 this.cantPaquetes = 0;
		 this.iteraciones = 1;
	}
	public Simulacion(int iteraciones) {
		 paquete = new PaqueteEstandar();
		 this.cantPaquetes = 0;
		 this.iteraciones = iteraciones;
	}
	
	
	public void ejecutar() {
		DatosSimulacion simulacion = DatosSimulacion.getInstance();
		Date fechaEjecucion;
		//_-____--WHILE---_-_____
		for(int x = 0; x <= iteraciones ; x++) {
			fechaEjecucion = new Date();
			cantPaquetes = 0;
			participante = new Participante();
			while (!participante.albumIsCompleto()) {
				List<Integer> res = pedirpaquete();
				
				for(Integer f: res)
					participante.recivirCarta(f);
				
				participante.cargarAlbum();
			}
			
			
			//crear linea
			DatosSimulacion.Dato linea = simulacion.nuevaLinea();
			linea.setCantPaquetes(cantPaquetes);
			linea.setParticipante(participante.getId());
			linea.setFecha(fechaEjecucion);
	
			//guardarDato
			simulacion.addSimulacion(linea);
		}
		
		//manejo de archivos
		JsonFile export = new JsonFile(simulacion.getSimulaciones());
		export.guardarJson(export.generarJson(), "./src/resource/example.json");
		//simulacion.guardarJson(simulacion.generarJson(), "./src/resource/example.json");
		//archivos
		
		
		
	}
	
	
	
	public List<Integer> pedirpaquete() {
		this.cantPaquetes ++;
		return paquete.pedirPaquete(); 
		
	}
	public int getPaquetesAbiertos() {
		return cantPaquetes;
	}
}
