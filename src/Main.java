import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static List<Integer> integers
            = new ArrayList<>(List.of(
                    1,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,16,17,18,19,20));

    public static Long getCountForEvenInteger(List<Integer> integers){
        return integers.stream().filter(integer->integer % 2 == 0).count();
    }

    public static <A> void findMinMax(
            Stream<? extends A> stream,
            Comparator<? super A> order,
            BiConsumer<? super A, ? super A> minMaxConsumer) {

        List<A> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));

        } else {
            minMaxConsumer.accept(null, null);
        }
    }


    public static void main(String[] args) {

        System.out.println("\n Quantity for even integers in list: " + getCountForEvenInteger(integers) +"\n");

        Stream<Integer> stream = integers.stream();

        findMinMax(stream, Integer::compareTo, (x, y) -> System.out.printf("min: %s, max: %s%n", x, y));

        stream.close();


    }



}