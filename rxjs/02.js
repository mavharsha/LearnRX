const req = fetch(
    'http://localhost:8000/user'
).then(r => r.json());

function successCallback(data){
    console.log(`We got back data ${data}`);
}

function onErrorCallback(error){
    console.log(`Error ${error}`);
}

res.then(successCallback, onErrorCallback);