package data_structure.bitset;

import java.util.BitSet;

/**
 * TODO
 *
 * @author 刘嘉杰
 * @version 1.0.0
 * @date 2019-11-13 22:30
 */
public class BitSetDemo {
    public static void main(String[] args) {
        BitSet bitSet1 = new BitSet(16);
        BitSet bitSet2 = new BitSet(16);

        //Set some bits
        for (int i = 0; i < 16; i++) {
            if ((i % 2) == 0) {
                bitSet1.set(i);
            }

            if ((i % 5) == 0) {
                bitSet2.set(i);
            }
        }

        System.out.println("Initial pattern in bitSet1:");
        System.out.println(bitSet1);
        System.out.println("\nInitial pattern in bitSet2:");
        System.out.println(bitSet2);


        //And bits
        andBits(bitSet1, bitSet2);

        //Or bits
        orBits(bitSet1, bitSet2);

        //XOr bits
        XOrBits(bitSet1, bitSet2);
    }

    private static void XOrBits(BitSet set1, BitSet set2) {
        BitSet bitSet1 = set1.get(0, set1.length());
        BitSet bitSet2 = set2.get(0, set2.length());
        bitSet2.xor(bitSet1);
        System.out.println("\nbits2 XOR bits1: ");
        System.out.println(set2);
    }

    private static void orBits(BitSet set1, BitSet set2) {

        BitSet bitSet1 = set1.get(0, set1.length());
        BitSet bitSet2 = set2.get(0, set2.length());

        bitSet2.or(bitSet1);
        System.out.println("\nbits2 OR bits1: ");
        System.out.println(bitSet2);
    }

    private static void andBits(BitSet set1, BitSet set2) {
        BitSet bitSet1 = set1.get(0, set1.length());
        BitSet bitSet2 = set2.get(0, set2.length());
        bitSet2.and(bitSet1);
        System.out.println("\nbits2 AND bits1: ");
        System.out.println(bitSet2);
    }


}
