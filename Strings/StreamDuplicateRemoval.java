import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class StreamDuplicateRemoval{
    public static void main(String[] args) {
        Stream<String> strs = List.of("Shah", "Shah", "noor", "aleeza", "eman", "noor").stream();
//         // str.forEach(System.out::println);
//         strs.forEach(str -> System.out.println(str));

//         List<String> list = List.of("apple", "banana", "cherry", "grape");

// list.parallelStream()
//     .map(String::toUpperCase)
//     .forEach(System.out::println);


// Stream<Integer> infiniteStream = Stream.iterate(7, n -> n + 1);
// infiniteStream.limit(10).forEach(System.out::println);

        uniqueStrings(strs).forEach(System.out::println);


        
    }

    public static Stream<String> uniqueStrings(Stream<String> stream) {
        HashSet<String> seen = new HashSet<>();
        return stream.filter(x -> seen.add(x));
    }

    
}