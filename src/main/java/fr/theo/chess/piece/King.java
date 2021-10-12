
package fr.theo.chess.piece;

import fr.theo.chess.game.Game;

public class King extends Piece {

  public King(Game game, boolean white, int index) {
    super(game, white, index);
  }

  @Override
  protected void computeValidTargets() {
    int x = this.getFileIndex();
    int y = this.getRankIndex();
    addIfValid(x+1, y+1);
    addIfValid(x+1, y-1);
    addIfValid(x-1, y+1);
    addIfValid(x-1, y-1);
    addIfValid(x+1, y);
    addIfValid(x, y-1);
    addIfValid(x-1, y);
    addIfValid(x, y+1);
  }
}
