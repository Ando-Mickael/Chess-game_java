package jeu;

import javax.swing.*;

public class Fou extends Piece {
	public Fou(boolean isWhite, Case place) {
		super(isWhite, place);

		if (this.isWhite) {
			this.ii = new ImageIcon("img/fb.png");
		} else {
			this.ii = new ImageIcon("img/fn.png");
		}
	}

}