package albumDelMundial;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import albumDelMundial.backend.simulator.Simulacion;
import albumDelMundial.frontend.APanelGrafico;
import albumDelMundial.frontend.PantallaSimulacion;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;

import javax.swing.JTextArea;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import java.awt.GridLayout;

public class app {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public app() {
		//Example m = new Example();
		PantallaSimulacion f= new PantallaSimulacion();
		f.getContentPane().setLayout(null);

		//f.getLayout().
//		JInternalFrame internalFrame = new JInternalFrame("");
//		
//		f.getContentPane().add(internalFrame, BorderLayout.WEST);
//		
//		JLayeredPane layeredPane = new JLayeredPane();
//		f.getContentPane().add(layeredPane, BorderLayout.EAST);
//		
//		JDesktopPane desktopPane = new JDesktopPane();
//		f.getContentPane().add(desktopPane, BorderLayout.SOUTH);
//		internalFrame.setVisible(true);
        //f.add(m);  

        //f.setLayout(null);  
        f.setVisible(true); 
		//		initialize();
//		System.out.println("Inicio de simulacion");
//		Simulacion simulacion = new Simulacion();
//		System.out.println("Fin de simulacion");
//		System.out.println(simulacion.getPaquetesAbiertos()); 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
//		JButton btnNewButton_1 = new JButton("Ejecutar");
//		frame.getContentPane().add(btnNewButton_1);
//		
//		JButton btnNewButton_3 = new JButton("New button");
//		frame.getContentPane().add(btnNewButton_3);
//		
//		JButton btnNewButton_2 = new JButton("New button");
//		frame.getContentPane().add(btnNewButton_2);
//		
//		JButton button = new JButton("New button");
//		frame.getContentPane().add(button);
//		
//		JButton btnNewButton = new JButton("Actualizar datos");
//		frame.getContentPane().add(btnNewButton);
//		
//		JTextArea textArea = new JTextArea();
//		frame.getContentPane().add(textArea);
//		
		APanelGrafico grafic = new APanelGrafico();
		frame.getContentPane().add(grafic);
		frame.setVisible(true);
		//grafic.paintComponet( frame.getGraphics());
//		Canvas canvas = new Canvas();
//		canvas.setBounds(10, 120, 220, 220);
//		canvas.setVisible(true);
//		frame.add(canvas);
//		//frame.getContentPane().add(canvas);
//		frame.setVisible(true);

//		GraphicsConfiguration gc = canvas.getGraphicsConfiguration();
//		
//		Graphics g = canvas.getGraphics();
//		
//		g = g.create(100, 120, 120, 120);
//        g.drawString("Hello",40,40);  
//        g.fillRect(130, 30,100, 80);  
//        g.drawOval(30,130,50, 60);  
//        g.fillOval(130,130,50, 60);  
//        g.drawArc(30, 200, 40,50,90,60);  
//        g.fillArc(30, 130, 40,50,180,40);  
		
	}
	
	  public void paint(Graphics g) {
		  	g.drawString("Hello",40,40);  
	        frame.setBackground(Color.WHITE);  
	        g.fillRect(130, 30,100, 80);  
	        g.drawOval(30,130,50, 60);  
	        frame.setForeground(Color.RED);  
	        g.fillOval(130,130,50, 60);  
	        g.drawArc(30, 200, 40,50,90,60);  
	        g.fillArc(30, 130, 40,50,180,40);  
		  }
	  
	private void ejemploGraficoss() {
		 	Canvas DisplayGrafico = new Canvas();
	    	Graphics g = DisplayGrafico.getGraphics();   
	        g.drawString("Hello",40,40);  
	        frame.setBackground(Color.WHITE);  
	        g.fillRect(130, 30,100, 80);  
	        g.drawOval(30,130,50, 60);  
	        frame.setForeground(Color.RED);  
	        g.fillOval(130,130,50, 60);  
	        g.drawArc(30, 200, 40,50,90,60);  
	        g.fillArc(30, 130, 40,50,180,40);  

	   
	}
}
