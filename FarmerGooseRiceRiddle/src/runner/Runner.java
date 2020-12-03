package runner;

import java.util.Scanner;

import service.GamePieceService;

public class Runner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		GamePieceService GPS;
		boolean running = true;
		while(running) {
			System.out.println("===============================\nFox, Goose and Rice Game\n===============================\n1. New Game\n2. Quit\n3. Rules");
			scan.reset();
			String choice = scan.nextLine();
			if(choice.equals("1")) {
				GPS = new GamePieceService();
				while(GPS.checkFoxAndGoose() && GPS.checkRiceAndGoose() && !GPS.checkWin()) {
					System.out.println("===============================");
					System.out.println(GPS.getPositions());
					System.out.println("What would you like to move?");
					System.out.println(GPS.getMoves());
					System.out.println("===============================");
					scan.reset();
					String move = scan.nextLine();
					GPS.movePiece(move);
				}
			}else if(choice.equals("2")) {
				running = false;
			}else if(choice.equals("3")){
				System.out.println("Get the [Fox], [Goose], and [Rice] to the finish.\nYou can only move one thing at a time.\nYou cannot leave the [Goose] alone with the [Rice].\nYou also cannot leave the [Fox] alone with the [Goose].");
			}else {
				System.out.println("Invalid choice. Please enter 1 or 2.");
			}
		}
			
	}	
}



