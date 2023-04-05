package jeu;

import javax.swing.*;

public class Reine extends Piece {
	public Reine(boolean isWhite, Case place) {
		super(isWhite, place);

		if (this.isWhite) {
			this.ii = new ImageIcon("img/db.png");
		} else {
			this.ii = new ImageIcon("img/dn.png");
		}
	}

}