package yahtzee;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class GuiFrame2016 extends JFrame implements ActionListener{

	public Pannel[] buttonPanels = new Pannel[14];
	Rectangle typical = new Rectangle(0,0,120,30);
	
	
	public GuiFrame2016(String title) {
		// invoke the super constructor
		super(title);
		setLayout(null);
		//Rectangle fuckaids=new Rectangle(100,100,100,100);
		// We are not going to use a layout manager
		//Pannel fuckme=new Pannel("swiggity",fuckaids);
		//this.add(fuckme);
		//System.out.println(fuckme.getComponentCount());
		//created an array of panels to contain the scores and act as buttons(duh)
		buttonPanels[0] = new Pannel("Ones",typical);
		interatetypical();
		System.out.println("memer");
		buttonPanels[1] = new Pannel("Twos",typical);
		interatetypical();
		buttonPanels[2] = new Pannel("Threes",typical);
		interatetypical();
		buttonPanels[3] = new Pannel("Fours",typical);
		interatetypical();
		buttonPanels[4] = new Pannel("Fives",typical);
		interatetypical();
		buttonPanels[5] = new Pannel("Sum",typical);
		interatetypical();
		buttonPanels[6] = new Pannel("Bonus",typical);
		interatetypical();
		buttonPanels[7] = new Pannel("Three of a kind",typical);
		interatetypical();
		buttonPanels[8] = new Pannel("Four of a kind",typical);
		interatetypical();
		buttonPanels[9] = new Pannel("Full House",typical);
		interatetypical();
		buttonPanels[10] = new Pannel("Small Straight",typical);
		interatetypical();
		buttonPanels[11] = new Pannel("Large Straight",typical);
		interatetypical();
		buttonPanels[12] = new Pannel("Chance",typical);
		interatetypical();
		buttonPanels[13] = new Pannel("YAHTZEE",typical);
		interatetypical();
		
		JButton rollDice = new JButton();
		rollDice.setText("Roll Dice");
		rollDice.addActionListener(this);
		rollDice.setActionCommand("roll");
		rollDice.setBounds(550, 625, 100, 50);
		this.add(rollDice);
//		System.out.println(typical.x);
		//buttonPanels[15] = new Pannel("Ones111",0, 90);
		//buttonPanels[16] = new Pannel("Ones",0, 0);
//		buttonPanels[17] = new Pannel("Ones1",0, 30);

		
		
		for (int i=0;i<buttonPanels.length;i++){
			this.add(buttonPanels[i]);
		//	System.out.println(buttonPanels[i].getComponentCount());
		}
		
		// Every time you create a new component, you have to add it to the
		// screen

		// these next two calls should be used to repaint the screen
		validate();
		repaint();
	}
	public void interatetypical(){
	typical.y+=16;
	}
	
	public static void checkIfLegal(ActionEvent e){
		System.out.println(e.getActionCommand());
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
