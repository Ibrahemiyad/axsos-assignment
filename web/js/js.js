function palindrome(s){
    s=s.toString();
    s=s.split('');
    x=s.length-1;
    for(var i=0; i<s.length;i++){
        if(s[i]!=s[x]){
            return false;
        }
        x--;
    }
    return true;
}

palindrome(123455)