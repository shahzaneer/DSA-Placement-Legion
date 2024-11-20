
import java.util.LinkedList;
import java.util.List;

public class AestroidCollisions {
    public static void main(String[] args) {
        
    }

    // ! TC: O(n) SC: O(n)
    static int [] asteroidCollision(int [] asteroids) {
         // monotonic stack
         List<Integer> st = new LinkedList<>();

         for(int i=0; i<asteroids.length; i++){
 
             if(asteroids[i] > 0) st.addLast(asteroids[i]);
 
             else{
                 while(!st.isEmpty() && st.getLast() > 0 && st.getLast() < Math.abs(asteroids[i])){
                     st.removeLast();
                 }
 
                 if(!st.isEmpty() && Math.abs(asteroids[i]) == st.getLast()){
                     st.removeLast();
             } 
             else if(!st.isEmpty() && st.getLast() < 0){
                 st.addLast(asteroids[i]);
             }
             else if(st.isEmpty()){
                 st.addLast(asteroids[i]);
             }
             }
         
     }
 
     int [] answer = new int [st.size()];
 
    for(int i=0; i<st.size(); i++){
     answer[i] = st.get(i);
    }
    
    return answer;
     
    }
}

