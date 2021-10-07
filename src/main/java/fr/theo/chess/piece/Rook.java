
package fr.theo.chess.piece;

public class Rook extends Piece {

  public Rook(Piece[] pieces, boolean white, int index) {
    super(pieces, white, index);
  }

  @Override
  protected void computeValidTargets() {
    int x = this.getFileIndex();
    int y = this.getRankIndex();

    // for (int i = 0; i < 8; i++) {
    //   auxxl(x, y, i);
    //   auxxr(x, y, i);
    //   auxyu(x, y, i);
    //   auxyd(x, y, i);
    // }

    // for (int i = 0; i < 8; i++) {
    //   this.addIfValid(x + i, y);
    //   this.addIfValid(x - i, y);
    //   this.addIfValid(x, y + i);
    //   this.addIfValid(x, y - i);
    // }
    
    // int i = 0;
    // while (this.addIfValid(x, y + i)) i++;
    // i = 0;
    // while (this.addIfValid(x, y - i)) i++;
    // i = 0;
    // while (this.addIfValid(x - i, y)) i++;
    // i = 0;
    // while (this.addIfValid(x + i, y)) i++;

    // boolean breakUp    = false;
    // boolean breakDown  = false;
    // boolean breakLeft  = false;
    // boolean breakRight = false;
    // for (int i = 0; i < 8; i++) {
    //   if (!breakUp)    breakUp    = this.addIfValid(x, y + i);
    //   if (!breakDown)  breakDown  = this.addIfValid(x, y - i);
    //   if (!breakLeft)  breakLeft  = this.addIfValid(x - i, y);
    //   if (!breakRight) breakRight = this.addIfValid(x + i, y);
    // }

    System.out.println("recomputing ");

    System.out.println(this.addIfValid(x, y+1));
    System.out.println(this.addIfValid(x, y+2));
    System.out.println(this.addIfValid(x, y+3));
    System.out.println(this.addIfValid(x, y+4));
    System.out.println(this.addIfValid(x, y+5));
    System.out.println(this.addIfValid(x, y+6));
    System.out.println(this.addIfValid(x, y+7));

    System.out.println(this.addIfValid(x+1, y));
    System.out.println(this.addIfValid(x+2, y));
    System.out.println(this.addIfValid(x+3, y));
    System.out.println(this.addIfValid(x+4, y));
    System.out.println(this.addIfValid(x+5, y));
    System.out.println(this.addIfValid(x+6, y));
    System.out.println(this.addIfValid(x+7, y));

    System.out.println(this.addIfValid(x-1, y));
    System.out.println(this.addIfValid(x-2, y));
    System.out.println(this.addIfValid(x-3, y));
    System.out.println(this.addIfValid(x-4, y));
    System.out.println(this.addIfValid(x-5, y));
    System.out.println(this.addIfValid(x-6, y));
    System.out.println(this.addIfValid(x-7, y));

    System.out.println(this.addIfValid(x, y-1));
    System.out.println(this.addIfValid(x, y-2));
    System.out.println(this.addIfValid(x, y-3));
    System.out.println(this.addIfValid(x, y-4));
    System.out.println(this.addIfValid(x, y-5));
    System.out.println(this.addIfValid(x, y-6));
    System.out.println(this.addIfValid(x, y-7));

    // this.addIfValid(x+1, y);
    // this.addIfValid(x+2, y);
    // this.addIfValid(x+3, y);
    // this.addIfValid(x+4, y);
    // this.addIfValid(x+5, y);
    // this.addIfValid(x+6, y);
    // this.addIfValid(x+7, y);

    // this.addIfValid(x-1, y);
    // this.addIfValid(x-2, y);
    // this.addIfValid(x-3, y);
    // this.addIfValid(x-4, y);
    // this.addIfValid(x-5, y);
    // this.addIfValid(x-6, y);
    // this.addIfValid(x-7, y);

    // this.addIfValid(x, y+1);
    // this.addIfValid(x, y+2);
    // this.addIfValid(x, y+3);
    // this.addIfValid(x, y+4);
    // this.addIfValid(x, y+5);
    // this.addIfValid(x, y+6);
    // this.addIfValid(x, y+7);

    // this.addIfValid(x, y-1);
    // this.addIfValid(x, y-2);
    // this.addIfValid(x, y-3);
    // this.addIfValid(x, y-4);
    // this.addIfValid(x, y-5);
    // this.addIfValid(x, y-6);
    // this.addIfValid(x, y-7);
  }

  // private void auxxr(int x, int y, int i) {
  //   if (this.addIfValid(x + i, y)) {auxxr(x, y, i + 1);}
  // }
  // private void auxxl(int x, int y, int i) {
  //   if (this.addIfValid(x - i, y)) {auxxl(x, y, i + 1);}
  // }
  // private void auxyu(int x, int y, int i) {
  //   if (this.addIfValid(x, y + i)) {auxyu(x, y, i + 1);}
  // }
  // private void auxyd(int x, int y, int i) {
  //   if (this.addIfValid(x, y - i)) {auxyd(x, y, i + 1);}
  // }
}








