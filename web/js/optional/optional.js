function number(par1){
    x=[];
    for(var i=par1;i<=par1;i--){
       x.push(i);
        if (i==0){
            break;
        }
    }
    
    console.log(x);
}
number(5);

function number([par1,par2]){
    console.log(par1);
    return (par2);
}
number([4,5])



var x=[1,2,3,4,5,6,7];
var z=x[0];
var y=x.length
var sum=z+y;
console.log(sum);



var x=[1,3,5,7,9,13];
var sum=0
for(i=0;i<=x.length-1; i++){
    if (x[i]>x[1]){
        sum++;
    }
}
   console.log(sum);




