package albumDelMundial;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import albumDelMundial.backend.simulacion.Simulacion;
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
		Router f= new Router();
		f.getContentPane().setLayout(null);
		
        f.setVisible(true); 
	}
	  
}
