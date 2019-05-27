package arrays;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevealCardsInIncreasingOrder {
//For both solutions Complexity Analysis
//
//Time Complexity: O(NlogN), where N is the length of deck.
//
//Space Complexity: O(N).


    //Official Solution using queue for determining index

        public int[] deckRevealedIncreasingOfficial(int[] deck) {
            int N = deck.length;
            Deque<Integer> index = new LinkedList();
            for (int i = 0; i < N; ++i)
                index.add(i);

            int[] ans = new int[N];
            Arrays.sort(deck);
            for (int card: deck) {
                ans[index.pollFirst()] = card;
                if (!index.isEmpty())
                    index.add(index.pollFirst());
            }

            return ans;
        }

        
    //My Solution
    public int[] deckRevealedIncreasing(int[] deck) {
        int count = 0;
        int[] outputDeck = new int[deck.length];
        Arrays.sort(deck);
        Arrays.fill(outputDeck,-1);
        int i=0,j=0;
        boolean foundEmpty = true;
        while(i<deck.length){
            if(outputDeck[j] == -1 ){
                if(foundEmpty)
                {
                    outputDeck[j] = deck[i];
                    foundEmpty = false;
                    i++;
                }
                else{
                    foundEmpty = true;
                }
            }
            j++;
            if(j== outputDeck.length){
                j=0;

            }
        }
        return outputDeck;
    }


}
