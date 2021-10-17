package fr.theo.chess.board;

import fr.theo.chess.Local;

public class Board {

  private int[] array;

  public Board() {
    this.array = Local.STARTING_BOARD;
  }

  public int[] getArray() {return this.array;}

  public int get(int index) {return getArray()[index];}
  public int get(int file, int rank) {return getArray()[indexOf(file, rank)];}

  private int indexOf(int file, int rank) {return 8 * rank + file;}
}




