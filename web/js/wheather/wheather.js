function alert1(el) {
    alert(el.innerText);
}

function dismiss() {
    document.querySelector('.article3').style.display = 'none'; // Hide the cookie message
}
function alert2(){
    alert('Loading weather report')
}

function convertTemperatures() {
    var unit = document.getElementById('celcius').value;
    var highTemps = document.querySelectorAll('.par'); // الأحمر (الدرجة العالية)
    var lowTemps = document.querySelectorAll('.par2'); // الأزرق (الدرجة المنخفضة)

    for (var i = 0; i < highTemps.length; i++) {
        var highTemp = parseFloat(highTemps[i].innerText);
        var lowTemp = parseFloat(lowTemps[i].innerText);

        if (unit === 'F') {
            highTemps[i].innerText = Math.round((highTemp * (9 / 5)) + 32) + '°';
            lowTemps[i].innerText = Math.round((lowTemp * (9 / 5)) + 32) + '°';
        } else if (unit === 'C') {
            highTemps[i].innerText = Math.round((highTemp - 32) * 5 / 9) + '°';
            lowTemps[i].innerText = Math.round((lowTemp - 32) * 5 / 9) + '°';
        }
    }
}

document.getElementById('celcius').addEventListener('change', convertTemperatures);