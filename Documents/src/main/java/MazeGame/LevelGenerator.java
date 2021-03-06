package MazeGame;

import Characters.Player;
import Objects.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Creates a level from a JSON file using game objects
 *
 * @author Reece Landry
 */

public class LevelGenerator extends JComponent {

    public static GameObject[][] gameObjects;
    static ArrayList<GameObject> queue = new ArrayList<>();
    public static boolean isLoading = false;

    private static int WIDTH;
    private static int HEIGHT;

    private Point playerStart;

    public Player player;

    private HashMap<String, GameObject> codes = new HashMap<>();

    public LevelGenerator() {
        codes.put("-", new BarrierGrass("s"));
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
     *
     * @param levelPath level description
     * @author Reece Landry
     */

    public void buildGame(String levelPath) {
        JSONParser parser = new JSONParser();

        // Reads json file
        try {
            String path = "Level1.json";
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(path);
            BufferedReader in = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = in.readLine()) != null){
                buffer.append(line);
            }
            JSONObject object = (JSONObject) parser.parse(buffer.toString());
            JSONArray layout = (JSONArray) object.get("layout");
            JSONArray first = (JSONArray) layout.get(0);

            // Sets width and height
            this.WIDTH = first.size();
            this.HEIGHT = layout.size();
            this.setPreferredSize(new Dimension(this.WIDTH * GameObject.SIZE, this.HEIGHT * GameObject.SIZE));

            JSONObject spawn = (JSONObject) object.get("start");
            Point start = new Point(Integer.parseInt(spawn.get("x").toString()), Integer.parseInt(spawn.get("y").toString()));
            this.playerStart = start;

            this.gameObjects = new GameObject[this.HEIGHT][this.WIDTH];

            for (int y = 0; y < this.HEIGHT; y++) {
                JSONArray xLayout = (JSONArray) layout.get(y);
                for (int x = 0; x < this.WIDTH; x++) {
                    if (codes.containsKey(xLayout.get(x))) {
                        // Create gameObject based on code reference and create new instance.
                        setGameObject(codes.get(xLayout.get(x)).getClass().getDeclaredConstructor(new Class[]{String.class}).newInstance((xLayout.get(x))), new Point(x, y));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    /**
     * Initializes a game object given the parameters
     *
     * @param o the GameObject that is being located
     * @param p the location of the param o
     * @author Reece Landry
     */

    public void setGameObject(GameObject o, Point p) {
        gameObjects[(int) p.getY()][(int) p.getX()] = o;
        o.setPosition(p);
        LevelGenerator.queue(o);
    }

    /**
     * Adds the object to the list of {@code GameObject}
     *
     * @param obj the GameObject that is being put in the list
     * @author Reece Landry
     */

    public static void queue(GameObject obj) {
        queue.add(obj);
    }

    /**
     * Clears the current list of {@code GameObject}
     *
     * @author Reece Landry
     */

    public static void clearQueue() {
        queue.clear();
    }

    /**
     * Returns the coordinates of the player starting position
     *
     * @return Point
     * @author Reece Landry
     */
    public Point getPlayerStart() {
        return this.playerStart;
    }

}
