function alwaysHungry(arr) {
    // your code here
    var x = 0;

    for (var i = 0; i < arr.length; i++) {
        if (arr[i] == "food") {
            console.log("yummu")
            x++
        }
    }
    if (x == 0) {
        console.log("I'm hungry")
    }

}

alwaysHungry([3.14, "food", "pie", true, "food"]);
// this should console log "yummy", "yummy"
alwaysHungry([4, 1, 5, 7, 2]);
// this should console log "I'm hungry"




function highPass(arr, cutoff) {
    var filteredArr = [];
    for(var i=0;i<arr.length;i++){
        if(arr[i]>cutoff){
            filteredArr.push(arr[i]);
        
    }
}
    console.log(filteredArr)
    return filteredArr;

}
highPass([6, 8, 3, 10, -2, 5, 9], 5);



function betterThanAverage(arr) {
    var sum = 0;
    // calculate the average
    for(var i=0; i<arr.length;i++){
    sum+=arr[i];
    }
    var avg= sum/arr.length
    var count = 0;
    // count how many values are greated than the average
        for(var i=0; i<arr.length;i++){
    if(arr[i]>avg){
        count++;
    } 
        }
    return count;

}


function reverse(arr) {
    arr.reverse()
    console.log(arr)
}
reverse(["a", "b", "c", "d", "e"])








function fibonacciArray(n) {

    var fibArr = [0, 1];
    var count = 2;
    while (count != n) {
        fibArr[count] = fibArr[count-1] + fibArr[count-2];
        count++;
    }
    return fibArr;
}  
var result = fibonacciArray(10);
console.log(result);

