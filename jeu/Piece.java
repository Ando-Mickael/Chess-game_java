package jeu;

import javax.swing.*;

public class Piece {
	ImageIcon ii;
	boolean isWhite;
	Case place;
	Case[][] listeCase;

	public Piece(boolean isWhite, Case place) {
		this.isWhite = isWhite;
		this.place = place;

		this.listeCase = this.place.getListeCase();
	}

	public ImageIcon getImageIcon() {
		return this.ii;
	}

	public Case getCase() {
		return this.place;
	}

	public boolean white() {
		return this.isWhite;
	}
}