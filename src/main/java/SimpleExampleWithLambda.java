import rx.Observable;

public class SimpleExampleWithLambda {

	public static void main(String[] args) {
		
		Observable.just("Hello from Mavharsha", "Hello again")
		.subscribe(s-> System.out.println(s));
	}
}