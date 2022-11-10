package albumDelMundial.backend;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/*
 * Agregar validacion a todo
 */
public class JsonFile<T> {
	private List<T> datos;
	public JsonFile() {
	}
	
	public JsonFile(List<T> datos) {
		this.datos = datos;
	}
	
	public String generarJson() {
		Gson json = new GsonBuilder().create();
		String res = json.toJson(datos);
		return res;
	}
	
	
	public List<T> getDatos() {
		return datos;
	}

	public void setDatos(List<T> datos) {
		this.datos = datos;
	}

	public String generarJsonPretty() {
		Gson json = new GsonBuilder().setPrettyPrinting().create();
		String res = json.toJson(datos);
		return res;
	}
	
	public void guardarJson(String DatoJson, String archivoDestino) {
		try {
			FileWriter write = new FileWriter(archivoDestino);
			write.write(DatoJson);
			write.close();
		}catch(IOException e) {
			
		}
	}

}
