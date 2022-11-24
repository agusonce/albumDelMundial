package albumDelMundial.backend;

import java.security.InvalidParameterException;
import java.util.logging.Logger;

public class Album {
	public final static int CANTIDAD_DE_FIGURITAS = 638;//redefinir lugar
	Integer[] figuritas;
	private int completados;
	
	public Album (){
		completados = 0;
		figuritas = new Integer[CANTIDAD_DE_FIGURITAS];
		for (int x = 0; x <= CANTIDAD_DE_FIGURITAS-1 ; x++) {
			figuritas[x] = 0;//cero significa que no tiene figurita
		}
	}
	
	public int getCompletados() {
		return this.completados;
	}
	
	public boolean contieneFigurita(int figurita) throws InvalidParameterException{
		if(!isFiguritaValida(figurita)){
			throw new InvalidParameterException("el numero de figurita '"+figurita+"' no es un valor valido");
		}
		return (figuritas[figurita] == 1);
	}
	
	public void agregarFigurita(int figurita){
		if(!isFiguritaValida(figurita)){
			throw new InvalidParameterException("el numero de figurita '"+figurita+"' no es un valor valido");
		}else if(figuritas[figurita] != 1) {
			figuritas[figurita] = 1;
			 this.completados++;
		}
	}
	
	public boolean isCompleto() {
		return completados == CANTIDAD_DE_FIGURITAS;
	}
	
	public boolean isFiguritaValida(int figurita) {
		return (figurita>=0 && figurita<CANTIDAD_DE_FIGURITAS);
	}
}
