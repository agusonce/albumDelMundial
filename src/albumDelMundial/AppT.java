package albumDelMundial;

import albumDelMundial.backend.simulator.Simulacion;

public class AppT {

	public AppT() {
		System.out.println("Inicio de simulacion");
		Simulacion simulacion = new Simulacion();
		System.out.println("Fin de simulacion");
		System.out.println(simulacion.getPaquetesAbiertos()); 
	}

	public static void main(String[] args) {
		AppT pp = new AppT();

	}

}
