import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class SimpleFilter {

	
	public static void main(String[] args) {
		
		 Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		 observable.filter(new Func1<Integer, Boolean>() {
			@Override
			public Boolean call(Integer value) {
				return (value % 2 == 0);
			}
		 }).subscribe(new Subscriber<Integer>() {
			@Override
			public void onCompleted() {
				
			}

			@Override
			public void onError(Throwable e) {
				
			}

			@Override
			public void onNext(Integer item) {
				System.out.println(item);
			}
		});
	}
}
