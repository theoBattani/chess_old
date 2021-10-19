
package fr.theo.chess.board;

public class Board {

  private int[] array;

  public Board() {
    this.array = new int[64];
  }

  public int[] getArray() {return this.array;}
  public int get(int index) {return this.getArray()[index];}
}









