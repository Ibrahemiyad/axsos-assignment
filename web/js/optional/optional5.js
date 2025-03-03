function sigma(par1) {
    var sum = 0;
    for (var i = par1; i <= par1; i--) {
        sum += i;
        if (i == 0) {
            console.log(sum)
        }
    }

}
sigma(5)

function factorial(num) {
    var x = 1
    for (var i = num; i <= num; i--) {
        x *= i;
        if (i == 1) {
            break;
        }
    }
    console.log(x)
}
factorial(2)


function drawRightStars(num) {
    console.log(' '.repeat(75 - num) + '*'.repeat(num));
}

function drawCenteredStars(num) {
    var spaces = Math.floor((75 - num) / 2);
    var stars = '*'.repeat(num);
    console.log(' '.repeat(spaces) + stars + ' '.repeat(75 - num - spaces));
}
drawLeftStars(15)
drawRightStars(15)
drawCenteredStars(15)



function drawLeftChars(num, char) {
    for (var i = 1; i <= num; i++) {
        console.log(char.repeat(i));
    }
}

function drawRightChars(num, char) {
    for (var i = 1; i <= num; i++) {
        console.log(' '.repeat(num - i) + char.repeat(i));
    }
}

function drawCenteredChars(num, char) {
    for (var i = 1; i <= num; i++) {
        var spaces = ' '.repeat((num - i) / 2);
        console.log(spaces + char.repeat(i) + spaces);
    }
}
drawLeftChars(5, '*');
drawRightChars(5, '#');
drawCenteredChars(5, '@');


