package albumDelMundial.backend;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import albumDelMundial.backend.paquetes.IPaquete;

public class Participante {
	Logger logger = Logger.getLogger(Participante.class.getName());
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
		Iterator < Integer > itFiguritas = figuritas.iterator();
		while (itFiguritas.hasNext()) {
		  Integer figurita = itFiguritas.next();
		  if(albumIsCompleto()) {
			  continue;
		  }
		  try {
			  if(!this.album.contieneFigurita(figurita)) {
				  this.album.agregarFigurita(figurita);
				  itFiguritas.remove();
			  }
		  }catch(InvalidParameterException e) {
			  logger.info(e.toString());
		  }
		}
		
	}
	
	public boolean contieneFigurita(int figurita){
		return album.contieneFigurita(figurita);
	}
	
	public void recivirCarta(int numero) {
		if(album.isFiguritaValida(numero)) 
			this.figuritas.add(numero);
	}; 
	

	/*
	 * Los duplicados son aqueyas figuritas que no cargaron en el album
	 */
	public List<Integer> getDuplicados() {
		return this.figuritas;
	}
	
	public List<Integer> extraerDuplicados() {
		List <Integer> res = new ArrayList<Integer>();
		for(int f: this.figuritas)
			res.add(f);
		this.figuritas.clear();
		return res;
	}
	
	public boolean  albumIsCompleto() {
		return album.isCompleto();
	}

	public int getId() {
		return id;
	}

}

