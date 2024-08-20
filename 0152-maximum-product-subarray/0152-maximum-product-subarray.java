class Solution {
    public int maxProduct(int[] array) {
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