package albumDelMundial.frontend;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;



public class Grafico extends JPanel{
	private List<Integer> datos;
	public final static int ANCHO_DEL_GRAFICO = 549;
	public final static int ALTO_DEL_GRAFICO = 600;
	public final static int ALTO_PANEL = 600;
	public final static int ANCHO_PANEL = 600;
	
	
	public Grafico() {
		super();
	}
	public void paint(Graphics g) {  
		  dibujarGrafico(g);
		if(datos!=null) {
			  g.clearRect(5, 0, ANCHO_PANEL, ALTO_PANEL);
			  

			  //Crear grafico
			  int mayorNumero = 0; //el mayor numero del 
			  for(Integer numero : datos) {
				  if(mayorNumero < numero)
					  mayorNumero = numero;
			  }
			 
			  
			  //Cargar datos
			  int valor = 0;
			  int diley = 0;
			  int valorDiley = 0;
			  int valorMayor = 0;
			  int valorMenor = 99999;
			  Iterator<Integer> it = datos.iterator();
			  for(int x=0; x<= ANCHO_DEL_GRAFICO; x++) {
				  valor = 0;
				  if(datos.size() < ANCHO_DEL_GRAFICO) {
					  if(diley > ANCHO_DEL_GRAFICO/datos.size()) {
						  diley = 0;
						 // valorDiley = it.next();
					  }else {
						  if(diley == 0)
							  valorDiley = it.next(); 
						  diley++;
					  }
					  valor = valorDiley;
				  }else { /*si la cantidad de numeros a mostrar es mayor a la cantidad de numeros que puedo representar, se hace un promedio */
					  int equivalencia = datos.size()/ANCHO_DEL_GRAFICO;
					  for(int i = 1; i <= equivalencia; i++)
						  valor += it.next();
					valor = valor/equivalencia;
				  }
				  valor = (valor*400)/mayorNumero;//400 es la altura del grafico
				  if(valorMayor < valor) {
					  valorMayor = valor;
				  }
				  if(valorMenor > valor) {
					  valorMenor = valor;
				  }
				  //dibulo del grafico
  				  g.fillOval(x + 40,448-valor,5, 5);//grafico/linea
				  
			  }
			  
			  //Dibujar datos de la grafica
			  dibujarGrafico(g);

			  g.drawString(String.valueOf( (valorMayor*mayorNumero)/400 ) , 10, 450 - valorMayor);//escribe valor mayor en el grafico
			  g.drawString(String.valueOf( Math.round((valorMenor*mayorNumero)/400)), 10, 450 - valorMenor);
			  int valorintermedio = valorMayor - ((valorMayor - valorMenor)/2);
			  g.drawString(String.valueOf(Math.round(valorintermedio*mayorNumero)/400 ), 10, 450- valorintermedio);
			  
			  //String.valueOf( Math.round((valorMenor*mayorNumero)/400))
			  g.drawString(String.valueOf(datos.size()), 40 + ANCHO_DEL_GRAFICO, 459 );
			  g.drawString(String.valueOf(Math.round(datos.size()/2 )), 40 + (ANCHO_DEL_GRAFICO/2), 459 );
			  g.drawString(String.valueOf("0"), 40 + 1, 459 );
		  }
	    }  
		
	  private void dibujarGrafico(Graphics g) {
		  g.drawString("paquetes", 20, 22 );
		  g.drawString("Participantes", 605, 450 );
		  g.drawLine (40,35, 40, 460);//recta en y
		  g.drawLine (30,446, 600, 446);//recta en x
	  }
	  public void setDatos(List<Integer> datos) {
		  this.datos = datos;
	  }

}
