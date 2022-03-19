package blackjack;

public class Card {
    private final int suit;
    private final int rank;
    private final int value;

    Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    Card(Card n) {
        this.suit = n.suit;
        this.rank = n.rank;
        this.value = n.value;
    }

    int getSuit() {
        return this.suit;
    }
    int getRank() {
        return this.rank;
    }
    int getValue() {
        return this.value;
    }
}