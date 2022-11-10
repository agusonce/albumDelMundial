package albumDelMundial.backend;

import java.util.ArrayList;
import java.util.List;

public class Participante {
	private int id;
	private List<Integer> figuritas;
	private Album album;
	public static int count = 0;
	
	public Participante() {
		this.id = count;
		count ++;
		this.album = new Album();
		inicializarFiguritas();

	}

	private void inicializarFiguritas() {
		this.figuritas= new ArrayList<Integer>(); 
	}
	
	
	//agarra las figuritas que tiene y carga el album
	public void cargarAlbum() {
		List<Integer> eliminar  = new ArrayList<Integer>();
		for(int x = 0; x <= figuritas.size()-1; x++) {
			if(!this.album.contieneFigurita(figuritas.get(x))) {
				this.album.agregarFigurita(figuritas.get(x));
				eliminar.add(x);
			}
		}
		this.figuritas.removeAll(eliminar);
		
	}
	
	public void recivirCarta(int numero) {
		//validar si hay uno o mas figuritas con esta clave
		this.figuritas.add(numero);
	}; 
	

	public List<Integer> getDuplicados() {
		return this.figuritas;
	}
	
	public boolean  albumIsCompleto() {
		return album.isCompleto();
	}

	public int getId() {
		return id;
	}

}

