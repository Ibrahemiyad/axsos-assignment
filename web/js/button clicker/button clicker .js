function omclick(x){
    x.innerText="logout"
}
function hide(m){
    m.remove()
}
function show(){
    alert("Ninja was liked")
}


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Input on Change</title>
</head>
<body>
    <!-- Input field -->
    <input type="text" id="searchInput" placeholder="Type something...">

    <!-- Search button -->
    <button id="searchButton">🔍</button>

    <!-- JavaScript -->
    <script>
        const inputField = document.getElementById('searchInput');
        const searchButton = document.getElementById('searchButton');
        let inputValue = ''; // Initialize variable to hold input value

        // Update inputValue dynamically whenever the input changes
        inputField.addEventListener('input', function() {
            inputValue = inputField.value; // Update the value
        });

        // Show an alert with the current input value when the button is clicked
        searchButton.addEventListener('click', function() {
            if (inputValue.trim() === '') {
                alert('Please enter some text!');
            } else {
                alert('You searched for: ' + inputValue);
            }
        });
    </script>
</body>
</html>