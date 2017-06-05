

public class Tile{
	private boolean used;
	private boolean isWhite;
/**
 * default tile value, for setting up a board
 */
	public Tile(){
		used = false;
		isWhite = true;

	}
	/**
	 * 
	 * @param used if a tile is taken or blank
	 * @param isWhite if a tile is white
	 */
	public Tile(boolean used, boolean isWhite){
		this.used = used;
		this.isWhite = isWhite;
	}
	/**
	 * return used the used boolean
	 * 
	 */
	public boolean isTaken(){
		return used;
	}
	/**
	 * return the color boolean
	 */
	public boolean isWhite(){
		return isWhite;
	}
	/**
	 * change the color
	 */
	public void changeColor(){
		isWhite = !isWhite;
	}
	/**
	 * Check if two tiles have the same values
	 * @param other a tile to compare to
	 */
	public boolean equals (Tile other) {
		return (other.isTaken()&&this.isTaken())&&(other.isWhite()&&this.isWhite);
	}
	/**
	 * Take a tile
	 */
	public void take(){
		used = true;
	}
	/*
	 * chagne the boolean value IsWhite
	 */
	public void changeIsWhite(boolean isWhite){
		this.isWhite = isWhite;
	}
	/*
	 * @deprecated no longer needed
	 * toString for text based version of the game
	 */
	@Deprecated
	public String toString(){
		if(!used){
			return " E ";
		}
		else if(isWhite){
			return " W ";
		}
		else{
			return " B ";
		}
	}


}
