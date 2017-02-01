//In case of streams in node. Example of readable streams
const readable =  getReadableStream();

function onNextDataCallBack(chunk){
    console.log(`Recieved data is ${chunk}`)
}

function onErrorCallBack(error){
    console.error(`error thrown ${error}`)
}

function onDone(){
    console.log('Completed');
}

readable.on('data', onNextDataCallBack);
readable.on('error', onErrorCallback);
readable.on('complete', onDone); 