package jeu;

import javax.swing.*;

public class Cavalier extends Piece {
	public Cavalier(boolean isWhite, Case place) {
		super(isWhite, place);

		if (this.isWhite) {
			this.ii = new ImageIcon("img/cb.png");
		} else {
			this.ii = new ImageIcon("img/cn.png");
		}
	}

}