package MazeGame;
import Character.Player;
import objects.Grass;
import objects.Road;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
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
		codes.put("ne", new Road("nw"));
		codes.put("ew", new Road("ew"));
		codes.put("es", new Road("es"));
		codes.put("nw", new Road("nw"));
		codes.put("sw", new Road("sw"));
	}
	
	
	/**
	 * @author Reece Landry
	 * @param levelPath
	 * @param objectCodeMap
	 * Creates a map based on the JSON file at levelPath
	 * based on the coding scheme defied in objectCodeMap
	 */
	
	public void buildGame(String levelPath) {
		JSONParser parser = new JSONParser();
		
		//read json file
		try {
			File file = new File(levelPath);
			FileReader fileReader = new FileReader(file.getAbsoluteFile());
			JSONObject object = (JSONObject) parser.parse(fileReader);
			JSONArray layout = (JSONArray) object.get("layout");
			JSONArray first = (JSONArray) layout.get(0);
			
			//set width and height
			this.WIDTH = first.size();
			this.HEIGHT= layout.size();
			this.setPreferredSize(new Dimension(this.WIDTH * GameObject.SIZE, this.HEIGHT * GameObject.SIZE));
			
			this.gameObjects = new GameObject[this.HEIGHT][this.WIDTH];
			
			for (int y = 0; y < this.HEIGHT; y++) {
				JSONArray xLayout = (JSONArray) layout.get(y);
				for(int x = 0; x < this.WIDTH; x++) {
					if (codes.containsKey(xLayout.get(x))) {
						//create gameObject based on code reference and create new instance.
						System.out.println("Code: " + xLayout.get(x));
						System.out.println(codes.get(xLayout.get(x)).getClass().getDeclaredConstructor(new Class[] {String.class}));
						setGameObject(codes.get(xLayout.get(x)).getClass().getDeclaredConstructor(new Class[] {String.class}).newInstance((xLayout.get(x))) , new Point(x, y));
					}
				}
			}
			
		}	catch (Exception e) {System.out.println("Error:" + e);}
	}
	
	public void setGameObject(GameObject o, Point p) {
		System.out.println("Queue");
		gameObjects[(int)p.getY()][(int)p.getX()] = o;
		o.setPosition(p);
		this.queue(o);
		
	}
	
	public static void queue(GameObject obj) {
		queue.add(obj);
	}
	
//	public static void drawQueue() {
//		//Main.manager.level.getGraphics();
//        //Graphics g = MazeGame.manager.level.getGraphics();
//        
//        //Collections.sort(queue, new QueueOrderer());
//        for(GameObject obj : queue) {
//            obj.draw(g);
//        }
//        
//        clearQueue();
//    }
	
	 public static void clearQueue() {
	        queue.clear();
	    }
	
	
	public Point getPlayerStart() {
		return this.playerStart;
	}
	
}
