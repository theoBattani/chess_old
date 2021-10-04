
package fr.theo.chess.piece;

import java.util.ArrayList;

import fr.theo.chess.board.Tile;
import fr.theo.chess.InvalidTargetException;

public abstract class Piece {
  
  private boolean white;
  private Tile tile;
  private ArrayList<Tile> validTargets;

  public Piece(boolean white, Tile tile) {
    this.white = white;
    this.tile = tile;
    this.validTargets = new ArrayList<Tile>();
  }

  public Tile getTile() {return this.tile;}

  public void setTile(Tile tile) {this.tile = tile;}

  public boolean isWhite() {return this.white;}

  protected void moveOnTarget(Tile target) throws InvalidTargetException {
    if (!targetIsValid(tile)) throw new InvalidTargetException();
    else {this.tile = target;}
  }

  private boolean targetIsValid(Tile target) {
    return this.validTargets.contains(target);
  }

  protected abstract void computeValidTargets();
}









