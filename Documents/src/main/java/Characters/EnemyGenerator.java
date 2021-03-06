package Characters;

import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * EnemyGenerator clas to generate enemies on the game panel without overlapping with other enemies, punishments
 * and rewards
 *
 * @author Kerem Sarisen
 */
public class EnemyGenerator {
    private final ArrayList<Enemy> enemyList = new ArrayList<>();

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    GamePanel map;

    final int maxCordX = 25;
    final int maxCordY = 15;
    final int viewRange = 8;
    final int maxEnemyAmount = 3;

    /**
     * Constructor that adds the generated enemies to the list that is declared to keep them
     *
     * @param map the game panel where enemies need to be generated
     */
    public EnemyGenerator(GamePanel map) {
        this.map = map;
        for (int i = 1; i <= maxEnemyAmount; i++) {
            enemyList.add(generateEnemy(map));
        }
    }

    Random r = new Random();

    /**
     * It generates enemy randomly on the map.
     * It also makes sure that each enemy has different location than any other enemies.
     *
     * @param map the game panel where enemies need to be generated
     * @return Enemy that has been created
     * @see Enemy
     */
    public Enemy generateEnemy(GamePanel map) {
        Image enemyImg = new Image("Police-South.png");

        int xCord = r.nextInt(maxCordX - 1);
        int yCord = r.nextInt(maxCordY - 1);

        Enemy enemy = new Enemy(viewRange, enemyImg, new Point(xCord, yCord), map);

        for (Enemy value : enemyList) {
            if (enemy.getLocation().equals(value.getLocation()))
                return generateEnemy(map);
        }
        if (!map.level.gameObjects[(int) enemy.getLocation().getY()][(int) enemy.getLocation().getX()].getClass().getSimpleName().equals("Road"))
            return generateEnemy(map);
        return enemy;
    }
}
