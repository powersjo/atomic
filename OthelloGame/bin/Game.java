import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.io.StringReader;
import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONObject;

public class Game {
	static int boardWidth, boardHeight, boardSize;
	static CellState[] board;

	@SuppressWarnings("unchecked")
	public static void main (String[] args){
		JSONParser parser = new JSONParser();
		
		/////////////////

		//////////////////

		try {

		///////////////

		Object obj = parser.parse(new FileReader(
                    "C:/Users/Jonathan/Downloads/atomic/atomic/OthelloGame/bin/file1.txt"));
 
            //JSONObject jsonObject = (JSONObject) obj;
 
            

		////////////////

			//Object myObj = parser.parse(new FileReader(
                    //"C:/Users/Jonathan/Downloads/atomic/atomic/OthelloGame/bin/test.JSON"));
			//StringReader myArg = new StringReader(args[0]);
			//System.out.println(args[0]);
           //Object obj = parser.parse(String.valueOf(myArg));
		   //StringReader myArg = new StringReader(args[0]);
			runMe((JSONObject)obj);
            /*JSONObject jsonObject = new JSONObject();
 
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
            }*/
 
        } catch (Exception e) {
            e.printStackTrace();
        }

		
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
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
	}
}
