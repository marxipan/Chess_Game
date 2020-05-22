package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public abstract class Move {        //class
   final Board board;
   final Piece movedPiece;
   final int destinationCoordinates;

   Move(final Board board, final Piece movedPiece, final int destinationCoordinates){
       this.board = board;
       this.movedPiece = movedPiece;
       this.destinationCoordinates = destinationCoordinates;
   }

   public static final class MajorMove extends Move {       //subclass

       public MajorMove(final Board board, final Piece movedPiece, final int destinationCoordinates) {
           super(board, movedPiece, destinationCoordinates);
       }
   }

   public static final class AttackMove extends Move {      //subclass
       final Piece attackedPiece;

       public AttackMove(final Board board, final Piece movedPiece, final int destinationCoordinates, final Piece attackedPiece) {
           super(board, movedPiece, destinationCoordinates);
           this.attackedPiece = attackedPiece;
       }
   }
}
