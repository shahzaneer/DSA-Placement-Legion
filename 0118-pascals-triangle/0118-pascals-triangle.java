class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            List<Integer> temp = findRowInPascalTriangleOptimized(i);
            pascalTriangle.add(temp);
        } 
        return pascalTriangle;
    }


     static List<Integer> findRowInPascalTriangleOptimized(int rowNos){
        List<Integer> row = new ArrayList<>();
        Integer ans = 1;
        row.add(ans);
        for (int i = 1; i < rowNos; i++) {
            ans = ans * (rowNos - i);
            ans = ans / i;
            row.add(ans);
        }
        return row;
    }
}