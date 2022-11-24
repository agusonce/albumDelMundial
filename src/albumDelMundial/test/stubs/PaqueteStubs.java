package albumDelMundial.test.stubs;

import java.util.ArrayList;
import java.util.List;

import albumDelMundial.backend.paquetes.IPaquete;


public class PaqueteStubs implements IPaquete{
	private int contFigurita = 0;
	private int[] datos;
	
	public List<Integer> pedirPaquete() {
		List<Integer> res = new ArrayList<Integer>();
		for(int x = 1; x<= 5 ; x++) {
			if(contFigurita==datos.length)
				contFigurita = 0;
			res.add(datos[contFigurita]);
			contFigurita++;
		}
	
		return res;
	}
	
	public void cargarDatosADevolver(int[] d) {
		datos = d;
	}
}
