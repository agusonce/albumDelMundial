package albumDelMundial.backend.serializacion;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class DatosSimulacion{
	private static DatosSimulacion simulacionJson;
	private List<Dato> simulaciones;
	private Integer mayorNumero;
	
	private DatosSimulacion() {
		this.simulaciones = new ArrayList<Dato>();
	}
	
	
	public void addSimulacion(Dato s) {
		simulaciones.add(s);
	}
	
	
	public Dato nuevaLinea() {
		return new Dato();
	}

	
	public int tamaño() {
		return this.simulaciones.size();
	}
	
	
	public List<Dato> getSimulaciones() {
		return simulaciones;
	}


	public void setSimulaciones(List<Dato> simulaciones) {
		this.simulaciones = simulaciones;
	}

	public static DatosSimulacion getInstance() {
		if (simulacionJson == null) {
			simulacionJson = new DatosSimulacion();
		}
		return simulacionJson;
	}
//	public String generarJson() {
//		Gson json = new GsonBuilder().create();
//		String datos = json.toJson(this);
//		return datos;
//	}
//	
//	
//	public String generarJsonPretty() {
//		Gson json = new GsonBuilder().setPrettyPrinting().create();
//		String datos = json.toJson(this);
//		return datos;
//	}
//	
//	public void guardarJson(String DatoJson, String archivoDestino) {
//		try {
//			FileWriter write = new FileWriter(archivoDestino);
//			write.write(DatoJson);
//			write.close();
//		}catch(IOException e) {
//			
//		}
//	}
//	

	
	public class Dato{
		private int id;
		private int participante;
		private int cantPaquetes;
		private Date fecha;
		

		public Dato() {
		}
		
		public Dato(Date fecha) {
			this.fecha = fecha;
		}

		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getParticipante() {
			return participante;
		}


		public void setParticipante(int participante) {
			this.participante = participante;
		}


		public int getCantPaquetes() {
			return cantPaquetes;
		}


		public void setCantPaquetes(int cantPaquetes) {
			this.cantPaquetes = cantPaquetes;
		}


		public Date getFecha() {
			return fecha;
		}


		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
	}
}
