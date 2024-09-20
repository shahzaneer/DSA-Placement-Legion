public class Ithbit {
    public static void main(String[] args) {
        int num = 5; // Binary: 0101
        int i = 1;   // Bit position to manipulate (0-based)

        System.out.println("Original number: " + num); // 5

        // Set the i-th bit
        int set = setBit(num, i);
        System.out.println("After setting bit " + i + ": " + set); // 7 (0111)

        // Unset the i-th bit
        int unset = unSetBit(set, i);
        System.out.println("After unsetting bit " + i + ": " + unset); // 5 (0101)

        // Toggle the i-th bit
        int toggle = ToggleBit(unset, i);
        System.out.println("After toggling bit " + i + ": " + toggle); // 7 (0111)
    }

    //! Setbit the ith if its 1 stays 1   otherwise make it 1
    static int setBit(int num, int i){
        return (num | (1<<i));
    }
    //! UnsetBit the ith if its 0 stays 0 otherwise make it 0
    static int unSetBit(int num, int i){
        return (num & ~(1<<i));
    }

    //! ToggleBit the ith if its 1 make it 0 and vice versa
    static int ToggleBit(int num, int i){
        return (num ^ (1<<i));
    }

}

