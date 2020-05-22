package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int tileCoordinates;
    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
            emptyTileMap.put(i, new EmptyTile(i));
        }

        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoordinates, final Piece piece) {
        return piece != null ? new OccupiedTile(tileCoordinates, piece) : EMPTY_TILES_CACHE.get(tileCoordinates);
    }

    private Tile(int tileCoordinates){
        this.tileCoordinates = tileCoordinates;
    }

    public abstract boolean isTileOccupied();
    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile {               //Subclass

       private EmptyTile(final int coordinates) {
            super(coordinates);
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }

    }

    public static final class OccupiedTile extends Tile{        //Subclass

        private final Piece pieceOnTile;

        private OccupiedTile(int tileCoordinates, final Piece pieceOnTile){
            super(tileCoordinates);
            this.pieceOnTile = pieceOnTile;
        }

            @Override
            public boolean isTileOccupied() {
                return true;
            }

            @Override
            public Piece getPiece(){
            return this.pieceOnTile;
            }
        }
    }

