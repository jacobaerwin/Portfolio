package service;

import model.BridgeEnum;
import model.GamePiece;

public class GamePieceService {

	GamePiece farmer = new GamePiece(BridgeEnum.START), 
			goose = new GamePiece(BridgeEnum.START),
			rice = new GamePiece(BridgeEnum.START),
			fox = new GamePiece(BridgeEnum.START);
	
	public boolean checkRiceAndGoose() {
		if(goose.getPosition().equals(rice.getPosition())) {
			if(farmer.getPosition().equals(goose.getPosition())) {
				return true;
			}else {
				System.out.println("The Goose ate the Rice!");
				return false;
			}
		}
		return true;
	}
	
	public boolean checkFoxAndGoose() {
		if(goose.getPosition().equals(fox.getPosition())) {
			if(farmer.getPosition().equals(goose.getPosition())) {
				return true;
			}else {
				System.out.println("The Fox ate the Goose!");
				return false;
			}
		}
		return true;
	}
	
	public boolean checkWin() {
		if(
			goose.getPosition().equals(BridgeEnum.FINISH)
			&& rice.getPosition().equals(BridgeEnum.FINISH)
			&& fox.getPosition().equals(BridgeEnum.FINISH)
				) {
			System.out.println("You win!");
			return true;
		}
		return false;
	}
	
	public String getMoves() {
		String moves = "";
		if(farmer.getPosition().equals(goose.getPosition())) {
			moves += "Goose \n";
		}
		if(farmer.getPosition().equals(rice.getPosition())) {
			moves += "Rice \n";
		}
		if(farmer.getPosition().equals(fox.getPosition())) {
			moves += "Fox \n";
		}
		return moves + "Nothing";
	}
	
	public String getPositions() {
		String start = "START: ";
		String finish = "FINISH: ";
		if(farmer.getPosition().equals(BridgeEnum.START)) {
			start += "[YOU] ";
		}else {
			finish += "[YOU] ";
		}
		if(goose.getPosition().equals(BridgeEnum.START)) {
			start += "[Goose] ";
		}else {
			finish += "[Goose] ";
		}
		if(rice.getPosition().equals(BridgeEnum.START)) {
			start += "[Rice] ";
		}else {
			finish += "[Rice] ";
		}
		if(fox.getPosition().equals(BridgeEnum.START)) {
			start += "[Fox] ";
		}else {
			finish += "[Fox] ";
		}
		return start + "\n  ||=========||\n  ||=========||\n  ||=========||\n  ||=========||\n" + finish + "\n";
	}
	
	public void movePiece(String name) {
		if(name.equals("Goose") && farmer.getPosition().equals(goose.getPosition())) { 
			goose.setPosition((goose.getPosition().equals(BridgeEnum.START) ? BridgeEnum.FINISH : BridgeEnum.START));
			farmer.setPosition(goose.getPosition());
		}else if(name.equals("Fox") && farmer.getPosition().equals(fox.getPosition())) {
			fox.setPosition((fox.getPosition().equals(BridgeEnum.START) ? BridgeEnum.FINISH : BridgeEnum.START));
			farmer.setPosition(fox.getPosition());
		}else if(name.equals("Rice") && farmer.getPosition().equals(rice.getPosition())) {
			rice.setPosition((rice.getPosition().equals(BridgeEnum.START) ? BridgeEnum.FINISH : BridgeEnum.START));
			farmer.setPosition(rice.getPosition());
		}else if(name.equals("Nothing")) {
			farmer.setPosition((farmer.getPosition().equals(BridgeEnum.START)? BridgeEnum.FINISH : BridgeEnum.START));
			System.out.println("You moved to the other side.");
		}else {
			System.out.println("***Invalid move, try again.***");
		}
	}
}
