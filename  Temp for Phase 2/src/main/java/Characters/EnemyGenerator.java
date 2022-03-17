package main.java.Characters;

import main.java.Rewards.RegularReward;
import main.java.Rewards.Reward;
import main.java.Textures.Image;
import main.java.MazeGame.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class EnemyGenerator {
    private ArrayList<Reward> enemyList = new ArrayList<>();

    final int maxCordX = 25;
    final int maxCordY = 15;
    final int speedX = 1;
    final int speedY = 1;
    final int viewRange = 5;
    final int maxEnemyAmount = 5;

    public EnemyGenerator() {
        for (int i = 0; i <= maxEnemyAmount; i++) {
            enemyList.add(generateEnemy());
        }
    }

    Random r = new Random();

    public Enemy generateEnemy() {
        Image enemyImg = new Image("Textures/Police.png");

        int xCord = r.nextInt(maxCordX + 1);
        int yCord = r.nextInt(maxCordY + 1);

        Enemy enemy = new Enemy(viewRange, speedX, speedY, enemyImg, new Point(xCord, yCord),/*needs GamePanel param*/ );

        for (int i = 0; i < enemyList.size(); i++) {
            if (enemy.getLocation() == enemyList.get(i).getLocation())
                return generateEnemy();
        }
        return enemy;
    }
}
