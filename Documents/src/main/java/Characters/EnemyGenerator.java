package Characters;

import MazeGame.GameObject;
import MazeGame.LevelGenerator;
import Objects.BarrierGrass;
import Textures.Image;
import MazeGame.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class EnemyGenerator {
    private static final ArrayList<Enemy> enemyList = new ArrayList<>();

    public static ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    GamePanel map;

    final int maxCordX = 25;
    final int maxCordY = 15;
    final int speedX = 1;
    final int speedY = 1;
    final int viewRange = 5;
    final int maxEnemyAmount = 5;

    public EnemyGenerator(GamePanel map) {
        this.map = map;
        for (int i = 0; i <= maxEnemyAmount; i++) {
            enemyList.add(generateEnemy(map));
        }
    }

    Random r = new Random();

    public Enemy generateEnemy(GamePanel map) {
        Image enemyImg = new Image("Police.png");

        int xCord = r.nextInt(maxCordX -1);
        int yCord = r.nextInt(maxCordY -1);

        Enemy enemy = new Enemy(viewRange, speedX, speedY, enemyImg, new Point(xCord, yCord), map );

        for (Enemy value : enemyList) {
            if (enemy.getLocation() == value.getLocation())
                return generateEnemy(map);
        }
        if(!map.level.gameObjects[(int)enemy.getLocation().getY()][(int)enemy.getLocation().getX()].getClass().getSimpleName().equals("Road"))
            return generateEnemy(map);

        return enemy;
    }
}
