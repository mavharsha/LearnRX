import rx.Observable;
import rx.functions.Func1;

public class SimpleMap {

	public static void main(String[] args) {

		Observable.just("Hello, World")
			.map(new Func1<String, String>() {
				@Override
				public String call(String emittedString){
					return emittedString + " -MavHarsha";
				}})
			.subscribe(s-> System.out.println(s));
		
		 Observable<String> myObservable = Observable.just("Hello, World");

		/*
		 *	With Lambdas
		 */		
		 myObservable
		.map(s-> s + " -MavHarsha")
		.subscribe(s-> System.out.println(s));
		
		/*
		 *   Map returning HashCode
		 */
		Observable.just("Hello, World")
		.map(s-> s.hashCode())
		.subscribe(i-> System.out.println(Integer.toString(i)));
		
		/*
		 *   Map chaining
		 */
		Observable.just("Hello, World")
		.map(s-> s.hashCode())
		.map(i-> Integer.toString(i))
		.subscribe(i-> System.out.println(i));
		
		/*
		 *   Map chaining
		 */
		Observable.just("Hello, World")
		.map(s-> s + " -Mavharsha")
		.map(s-> s.hashCode())
		.map(i-> Integer.toString(i))
		.subscribe(i-> System.out.println(i));
	
	}
}
