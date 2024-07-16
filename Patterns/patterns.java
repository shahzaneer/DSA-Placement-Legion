class patterns{
    public static void main(String[] args) {
        // pattern1(5);
        pattern20(5);

        
    }
static void pattern1(int n){
    for(int row = 0; row<n;row++){
        for(int column = 0; column<n;column++){
            System.out.print("* ");
        }
        System.out.println();
    }
}

static void pattern2(int n){
    for(int row = 0; row<n;row++){
        for(int column = 0; column<row+1; column++){
            System.out.print("*");
        }
        System.out.println();
    }
}

static void pattern3(int n){
    for(int row = 1; row <= n; row++){
        for (int column = 1; column<=row; column++){
            System.out.print(column + " ");
        }
        System.out.println();
    }
}

static void pattern4(int n){
    for(int row = 1; row <= n; row++){
        for (int column = 1; column<=row; column++){
            System.out.print(row + " ");
        }
        System.out.println();
    }
}

static void pattern5(int n){
    for (int row = n; row > 0; row--){
        for (int column = 0; column<row;column++){
            System.out.print("*");
        }
        System.out.println();
    }
}

static void pattern6(int n){
    for(int row = n; row > 0; row--){
        for (int column = 1; column <= row; column++){
            System.out.print(column);
        }
        System.out.println();
    }
}

static void pattern13(int n){
    int count = 1;
    for(int row = 0; row < n; row++){
        for(int column = 0; column<row+1; column++){
            System.out.print(count++ + " ");
        }
        System.out.println();
    }
}

static void pattern14(int n){
    for(int row = 0; row<n; row++){
        int value = 65;
        for(int column = 0; column< row+1; column++){
            char character = (char) value;
            System.out.print(character);
            value++;
        }
        System.out.println();
    }
}

static void pattern15(int n){
    for(int row = n; row>0; row--){
        int value = 65;
        for(int column = 0; column<row; column++){
            char character = (char) value;
            System.out.print(character);
            value++;        
        }
        System.out.println();
    }
}

static void pattern16(int n){
    int value = 64;
    for(int row = 0; row<n; row++){
        value++;
        for (int column = 0; column< row+1; column++){
            char character = (char) value;
            System.out.print(character);
        }
        System.out.println();
    }
}


static void pattern7(int n){
    for(int row = 0; row<n; row++){
        // LEADING SPACES
        for(int space = 0; space < n-row-1; space++){
            System.out.print(" ");
        }
        // STARS
        for(int column = 0; column < (2*row+1); column++){
            System.out.print("*");
        }
    //  TRAILING SPACES
            for(int space = 0; space < n-row-1; space++){
                System.out.print(" ");
            }
            System.out.println();
    }
}


static void pattern8(int n){
    for(int row = n; row > 0; row--){
        // LEADING SPACES
        for( int space = 0; space < n - row; space++){
            System.out.print(" ");
        }
        // STARS
        for (int stars = 0; stars< 2*row-1; stars++){
            System.out.print("*");
        }
        // TRAILING SPACES
        for( int space = 0; space < n - row; space++){
            System.out.print(" ");
        }
        System.out.println();
    }    
}

static void pattern9(int n){
    pattern7(n);
    pattern8(n);
}

static void pattern10(int n){
    for(int row = 1; row <= (2 * n - 1); row++){
        int stars = row;
        if(row > n) stars = 2 * n - row;
          for (int column = 1; column <= stars; column++){
            System.out.print("*");
          }   
        System.out.println();
}
}

static void pattern11(int n){
    int start;
    for(int row = 0; row < n; row++){
        start = 0;
        if(row % 2 == 0) start = 1;
        for(int column = 0; column<row+1; column++){
            System.out.print(start + " ");
            start = 1 - start; // fliping the bit

        }
        System.out.println();
    }
}

static void pattern12(int n){

    for (int row = 1; row <= n; row++){
        // order counting
        for(int column = 1; column <= row; column++ ){
            System.out.print(column);
        }
        // spaces
        for(int i = 1; i <= 2 * (n - row); i++){
            System.out.print(" ");
        }
        // reverse counting

        for(int column = row; column >= 1; column--){
            System.out.print(column);
        }
        System.out.println();
    }
}

static void pattern17(int n){
        for(int row = 1; row <= n; row++){
            // SPACES
            for(int space = 0; space <= (n - row); space++){
                System.out.print(" ");
            }
        //    Characters
            char ch = 'A';
            int breakPoint = (2* row - 1)/2;
            for(int i = 1; i<= (2 * row -1); i++){
             System.out.print(ch);
             if(i <= breakPoint) ch++;
             else ch--;
            }

            //  SPACES
            for(int space = 0; space <= (n - row); space++){
                System.out.print(" ");
            }

            System.out.println();
        }
}

static void pattern18(int n){
    for(int row = 0; row<n; row++){
        for(int column = 'E' - row; column <= 'E'; column++){
            System.out.print((char) column);
        }
        System.out.println();
    }
}

static void pattern21(int n){
    for(int row = 0; row < n; row++){
        for (int column = 0; column < n; column++){
            if (row == 0 || column == 0 || row == n-1 || column == n-1){
                System.out.print("*");
            } else{
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

static void pattern22(int n){
    // its tricky (watch video if not getting it)
    for(int row = 0;  row < 2 * n -1; row++){
        for(int column = 0; column < 2 * n - 1; column++){
            int top = row;
            int bottom = column;
            int right = (2 * n - 2) - column;
            int left = (2 * n - 2) - row;

            System.out.print(n - Math.min(Math.min( top, bottom), Math.min(right, left)));


        }
        System.out.println();
    }
}

static void pattern19(int n){
    int initialSpace = 0;
    for(int row = n; row > 0; row--){
        // STARS
        for (int column = 0; column < row; column++){
            System.out.print("*");
        }
        // SPACE
        for(int i=0; i<initialSpace; i++){
            System.out.print(" ");
        }
        // STARS
        for (int column = 0; column < row; column++){
            System.out.print("*");
        }
        initialSpace+=2;

        System.out.println();       
}

initialSpace = 2 * n;
for(int row = 0; row < n; row++){
    // STARS
    for (int column = 0; column < row; column++){
        System.out.print("*");
    }
    // SPACE
    for(int i= initialSpace; i > 0; i--){
        System.out.print(" ");
    }
    // STARS
    for (int column = 0; column < row; column++){
        System.out.print("*");
    }
    initialSpace+=-2;
    System.out.println();
}
}

static void pattern20(int n){
    int initialSpace = 2*n -2;

    for(int row = 0; row<n; row++){
        for(int column = 0; column < row+1; column++){
            System.out.print("*");
        }
        for(int space = 0; space < initialSpace; space++ ){
            System.out.print(" ");
        }
        for(int column = 0; column < row+1; column++){
            System.out.print("*");
        }
        initialSpace+=-2;
        System.out.println();
        
        
    }
    initialSpace = 2;

    for(int row = n-1; row >0; row--){
        for(int column = 0; column < row; column++){
          System.out.print("*");  
        }

        for(int space = 0; space < initialSpace; space++){
            System.out.print(" ");
        }

        for(int column = 0; column < row; column++){
            System.out.print("*");  
          }
          initialSpace+=2;
          System.out.println();
    }

}

}








// ! IMPORTANT PATTERNS TO GAIN CONTROL OVER LOOPS
//TODO: https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/