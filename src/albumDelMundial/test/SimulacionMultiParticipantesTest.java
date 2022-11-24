package albumDelMundial.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import albumDelMundial.backend.Album;
import albumDelMundial.backend.simulacion.SimulacionMultiParticipantes;
import albumDelMundial.test.stubs.PaqueteStubs;

class SimulacionMultiParticipantesTest {

	@Test
	void cargaConDuplicados() {
		
		PaqueteStubs paqueteStubs = new PaqueteStubs();
		int cantParticipantes = 2;
		int[] d = new int[Album.CANTIDAD_DE_FIGURITAS*cantParticipantes];
		int posicion= 0;
		for(int x = 0; x <= Album.CANTIDAD_DE_FIGURITAS-1; x++ ) {
			for(int u = 1;u<=cantParticipantes ;u++) {
				d[posicion++] = x;
			}
		}
		
		paqueteStubs.cargarDatosADevolver(d);
		
		SimulacionMultiParticipantes simulacion= new SimulacionMultiParticipantes(paqueteStubs);
		simulacion.setIteraciones(1);
		simulacion.setCantParticipantes(cantParticipantes);
		simulacion.ejecutar();
		simulacion.getDatos().size();
		int valorEsperado = (int) Math.ceil((double)Album.CANTIDAD_DE_FIGURITAS/5);
		
		int valor =  simulacion.getDatos().get(0).getCantPaquetes();
		assertTrue( valor == valorEsperado);
	}

}
