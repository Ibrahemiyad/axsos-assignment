public class variable {
    public static void main(String[] args){
        int a = 400;
        boolean b = true;
        double pi = 3.14;
        String st = "hello world";
        boolean isRaining = false;
    
// if(isRaining) {
//     System.out.println("Bring an umbrella.");
// }

// int temperature = 85;
// boolean isCloudy = true;

// if(temperature < 40 && isCloudy){
//     System.out.println("It might snow.");
// }else if(isCloudy){
//     System.out.println("It might rain.");
// }else{
//     System.out.println("We should have nice weather today.");

//     }
int day = 10;
switch(day){
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    case 4:
        System.out.println("Thursday");
        break;
    case 5:
        System.out.println("Friday");
        break;
    case 6:
        System.out.println("Saturday");
        break;
    case 7:
        System.out.println("Sunday");
        break;
    default:
        System.out.println("There are only seven days in a week...");
}
int goals = 4;
boolean watchReplay = false;
System.out.println("Are we watching this?");
switch(goals){
    case 0:
    System.out.println("Sounds like a boring game.");
    break;
    case 1:
    System.out.println("Was it a good goal?");
    watchReplay = true;
break;
    case 2:
    System.out.println("Was it a tie?");
    watchReplay = true;
break;
    case 3:
    System.out.println("I can't wait to see it!");
    watchReplay = true;
break;
    default:
    System.out.println("More than 3 goals? I'm in!");
    watchReplay = true;
}
System.out.println(watchReplay ? "I'll see you in a bit." : "I'll pass.");
}

}

