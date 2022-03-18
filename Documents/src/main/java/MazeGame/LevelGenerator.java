package MazeGame;
import Characters.Player;
import Objects.Bank;
import Objects.Grass;
import Objects.PoliceStation;
import Objects.Road;
import Objects.Helicopter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileReader;
import javax.swing.JComponent;
import java.awt.Point;



/**
 * @author Reece Landry
 * 
 * Creates a level from a JSON file using game objects
 * 
 */

public class LevelGenerator extends JComponent {

	public static GameObject[][] gameObjects;
	static ArrayList<GameObject> queue = new ArrayList<>();
	public static boolean isLoading = false;
	
	private static int WIDTH;
	private static int HEIGHT;
	
	private Point playerStart;
	
	public Player player;
	
	private HashMap <String, GameObject> codes = new HashMap<>();
	
	public LevelGenerator() {
		codes.put("-", new Grass());
		codes.put("esw", new Road("esw"));
		codes.put("es", new Road("es"));
		codes.put("ew", new Road("ew"));
		codes.put("nesw", new Road("nesw"));
		codes.put("nes", new Road("nes"));
		codes.put("new", new Road("new"));
		codes.put("ne", new Road("ne"));
		codes.put("nsw", new Road("nsw"));
		codes.put("ns", new Road("ns"));
		codes.put("nw", new Road("nw"));
		codes.put("sw", new Road("sw"));
		codes.put("o", new Road("o"));
		codes.put("h", new Helicopter("h"));
		codes.put("pl", new PoliceStation("l"));
		codes.put("pr", new PoliceStation("r"));
		codes.put("bl", new Bank("l"));
		codes.put("br", new Bank("r"));
	}
	
	
	/**
	 * Creates a map based on the JSON file at levelPath
	 * based on the decoding scheme defined in code
	 * @author Reece Landry
	 * @param levelPath
	 */
	
	public void buildGame(String levelPath) {
		JSONParser parser = new JSONParser();
		
		// Read json file
		try {
			File file = new File(levelPath);
			FileReader fileReader = new FileReader(file.getAbsoluteFile());
			JSONObject object = (JSONObject) parser.parse(fileReader);
			JSONArray layout = (JSONArray) object.get("layout");
			JSONArray first = (JSONArray) layout.get(0);
			
			// Set width and height
			this.WIDTH = first.size();
			this.HEIGHT= layout.size();
			this.setPreferredSize(new Dimension(this.WIDTH * GameObject.SIZE, this.HEIGHT * GameObject.SIZE));
			
			JSONObject spawn = (JSONObject) object.get("start");
			Point start = new Point(Integer.parseInt(spawn.get("x").toString()), Integer.parseInt(spawn.get("y").toString()));
			this.playerStart = start;
			
			this.gameObjects = new GameObject[this.HEIGHT][this.WIDTH];
			
			for (int y = 0; y < this.HEIGHT; y++) {
				JSONArray xLayout = (JSONArray) layout.get(y);
				for(int x = 0; x < this.WIDTH; x++) {
					if (codes.containsKey(xLayout.get(x))) {
						// Create gameObject based on code reference and create new instance.
						setGameObject(codes.get(xLayout.get(x)).getClass().getDeclaredConstructor(new Class[] {String.class}).newInstance((xLayout.get(x))) , new Point(x, y));
					}
				}
			}
		}	catch (Exception e) {System.out.println("Error:" + e);}
	}
	
	/**
	 * Initializes a game object given the parameters
	 * @param o
	 * @param p
	 * @author Reece Landry
	 */
	
	public void setGameObject(GameObject o, Point p) {
		gameObjects[(int)p.getY()][(int)p.getX()] = o;
		o.setPosition(p);
		this.queue(o);
	}
	
	/**
	 * Adds the object to the list of {@code GameObject}
	 * @param obj
	 * @author Reece Landry
	 */
	
	public static void queue(GameObject obj) {
		queue.add(obj);
	}
	
	/**
	 * Clears the current list of {@code GameObject}
	 * @author Reece Landry
	 */
	
	public static void clearQueue() {
		queue.clear();
	}
	
	/**
	 * Returns the coordinates of the player starting position
	 * @return Point
	 * @author Reece Landry
	 */
	public Point getPlayerStart() {
		return this.playerStart;
	}
	
}
