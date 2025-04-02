package ija.ija2024.homework1.game;

import ija.ija2024.homework1.common.GameNode;
import ija.ija2024.homework1.common.Position;
import ija.ija2024.homework1.common.Side;

public class Game {
    private int rows;
    private int cols;
    private GameNode[][] board;
    private boolean powerPlaced = false;

    public Game(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new GameNode[rows][cols];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                Position position = new Position(i, j);
                this.board[position.getRow()][position.getCol()] = new GameNode(position, GameNode.Type.EMPTY);
            }
        }
    }

    public static Game create(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException();
        }
        return new Game(rows, cols);
    }

    public int rows() {
        return this.rows;
    }

    public int cols() {
        return this.cols;
    }

    public GameNode node(Position p) {
        if (p.getRow() < 0 || p.getRow() >= rows || p.getCol() < 0 || p.getCol() >= cols) {
            return null;
        }
        return this.board[p.getRow()][p.getCol()];
    }

    public GameNode createBulbNode(Position position, Side side) {
        if (!isValidPosition(position)) {
            return null;
        }
        GameNode node = new GameNode(position, GameNode.Type.BULB, side);
        this.board[position.getRow()][position.getCol()] = node;
        return node;
    }

    public GameNode createLinkNode(Position position, Side... side) {
        if (!isValidPosition(position) || side.length < 2) {
            return null;
        }
        GameNode node = new GameNode(position, GameNode.Type.LINK, side);
        this.board[position.getRow()][position.getCol()] = node;
        return node;
    }

    public GameNode createPowerNode(Position position, Side... side) {
        if (!isValidPosition(position) || side.length < 1 || powerPlaced) {
            return null;
        }
        GameNode node = new GameNode(position, GameNode.Type.POWER, side);
        this.board[position.getRow()][position.getCol()] = node;
        powerPlaced = true;
        return node;
    }

    private boolean isValidPosition(Position position) {
        return position.getRow() >= 0 && position.getRow() < rows && position.getCol() >= 0 && position.getCol() < cols;
    }
}
