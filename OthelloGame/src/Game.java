import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Game {
	static int boardWidth, boardHeight, boardSize;
	static CellState[] board;
	static ArrayList<Integer> blackCells, whiteCells, emptyCells;
	static Set<Integer> possibleMoves;
	static CellState enemy, me;

	public Game(){
		possibleMoves = new HashSet<Integer>();
		board = new CellState[64];
	}
	
	public boolean checkLeft(int i){
		i--;
		if (i%8 == 0){
			return false;
		}
		else if (board[i] == enemy){
			return checkLeft(i);
		}
		else if (board[i] == me){
			return false;
		}
		else{
			// only executes when the given cell is empty
			possibleMoves.add(i);
			return true;
		}
	}
	
	public boolean checkRight(int i){
		i++;
		if (i%8 == 7){
			return false;
		}
		else if (board[i] == enemy){
			return checkRight(i);
		}
		else if (board[i] == me){
			return false;
		}
		else{
			// only executes when empty
			possibleMoves.add(i);
			return true;
		}
	}
	
	public boolean checkUp(int i){
		i -= 8;
		if (i < 8){
			return false;
		}
		else if (board[i] == enemy){
			return checkUp(i);
		}
		else if (board[i] == me){
			return false;
		}
		else{
			possibleMoves.add(i);
			return true;
		}
	}
	
	public boolean checkDown(int i){
		i += 8;
		if (i > 55){
			return false;
		}
		else if (board[i] == enemy){
			return checkDown(i);
		}
		else if (board[i] == me){
			return false;
		}
		else{
			possibleMoves.add(i);
			return true;
		}
	}
	
	public boolean checkDiagUpLeft(int i){
		i -= 9;
		if (i < 8 || i%8 == 0){
			return false;
		}
		else if (board[i] == enemy){
			return checkDiagUpLeft(i);
		}
		else if (board[i] == me){
			return false;
		}
		else{
			possibleMoves.add(i);
			return true;
		}
	}
	
	public boolean checkDiagUpRight(int i){
		i -= 7;
		if (i < 8 || i%8 == 7){
			return false;
		}
		else if (board[i] == enemy){
			return checkDiagUpRight(i);
		}
		else if(board[i] == me){
			return false;
		}
		else{
			possibleMoves.add(i);
			return true;
		}
	}
	
	public boolean checkDiagDownLeft(int i){
		i += 7;
		if (i > 55 || i%8 == 0){
			return false;
		}
		else if (board[i] == enemy){
			return checkDiagDownLeft(i);
		}
		else if (board[i] == me){
			return false;
		}
		else{
			possibleMoves.add(i);
			return true;
		}
	}
	
	public boolean checkDiagDownRight(int i){
		i += 9;
		if (i > 55 || i%8 == 7){
			return false;
		}
		else if (board[i] == enemy){
			return checkDiagDownLeft(i);
		}
		else if(board[i] == me){
			return false;
		}
		else{
			possibleMoves.add(i);
			return true;
		}
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
//		Random randomgenerator = new Random();
//		int random = randomgenerator.nextInt(possibleMoves.size());
//		
//		Object x[] = possibleMoves.toArray();
//		
//		return (int)x[random];
		
		return possibleMoves.size();
	}

	public static int runMe(JSONObject myObj){
		
		Game g = new Game();

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
		
		blackCells = new ArrayList<>();
		whiteCells = new ArrayList<>();
		
		int index = 0;
		while (iterator.hasNext()) {
			if (squares.get(index).equals("b")){
				board[index] = CellState.BLACK;
				blackCells.add(index);
			}
			else if (squares.get(index).equals("w")){
				board[index] = CellState.WHITE;
				whiteCells.add(index);
			}
			else if (squares.get(index).equals("-")){
				board[index] = CellState.EMPTY;
			}
			
			if(index < 64){
				index++;
			}
			System.out.println(iterator.next());
		}

		enemy = CellState.WHITE;
		me = CellState.BLACK; 
		Game g2 = new Game();
		
		for (int i : blackCells){
			g2.checkCell(i);
		}
		JSONParser parser = new JSONParser();

		
		
		return g2.pickMove();

	}


	public static void main (String[] args){
		JSONParser parser = new JSONParser();
		try{
			Object obj = parser.parse(new FileReader(
					"C:/Users/onekam/Documents/Othello/the_game/atomic/OthelloGame/bin/file1.txt"));
			System.out.println(runMe((JSONObject)obj));
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
}
