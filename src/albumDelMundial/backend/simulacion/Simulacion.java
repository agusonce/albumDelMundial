package albumDelMundial.backend.simulacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import albumDelMundial.backend.Dato;
import albumDelMundial.backend.Participante;
import albumDelMundial.backend.paquetes.IPaquete;
import albumDelMundial.backend.paquetes.PaqueteEstandar;
//import albumDelMundial.backend.serializacion.JsonFile;

public class Simulacion implements ISimulacion{
	private IPaquete paquete;
	private List<Dato> simulaciones;
	private int iteraciones;
//	private String fileName = "example.json";
	public Simulacion(IPaquete p) {
		 paquete = p;
		 this.iteraciones = 1;
	}
	
	public void ejecutar() {
		simulaciones = new ArrayList<Dato>();
		Date fechaEjecucion;
		
		Participante participante;
		int cantPaquetes;
		for(int x = 1; x <= iteraciones ; x++) {
			fechaEjecucion = new Date();
			cantPaquetes = 0;
			participante = new Participante();
			while (!participante.albumIsCompleto()) {
				List<Integer> res = pedirpaquete();
				cantPaquetes ++;
				for(Integer f: res)
					participante.recivirCarta(f);
				
				participante.cargarAlbum();
			}
			
			//crear linea
			Dato linea = new Dato();
			linea.setCantPaquetes(cantPaquetes);
			linea.setParticipante(participante.getId());
			linea.setFecha(fechaEjecucion);
	
			simulaciones.add(linea);
		}
		
		//guardarDato
		//manejo de archivos
//		JsonFile export = new JsonFile(simulaciones);
//		export.eliminarArchivo(fileName);
//		export.guardarJson(export.generarJsonPretty(), fileName);
		//archivos
		
		
		
	}
	
	public void setIteraciones(int iteraciones) {
		this.iteraciones = iteraciones;
	}
	
	public List<Dato> getDatos() {
		return this.simulaciones;
	}
	
	public List<Integer> pedirpaquete() {
		
		return paquete.pedirPaquete(); 
		
	}
}
