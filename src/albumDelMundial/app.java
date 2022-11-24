package albumDelMundial;

import java.awt.EventQueue;


import albumDelMundial.frontend.Router;

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
