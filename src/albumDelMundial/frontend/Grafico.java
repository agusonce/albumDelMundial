package albumDelMundial.frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import javafx.scene.canvas.GraphicsContext;


public class Grafico extends JPanel{
	private List<Integer> paquetes;
	public final static int ANCHO_DEL_GRAFICO = 550;
	public final static int ALTO_DEL_GRAFICO = 600;
	public final static int ALTO_PANEL = 600;
	public final static int ANCHO_PANEL = 600;
	
	
	public Grafico() {
		super();
	}
	public void paint(Graphics g) {  
		  dibujarGrafico(g);
		if(paquetes!=null && paquetes.size()>ANCHO_DEL_GRAFICO) {
			  g.clearRect(5, 0, ANCHO_PANEL, ALTO_PANEL);
			  

			  //Crear grafico
			  int mayorNumero = 0; //400;el mayor numero del 
			  for(Integer numero : paquetes) {
				  if(mayorNumero < numero)
					  mayorNumero = numero;
			  }
			 
			  
			  //Cargar datos
			  int valor = 0;
			  int diley = 0;
			  int valorMayor = 0;
			  int valorMenor = 99999;
			  Iterator<Integer> it = paquetes.iterator();
			  for(int x=0; x<= ANCHO_DEL_GRAFICO; x++) {
				  valor = 0;
				  if(paquetes.size() < ANCHO_DEL_GRAFICO) {
					  if(diley > paquetes.size()/420) {
						  diley = 0;
						  valor = it.next();
					  }else {
						  diley++;
					  }
				  }else { /*si la cantidad de numeros a mostrar es mayor a la cantidad de numeros que puedo representar, hago un promedio */
					  int equivalencia = paquetes.size()/ANCHO_DEL_GRAFICO;
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
				  g.fillOval(x + 40,450-valor,5, 5);//grafico/linea
				  
			  }
			  
			  //Dibula grafica
			  dibujarGrafico(g);

			  g.drawString(String.valueOf( (valorMayor*mayorNumero)/400 ) , 20, 450 - valorMayor);//escribe valor mayor en el grafico
			  g.drawString(String.valueOf( Math.round((valorMenor*mayorNumero)/400)), 20, 450 - valorMenor);
			  int valorintermedio = valorMayor - ((valorMayor - valorMenor)/2);
			  g.drawString(String.valueOf(Math.round(valorintermedio*mayorNumero)/400 ), 20, 450- valorintermedio);
		  }
	    }  
		
	  private void dibujarGrafico(Graphics g) {
		  g.drawString("paquetes", 20, 22 );
		  g.drawString("simulaciones", 600, 464 );
		  g.drawLine (40,35, 40, 460);//recta en y
		  g.drawLine (30,450, 650, 450);//recta en x
	  }
	  public void setDatos(List<Integer> datos) {
		  this.paquetes = datos;
	  }

}
