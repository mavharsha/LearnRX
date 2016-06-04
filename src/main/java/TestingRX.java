import rx.Observable;
import rx.Subscriber;

public class TestingRX {
   
	public static void main(String args[]){
	
		Observable<String> myObservable = Observable.create(
			    new Observable.OnSubscribe<String>() {
			        @Override
			        public void call(Subscriber<? super String> sub) {
			            sub.onNext("Hello, world!");
			            System.out.println("One sent");
			            sub.onNext("Hello, world!");
			            sub.onCompleted();
			        }
			    }
			);
		
		Subscriber<String> mySubscriber = new Subscriber<String>() {
		    @Override
		    public void onNext(String s) { 
		    	System.out.println(s); 
		    }

		    @Override
		    public void onCompleted() { 
		    }

		    @Override
		    public void onError(Throwable e) { }
		};
		
		myObservable.subscribe(mySubscriber);
	}
}
