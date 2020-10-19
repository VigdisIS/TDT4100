package stateandbehavior;

public class Location {
	private int x;
	private int y;

	public Location() {
		this.x = 0;
		this.y = 0;
	}
	
	public void up() {
		this.y -= 1;
	}
	
	public void down() {
		this.y += 1;
	}

	public void left() {
		this.x -= 1;
	}

	public void right() {
		this.x += 1;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String toString() {
		return "Character's current position: (" + String.valueOf(x) + ", " + String.valueOf(y) + ")";
	}
	

	public static void main(String[] args) {
		Location loc = new Location();
		
		loc.right();
		loc.up();
		loc.up();
		loc.right();
		loc.down();
		loc.left();
		
		System.out.println(loc);

	}

}
