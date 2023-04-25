package com.example.groupproject

class Blackjack {

    private var deck : Deck
    private var playerHand : ArrayList<Card>
    private var dealerHand : ArrayList<Card>

    constructor() {
        this.deck = Deck()
        this.deck.shuffleDeck()
        this.playerHand = ArrayList<Card>()
        this.dealerHand = ArrayList<Card>()
        dealDealerOneCard()
        dealDealerOneCard()
        dealPlayerOneCard()
        dealPlayerOneCard()
    }

    fun dealDealerOneCard() {
        this.dealerHand.add(this.deck.dealOneCard())
    }

    fun dealPlayerOneCard() {
        this.playerHand.add(this.deck.dealOneCard())
    }

    fun getDealerHand() : ArrayList<Card> {
        return this.dealerHand
    }

    fun getPlayerHand() : ArrayList<Card> {
        return this.playerHand
    }

    fun getDealerHandScore() : ArrayList<Int> {
        var acePresent : Boolean = false
        var handValue : Int = 0
        val toReturn : ArrayList<Int> = ArrayList<Int>()
        for (card in this.dealerHand) {
            if (card.getValue() == 1) {
                acePresent = true
            }
        }
        for (card in this.dealerHand) {
            handValue += card.getValue()
        }
        toReturn.add(handValue)
        if (acePresent == false) {
            return toReturn
        }
        if (handValue + 10 <= 21) {
            toReturn.add(handValue + 10)
        }
        return toReturn
    }

    fun getPlayerHandScore() : ArrayList<Int> {
        var acePresent : Boolean = false
        var handValue : Int = 0
        val toReturn : ArrayList<Int> = ArrayList<Int>()
        for (card in this.playerHand) {
            if (card.getValue() == 1) {
                acePresent = true
            }
        }
        for (card in this.playerHand) {
            handValue += card.getValue()
        }
        toReturn.add(handValue)
        if (acePresent == false) {
            return toReturn
        }
        if (handValue + 10 <= 21) {
            toReturn.add(handValue + 10)
        }
        return toReturn
    }

}
