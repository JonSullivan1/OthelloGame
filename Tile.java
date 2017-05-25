public class Tile{
	private boolean used;
	private boolean isWhite;
	
	Tile(){
		used = false;
		isWhite = true;
	}
	
	Tile(boolean used, boolean isWhite){
		this.used = used;
		this.isWhite = isWhite;
	}
	
	
	public boolean isTaken(){
		return used;
	}
	public boolean white(){
		return isWhite;
	}
	
	public void changeColor(){
		isWhite = !isWhite;
	}
	
	
}