package jeu;

import javax.swing.*;

public class Roi extends Piece {
	public Roi(boolean isWhite, Case place) {
		super(isWhite, place);

		if (this.isWhite) {
			this.ii = new ImageIcon("img/rb.png");
		} else {
			this.ii = new ImageIcon("img/rn.png");
		}
	}

}