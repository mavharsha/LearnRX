// Works in the browser
const myElement = document.querySelector("#element");

function consoleLogClick(x){
    console.log('hello' + x);
}

myElement.addEventListener('click', consoleLogClick);