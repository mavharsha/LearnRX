import rx.Observable;
import rx.Subscriber;

/*
 * Basic Reactive stuff
 * An observable emits, and the subscriber captures the stream of emissions it subscribed to.
 * @author github.com/mavharsha
 */

public class TestingRX {
   
	public static void main(String args[]){
	/*
	 * Observer that emits a stream of strings 
	 */
		Observable<String> myObservable = Observable.create(
			    new Observable.OnSubscribe<String>() {
			        @Override
			        public void call(Subscriber<? super String> sub) {
			            sub.onNext("Hello, world!");
			            sub.onNext("Hello, world again! ");
			            sub.onCompleted();
			        }
			    }
			);
	/*
	 * A subscriber 
	 */
		Subscriber<String> mySubscriber = new Subscriber<String>() {
		    @Override
		    public void onNext(String s) { 
		    	System.out.println(s); 
		    }
		    @Override
		    public void onCompleted() {
		    	System.out.println("Done.");
		    }

		    @Override
		    public void onError(Throwable e) { }
		};

	/*
	 * A Subscription
	 */
		myObservable.subscribe(mySubscriber);
	}
}
