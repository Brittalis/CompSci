package yahtzee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Pannel extends JPanel implements ActionListener {

	public JButton button = new JButton();
	boolean filled = false;
	public JLabel label = new JLabel();
	int finalScore;
	//Rectangle position= new Rectangle();
	

	Pannel(String name, Rectangle position) {
		
		//super();
		this.setLayout(null);
		this.setName(name);
		this.setSize(1200,900);
		this.setLocation(position.x, position.y);
		//System.out.println(position.x+""+position.y+""+position.height+""+position.width);
		//this.button.addMouseListener(this);
		this.button.setText(name);
		this.button.addActionListener(this);
		this.button.setActionCommand(name);
		//PASS RECTANGLES IN LATER
		this.button.setBounds(position);
		System.out.println("meme");
		this.label.setBounds(position.x+130,position.y+10,100,10);
		this.label.setText("-");
		this.add(this.button);
		this.add(this.label);
//		this.repaint();
//		this.validate();
//		this.revalidate();
	}
	

	public void selectPanel(int score) {
		boolean filled = true;
		label.setText(score + "");
		finalScore = score;
	}

	public void paintComponent(Graphics g) {
		// start by calling the super method
		// super.paintComponent(g);

		// Set the parameters of the panel here
		// this.setSize(200,200);
		this.setVisible(true);

		// Now we can start drawing
		// this.setBackground(Color.red);
		// g.setColor(col2);
		// g.fillOval(50,50,50,50);
		// repaint();

		// //In order to draw images, you need to upgrade the Graphics object
		// to Graphics 2D
		// Graphics2D g2 = (Graphics2D) g;
		//
		// g2.drawImage(image1, 0,0, 200,200, this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GuiFrame2016.checkIfLegal(e);
			
	}

}
