package jeu;

public class Cases {
	Case[][] listeCase = new Case[8][8];

	public Cases() {
		this.setCases();
		this.setPieces();
	}

	void setCases() {
		int size = 60;
		int marge = 30;

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (row % 2 == 0) {
					if (col % 2 != 0) {
						this.listeCase[row][col] = new Case(false, row, col, col * size + marge, row * size + marge,
								this.listeCase);
					} else {
						this.listeCase[row][col] = new Case(true, row, col, col * size + marge, row * size + marge,
								this.listeCase);
					}
				} else {
					if (col % 2 == 0) {
						this.listeCase[row][col] = new Case(false, row, col, col * size + marge, row * size + marge,
								this.listeCase);
					} else {
						this.listeCase[row][col] = new Case(true, row, col, col * size + marge, row * size + marge,
								this.listeCase);
					}
				}
			}
		}
	}

	void setPieces() {
		// tour
		this.listeCase[0][0].setPiece(new Tour(false, this.listeCase[0][0]));
		this.listeCase[0][7].setPiece(new Tour(false, this.listeCase[0][7]));

		this.listeCase[7][0].setPiece(new Tour(true, this.listeCase[7][0]));
		this.listeCase[7][7].setPiece(new Tour(true, this.listeCase[7][7]));

		// cavalier
		this.listeCase[0][1].setPiece(new Cavalier(false, this.listeCase[0][1]));
		this.listeCase[0][6].setPiece(new Cavalier(false, this.listeCase[0][6]));

		this.listeCase[7][1].setPiece(new Cavalier(true, this.listeCase[7][1]));
		this.listeCase[7][6].setPiece(new Cavalier(true, this.listeCase[7][6]));

		// fou
		this.listeCase[0][2].setPiece(new Fou(false, this.listeCase[0][2]));
		this.listeCase[0][5].setPiece(new Fou(false, this.listeCase[0][5]));

		this.listeCase[7][2].setPiece(new Fou(true, this.listeCase[7][2]));
		this.listeCase[7][5].setPiece(new Fou(true, this.listeCase[7][5]));

		// roi
		this.listeCase[0][4].setPiece(new Roi(false, this.listeCase[0][4]));

		this.listeCase[7][4].setPiece(new Roi(true, this.listeCase[7][4]));

		// reine
		this.listeCase[0][3].setPiece(new Reine(false, this.listeCase[0][3]));

		this.listeCase[7][3].setPiece(new Reine(true, this.listeCase[7][3]));

		// pion
		for (int col = 0; col < 8; col++) {
			this.listeCase[1][col].setPiece(new Pion(false, this.listeCase[1][col]));

			this.listeCase[6][col].setPiece(new Pion(true, this.listeCase[6][col]));
		}

	}

	public Case[][] getListeCase() {
		return this.listeCase;
	}
}