package albumDelMundial.frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;


public class Example extends JPanel{
	private List<Integer> paquetes;
	private static int ANCHO_DEL_GRAFICO = 410;
	private static int ALTO_DEL_GRAFICO = 600;
	  public void paint(Graphics g) {  
//	        g.drawString("Hello",40,40);  
//	        setBackground(Color.WHITE);  
//	        g.fillRect(130, 30,100, 80);  
//	        g.drawOval(30,130,50, 60);  
//	        setForeground(Color.RED);  
//	        g.drawArc(30, 200, 40,50,90,60);  
//	        g.fillArc(30, 130, 40,50,180,40);  
		  //cargar variable paquetes
//		  paquetes = new Integer[520];
		  if(paquetes!=null) {
			  System.out.println("nueva ejecucion");
			  g.clearRect(ALTO_DEL_GRAFICO, ALTO_DEL_GRAFICO, ANCHO_DEL_GRAFICO, ALTO_DEL_GRAFICO);
			  int mayorNumero = 0; //400;el mayor numero del 
			  int menorNumero = 90000;//el mayor numero del 
			  for(Integer numero : paquetes) {
				  if(mayorNumero < numero)
					  mayorNumero = numero;
				  if(menorNumero > numero)
					  menorNumero = numero;
			  }
			  
			  
			  
			  int valor = 0;
			  int indicepaquete = 0;
			  int diley = 0;
			  int paquete =400;
			  int valorMayor = 0;
			  int valorMenor = 99999;
			  Iterator<Integer> it = paquetes.iterator();
			  for(int x=0; x<= ANCHO_DEL_GRAFICO; x++) {
				  //dibujo de recta
				  g.fillOval(x + 30,420,5, 5);//recta en x
				  valor = 0;
				  if(paquetes.size() < 400) {
					  if(diley > paquetes.size()/420) {
						  diley = 0;
						  valor = it.next();
					  }else {
						  diley++;
					  }
				  }else {
					  /*
					   *si la cantidad de numeros a mostrar es mayor a la cantidad de numeros que puedo representar,
					   * hago un promedio
					   */
					  int equivalencia = paquetes.size()/ANCHO_DEL_GRAFICO;
					  for(int i = 1; i <= equivalencia; i++)
						  valor += it.next();
					valor = valor/equivalencia;
				  }
				  valor = (valor*400)/mayorNumero;//400 es la altura del grafico
				  
				  if(valor>valorMayor) {valorMayor = valor;}
				  if(valor<valorMenor) {valorMenor = valor;}
				  
				  //dibulo del grafico
				  g.fillOval(x + 30,400-valor,5, 5);//grafico/linea
				  System.out.print("x = "+(x + 30)+ "y ="+ (400-valor));
				  
				  g.fillOval(x + 30,10,5, 5);//techo, sacar
			  }
			  System.out.println(" ");
			  System.out.println("valor mayor:" + valorMayor);
			  System.out.println("valor menor:" + valorMenor);
			  System.out.println("numero mayor:" + mayorNumero);
			  System.out.println("numero menor:" + menorNumero);
		  }
	          
	    }  

	  public void setDatos(List<Integer> datos) {
		  this.paquetes = datos;
	  }

}
