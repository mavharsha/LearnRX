function nextCallback(data){

}

function onErrorCallback(data){

}

function onCompleteCallback(){

}

giveMeSomeData(
    nextCallback,
    onErrorCallBack,
    onCompleteCallback
)


// Using Generic to imitate onclicks

function nextCallback(data){
    console.log(data)
}

function onErrorCallback(data){

}

function onCompleteCallback(){

}

function giveMeSomeData(nextCB, errorCB, completeCB){
    document.addEventListener('click', nextCB);
}

giveMeSomeData(
    nextCallback,
    onErrorCallBack,
    onCompleteCallback
)



//Using generic for fetch to do HTTP requests
function nextCallback(data){
    console.log(data);
}

function onErrorCallback(error){
    console.log(error);
}

function onCompleteCallback(){

}

function giveMeSomeData(nextCB, errorCB, completeCB){
    fetch(url).then(nextCB, errorCB);
}

giveMeSomeData(
    nextCallback,
    onErrorCallBack,
    onCompleteCallback
)


//Using generic to iterate over an array
function nextCallback(data){
    console.log(data);
}

function onErrorCallback(error){
    console.log(error);
}

function onCompleteCallback(){
    console.log('Completed')
}

function giveMeSomeData(nextCB, errorCB, completeCB){
    [10,20,30,40].forEach(nextCB);
    completeCB();

}

giveMeSomeData(
    nextCallback,
    onErrorCallBack,
    onCompleteCallback
)