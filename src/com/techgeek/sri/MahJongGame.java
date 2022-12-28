package com.techgeek.sri;

/*
You're creating a game with some amusing mini-games, and you've decided to make a simple variant of the game Mahjong.

In this variant, players have a number of tiles, each marked 0-9. The tiles can be grouped into pairs or triples of the same tile. For example, if a player has "33344466", the player's hand has a triple of 3s, a triple of 4s, and a pair of 6s. Similarly, "55555777" has a triple of 5s, a pair of 5s, and a triple of 7s.

A "complete hand" is defined as a collection of tiles where all the tiles can be grouped into any number of triples (zero or more) and exactly one pair, and each tile is used in exactly one triple or pair.

Write a function that takes a string representation of a collection of tiles in no particular order, and returns true or false depending on whether or not the collection represents a complete hand.

tiles1 = "88844"           # True. Base case - a pair and a triple
tiles2 = "99"              # True. Just a pair is enough.
tiles3 = "55555"           # True. The triple and a pair can be of the same tile value
tiles4 = "22333333"        # True. A pair and two triples
tiles5 = "73797439949499477339977777997394947947477993"
                            # True. 4 has two triples and a pair, other numbers have just triples
tiles6 = "111333555"       # False. There are three triples, 111 333 555 but no pair
tiles7 = "42"              # False. Two singles not forming a pair
tiles8 = "888"             # False. A triple, no pair
tiles9 = "100100000"       # False. A pair of 1 and two triples of 0, a left over 0
tiles10 = "346664366"      # False. Three pairs and a triple
tiles11 = "8999998999899"  # False. A triple of 8, three triples of 9, a leftover 9
tiles12 = "17610177"       # False. Triples of 1, and 7, left over 6 and 0
tiles13 = "600061166"      # False. A pair of 1, triple of 0, triple of 6, and 6 leftover
tiles14 = "6996999"        # False. A pair of 6, a triple of 9 and another pair of 9
tiles15 = "03799449"       # False. A pair of 4, triple of 9 and 0, 3, and 7 left over
tiles16 = "64444333355556" # False. A pair of 6, two pairs each of 3, 4, 5

complete(tiles1) => True
complete(tiles2) => True
complete(tiles3) => True
complete(tiles4) => True
complete(tiles5) => True
complete(tiles6) => False
complete(tiles7) => False
complete(tiles8) => False
complete(tiles9) => False
complete(tiles10) => False
complete(tiles11) => False
complete(tiles12) => False
complete(tiles13) => False
complete(tiles14) => False
complete(tiles15) => False
complete(tiles16) => False

Complexity Variable
N - Number of tiles in the input string
*/

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class MahJongGame {
    public static void main(String[] argv) {
        String tiles1 = "88844";
        String tiles2 = "99";
        String tiles3 = "55555";
        String tiles4 = "22333333";
        String tiles5 = "73797439949499477339977777997394947947477993";
        String tiles6 = "111333555";
        String tiles7 = "42";
        String tiles8 = "888";
        String tiles9 = "100100000";
        String tiles10 = "346664366";
        String tiles11 = "8999998999899";
        String tiles12 = "17610177";
        String tiles13 = "600061166";
        String tiles14 = "6996999";
        String tiles15 = "03799449";
        String tiles16 = "64444333355556";

        Stream.of(
                tiles1,
                tiles2,
                tiles3 ,
                tiles4,
                tiles5 ,
                tiles6 ,
                tiles7,
                tiles8,
                tiles9,
                tiles10,
                tiles11,
                tiles12,
                tiles13,
                tiles14,
                tiles15,
                tiles16
        ).forEach(s -> System.out.println(s + isMahJong(s)));
        //System.out.println(isMahJong(tiles10));



    }

    /**
     * Solution is to do % 3 for triplets and % 2 for pairs.
     * First do %3 and check if the remainder of %3 is divisible by 2 i.e %2 == 0
     * if it is divisible ,it means a pair exists so set the pairFound flag to true
     * Once the flag is set there should not be any character that is a pair. i.e divisible by 2
     *
     * subtract the charCount against the total after every successful %3 and %2, successful meaning divible by 2 and 3
     * i.e character 88888333 is occuring 5 times , it should 5 % 3 = 2 and 2 % 2 == 0 so count is successfully converted as a
     * pair and triplet. so the total becomes 8 - 5  = 3;
     * @param title
     * @return
     */
    public static boolean isMahJong(String title) {
        Map<Character, Integer> charMap = new HashMap<>();
        int total = 0;
        for (Character c: title.toCharArray()) {
            int charCount = charMap.getOrDefault(c, 0);
            charMap.put(c, charCount + 1);
            total++;
        }
        boolean hasPair = false;
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            int currCharCount = entry.getValue();
            int temp = currCharCount;
            if (total > 0) {
                currCharCount %= 3;
                if (currCharCount > 0 && currCharCount % 2 == 0 && !hasPair) {
                    currCharCount %= 2;
                    hasPair = true;
                }
                if (currCharCount != 0) {
                    return false;
                }
                total -= temp;
            }

        }
        return total == 0 && hasPair;
    }
}
