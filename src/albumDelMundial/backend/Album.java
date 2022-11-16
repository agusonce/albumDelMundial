package albumDelMundial.backend;


public class Album {
	public final static int CANTIDAD_DE_FIGURITAS = 20;//redefinir lugar,  aca no va
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
	
	public boolean contieneFigurita(int key) {
		return (figuritas[key] == 1);
	}
	
	public void agregarFigurita(int key){
		if(figuritas[key] == 1) {
			//error o 
		}else{
			figuritas[key] = 1;
			 this.completados++;
		}
		
	}
	
	public boolean isCompleto() {
		return completados == CANTIDAD_DE_FIGURITAS;
	}
}
