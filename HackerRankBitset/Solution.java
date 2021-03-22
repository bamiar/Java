package HackerRankBitset;

import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int size = scanner.nextInt();
        int cal = scanner.nextInt();

        BitSet B1 = new BitSet(size);
        BitSet B2 = new BitSet(size);
        BitSet[] bitsets = new BitSet[]{B1, B2};

        while(0 < cal--) {
            final String operation = scanner.next();
            final int a = scanner.nextInt()-1;
            final int b = scanner.nextInt();

            switch (operation) {
                case "AND" :
                    bitsets[a].and(bitsets[b-1]);
                    break;
                case "OR" :
                    bitsets[a].or(bitsets[b-1]);
                    break;
                case "XOR" :
                    bitsets[a].xor(bitsets[b-1]);
                    break;
                case "FLIP" :
                    bitsets[a].flip(b);
                    break;
                case "SET" :
                    bitsets[a].set(b);
                    break;
                default:
                    System.out.println("no proper operation.");
            }
            System.out.printf("%d %d%n", bitsets[0].cardinality(), bitsets[1].cardinality());
        }

    }
}
