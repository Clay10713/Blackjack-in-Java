
import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		
		//init
		Scanner sc = new Scanner(System.in);
		Deck theDeck = new Deck (1, true);
		
		//init the player objects
		Player me = new Player("Orobio");
		Player dealer = new Player("Dealer");
		
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		
		// Print initial hands
		System.out.println("Cards are dealt\n");
		me.printHand(true);
		dealer.printHand(false);
		System.out.println("\n");
		
		// Flags for when each player is finished hitting
		boolean meDone = false;
		boolean dealerDone = false;
		String ans;
		
		while (!meDone || !dealerDone){
			
			// Player's turn
			if (!meDone){
				
				System.out.print("Hit or Stay? (Enter H or S): ");
				ans = sc.next();
				System.out.println();
				
				// If the player hits
				if (ans.compareToIgnoreCase("H") == 0){
					
					// Add next card in the deck and store whether player is busted
					
					meDone = !me.addCard(theDeck.dealNextCard());
					me.printHand(true);
					
				} else {
					meDone = true;
				}
			}
			
			// Dealer's turn
			if (!dealerDone){
				if (dealer.getHandSum() < 17){
					System.out.println("The dealer hits\n");
					dealerDone = !dealer.addCard(theDeck.dealNextCard());
					dealer.printHand(false);	
				} else {
					System.out.println("The Dealer stays\n");
					dealerDone = true;
				}
			}
			
			System.out.println();
		}
		
		// Close scanner
		sc.close();
		
		// Print final hands
		me.printHand(true);
		dealer.printHand(true);
		
		int mySum = me.getHandSum();
		int dealerSum = dealer.getHandSum();
		
		if (mySum > dealerSum && mySum <= 21 || dealerSum > 21){
			System.out.println("Your Win!");
		} else {
			System.out.println("Dealer Wins!");
		}
	}

}
