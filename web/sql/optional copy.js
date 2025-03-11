function unique(num){
    for (var i =1;i<num.length;i++){
        if (num[i] == num[i-1]){
            num.slice(i,1);
            i--;
        }
    }
    console.log(num);
    return num.length;
}
unique([1,2,3,3,5,5,5])
