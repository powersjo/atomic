import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Game {
	static int boardWidth, boardHeight, boardSize;
	static CellState[] board;
	
	public static void main (String[] args){
		JSONParser parser = new JSONParser();
		
		try {
			
			System.out.println(args[0]);
           Object obj = parser.parse(args[0]);
 
            JSONObject jsonObject = new JSONObject();
 
            String width = (String) jsonObject.get("width");
            boardWidth = Integer.parseInt(width);
            
            String height = (String) jsonObject.get("height");
            boardHeight = Integer.parseInt(height);
            
            String size = (String) jsonObject.get("max-index");
            boardSize = Integer.parseInt(size);
            board = new CellState[boardSize];
            
            JSONArray cells = (JSONArray) jsonObject.get("squares");
            for (int i = 0; i < boardSize; i++){
            	if (cells.get(i).equals("-")) 
            		board[i] = CellState.EMPTY;
            	else if (cells.get(i).equals("b"))
            		board[i] = CellState.BLACK; 
            	else if (cells.get(i).equals("w"))
            		board[i] = CellState.WHITE;
            	else
            		System.out.println("Not Found");
            }
 
        } catch (Exception e) {
            System.out.println("error");
        }
		
	}
}
