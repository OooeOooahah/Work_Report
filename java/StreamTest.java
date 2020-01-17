import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

        List<String> list =new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        list.stream().filter(arg->arg.contains("2")||arg.contains("4")).forEach(System.out::println);

        List<String> res=list.stream().filter(arg-> arg.equals("2")).collect(Collectors.toList());
        res.stream().forEach(System.out::println);
    }
}
