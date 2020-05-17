package pl.sda.lambda;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Paweł Matyaszczyk
 */
public class Main {
    public static void main(String[] args) {

        UnaryOperator<Integer> square = x->x*x;
        System.out.println(square.apply(2));

        Object object = new Object();
        IntSupplier method = object::hashCode;
        System.out.println(method.getAsInt());

        List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
        for (Integer integer:integers){
            System.out.println(integer);
        }

        Consumer<Integer> iterate = x-> System.out.println(x);
        integers.forEach(iterate);
        System.out.println("===");
        integers.forEach(System.out::println);

        List<String> nameList = Arrays.asList("Jan","Janusz","Kamil","Ola","Paweł");
        nameList
                .stream()
                .filter(e->e.startsWith("J"))
                .forEach(System.out::println);

        List<String> filterList = nameList
                .stream()
                .filter(e->e.startsWith("J"))
                .map(e->e.toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println(filterList);

        Stream<String> streamExample = Stream.of("Jan","Marek","Jonasz","Weronika","Jarek","Paweł","Jożin");
        List<String> streamList = streamExample
                .filter(e->e.startsWith("J"))
                .map(e->e.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(streamList);
    }
}
