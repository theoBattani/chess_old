
package fr.theo.chess.piece;

import java.util.ArrayList;

import fr.theo.chess.InvalidTargetException;

public abstract class Piece {
  
  private boolean white;
  private int index;
  private int rankIndex;
  private int fileIndex;
  private Piece[] pieces;
  private ArrayList<Integer> validIndices;
  private ArrayList<Integer> freeIndices;
  private ArrayList<Integer> occupiedIndices;

  public Piece(Piece[] pieces, boolean white, int index) {
    this.white = white;
    this.index = index;
    this.pieces = pieces;
    this.validIndices = new ArrayList<Integer>();
    this.freeIndices = new ArrayList<Integer>();
    this.occupiedIndices = new ArrayList<Integer>();
    this.computeIndices();
  }

  public int getIndex() {return this.index;}
  public int getRankIndex() {return this.rankIndex;}
  public int getFileIndex() {return this.fileIndex;}
  public ArrayList<Integer> getValidIndices() {return this.validIndices;}

  public boolean isWhite() {return this.white;}

  public void update() {this.computeTargets();}

  public void move(int index) {
    try {
      this.moveOnTarget(index);
      for (Piece piece: this.pieces) {
        if (piece != null) {
          piece.computeIndices();
          piece.computeTargets();
        }
      }
    } catch (InvalidTargetException e) {
      e.printStackTrace();
    }
  }

  protected int indexOf(int x, int y) {return 8 * y + x;}

  protected void moveOnTarget(int targetIndex) throws InvalidTargetException {
    if (!targetIsValid(targetIndex)) throw new InvalidTargetException();
    else {
      this.moveInTab(this.index, targetIndex);
      this.index = targetIndex;
    }
  }

  protected boolean isValid(int x, int y) {
    return (x >= 0 && x < 8) && (y >= 0 && y < 8);
  }

  protected boolean addIfValid(int x, int y) {
    if (!isValid(x, y)) return false;
    int index = this.indexOf(x, y);
    if (targetIsOccupied(index)) {
      if (this.isWhite()) {
        if (!this.pieces[index].isWhite()) this.getValidIndices().add(index);
        return false;
      }
      if (this.pieces[index].isWhite()) this.getValidIndices().add(index);
      return false;
    }
    this.getValidIndices().add(index);
    return true;
  }

  private void moveInTab(int from, int to) {
    this.pieces[to] = this;
    this.pieces[from] = null;
  }

  private boolean targetIsValid(int targetIndex) {
    return this.validIndices.contains(targetIndex);
  }

  private boolean targetIsOccupied(int index) {
    return this.pieces[index] != null;
  }

  private void computeIndices() {
    this.fileIndex = this.index % 8;
    this.rankIndex = this.index / 8;
  }

  private void computeTargets() {
    this.validIndices.removeAll(this.validIndices);
    this.freeIndices.removeAll(this.freeIndices);
    this.occupiedIndices.removeAll(this.occupiedIndices);
    this.computeValidTargets();
  }

  protected abstract void computeValidTargets();
}









