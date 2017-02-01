// Converting the generic callback pattern to something similar
// observable pattern (RX-ish)
function map(transformFn){
    const inputObservable = this;
    const outputObservable = createObservable(function subscribe(outputObservable){
        inputObservable.subscribe({
            next: function(x){
                const y = transformFn(x);
                outputObservable.next(y);
            },
            error: function(error){
                outputObservable.error(error);
            },
            complete: function(){
                outputObservable.complete(); 
             }
        });
    });
    return outputObservable;
}

function filter(conditionFn){
    const inputObservable = this;
    const outputObservable = createObservable(function subscribe(outputObservable){
        inputObservable.subscribe({
            next: function(x){
                if(conditionFn(x)){
                    outputObservable.next(x);
                }
            },
            error: function(error){
                outputObservable.error(error);
            },
            complete: function(){
                outputObservable.complete(); 
             }
        });
    });
    return outputObservable;
}

function delay(time){
    const inputObservable = this;
    const outputObservable = createObservable(function subscribe(outputObservable){
        inputObservable.subscribe({
            next: function(x){
                setTimeout(function(){
                    outputObservable.next(x)
                }, time);
            },
            error: function(error){
                outputObservable.error(error);
            },
            complete: function(){
                outputObservable.complete(); 
             }
        });
    });
    return outputObservable;
}

function createObservable(subscribe){
    return{
        subscribe: subscribe,
        map: map,
        filter: filter,
        delay: delay
    }
} 

const clickobservable = createObservable( function subscribe(observer){
         document.addEventListener('click', observer.next)
});

const arrayobservable = createObservable( function subscribe(observer){
        [10,20,30].forEach(observer.next);
        observer.complete();
});

const observer = {
    next : function nextCallback(data){
        console.log(data);
    },
    error: function errorCall(error){
        console.error(`error ${error}`);
    },
    complete : function completeCallbact(){
        console.log('Completed');
    }
};

arrayobservable
.map(x => x/10)
.filter(x => x%2 !== 0)
.delay(2000)
.subscribe(observer);