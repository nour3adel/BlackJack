package blackjack;
import java.util.Scanner;

public class BlackJack {

    public static Game GameObj = new Game();


    public static void main(String[] args) {
        GUI gui = new GUI();



        Scanner input = new Scanner(System.in);



        GameObj.DeckOfCards();
        GameObj.setPlayersData();
        gui.runGUI( GameObj.getDeck(), GameObj.players[0].getCards(),GameObj.players[1].getCards(), GameObj.players[2].getCards(), GameObj.players[3].getCards());


//        ****************************************************************************************************
//        ****************************************************************************************************
//        *******************************     PLayer Turn       **********************************************
//        ****************************************************************************************************
//        ****************************************************************************************************


        for (int PlayersTurn = 0; PlayersTurn < 3; PlayersTurn++) {

            while (true) {
                System.out.println(GameObj.players[PlayersTurn].name + " has Score : " + GameObj.players[PlayersTurn].score);

                System.out.println("Press  (1) For  Hit ");
                System.out.println("Press  (2) For  Stand ");
                int Response = input.nextInt();
                if (Response == 1) {
                    System.out.println("****************************************************");
                    System.out.println("Dealer Give Your Card.");
                    System.out.println("****************************************************");



                    GameObj.players[PlayersTurn].AddCard(GameObj.ShuffleDeck());



//   ***********************************************      GUi Player Here    *****************************************************

                    gui.updatePlayerHand(GameObj.players[PlayersTurn].getCards()[GameObj.players[PlayersTurn].getIndex()-1], PlayersTurn);

//   ******************************************************************************************************************************


                        GameObj.setHighScore();
                    if (GameObj.players[PlayersTurn].Blackjack) {
                        System.out.println("**************************************");
                        System.out.println("BlackJack");
                        System.out.println("**************************************");

                        break;
                    }
                    else if (GameObj.players[PlayersTurn].Busted) {
                        System.out.println("**************************************");
                        System.out.println("busted");
                        System.out.println("**************************************");

                        GameObj.players[PlayersTurn].score = 0;
                        GameObj.setHighScore();
                        break;
                    }

                }
                if (Response == 2) {
                    GameObj.setHighScore();
                    break;
                }

            }
            if (GameObj.players[PlayersTurn].Blackjack != true && GameObj.players[PlayersTurn].Busted != true) {
                System.out.println("Score of  " + GameObj.players[PlayersTurn].name + " is " + GameObj.players[PlayersTurn].score);
            }
            System.out.println("**************************************");
            System.out.println( "HighScore is : "+ GameObj.getHighScore());
            System.out.println("**************************************");


        }


//        ****************************************************************************************************
//        ****************************************************************************************************
//        *******************************    Dealer Turn       ***********************************************
//        ****************************************************************************************************
//        ****************************************************************************************************



        if (GameObj.players[3].score > GameObj.getHighScore()) {
            GameObj.setHighScore(GameObj.players[3].score);
            System.out.println("Dealer has HighScore = " + GameObj.getHighScore());
        } else {
            System.out.println("Dealer has Score = " + GameObj.players[3].score);
            System.out.println("The Dealer will hit until BlackJack or busted ");
            while (true) {
                GameObj.players[3].AddCard(GameObj.ShuffleDeck());

//             ************************************Gui HERE DEAlER *******************************************************

                gui.updateDealerHand(GameObj.players[3].getCards()[GameObj.players[3].getIndex()-1], GameObj.getDeck());

//             ***********************************************************************************************************
                if (GameObj.players[3].score > GameObj.getHighScore()) {
                    GameObj.setHighScore(GameObj.players[3].score);

                }
                if (GameObj.players[3].Busted) {
                    System.out.println("Dealer Busted");
                    GameObj.setHighScore();
                    break;
                } else if (GameObj.players[3].Blackjack) {
                    System.out.println("Dealer BlackJack");
                    break;

                } else if (GameObj.players[3].score > GameObj.getHighScore()) {
                    break;

                }

            }

        }
//     **********************   Pushed Case    *****************************
//     *********************************************************************



        int PlayerCounter = 0;
        for (int i = 0; i < 4; i++) {
            if (GameObj.players[i].score == GameObj.getHighScore()) {
                PlayerCounter++;
            }
        }
            if (PlayerCounter == 1) {
                for (int j = 0; j < 4; j++) {
                    if (GameObj.players[j].score == GameObj.getHighScore()) {
                        System.out.println("Winner is "+ GameObj.players[j].name);
                    }
                }
            }
            else{
                System.out.println("Pushed Case");
            }

        }

    }






























