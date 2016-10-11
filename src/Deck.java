
import java.util.Random;
/**
 * An implemenation of a deck of cards.
 * @author Clayton Orobio
 * @since 08/03/2016
 */
public class Deck {

	
	/**
	 * The array of cards in the deck, where the top card is in the first index.
	 */
	private Card[] myCards;
	
	/**
	 * The number of cards currently in the deck.
	 */
	private int numCards;
	
	/**
	 * Constructor with a default of one deck (a.k.a. 52 cards) and no shuffling.
	 */
	
	public Deck () {
		
		//call the other constructor, defining one deck without shuffling 
		this(1, false);
		
		
	}
	/**
	 * Constructor that defines the number of decks (a.k.a. how many sets of 52
	 * cards are in the deck) and whether is should be shuffled.
	 * 
	 * @param numDeck	The number of individual decks in this deck
	 * @param shuffle	Whether to shuffle the cards
	 */
	
	public Deck (int numDecks, boolean shuffle){
		
		this.numCards = numDecks * 52;
		this.myCards = new Card [this.numCards]; 
		
		// Int card index
		int c = 0;
		
		// For each deck
		for (int d = 0; d < numDecks; d++){
			
			// For each suit
			for (int s = 0; s <4; s++){
				
				// For each number
				for (int n = 1; n <=13; n++){
					
					// Add a new card to the deck
					this.myCards[c] = new Card(Suit.values()[s], n);
					c++;
				}
			}
			
		}
		// Shuffle, if necessary
		if(shuffle){
			this.shuffle();
		}
	}
	
		/**
		 * Shuffle deck by randomly swapping pairs of cards.
		 */
	
	
public void shuffle(){
		
		// Init random number generator
		Random rng = new Random();
		
		// Temporary card
		Card temp;
		
		int j;
		for (int i = 0; i < this.numCards; i++){
			
			// Get a random J to swamp i's value with
			j = rng.nextInt(this.numCards);
			
			// Do swap
			temp = this.myCards[i];
			this.myCards[i] = this.myCards[j];
			this.myCards[j] = temp;
			
		}
	}
/**
 * Deal the next card from the top of the deck.
 * @return The deal card.
 */

public Card dealNextCard(){
	
	// Get the top card on deck
	Card top = this.myCards[0];
	
	// Shift all subsequent cards to the left by one index
	for (int c = 1; c < this.numCards; c++){
		this.myCards [c-1] = this.myCards[c];
	}
	this.myCards[this.numCards-1] = null;
	
	// Decrement the number of cards in our deck
	this.numCards--;
	
	return top;
}

/**
 * Print the top cards in the deck.
 * 
 * @param numToPrint		The number of cards from the top of the deck to print
 * 
 */
public void printDeck(int numToPrint){
	
	for (int c = 0; c < numToPrint; c++){
		System.out.printf("% 3d/%d %s\n", c+1, this.numCards, 
				this.myCards[c].toString());
	}
	System.out.printf("\t[%d others]\n", this.numCards-numToPrint);
  }
}


