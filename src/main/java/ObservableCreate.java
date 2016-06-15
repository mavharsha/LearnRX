import java.util.stream.IntStream;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;


public class ObservableCreate {

	/*
	 *  Creating an Observable with Observable.create with Lambdas
	 */
	 public static Observable<Integer> printNumbersWithLambdas(int n) {
	        
		 return Observable.create(subscriber -> {
	            IntStream.rangeClosed(1, n)
	            	.forEach(number -> subscriber.onNext(number));
	            subscriber.onCompleted();
	        });
	    }

	 /*
	  *  Creating an Observable with Observable.create 
	  */
	 public static Observable<Integer> printNumbers(int n) {
	        
		 return Observable.create(new OnSubscribe<Integer>() {
				@Override
				public void call(Subscriber<? super Integer> subscriber) {
					
				try {
					if (!subscriber.isUnsubscribed()) {
						for (int counter = 1; counter < n; counter++) {
							subscriber.onNext(counter);
						}
						subscriber.onCompleted();
					}
				} catch (Exception e) {
					subscriber.onError(e);
				}
				}
		        });
	    }
	 
	public static void main(String[] args) {

		System.out.println("*** Without Lambdas ***");
		Observable<Integer> myObservable = printNumbers(10);
        myObservable.subscribe(number -> System.out.println(number));
        
		System.out.println("*** With Lambdas ***");
        myObservable = printNumbersWithLambdas(10);
        myObservable.subscribe(number -> System.out.println(number));
        
      	}
}
