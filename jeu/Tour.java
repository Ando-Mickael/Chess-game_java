package jeu;

import javax.swing.*;

public class Tour extends Piece {
	public Tour(boolean isWhite, Case place) {
		super(isWhite, place);

		if (this.isWhite) {
			this.ii = new ImageIcon("img/tb.png");
		} else {
			this.ii = new ImageIcon("img/tn.png");
		}
	}

}