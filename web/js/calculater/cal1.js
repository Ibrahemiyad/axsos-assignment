let btn = document.querySelectorAll(".btn");
for (let i = 0; i < btn.length; i++) {
    btn[i].onclick = function () {
        let display = btn[i].innerText;
        let dis = document.getElementById('display');
        console.log("dis = " + dis.innerText)
        console.log("dsplay= " + display)
        
        if (dis.innerText == "0") {
            dis.innerText = display;
        } else {
            dis.innerText += display; 
        }

        }

    }


let clear = document.getElementById("clear")
clear.onclick = function () {
    display.innerText = "0";
};

let num1, operation, num2, operator;
operator = document.querySelectorAll(".operator")
for (let i = 0; i < operator.length; i++) {
    operator[i].onclick = function () {
        num1 = document.getElementById("display").innerText;
        operation = operator[i].value
        document.getElementById('display').innerHTML = ''

    }
}
let equal = document.getElementById('equals')
equal.onclick = function () {
    console.log(operation)
    num2 = document.getElementById("display").innerText;
    let result = 0;
    switch (operation) {
        case "+":
            result = +num1 + +num2;
            break;
        case "-":
            result = num1 - num2;
            break;
        case "*":
            result = num1 * num2;
            break;
        case "/":
            result = num1 / num2;
            break;
        default:
            result = "Error";
    }

    display.innerText = result;
    num1 = result;
    operation = null;


}