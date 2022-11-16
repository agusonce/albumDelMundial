package albumDelMundial.backend.serializacion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/*
 * Agregar validacion a todo
 */
public class JsonFile<T> {
	private String UrlFile = "./src/resource/";
	private List<T> datos;
	public JsonFile() {
	}
	
	public JsonFile(List<T> datos) {
		this.datos = datos;
	}
	
	public String generarJson() {
		
		if(this.datos== null || this.datos.isEmpty())
			new Exception("Ingrese datos");
			
			
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
	
	
	public void guardarJson(String nombreArchivo) {
		String d = generarJson();
		if(d== null || d.isEmpty()) {
			//error
		}
		
		
		try (FileWriter write = new FileWriter(this.UrlFile+nombreArchivo);){
			write.write(generarJson());
			write.close();
		}catch(IOException e) {
			
		}
	}
	
	
	public void guardarJson(String DatoJson, String nombreArchivo) {
		try (FileWriter write = new FileWriter(this.UrlFile+nombreArchivo);){
			write.write(DatoJson);
			write.close(); 
		}catch(IOException e) {
			
		}
	}
	
	
	public void eliminarArchivo( String archivoDestino) {
			File write = new File(archivoDestino);
			write.deleteOnExit();
	}

}
