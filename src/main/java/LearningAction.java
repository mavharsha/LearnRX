import rx.Observable;

import rx.functions.*;
public class LearningAction {

	 public static void main(String[] args) {
		 
		 String[] list = {"Hello World!", "from", "Harsha"};
		 Observable<String> myObservable = Observable.from(list);
		 Action1<String> onNextAction = new Action1<String>(){
			@Override
			public void call(String emittedString) {
				
				System.out.println(emittedString);
			}
		 	};
		 	
		 	Action0 onCompleteAction = new Action0(){
				@Override
				public void call() {
					System.out.println("Completed");
				}
			 	};
			 	
			 Action1<Throwable> onErrorAction = new Action1<Throwable>(){
					@Override
					public void call(Throwable throwable) {
						System.out.println(throwable);
					}
				 	};
		 
		 myObservable.subscribe(onNextAction, onErrorAction, onCompleteAction);
	}
}
