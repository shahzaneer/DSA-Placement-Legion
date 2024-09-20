public class IthBitSetOrNot {
    public static void main(String[] args) {
        System.out.println(ithBitSetOrNotWithLeftShift(13, 2));
        System.out.println(ithBitSetOrNotWithRightShift(13, 2));
    }

    static boolean ithBitSetOrNotWithLeftShift(int num, int i){
        return ((num & (1 << i)) != 0); 
    }

    static boolean ithBitSetOrNotWithRightShift(int num, int i){
        return (((num >> i) & 1 ) != 0);
    }
}
