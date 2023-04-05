package jeu;

import javax.swing.*;

public class Echiquier extends JFrame {
	Cases cases;
	Case[][] listeCase;

	BtnWin btnW;
	BtnWin btnB;
	BtnWin btnD;

	public Echiquier() {
		this.cases = new Cases();
		this.listeCase = this.cases.getListeCase();

		this.btnW = new BtnWin("blanc");
		this.btnW.setPosition(530, 30);
		this.btnB = new BtnWin("noir");
		this.btnB.setPosition(530, 150);
		this.btnD = new BtnWin("nul");
		this.btnD.setPosition(530, 270);

		this.setTitle("ETU001464");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);

		this.addCases();
		this.add(this.btnW);
		this.add(this.btnB);
		this.add(this.btnD);

		this.setVisible(true);
	}

	void addCases() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				this.add(this.listeCase[row][col]);
			}
		}
	}

}