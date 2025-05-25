package Abstract;

public class Painting extends Art{
	
	private String paintType;
	
	public Painting(String title,String author, String description, String string) {
		
		super(title,author,description);
		this.paintType = paintType;
		
		
	}
	
	@Override
	public void viewArt() {
        System.out.println("Painting: " + title);
        System.out.println("Author: " + author);
        System.out.println("Description: " + description);
        System.out.println("Paint Type: " + paintType);
        System.out.println("----------------------------------");

	}
	
	

}
