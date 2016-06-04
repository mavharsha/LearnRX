import rx.Observable;

public class SimpleExampleWithLambda {

	public static void main(String[] args) {
		
		Observable.just("Hello from Mavharsha")
		.subscribe(s-> System.out.println(s));
	}
}