import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main( String[] args ) {
        onErrorReturn(12);
        onErrorResumeNext();
    }

    /**
     * Instruct an Observable to emit a particular item when it encounters an error, and
     * then terminate normally.
     **/
    private static void onErrorReturn(Integer item) {
            System.out.println("onErrorReturn");

            List<Integer> integerList = Arrays.asList(1, 2, 3);
            System.out.println(integerList);
            Observable<Integer> integerObservable = Observable.fromIterable(integerList);

            System.out.println("onErrorReturn(" + item + ") =====================>");

            integerObservable.doAfterNext(integer -> {
                        if (integer == 3) {
                            throw new RuntimeException();
                        }
                    }).onErrorReturn(throwable -> item)
                    .subscribe(System.out::println);
            System.out.println();
        }

    /**
     * Instruct an Observable to begin emitting a second Observable if it encounters an
     * error.
     **/
    private static void onErrorResumeNext() {
        System.out.println("onErrorResumeNext");

        List<String> stringList = Arrays.asList("1", "2", "4", "5");
        List<String> stringList1 = Arrays.asList("A", "B", "C");
        System.out.println(stringList);
        System.out.println(stringList1);
        Observable<String> stringObservable = Observable.fromIterable(stringList);
        Observable<String> stringObservable1 = Observable.fromIterable(stringList1);

        System.out.println("onErrorResumeNext =====================>");

        stringObservable.doAfterNext(s -> {
            if (s.equals("2")) {
                throw new RuntimeException();
            }
        }).onErrorResumeNext(stringObservable1)
                .subscribe(System.out::println);
        System.out.println();
    }
}