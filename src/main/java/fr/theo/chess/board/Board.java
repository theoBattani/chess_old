
package fr.theo.chess.board;

public class Board {

  Tile[] tiles;
   
  public Board() {
    tiles = new Tile[64];
    for (int index = 0; index < 64; index++) {
      tiles[index] = new Tile(index);
    }
  }

  public Tile getTile(int index) {return tiles[index];}
}
