function alert1(x){
    alert('Burbank')
}
function dismiss(y){
    alert('dismiss the cookie policy ')
}

function convertTemperatures() {
    var unit = document.getElementById('celcius').value; // Note: Ensure the element exists
    var temps = document.querySelectorAll('.par'); // Changed 'temp' to 'temps' to match usage

    for (var i = 0; i < temps.length; i++) {
        var par = temps[i]; // Get the current element
        var temperature = parseFloat(par.innerText); // Assuming the temperature is in the text

        if (unit === '°F') {
            par.innerText = ((temperature * 9/5) + 32).toFixed(2) + ' °F'; // Convert to Fahrenheit
        } else if (unit === '°C') {
            par.innerText = ((temperature - 32) * 5/9).toFixed(2) + ' °C'; // Convert to Celsius
        }
    }
}
