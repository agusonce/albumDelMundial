package albumDelMundial.backend.simulacion;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import albumDelMundial.backend.Dato;
import albumDelMundial.backend.Participante;
import albumDelMundial.backend.paquetes.IPaquete;

public class SimulacionMultiParticipantes implements ISimulacion{
	Logger logger = Logger.getLogger(SimulacionMultiParticipantes.class.getName());
	private IPaquete paquete;
	private List<Dato> simulaciones;
	private int iteraciones;
	private int cantParticipante;
//	private String fileName = "example.json";
	public SimulacionMultiParticipantes(IPaquete p) {
		 paquete = p;
		 this.iteraciones = 1;
		 this.cantParticipante =1;
	}
	
	@Override
	public void ejecutar() {
		simulaciones = new ArrayList<Dato>();
		Date fechaEjecucion;
		
		int[] cantPaquetes = new int[cantParticipante];
		for(int x = 1; x <= iteraciones ; x++) {
			fechaEjecucion = new Date();
			//Inicializar participantes
			Participante[] participantes = new Participante[cantParticipante];
			for(int j=0; j <= cantParticipante-1; j++ ) {
				participantes[j] = new Participante();
				cantPaquetes[j] = 0;
			}
			//simulacion
			boolean participantesTerminaron = false;
			while (!participantesTerminaron) {
				List<Integer> duplicados = new ArrayList<Integer>();
				for(int j=0; j <= cantParticipante-1; j++ ){
					if(participantes[j].albumIsCompleto())
						continue;
					List<Integer> res = pedirpaquete();
					cantPaquetes[j] ++;
					for(Integer f: res)
						participantes[j].recivirCarta(f);
					
					participantes[j].cargarAlbum();
					//guardar duplicados 
					duplicados.addAll(participantes[j].extraerDuplicados());
				}
				
				if(duplicados.size() > 0) {
					for(Participante participante: participantes) {
						if(participante.albumIsCompleto())
							continue;
						
						Iterator < Integer > ifiguritasDuplicadas = duplicados.iterator();
						while (ifiguritasDuplicadas.hasNext()) {
						  Integer f = ifiguritasDuplicadas.next();
						  try{
							  if(!participante.contieneFigurita(f)){
								  participante.recivirCarta(f);
								  ifiguritasDuplicadas.remove();
							  }
						  }catch(InvalidParameterException e) {
							  logger.info("Error: " + e);
						  }
						}
					}
				}
				participantesTerminaron = true;
				for(Participante participante :participantes) {
					if(!participante.albumIsCompleto()) {
						participantesTerminaron = false;
					}
				}
			}
			
			//persistir datos
			for(int j=0; j <= cantParticipante-1; j++ ) {
				
				Dato linea = new Dato();
				linea.setCantPaquetes(cantPaquetes[j]);
				linea.setParticipante(participantes[j].getId());
				linea.setFecha(fechaEjecucion);
				simulaciones.add(linea);
			}
		}
	}
	
	public void setIteraciones(int iteraciones) {
		this.iteraciones = iteraciones;
	}
	
	public void setCantParticipantes(int participantes) {
		this.cantParticipante = participantes;
	}
	
	public List<Dato> getDatos() {
		return this.simulaciones;
	}
	
	public List<Integer> pedirpaquete() {
		return paquete.pedirPaquete(); 
	}
	

}
