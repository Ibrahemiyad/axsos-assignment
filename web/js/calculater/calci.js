function calculate() {
    let num1 = parseFloat(document.getElementById("num1").value);
    let num2 = parseFloat(document.getElementById("num2").value);
    let operator = document.getElementById("operator").value;
    let result;

    if (isNaN(num1) || isNaN(num2)) {
        result = "Please enter valid numbers.";
    } else if (operator === "add") {
        result = num1 + num2;
    } else if (operator === "subtract") {
        result = num1 - num2;
    } else if (operator === "multiply") {
        result = num1 * num2;
    } else if (operator === "divide") {
        if (num2 === 0) {
            result = "Cannot divide by zero!";
        } else {
            result = num1 / num2;
        }
    } else {
        result = "Invalid operator!";
    }

    document.getElementById("result").innerText = "Result: " + result;
}
