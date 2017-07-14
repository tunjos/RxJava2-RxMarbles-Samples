import com.tunjos.rxjava2.NumberUtils;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main  {
    public static void main( String[] args ) {
        debounce(1);
        distinct();
        distinctUntilChanged();
        elementAt(3);
        filter();
        first();
        last();
        skip(2);
        skipLast(1);
        take(2);
        takeLast(2);
        ignoreElements();
    }

    /**
     * Only emit an item from an Observable if a particular timespan has passed without
     * emitting intermediate items.
     **/
    private static void debounce(long timeout) {
        System.out.println("debounce");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("debounce(" + timeout + "ns) =====================>");

        integerObservable.debounce(timeout, TimeUnit.NANOSECONDS)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Suppress duplicate items emitted by an Observable.
     *
     **/
    private static void distinct() {
        System.out.println("distinct");

        List<Integer> integerList = Arrays.asList(1, 2, 2);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("distinct =====================>");

        integerObservable.distinct()
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Suppress duplicate items emitted by an Observable only until a distinct item is
     * emitted.
     **/
    private static void distinctUntilChanged() {
        System.out.println("distinctUntilChanged");

        List<Integer> integerList = Arrays.asList(1, 2, 2, 4, 2);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("distinctUntilChanged =====================>");

        integerObservable.distinctUntilChanged()
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Emit only item N emitted by an Observable.
     *
     **/
    private static void elementAt(long index) {
        System.out.println("elementAt");

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("elementAt(" + index + ") =====================>");

        integerObservable.elementAt(index)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Emit only those items from an Observable that pass a predicate test.
     *
     **/
    private static void filter() {
        System.out.println("filter");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("filter(x => isEven(x^2)) =====================>");

        integerObservable.filter(x -> NumberUtils.isEven(x^2))
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Emit only the first item, or the first item that meets a condition from an
     * Observable.
     **/
    private static void first() {
        System.out.println("first");

        List<Integer> integerList = Arrays.asList(11, 33, 66);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("first =====================>");

        integerObservable.firstElement()
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Emit only the last item emitted by an Observable.
     *
     **/
    private static void last() {
        System.out.println("last");

        List<Integer> integerList = Arrays.asList(11, 33, 66);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("last =====================>");

        integerObservable.lastElement()
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Suppress the first N items emitted by an Observable.
     *
     **/
    private static void skip(long count) {
        System.out.println("skip");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("skip(" + count + ") =====================>");

        integerObservable.skip(count)
                .subscribe(System.out::println);
        System.out.println();

    }

    /**
     * Suppress the last N items emitted by an Observable.
     *
     **/
    private static void skipLast(int count) {
        System.out.println("skipLast");

        List<String> stringList = Arrays.asList("A", "B", "C");
        System.out.println(stringList);
        Observable<String> integerObservable = Observable.fromIterable(stringList);

        System.out.println("skipLast(" + count + ") =====================>");

        integerObservable.skipLast(count)
                .subscribe(System.out::println);
        System.out.println();

    }

    /**
     * Emit only the first N items emitted by an Observable.
     *
     **/
    private static void take(long count) {
        System.out.println("take");

        List<Integer> integerList = Arrays.asList(1, 10, 15);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("take(" + count + ") =====================>");

        integerObservable.take(count)
                .subscribe(System.out::println);
        System.out.println();

    }

    /**
     * Emit only the last N items emitted by an Observable.
     *
     **/
    private static void takeLast(int count) {
        System.out.println("takeLast");

        List<String> stringList = Arrays.asList("A", "B", "C");
        System.out.println(stringList);
        Observable<String> integerObservable = Observable.fromIterable(stringList);

        System.out.println("takeLast(" + count + ") =====================>");

        integerObservable.takeLast(count)
                .subscribe(System.out::println);
        System.out.println();

    }

    /**
     * Do not emit any items from an Observable but mirror its termination notification.
     *
     **/
    private static void ignoreElements() {
        System.out.println("ignoreElements");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("ignoreElements =====================>");

        integerObservable.ignoreElements()
                .subscribe(System.out::println);
        System.out.println();
    }
}