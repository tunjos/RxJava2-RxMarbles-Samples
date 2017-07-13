import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main( String[] args ) {
        startWith(0);
        amb();
        combineLatest();
        concat();
        merge();
        sequenceEqual();
        zip();
    }

    /**
     * Emit a specified sequence of items before beginning to emit the items the items
     * from the source Observable.
     **/
    private static void startWith(Integer item) {
        System.out.println("startWith");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("startWith(" + item + ") =====================>");

        integerObservable.startWith(item)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Given two or more source Observables, emit all of the items from only the first
     * of these Observables to emit an item or notification.
     **/
    private static void amb() {
        System.out.println("amb");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<String> stringList = Arrays.asList("A", "B", "C");
        System.out.println(integerList);
        System.out.println(stringList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);
        Observable<String> stringObservable = Observable.fromIterable(stringList);

        System.out.println("amb =====================>");

        Observable.ambArray(integerObservable, stringObservable)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * When an item is emitted by either of two Observables, combine the latest item
     * emitted by each Observable via a specified function and emit items based on the
     * results of this function. Implemented differently across platforms and
     * synchronisation modes.
     **/
    private static void combineLatest() {
        System.out.println("combineLatest");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<String> stringList = Arrays.asList("A", "B", "C");
        System.out.println(integerList);
        System.out.println(stringList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);
        Observable<String> stringObservable = Observable.fromIterable(stringList);

        System.out.println("combineLatest =====================>");

        Observable.combineLatest(integerObservable, stringObservable, (integer, s) -> integer + s)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Emit the emissions from two or more observables sequentially, one set after
     * another.
     **/
    private static void concat() {
        System.out.println("concat");

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        List<String> stringList = Arrays.asList("A", "B", "C");
        System.out.println(integerList);
        System.out.println(stringList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);
        Observable<String> stringObservable = Observable.fromIterable(stringList);

        System.out.println("concat =====================>");

        Observable.concat(integerObservable, stringObservable)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Combine multiple Observables into one by merging their emissions.
     *
     **/
    private static void merge() {
        System.out.println("merge");

        List<String> stringList = Arrays.asList("M", "R", "G", "D");
        List<String> stringList2 = Arrays.asList("E", "E");
        System.out.println(stringList);
        System.out.println(stringList2);
        Observable<String> stringObservable = Observable.fromIterable(stringList);
        Observable<String> stringObservable2 = Observable.fromIterable(stringList2);

        System.out.println("merge =====================>");

        Observable.merge(stringObservable, stringObservable2)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Emit true if two Observables emit the same sequence of items, or false otherwise.
     *
     **/
    private static void sequenceEqual() {
        System.out.println("sequenceEqual");

        List<Integer> integerList = Arrays.asList(1, 2);
        List<Integer> integerList1 = Arrays.asList(1, 2);
        System.out.println(integerList);
        System.out.println(integerList1);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);
        Observable<Integer> integerObservable1 = Observable.fromIterable(integerList1);

        System.out.println("sequenceEqual =====================>");

        Observable.sequenceEqual(integerObservable, integerObservable1)
                .subscribe(System.out::println);
        System.out.println();
    }


    /**
     * Combine the emissions of multiple Observables together via a specified function
     * and emit single items for each combination based on the results of this function.
     **/
    private static void zip() {
        System.out.println("zip");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<String> stringList = Arrays.asList("A", "B", "C");
        System.out.println(integerList);
        System.out.println(stringList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);
        Observable<String> stringObservable = Observable.fromIterable(stringList);

        System.out.println("zip =====================>");

        Observable.zip(integerObservable, stringObservable, (integer, s) -> integer + s)
                .subscribe(System.out::println);
        System.out.println();
    }
}