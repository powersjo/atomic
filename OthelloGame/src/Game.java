import java.util.ArrayList;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Game {
	static int boardWidth, boardHeight, boardSize;
	static CellState[][] board;
	static ArrayList<Integer> blackCells, whiteCells, emptyCells;
	
	public static void main (String[] args){
		JSONParser parser = new JSONParser();
		
		try {
			
			System.out.println(args[0]);
            Object obj = parser.parse(args[0]);
			
            blackCells = new ArrayList<Integer>();
            whiteCells = new ArrayList<Integer>();
            emptyCells = new ArrayList<Integer>();
 
            JSONObject jsonObject = new JSONObject();
 
            String width = (String) jsonObject.get("width");
            boardWidth = Integer.parseInt(width);
            
            String height = (String) jsonObject.get("height");
            boardHeight = Integer.parseInt(height);
            board = new CellState[boardHeight][boardWidth];
            
            String size = (String) jsonObject.get("max-index");
            boardSize = Integer.parseInt(size);
            
            JSONArray cells = (JSONArray) jsonObject.get("squares");

            for (int i = 0; i < boardHeight; i++){
            	for (int j = 0; j < boardWidth; j++){
            		for (int k = 0; k < boardSize; k++)
            			if (cells.get(k).equals("-"))
            				board[i][j] = CellState.EMPTY;
            				
            			else if (cells.get(k).equals("b"))
            				board[i][j] = CellState.BLACK;
            			else if (cells.get(k).equals("w"))
            				board[i][j] = CellState.WHITE;
            			else
            				System.out.println("somethings wrong...");
            	}
            }
 
        } catch (Exception e) {
            System.out.println("error");
        }
		
	}
}
