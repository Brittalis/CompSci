package yahtzee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Dice extends JPanel implements ActionListener {

	boolean saved = false;
	private ImageIcon[] diceIcon = new ImageIcon[6];
	Image[] Image = new Image[6];
	{
		for (int i = 0; i < 6; i++) {
			diceIcon[i] = new ImageIcon(i +1+ ".jpg");
			Image[i]= diceIcon[i].getImage();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
