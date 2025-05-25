
public class Gorilla extends Mammal {
	
	public void throwSomething() {
		energy -= 5;
		System.out.println("Gorilla throwSomething");
		display();

	}
	
	public void eatBananas() {
		energy += 10;
		System.out.println("Gorilla eatBananas");
		display();

	}
	
	public void climb() {
		energy -= 10;
		System.out.println("Gorilla climb");
		display();

	}
}
