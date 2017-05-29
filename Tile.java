public class Tile{
	private boolean used;
	private boolean isWhite;
	
	
	public Tile(){
		used = false;
		isWhite = true;
	
	}
	
	public Tile(boolean used, boolean isWhite){
		this.used = used;
		this.isWhite = isWhite;
	}
	//
	public boolean isTaken(){
		return used;
	}
	public boolean white(){
		return isWhite;
	}
	
	public void changeColor(){
		isWhite = !isWhite;
	}
	public boolean equals (Tile other) {
		return (other.isTaken()&&this.isTaken())&&(other.white()&&this.isWhite);
	}
	
	
}
