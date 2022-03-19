package blackjack;
import  java.util.Random;
import java.util.Scanner;

public class Game {

    Player[] players = new Player[4];

    public Card[] getDeck() {
        return Deck;
    }

    private  Card[] Deck = new Card[52];

   private int HighScore = 0;

    public void DeckOfCards() {
        int index = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 0; rank < 13; rank++) {

                if (rank < 10) {

                    Deck[index] = new Card(suit, rank, rank + 1);

                } else {
                    Deck[index] = new Card(suit, rank, 10);

                }
                index++;
            }
        }
    }

    public Card ShuffleDeck() {
        Random rand = new Random();
        Card newCard;
        while (true) {
            int randomChoice = rand.nextInt(52);

            if (Deck[randomChoice] != null) {
                newCard = Deck[randomChoice];
                Deck[randomChoice] = null;
                break;
            }

        }
        return newCard;
    }

    public void setPlayersData() {

        Scanner input = new Scanner(System.in);
        for (int pName = 0; pName < 4; pName++) {
            players[pName]=new Player();
            System.out.println("Enter your Name : ");
            String Name = input.next();
            players[pName].name = Name;
            for (int PCards = 0; PCards < 2; PCards++) {
                Card NewOne;
                NewOne = ShuffleDeck();
                players[pName].AddCard(NewOne);

            }
        }
    this.setHighScore();
    }

    public void setHighScore() {
        HighScore = players[0].score;
        for (int player = 0; player < 3; player++) {
            if (HighScore < players[player].score) {
                HighScore = players[player].score;
            }


        }
    }

    public int getHighScore() {
        return HighScore;
    }

//    ******************************************
    public void setHighScore(int HighScore){
        this.HighScore=HighScore;
    }
// *********************************************

}

