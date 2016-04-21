package yahtzee;

import javax.swing.JFrame;

public class GuiThread2016 implements Runnable {
	
	public GuiThread2016() {
		
	}
	
	public void run() {
		
		GuiFrame2016 frame1 = new GuiFrame2016("Yahtzee");
		frame1.setSize(1200,900);
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
