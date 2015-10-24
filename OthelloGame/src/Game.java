import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Game {
	public int boardWidth, boardHeight, boardSize;
	public CellState[] board;
	static ArrayList<Integer> blackCells, whiteCells, emptyCells;
	static Set<Integer> possibleMoves;
	static CellState enemy, me;

	public Game(){
		possibleMoves = new HashSet<Integer>();
		board = new CellState[64];
		enemy = CellState.WHITE;
		me = CellState.BLACK; 


		blackCells = new ArrayList<>();
		whiteCells = new ArrayList<>();
	}

	public boolean checkLeft(int i){
		i--;

		if (i%8 == 0)
			return false;
		else if (board[i] == enemy){
			//System.out.println(i);
			return checkLeft(i);
		}
		else if ((board[i] != enemy && board[i] != me) && board[i+1] == enemy){
			//System.out.println("I got here");
			possibleMoves.add(i);
			return true;
		}
		else{	
			return false;
		}		

		//		i--;
		//		if (i%8 == 0){
		//			return false;
		//		}
		//		else if (board[i] == enemy){
		//			return checkLeft(i);
		//		}
		//		else if (board[i] == me){
		//			return false;
		//		}
		//		else if (board[i+1] == me && board[i] == null){
		//			return false;
		//		}
		//		else if (board[i] == null){
		//			// only executes when the given cell is empty
		//			possibleMoves.add(i);
		//			return true;
		//		}
		//		else{
		//			return false;
		//		}
	}

	public boolean checkRight(int i){
		i++;

		if (i%8 == 7)
			return false;
		else if (board[i] == enemy){
			return checkRight(i);
		}
		else if (((board[i] != enemy && board[i] != me) && board[i-1] == enemy)){
			possibleMoves.add(i);
			return true;
		}
		else{
			return false;
		}
		//		i++;
		//		if (i%8 == 7){
		//			return false;
		//		}
		//		else if (board[i] == enemy){
		//			return checkRight(i);
		//		}
		//		else if (board[i] == me){
		//			return false;
		//		}
		//		else if (board[i-1] == me && board[i] == null){
		//			return false;
		//		}
		//		else if (board[i] == null){
		//			// only executes when empty
		//			possibleMoves.add(i);
		//			return true;
		//		}
		//		else{
		//			return false;
		//		}
	}

	public boolean checkUp(int i){
		i-=8;

		if (i < 8)
			return false;
		else if (board[i] == enemy){
			return checkUp(i);
		}
		else if ((board[i] != enemy && board[i] != me) && board[i+8] == enemy){
			possibleMoves.add(i);
			return true;
		}
		else{
			return false;
		}
		//		i -= 8;
		//		if (i < 8){
		//			return false;
		//		}
		//		else if (board[i] == enemy){
		//			return checkUp(i);
		//		}
		//		else if (board[i] == me){
		//			return false;
		//		}
		//		else if (board[i+8] == me && board[i] == null){
		//			return false;
		//		}
		//		else if (board[i] == null){
		//			possibleMoves.add(i);
		//			return true;
		//		}
		//		else{
		//			return false;
		//		}
	}

	public boolean checkDown(int i){
		i += 8;

		if (i > 55)
			return false;
		else if (board[i] == enemy){
			return checkDown(i);
		}
		else if ((board[i] != enemy && board[i] != me) && board[i-8] == enemy){
			possibleMoves.add(i);
			return true;
		}
		else{
			return false;
		}
		//		i += 8;
		//		if (i > 55){
		//			return false;
		//		}
		//		else if (board[i] == enemy){
		//			return checkDown(i);
		//		}
		//		else if (board[i] == me){
		//			return false;
		//		}
		//		else if (board[i-8] == me && board[i] == null){
		//			return false;
		//		}
		//		else if (board[i] == null){
		//			possibleMoves.add(i);
		//			return true;
		//		}
		//		else{
		//			return false;
		//		}
	}

	public boolean checkDiagUpLeft(int i){
		i -= 9;

		if (i%8 == 0 || i < 8)
			return false;
		else if (board[i] == enemy){
			return checkDiagUpLeft(i);
		}
		else if (((board[i] != enemy && board[i] != me) && board[i+9] == enemy)){
			possibleMoves.add(i);
			return true;
		}
		else{
			return false;
		}
		//		if (i < 8 || i%8 == 0){
		//			return false;
		//		}
		//		else if (board[i] == enemy){
		//			return checkDiagUpLeft(i);
		//		}
		//		else if (board[i] == me){
		//			return false;
		//		}
		//		else if (board[i+9] == me && board[i] == null){
		//			return false;
		//		}
		//		else if (board[i] == null){
		//			possibleMoves.add(i);
		//			return true;
		//		}
		//		else{
		//			return false;
		//		}
	}

	public boolean checkDiagUpRight(int i){

		i-=7;

		if (i < 8 || i%8 == 7)
			return false;
		else if (board[i] == enemy){
			return checkDiagUpRight(i);
		}
		else if (((board[i] != enemy && board[i] != me) && board[i+7] == enemy)){
			possibleMoves.add(i);
			return true;
		}
		else{
			return false;
		}
		//		i -= 7;
		//		if (i < 8 || i%8 == 7){
		//			return false;
		//		}
		//		else if (board[i] == enemy){
		//			return checkDiagUpRight(i);
		//		}
		//		else if(board[i] == me){
		//			return false;
		//		}
		//		else if (board[i+7] == me && board[i] == null){
		//			return false;
		//		}
		//		else if (board[i] == null){
		//			possibleMoves.add(i);
		//			return true;
		//		}
		//		else{
		//			return false;
		//		}
	}

	public boolean checkDiagDownLeft(int i){
		i+=7;

		if (i>55 || i%8 == 0)
			return false;
		else if (board[i] == enemy){
			return checkDiagDownLeft(i);
		}
		else if (((board[i] != enemy && board[i] != me) && board[i-7] == enemy)){
			possibleMoves.add(i);
			return true;
		}
		else{
			return false;
		}
		//		i += 7;
		//		if (i > 55 || i%8 == 0){
		//			return false;
		//		}
		//		else if (board[i] == enemy){
		//			return checkDiagDownLeft(i);
		//		}
		//		else if (board[i] == me){
		//			return false;
		//		}
		//		else if (board[i-7] == me && board[i] == null){
		//			return false;
		//		}
		//		else if (board[i] == null){
		//			possibleMoves.add(i);
		//			return true;
		//		}
		//		else{
		//			return false;
		//		}
	}

	public boolean checkDiagDownRight(int i){

		i += 9;

		if (i > 55 || i%8 == 7)
			return false;
		else if (board[i] == enemy){
			return checkDiagDownRight(i);
		}
		else if (((board[i] != enemy && board[i] != me) && board[i-9] == enemy)){
			possibleMoves.add(i);
			return true;
		}
		else{
			return false;
		}
		//		i += 9;
		//		if (i > 55 || i%8 == 7){
		//			return false;
		//		}
		//		else if (board[i] == enemy){
		//			return checkDiagDownRight(i);
		//		}
		//		else if(board[i] == me){
		//			return false;
		//		}
		//		else if (board[i-9] == me && board[i] == null){
		//			return false;
		//		}
		//		else if (board[i] == null){
		//			possibleMoves.add(i);
		//			return true;
		//		}
		//		else{
		//			return false;
		//		}
	}

	public void checkCell(int i){
		checkLeft(i);
		checkRight(i);
		checkUp(i);
		checkDown(i);
		checkDiagUpLeft(i);
		checkDiagUpRight(i);
		checkDiagDownLeft(i);
		checkDiagDownRight(i);
	}

	public int pickMove(){
		Random randomgenerator = new Random();
		int random = randomgenerator.nextInt(possibleMoves.size());

		Object x[] = possibleMoves.toArray();

		return (int)x[random];

		//return possibleMoves.size();
	}

	public CellState[] getBoard(){
		return board;
	}

	public void setValue(int x, CellState cs){
		board[x] = cs;
	}

	public static void runMe(JSONObject myObj){



		JSONObject jsonObject = myObj;
		int width = ((Long)jsonObject.get("width")).intValue();
		int height = ((Long)jsonObject.get("height")).intValue();
		int max = ((Long)jsonObject.get("max-index")).intValue();
		JSONArray squares = (JSONArray) jsonObject.get("squares");

		System.out.println("width: " + width);
		System.out.println("height: " + height);
		System.out.println("Max index: " + max);
		System.out.println("\nsquares:");
		Iterator<String> iterator = squares.iterator();

		Game g2 = new Game();


		int index = 0;
		while (iterator.hasNext() && index < 64) {
			if (squares.get(index).equals("b")){
				g2.setValue(index, CellState.BLACK);
				blackCells.add(index);
			}
			else if (squares.get(index).equals("w")){
				g2.setValue(index, CellState.WHITE);
				whiteCells.add(index);
			}

			//if(index < 64){
			index++;
			//}
			System.out.print(iterator.next());
		}

		for (int i : blackCells){
			g2.checkCell(i);
		}

		System.out.println(possibleMoves.toString());
		System.exit(g2.pickMove());

	}


	public static void main (String[] args){
		try{
			System.out.println("\n\n" + args[0]);
			System.out.println(args[1]+"\n"+args[2]+"\n");
			System.out.println(args[3]+"\n\n");

			JSONParser parser = new JSONParser();
			try{
				//			Object obj = parser.parse(new FileReader(
				//					"C:/Users/onekam/Documents/Othello/the_game/atomic/OthelloGame/bin/file1.txt"));
				//			runMe((JSONObject)obj);


				Object obj = parser.parse(args[1]);
				String color = args[3];

				if (color.equals("white")){
					me = CellState.WHITE;
					enemy = CellState.BLACK;
				}
				else if (color.equals("black")){
					me = CellState.BLACK;
					enemy = CellState.WHITE;
				}
				else{
					System.exit(0);
				}

				runMe((JSONObject)obj);
			}
			catch (Exception e){
				e.printStackTrace();
			}

		}
		catch (Exception e1){
			System.out.println("");
		}



	}

}
