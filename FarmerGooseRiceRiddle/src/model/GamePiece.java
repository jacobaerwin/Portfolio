package model;

public class GamePiece {

	private BridgeEnum position;
	
	public BridgeEnum getPosition() {
		return this.position;
	}
	
	@Override
	public String toString() {
		return "GamePiece [position=" + position + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GamePiece other = (GamePiece) obj;
		if (position != other.position)
			return false;
		return true;
	}

	public void setPosition(BridgeEnum position) {
		this.position = position;
	}
	
	public GamePiece(BridgeEnum position) {
		this.position = position;
	}
}
