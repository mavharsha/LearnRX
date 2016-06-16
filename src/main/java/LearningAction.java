import rx.Observable;

import rx.functions.Action0;
import rx.functions.Action1;

/*
 * Basic Reactive stuff
 * @author github.com/mavharsha
 */


public class LearningAction {

	public static void main(String[] args) {

		String[] list = { "Hello World!", "from", "MavHarsha" };

		/*
		 * An Observable that emits from a data structure
		 */
		Observable<String> myObservable = Observable.from(list);

		/*
		 * onNext
		 */
		Action1<String> onNextAction = new Action1<String>() {
			@Override
			public void call(String emittedString) {

				System.out.println(emittedString);
			}
		};

		/*
		 * This method is invoked when the observable is done emitting
		 */
		Action0 onCompleteAction = new Action0() {
			@Override
			public void call() {
				System.out.println("Done emitting");
			}
		};

		/*
		 * This method is invoked on the Observer when an error occurs during
		 * the emission stream from a Observable
		 */
		Action1<Throwable> onErrorAction = new Action1<Throwable>() {
			@Override
			public void call(Throwable throwable) {
				System.out.println(throwable);
			}
		};

		/*
		 * Subscription
		 */
		myObservable.subscribe(onNextAction, onErrorAction, onCompleteAction);
	}
}
