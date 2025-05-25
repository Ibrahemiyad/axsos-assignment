
public class phone extends Devices{
	
	public void makeCall() {
		battery -= 5;
		System.out.println("making call");
		checkBattery();
	}
	
	public void playGame() {
		if (battery < 20) {
			System.out.println("battery too low");
			display();
			return;
	}
		battery -=20;
		System.out.println("play the game");
		checkBattery();
		
	}
	
	public void charge() {
		battery += 50;
		if (battery > 100) {
			battery = 100;
			
		}
		System.out.println("phone is charge");
		display();

	}
	
    private void checkBattery() {
        if (battery < 10) {
            System.out.println("Battery critical!");
        }
        display();
    }

}
