import java.util.HashMap;

public class RomanTOInteger {
    public static void main(String[] args) {
        
    }


    static int romanToInteger(String roman){
        int decimalNo = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V',5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('D',500);
        map.put('C', 100);
        map.put('M',1000);

        for(int i=0; i<roman.length(); i++){
            
            if(i<(roman.length() - 1) && (map.get(roman.charAt(i)) < map.get(roman.charAt(i+1)))){
                decimalNo+= map.get(roman.charAt(i+1)) - map.get(roman.charAt(i));
                i++;
            }
            else {
            decimalNo+= map.get(roman.charAt(i));

            }
        }
        return decimalNo;
 
    }
}

