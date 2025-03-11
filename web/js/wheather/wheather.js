function alert1() {
    alert('Burbank');
}

function dismiss() {
    document.querySelector('.article3').style.display = 'none'; // Hide the cookie message
}

function convertTemperatures() {
    var x = document.getElementById('celcius').value;
    var temps = document.querySelectorAll('.par'); 

    for (var i = 0; i < temps.length; i++) {
        var par = temps[i]; 
        var temperature = parseFloat(par.innerText); 

        if (x === 'F') {
            par.innerText = Math.round((temperature * 9 / 5) + 32) + ' °'; 
        } else if (unit === 'C') {
            par.innerText = Math.round((temperature - 32) * 5 / 9) + ' °'; 
        }
    }
}

document.getElementById('celcius').addEventListener('change', convertTemperatures);

function convertTemperatures() {
    var unit = document.getElementById('celcius').value;
    var temps = document.querySelectorAll('.par2'); 

    for (var i = 0; i < temps.length; i++) {
        var par = temps[i]; 
        var temperature = parseFloat(par.innerText); 

        if (unit === 'F') {
            par.innerText = Math.round((temperature * 9 / 5) + 32) + ' °'; 
        } else if (unit === 'C') {
            par.innerText = Math.round((temperature - 32) * 5 / 9) + ' °'; 
        }
    }
}

document.getElementById('celcius').addEventListener('change', convertTemperatures);
