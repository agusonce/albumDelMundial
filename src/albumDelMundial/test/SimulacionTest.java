package albumDelMundial.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import albumDelMundial.backend.Album;
import albumDelMundial.backend.Dato;
import albumDelMundial.backend.simulacion.ISimulacion;
import albumDelMundial.backend.simulacion.Simulacion;
import albumDelMundial.test.stubs.PaqueteStubs;

class SimulacionTest {

	@Test
	void unaEjecucion() {
		PaqueteStubs paqueteStubs = new PaqueteStubs();
		int[] d = new int[700];
		for(int x = 0; x <= 699; x++ )
			d[x] = x;
		
		paqueteStubs.cargarDatosADevolver(d);
		
		ISimulacion simulacion= new Simulacion(paqueteStubs);
		simulacion.setIteraciones(1);
		simulacion.ejecutar();
		simulacion.getDatos().size();
		int valorEsperado = (int) Math.ceil((double)Album.CANTIDAD_DE_FIGURITAS/5);
		int valor =  simulacion.getDatos().get(0).getCantPaquetes();
		assertTrue( valor == valorEsperado);
	}
	
	@Test
	void multiEjecuciones() {
		int iteraciones = 3;
		PaqueteStubs paqueteStubs = new PaqueteStubs();
		int[] d = new int[Album.CANTIDAD_DE_FIGURITAS*iteraciones];
		int puntero =0;
		for(int j = 0; j <= iteraciones-1; j++ ){
			for(int x = 0; x <= Album.CANTIDAD_DE_FIGURITAS-1; x++ )
				d[puntero++] = x;
		}
		System.out.println(d[0]);
		System.out.println(d[d.length-1]);
		paqueteStubs.cargarDatosADevolver(d);
		
		ISimulacion simulacion= new Simulacion(paqueteStubs);
		simulacion.setIteraciones(2);
		simulacion.ejecutar();
		simulacion.getDatos().size();
		int valorEsperado = (int) Math.ceil((double)Album.CANTIDAD_DE_FIGURITAS/5);
		int valor =  simulacion.getDatos().get(0).getCantPaquetes();
		assertTrue( valor == valorEsperado);
	}

}
