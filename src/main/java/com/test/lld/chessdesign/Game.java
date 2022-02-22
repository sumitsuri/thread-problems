package com.test.lld.chessdesign;

import com.google.common.collect.Lists;
import com.test.lld.chessdesign.factory.MoveValidatorFactory;
import com.test.lld.chessdesign.model.Board;
import com.test.lld.chessdesign.model.Move;
import com.test.lld.chessdesign.model.Player;
import com.test.lld.chessdesign.types.Color;
import com.test.lld.chessdesign.validator.MoveValidator;

import java.util.Queue;

public class Game {
    private Queue<Player> players;
    private Player winner;

    public static void main(String[] args) {
        Game game = new Game();
        game.initPlayers();

        Board board = new Board();
    }

    public void startGame(Board board){
        //Get first player from queue.
        //Get random piece. Get move for this player for random piece
        //check if move is valid. if not get another move until there is valid move.
        //Once move is valid, move the piece from source to destination.
        //Check if current player wins the game or not. If not, let other player repeat the step until
        //someone wins.
        while (isGameNotOver()){
            Player player = players.poll();
            Move move = getNextMove(player.getColor());
            MoveValidator moveValidator = MoveValidatorFactory.getMoveValidator(move.getPiece().getPieceType());

            while(!moveValidator.validate(board, move.getStartPosition(), move.getEndPosition())){
                move = getNextMove(player.getColor());
            }
            boolean isCurrentPlayerWinner = player.movePiece(board,move.getPiece(), move.getStartPosition(), move.getEndPosition());
            //check is player won
            if(isCurrentPlayerWinner){
                winner = player;
                break;
            }
            players.add(player);
        }
    }

    public Move getNextMove(Color color){
        Move move = Move.builder().piece(null).startPosition(null).endPosition(null).build();
        return move;
    }

    private boolean isGameNotOver(){
        return (winner == null);
    }

    public void initPlayers(){
        this.players = Lists.newLinkedList();
        this.players.add(new Player("p1", Color.WHITE));
        this.players.add(new Player("p2", Color.BLACK));
    }
}
