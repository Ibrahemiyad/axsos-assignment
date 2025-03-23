document.getElementsByClassName('.sound')
function playsound() {
    let audio = new Audio('hello.mp3')
    audio.play()
}
let inputField = document.getElementById('searchInput');
let searchButton = document.getElementById('searchButton');
let inputValue = ''
inputField.addEventListener('input', function () {
    inputValue = inputField.value;
});
searchButton.addEventListener('click', function () {
    if (inputValue.trim() === '') {
        alert('Please enter some text!');
    } else {
        alert(inputValue);
    }
});

let button = document.getElementById('colorButton');

button.addEventListener('mouseover', function () {
    button.style.backgroundColor = 'white';
    button.style.color = '#e0554c';
});
button.addEventListener('mouseout', function () {
    button.style.backgroundColor = '';
    button.style.color = '';
});

