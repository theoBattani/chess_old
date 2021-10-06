
package fr.theo.chess.piece;

import java.util.ArrayList;

import fr.theo.chess.InvalidTargetException;

public abstract class Piece {
  
  private boolean white;
  private int index;
  private int rankIndex;
  private int fileIndex;
  private ArrayList<Integer> validIndices;

  public Piece(boolean white, int index) {
    this.white = white;
    this.index = index;
    this.computeIndices();
    this.validIndices = new ArrayList<Integer>();
    this.computeTargets();
  }

  public int getIndex() {return this.index;}
  public int getRankIndex() {return this.rankIndex;}
  public int getFileIndex() {return this.fileIndex;}
  public ArrayList<Integer> getValidIndices() {return this.validIndices;}

  public boolean isWhite() {return this.white;}

  public void move(int index) {
    try {
      this.moveOnTarget(index);
      this.computeTargets();
    } catch (InvalidTargetException e) {
      e.printStackTrace();
    }
  }

  protected int indexOf(int row, int column) {return 8 * column + row;}

  protected void moveOnTarget(int targetIndex) throws InvalidTargetException {
    if (!targetIsValid(targetIndex)) throw new InvalidTargetException();
    else {this.index = targetIndex;}
  }

  private boolean targetIsValid(int targetIndex) {
    return this.validIndices.contains(targetIndex);
  }

  private void computeIndices() {
    this.fileIndex = this.index % 8;
    this.rankIndex = this.index / 8;
  }

  private void computeTargets() {
    this.validIndices.removeAll(this.validIndices);
    this.computeValidTargets();
  }

  protected abstract void computeValidTargets();
}









