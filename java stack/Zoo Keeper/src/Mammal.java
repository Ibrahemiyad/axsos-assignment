
public class Mammal {

	protected int energy;
	
	public Mammal() {
		this.energy = 100;
	}
	public int display() {
		System.out.println("energy: " + energy);
		return energy;
	}
	
}
