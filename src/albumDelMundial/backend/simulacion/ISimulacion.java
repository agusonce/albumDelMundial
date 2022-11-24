package albumDelMundial.backend.simulacion;

import java.util.List;

import albumDelMundial.backend.Dato;

public interface ISimulacion {

	public void ejecutar();
	
	public List<Dato> getDatos();
	
	public void setIteraciones(int iteraciones);
}
