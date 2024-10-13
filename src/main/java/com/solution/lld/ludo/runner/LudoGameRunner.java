package com.solution.lld.ludo.runner;

import com.solution.lld.ludo.constants.Constant;
import com.solution.lld.ludo.model.LudoBoard;
import com.solution.lld.ludo.model.Piece;
import com.solution.lld.ludo.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LudoGameRunner {

    private static String[] colors = {Constant.Color.BLUE, Constant.Color.RED,Constant.Color.GREEN,Constant.Color.YELLOW};
    private static List<Player> playerList = new ArrayList<>();
    private static Player currentPlayer;
    private static LudoBoard ludoBoard;

  public static void main(String[] args) {
    //
      ludoBoard = new LudoBoard();
      for(String color: colors){
          Player player = new Player(color);
          playerList.add(player);
          ludoBoard.initializePieces(player);
      }
      runGame();
  }

  private static void runGame(){
      Scanner scanner = null;
      boolean gameCompleted = false;
      //Can get from some method based on some logic of finding which player should start.
      currentPlayer = playerList.get(0);
      while(!gameCompleted){
          System.out.println(currentPlayer + "'s turn. The only thing which you can do is roll - r");
          boolean rollComplete = false;
          while(!rollComplete){
              scanner = new Scanner(System.in);
              String input = "a";
              try{
                  input = scanner.next();
              }catch(Exception e) {
                  // ignore
              }
              if(input.equals("r")){
                currentPlayer.rollDice();
                  rollComplete = true;
              }else{
                  System.out.println("Something went wrong.Type in \"r\".");
                  continue;
              }
              boolean movesArePossible = ludoBoard.movesPossible(currentPlayer, currentPlayer.getNumberRolled());
              if(!movesArePossible){
                  System.out.println("There are no possible moves..Moving on to next player");
                  setNextPlayer();
                  continue;
              }
              System.out.println(currentPlayer + " has rolled " + currentPlayer.getNumberRolled() +
                      ". Commands:\n" +
                      "\"t (piece number)\" without the brackets to take a piece out of the home circle;\n" +  //Type t 1 to move piece 1 out of home circle , t 2 for piece two and t 3 and so on (t(spacebar)(piece number))
                      "\"m (piece number)\" without the brackets to move a piece."); //Type m 1 to move piece 1, m 2 to move piece 2, m 3 and so on (m(spacebar)(piece number))

              boolean turnComplete = false;
              while(!turnComplete){
                  scanner = new Scanner(System.in);
                  String command = null;
                  boolean commandSuccessful = false;
                  try {
                      command = scanner.next();
                  } catch(Exception e) {
                      System.out.println("Invalid command. Try again.");
                      continue;
                  }
                  //replace with switchcase
                  //remove hardcoded constant
                  //Remove common code in both logical block
                  if(command.equals("t")){
                      int pieceNumber = 0;
                      try{
                          pieceNumber = scanner.nextInt()-1;
                      }catch (Exception e){

                      }
                      if(pieceNumber<0 || pieceNumber>3){
                          System.out.println("Wrong piece number!");
                          continue;
                      }

                      Piece piece = currentPlayer.getPieces().get(pieceNumber);
                      commandSuccessful = ludoBoard.takePieceOut(piece);

                  }else if(command.equals("m")){
                        int pieceNumber = 0;
                        try{
                            pieceNumber = scanner.nextInt() - 1;
                        }catch (Exception e){

                        }
                      if(pieceNumber<0 || pieceNumber>3){
                          System.out.println("Wrong piece number!");
                          continue;
                      }
                      Piece piece = currentPlayer.getPieces().get(pieceNumber);
                      commandSuccessful = ludoBoard.movePiece(
                              piece, currentPlayer.getNumberRolled()
                      );
                  }else{
                    System.out.println("Invalid command. Try out again");
                    continue;
                  }
                  if(commandSuccessful){
                      if(currentPlayer.hasWon()){
                        System.out.println("Congrats.. " + currentPlayer + " has won the game");
                        break;
                      }
                      if(currentPlayer.isHasRolledSix()){
                          System.out.println(currentPlayer + " has got rolled six. Means currentplayer will get one more chance. Roll");
                          continue;
                      }
                      setNextPlayer();
                      turnComplete = true;
                  }else{
                      System.out.println("Move cannot be completed..Try something else");
                  }

              }
          }
      }
      //move it to finally block.
      scanner.close();
  }

  private static void setNextPlayer(){
      int index = playerList.indexOf(currentPlayer) + 1;
      if(index == playerList.size()){
          index = 0;
      }
      currentPlayer = playerList.get(index);
  }
}
