package jeu;

import javax.swing.*;
import java.awt.event.*;

public class BtnWin extends JButton implements ActionListener {
	JOptionPane popUp;

	String couleur;
	String msgWin;

	public BtnWin(String couleur) {
		this.couleur = couleur;

		if (this.couleur == "blanc") {
			this.setText("White");
			this.msgWin = "White wins !";
		} else if (this.couleur == "noir") {
			this.setText("Black");
			this.msgWin = "Black wins !";
		} else {
			this.setText("Nul");
			this.msgWin = "Nul !";
		}

		this.addActionListener(this);
	}

	public void setPosition(int x, int y) {
		this.setBounds(x, y, 200, 100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.popUp.showMessageDialog(null, this.msgWin, "End game", JOptionPane.PLAIN_MESSAGE);
	}

}