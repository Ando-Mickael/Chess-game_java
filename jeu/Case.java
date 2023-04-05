package jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Case extends JButton implements ActionListener {
	boolean isWhite;

	int numRow;
	int numCol;
	int posX;
	int posY;
	boolean isEmpty;
	Piece piece;

	Case[][] listeCase;
	int tmpNumRow;
	int tmpNumCol;

	boolean turnWhite;

	int coupsBlanc;
	int coupsNoir;

	public Case(boolean isWhite, int numRow, int numCol, int posX, int posY, Case[][] listeCase) {
		this.isWhite = isWhite;
		this.numRow = numRow;
		this.numCol = numCol;
		this.posX = posX;
		this.posY = posY;
		this.listeCase = listeCase;

		this.piece = null;
		this.isEmpty = true;
		this.setBgColor();
		this.tmpNumRow = -1;
		this.tmpNumCol = -1;
		this.turnWhite = true;

		this.coupsBlanc = 0;
		this.coupsNoir = 0;

		this.addActionListener(this);
		this.setBounds(this.getPosX(), this.getPosY(), 60, 60);
	}

	public void setBgColor() {
		if (this.isWhite) {
			this.setBackground(Color.lightGray);
		} else {
			this.setBackground(Color.gray);
		}
	}

	public int getPosX() {
		return this.posX;
	}

	public int getPosY() {
		return this.posY;
	}

	int getNumRow() {
		return this.numRow;
	}

	int getNumCol() {
		return this.numCol;
	}

	int getTmpNumRow() {
		return this.tmpNumRow;
	}

	int getTmpNumCol() {
		return this.tmpNumCol;
	}

	Case[][] getListeCase() {
		return this.listeCase;
	}

	Piece getPiece() {
		return this.piece;
	}

	void updateIcon() {
		try {
			this.setIcon(this.piece.getImageIcon());
		} catch (Exception e) {
		}
	}

	void updateIconAll() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				this.listeCase[row][col].updateIcon();
			}
		}
	}

	void setPiece(Piece newPiece) {
		this.piece = newPiece;
		if (newPiece != null) {
			this.isEmpty = false;
		}
		updateIconAll();
	}

	void empty() {
		this.isEmpty = true;
	}

	void removePiece(int row, int col) {
		this.listeCase[row][col].setPiece(null);
		this.listeCase[row][col].setIcon(null);
		this.listeCase[row][col].empty();
	}

	void setTmp(int tmpNumRow, int tmpNumCol) {
		this.tmpNumRow = tmpNumRow;
		this.tmpNumCol = tmpNumCol;
	}

	void setTmpAll(int tmpNumRow, int tmpNumCol) {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				this.listeCase[row][col].setTmp(tmpNumRow, tmpNumCol);
			}
		}
	}

	void resetTmp() {
		this.tmpNumRow = -1;
		this.tmpNumCol = -1;
	}

	void resetTmpAll() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				this.listeCase[row][col].resetTmp();
			}
		}
	}

	void addCoups(boolean white) {
		if (white) {
			this.coupsBlanc++;
		} else {
			this.coupsNoir++;
		}
	}

	void addCoupsAll(boolean white) {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				this.listeCase[row][col].addCoups(white);
			}
		}
	}

	void toggleTurn() {
		if (this.turnWhite) {
			this.turnWhite = false;
		} else {
			this.turnWhite = true;
		}
	}

	void toggleTurnAll() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				this.listeCase[row][col].toggleTurn();
			}
		}
	}

	void movePiece() {
		Piece piece = this.listeCase[this.tmpNumRow][this.tmpNumCol].getPiece();
		this.setPiece(piece);
		removePiece(this.tmpNumRow, this.tmpNumCol);
		resetTmpAll();
		toggleTurnAll();

		if (piece.white()) {
			addCoupsAll(true);
		} else {
			addCoupsAll(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!this.isEmpty) {
			int tmpNumRow = this.getNumRow();
			int tmpNumCol = this.getNumCol();

			if (this.tmpNumRow == -1 && this.tmpNumCol == -1) {
				setTmpAll(tmpNumRow, tmpNumCol);
			} else {
				if (!this.piece.white() == this.listeCase[this.getTmpNumRow()][this.getTmpNumCol()].getPiece()
						.white()) {
					movePiece();
				} else {
					setTmpAll(tmpNumRow, tmpNumCol);
				}
			}
		} else {
			if (this.tmpNumRow != -1 && this.tmpNumCol != -1) {
				movePiece();
			}
		}

		if (this.turnWhite) {
			System.out.println("Turn white");
		} else {
			System.out.println("Turn black");
		}

		System.out.println("blanc : " + this.coupsBlanc + " coups");
		System.out.println("noir : " + this.coupsNoir + " coups");

		/*
		 * try
		 * {
		 * if(this.piece.white())
		 * {
		 * System.out.println("Blanc");
		 * }
		 * else
		 * {
		 * System.out.println("Noir");
		 * }
		 * }
		 * catch(Exception exception)
		 * {
		 * System.out.println(exception);
		 * }
		 * 
		 * System.out.printf("ACTUEL : row = %d / col = %d\n", this.getNumRow(),
		 * this.getNumCol());
		 * System.out.printf("TMP : row = %d / col = %d\n\n", this.tmpNumRow,
		 * this.tmpNumCol);
		 */

	}

}
