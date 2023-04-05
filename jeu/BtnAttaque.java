package jeu;

import javax.swing.*;
import java.awt.event.*;

public class BtnAttaque extends JButton implements ActionListener {
	public BtnAttaque() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.place.move();
	}

}
