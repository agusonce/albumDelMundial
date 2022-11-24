package albumDelMundial.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import albumDelMundial.backend.Album;

class AlbumTest {

	@Test
	void cargaFiguritasRepetidas() {
		Album album = new Album();
		int figurita = 3;
		album.agregarFigurita(figurita);
		album.agregarFigurita(figurita);
		assertTrue(album.contieneFigurita(figurita));
	}

	@Test
	void albumCompleto() {
		Album album = new Album();
		for (int x=0; x <= Album.CANTIDAD_DE_FIGURITAS-1; x++) {
			album.agregarFigurita(x);
		}
		assertTrue(album.isCompleto());
	}

	
	@Test
	void albumVacio() {
		Album album = new Album();
		assertFalse(album.isCompleto());
	}

	@Test
	void cargarFiguritasNoPermitidos() {
		Album album = new Album();
		try {
			album.agregarFigurita(-2);
	    } catch (Exception e) {
	        assertTrue(true);
	    }
	}

	
}
