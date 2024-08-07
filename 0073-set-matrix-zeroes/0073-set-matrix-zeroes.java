class Solution {
    public void setZeroes(int[][] matrix){

		int m=matrix.length, n=matrix[0].length;
        int rowsArray[]= new int[m];
        int colsArray[]= new int[n];
        
        Arrays.fill(rowsArray,1);
        Arrays.fill(colsArray,1);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rowsArray[i]=0;
                    colsArray[j]=0;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rowsArray[i]==0 || colsArray[j]==0)
                    matrix[i][j]=0;
            }
        }
    }
    }
