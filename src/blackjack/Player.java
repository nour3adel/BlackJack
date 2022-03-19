package blackjack;

public class Player {

    int CardCount=0;
    String name;
    int score=0;
    Card []ArrCards =new Card[10];

    public Card[] getCards() {
        return ArrCards;
    }
    public int getIndex() {
        return CardCount;
    }


    boolean Blackjack =false;
    boolean Busted =false;

    void AddCard(Card c){

        ArrCards[CardCount]=c;

        score+=ArrCards[CardCount].getValue();
        if (score == 21){
            Blackjack=true;
        }
        else if (score > 21){
            Busted=true;
        }

        CardCount++;

    }

    public int getScore() {

        return score;
    }

    void ShowUpdateScore(){

        System.out.println(score);
    }
}
