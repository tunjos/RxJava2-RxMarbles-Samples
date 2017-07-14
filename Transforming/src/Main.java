import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main( String[] args ) {
        map();
        flatMap();
        buffer(2);
        groupBy();
        scan();
    }

    /**
     * Transform the items emitted by an Observable by applying a function to each item.
     *
     **/
    private static void map() {
        System.out.println("map");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("map(x => 10 * x) =====================>");

        integerObservable.map(x -> 10 * x)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Transform the items emitted by an Observable into Observables, then flatten the
     * emissions from those into a single Observable.
     **/
    private static void flatMap() {
        System.out.println("flatMap");

        List<Integer> oneList = Arrays.asList(11, 12);
        List<Integer> twoList = Arrays.asList(21, 22);
        List<Integer> fourList = Arrays.asList(41, 42);
        List<List<Integer>> integerListList = Arrays.asList(oneList, twoList, fourList);
        integerListList.forEach(System.out::println);
        Observable<List<Integer>> integerListObservable = Observable.fromIterable(integerListList);

        System.out.println("flatMap =====================>");

        integerListObservable.flatMap(Observable::fromIterable).subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Periodically gather items from an Observable into bundles and emit these bundles
     * rather than emitting the items one at a time.
     **/
    private static void buffer(int count) {
        System.out.println("buffer");

        List<String> stringList = Arrays.asList("P", "C", "A");
        System.out.println(stringList);
        Observable<String> stringObservable = Observable.fromIterable(stringList);

        System.out.println("buffer(" + count + ") =====================>");

        stringObservable.buffer(count)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Divide an Observable into a set of Observables that each emit a different group
     * of items from the original Observable, organized by key.
     **/
    private static void groupBy() {
        System.out.println("groupBy");

        List<Integer> integerList = Arrays.asList(2, 4, 2, 6, 4, 6);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("groupBy(x => x/2) =====================>");

        integerObservable.groupBy(integer -> integer/2)
                .subscribe(integerIntegerGroupedObservable -> integerIntegerGroupedObservable.toList()
                        .subscribe(System.out::println));
        System.out.println();
    }

    /**
     * Apply a function to each item emitted by an Observable, sequentially, and emit
     * each successive value.
     **/
    private static void scan() {
        System.out.println("scan");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("scan((x, y) => x + y) =====================>");

        integerObservable.scan((x, y) -> x + y)
                .subscribe(System.out::println);
        System.out.println();
    }
}