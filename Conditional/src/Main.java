import io.reactivex.Observable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main( String[] args ) {
        all();
        contains(5);
        skipWhile();
        skipUntil();
        takeWhile();
        takeUntil();
    }

    /**
     * Emit true if all items emitted by an Observable meet some criteria, or false
     * otherwise.
     **/
    private static void all() {
        System.out.println("all");

        List<Integer> integerList = Arrays.asList(3, 5, 7);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("all(x => isPrime(x) =====================>");

        integerObservable.all(Main::isPrime)
                .subscribe(System.out::println);
        System.out.println();
    }

    private static boolean isPrime(int number) {
        if (number % 2 == 0) return false;

        for (int i = 3; i*i <= number; i+=2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Emit true if an Observable emits a particular item, or false otherwise.
     *
     **/
    private static void contains(Object element) {
        System.out.println("contains");

        List<Integer> integerList = Arrays.asList(1, 55, 25);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("contains(" + element + ") =====================>");

        integerObservable.contains(element)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Discard items emitted by an Observable until a specified condition becomes false.
     *
     **/
    private static void skipWhile() {
        System.out.println("skipWhile");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("skipWhile(x => x != 2) =====================>");

        integerObservable.skipWhile(x -> x != 2)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Discard items emitted by an Observable until a second Observable starts emitting
     * items.
     **/
    private static void skipUntil() {
        System.out.println("skipUntil");

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<Integer> integerList1 = Collections.singletonList(0);
        System.out.println(integerList);
        System.out.println(integerList1);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);
        Observable<Integer> integerObservable1 = Observable.fromIterable(integerList1);

        System.out.println("skipUntil =====================>");

        integerObservable.skipUntil(integerObservable1)
                .subscribe(System.out::println);
        System.out.println();
    }

    /**
     * Mirror items emitted by an Observable until a specified condition becomes false.
     *
     **/
    private static void takeWhile() {
        System.out.println("takeWhile");

        List<Integer> integerList = Arrays.asList(2, 4, 16, 9, 11);
        System.out.println(integerList);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);

        System.out.println("takeWhile(x => isEven(x) =====================>");

        integerObservable.takeWhile(Main::isEven)
                .subscribe(System.out::println);
        System.out.println();
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Apply a function to each item emitted by an Observable, sequentially, emit the
     * final value and terminate.
     **/
    private static void takeUntil() {
        System.out.println("takeUntil");

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4);
        List<Integer> integerList1 = Collections.singletonList(0);
        System.out.println(integerList);
        System.out.println(integerList1);
        Observable<Integer> integerObservable = Observable.fromIterable(integerList);
        Observable<Integer> integerObservable1 = Observable.fromIterable(integerList1);

        System.out.println("takeUntil =====================>");

        integerObservable.takeUntil(integerObservable1)
                .subscribe(System.out::println);
        System.out.println();
    }
}