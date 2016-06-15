import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;
public class SimpleFlatMap {

	public static void main(String[] args) {
		
		List<String> listOfStrings = new ArrayList<>();
		listOfStrings.add("url1");
		listOfStrings.add("url2");
		listOfStrings.add("url3");
		
		List<String> listOfOtherStrings = new ArrayList<>();
		listOfOtherStrings.add("url11");
		listOfOtherStrings.add("url22");
		listOfOtherStrings.add("url33");
		
		List<List<String>> listOfList = new ArrayList<>();
		listOfList.add(listOfStrings);
		listOfList.add(listOfOtherStrings);
		
		/*
		 * 	Observable emits a list of URL's 
		 */
		Observable<List<String>> myObservable = Observable.from(listOfList);
		
		/*
		 * 	Without FlatMap		
		 */	
		
		System.out.println("*** With out flatmap, using for loop ***");
		myObservable
			.subscribe(list->{
			for(String string: list){
				System.out.println(string);
			}
		});
		
		/*
		 * 	Without FlatMap, but subscriber implementing another Observable		
		 */	
		
		System.out.println("*** With out flatmap, implementing a Observable inside subscriber ***");

		myObservable
			.subscribe(list->{
				Observable.from(list)
				.subscribe(url-> System.out.println(url));
			});
		
		/*
		 * 	Using FlatMap		
		 */	
		
		System.out.println("*** With FlatMap ***");

		myObservable
			.flatMap(new Func1<List<String>, Observable<String>>() {
			@Override
			public Observable<String> call(List<String> list) {
				return Observable.from(list);
			}
		}).subscribe(url -> System.out.println(url));
		
		
		/*
		 * 	Using FlatMap with Lambdas
		 */		
		
		System.out.println("*** With FlatMap and Lambdas ***");

		myObservable
			.flatMap(list -> Observable.from(list))
			.subscribe(url -> System.out.println(url));
		
	}
}
