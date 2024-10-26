import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.stream.Stream;



public class Reading {
    public static void main(String[] args) {
        String filePath = args[0];
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            // String firstName = br.readLine();
            // System.out.println(firstName);
            // String secondName = br.readLine();
            // System.out.println(secondName);
            // int age = Integer.parseInt(br.readLine());
            // System.out.println(age);
            // String collegeName = br.readLine();
            // String [] college = collegeName.split(" ");
            // System.out.println(college[0] + " " + college[1] + " " + college[1]);

            Stream<String> s =  br.lines();
            // System.out.println(s.count()); // 6   (one Stream can be called one then it is automatically closed)
            Iterator<String> it = s.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }

            

            // String line;
            // while((line = br.readLine())!=null){
            //     System.out.println("the line is "+ line);
            // }
 
        } catch (FileNotFoundException e) {
            System.out.println("file not found" + e.toString());
        }
        catch(Exception e){
            System.out.println("something went wrong" + e.toString());
        }
    }    
}
