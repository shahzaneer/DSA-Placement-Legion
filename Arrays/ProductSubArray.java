public class ProductSubArray {
    public static void main(String[] args) {
        int [] array = {1, 2, -3, 0, -4, -5};
        System.out.println(ProductSubArrayBrute(array));
        System.out.println(ProductSubArrayBetter(array));
        System.out.println(ProductSubArrayOptimal(array));
    }
    //! brute: TC: O(n^3) SC: O(1)
    static int ProductSubArrayBrute(int [] array){
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            for(int j = i; j<array.length; j++){
                int product = 1;
                for(int k = i; k<=j; k++){
                    product*=array[k];
                }
                maxProduct = Math.max(product, maxProduct);
            }
        }
        return maxProduct;
    }
    // ! Better: TC: O(n^2) SC: O(1)
    static int ProductSubArrayBetter(int [] array){
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            int product = 1;
            for(int j = i; j<array.length; j++){
                product*=array[j];
                maxProduct = Math.max(product, maxProduct);
            }

        }
        return maxProduct;
 
    }
    // ! Optimal: TC: O(n) SC: O(1)
    // We have to cover these four cases
    // - when all elements are positive 
    // - when even negatives , other positves
    // - when odd negaties , other positives
    // - when they contain zero too.
    static int ProductSubArrayOptimal(int [] array){
        double maxProduct = Integer.MIN_VALUE;
        double suffixProduct = 1, prefixProduct = 1;
        for(int i = 0; i<array.length; i++){
            if(prefixProduct == 0) prefixProduct = 1;
            if (suffixProduct == 0) suffixProduct = 1;
            prefixProduct*=array[i];
            suffixProduct*=array[array.length-i-1];
            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));

        }
        return (int) maxProduct;
    }
    
}
