package albumDelMundial.frontend;

import java.awt.Graphics;

import javax.swing.JPanel;

public class APanelGrafico extends JPanel{

	
	public void paintComponet(Graphics g){
		super.paintComponent(g);
		g.drawRect(50, 50, 100, 100);
	}

}
