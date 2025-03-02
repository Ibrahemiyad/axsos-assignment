function bigsize(arr){
    for (var i=0;i<=arr.length;i++){
        if(arr[i]>0){
        arr[i]="big";
        }
        
    }
    console.log(arr);

}
bigsize([1,3,-1])

