package fr.theo.chess.piece;

import java.util.ArrayList;

import fr.theo.chess.InvalidTargetException;

public abstract class Piece {
  
  private int index;
  private boolean white;
  private ArrayList<Integer> validTargets;

  private 

  public Piece(boolean white, int index) {
    this.white = white;
    this.validTargets = new ArrayList<Integer>();
  }

  public boolean isWhite() {return this.white;}

  protected void moveOnTarget(int targetIndex) throws InvalidTargetException {
    if (!targetIsValid(targetIndex)) throw new InvalidTargetException();
    else {
      this.index = targetIndex;
    }
  }

  private boolean targetIsValid(int target) {
    return this.validTargets.contains(target);
  }

  protected abstract void computeValidTarget();
}
