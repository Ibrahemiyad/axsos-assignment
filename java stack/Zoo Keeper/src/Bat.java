
public class Bat extends Mammal {
	
	public Bat() {
		this.energy = 300;
	}
	public void fly() {
		energy -= 50;
		System.out.println("stating that the bat is now airborne");
		
	}
	public void eatHumans() {
		energy += 25;
		System.out.println("the bat's satisfaction level");

	}
	
	public void attackTown() {
		energy -= 100;
		System.out.println("bat's attack");

	}

	
	

}
