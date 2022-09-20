import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.sun.tools.attach.VirtualMachine.list;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5,23,6,0,12,123,6,5,1,99,3,4,1,2);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println("Sum of the elements: "+sum);

        double average = list.stream().mapToDouble(num -> num).average().getAsDouble();
        System.out.println("Average arithmetic number is: " +average);

        Set<Integer> result = findDuplicateBySetAdd(list);
        System.out.print("Duplicate numbers are: \n");

        result.forEach(System.out::println);
    }
    public static <T> Set<T> findDuplicateBySetAdd(List<T> list) {
        Set<T> items = new HashSet<>();
        return list.stream()
                .filter(n -> !items.add(n))
                .collect(Collectors.toSet());
    }

}