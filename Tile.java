

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

	public boolean isTaken(){
		return used;
	}
	public boolean isWhite(){
		return isWhite;
	}

	public void changeColor(){
		isWhite = !isWhite;
	}
	public boolean equals (Tile other) {
		return (other.isTaken()&&this.isTaken())&&(other.isWhite()&&this.isWhite);
	}
	public void take(){
		used = true;
	}
	public void changeIsWhite(boolean isWhite){
		this.isWhite = isWhite;
	}
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
