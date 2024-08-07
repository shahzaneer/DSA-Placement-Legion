public class SexMatrixZero {
    public static void main(String[] args) {
        int [][] array = {
            {1,2,3},
            {4,5,6},
            {7,8,9}};

            setZeroesBrute(array);
            setZeroesBetter(array);
    }

    // Brute TC: O(n*m + n*m + n+m ~ n^3) SC: O(1)
    static void setZeroesBrute(int [][] array){
        for(int i=0; i<array.length; i++){
            for(int j = 0; j<array[i].length;j++){
                if(array[i][j]== 0){
                  MarkRow(array,i);
                  MarkColumn(array,j);  
                }
            }
        }

        for(int i = 0; i<array.length;i++){
            for(int j= 0; j<array[i].length;j++){
                if(array[i][j] == -1) array[i][j] = 0;
            }
        }
    }
    static void MarkRow(int [][] array,int i){
        for(int k=0; k<array.length; k++){
            if(array[k][i]!=0)
                array[k][i] = -1; 
        }
    }
    static void MarkColumn(int [][] array,int i){
        for(int k=0; k<array.length; k++){
            if(array[i][k]!=0)
                array[i][k] = -1; 
        }
    }
    // Better TC (n^2) SC:O(n+m)
    static void setZeroesBetter(int [][] array){
        int [] rows = new int [array.length];
        int [] columns = new int [array[0].length];

        for(int i = 0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                if(array[i][j] == 0){
                    rows[i] = 1;
                    columns[j] = 1;
                }
             
            }
        }

        for(int i=0; i<array.length;i++){
            for(int j=0; j<array[i].length;j++){
                if(rows[i] == 1 || columns[j] == 1){
                    array[i][j] = 0;
                }
            }
        }
    }
}
