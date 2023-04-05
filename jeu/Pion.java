package jeu;

import javax.swing.*;

public class Pion extends Piece {
	public Pion(boolean isWhite, Case place) {
		super(isWhite, place);

		if (this.isWhite) {
			this.ii = new ImageIcon("img/pb.png");
		} else {
			this.ii = new ImageIcon("img/pn.png");
		}
	}

}