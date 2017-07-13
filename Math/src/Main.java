import hu.akarnokd.rxjava2.math.MathObservable;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main( String[] args ) {
        average();
        sum();
        reduce();
        count();
    }

    /**
     * Emit the average of numbers emitted by an Observable and terminate.
     *
     **/
    private static void average() {
        System.out.println("average");

        List<Integer> integerList = Arrays.asList(1, 3);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("average =====================>");

        MathObservable.averageFloat(integerObservable)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Emit the sum of numbers emitted by an Observable and terminate.
     *
     **/
    private static void sum() {
        System.out.println("sum");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("sum =====================>");

        MathObservable.sumInt(integerObservable)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Apply a function to each item emitted by an Observable, sequentially, emit the
     * final value and terminate.
     **/
    private static void reduce() {
        System.out.println("reduce");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("reduce((x, y) => x * Y) =====================>");

        integerObservable.reduce((x, y) -> x * y)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Emit the count of items emitted by an Observable and terminate.
     *
     **/
    private static void count() {
        System.out.println("count");

        List<Integer> integerList = Arrays.asList(4, 8);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("count =====================>");

        integerObservable.count()
                .subscribe(System.out::println);
        System.out.println();
    }
}