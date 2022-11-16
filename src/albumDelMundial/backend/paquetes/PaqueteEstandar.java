package albumDelMundial.backend.paquetes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import albumDelMundial.backend.Album;

public class PaqueteEstandar implements IPaquete{
	
	public List<Integer> pedirPaquete() {
		List<Integer> res = new ArrayList<Integer>();
		//random de 1 a 629 <-- creo
		Random rand = new Random();
		int min = 1; 
		for(int x = 1; x<= 5 ; x++) {
			int randomNum = rand.nextInt((Album.CANTIDAD_DE_FIGURITAS - min) + 1) + min-1;
			res.add(randomNum);
		}
		
		return res;
	}
}
