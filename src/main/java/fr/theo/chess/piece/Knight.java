
package fr.theo.chess.piece;

import fr.theo.chess.game.Game;

public class Knight extends Piece{

  public Knight(Game game, boolean white, int index) {
    super(game, white, index);
  }

  @Override
  protected void computeValidTargets() {
    int x = this.getFileIndex();
    int y = this.getRankIndex();
    addIfValid(x+1, y+2);
    addIfValid(x+1, y-2);
    addIfValid(x-1, y+2);
    addIfValid(x-1, y-2);
    addIfValid(x+2, y+1);
    addIfValid(x+2, y-1);
    addIfValid(x-2, y+1);
    addIfValid(x-2, y-1);
  }
}









