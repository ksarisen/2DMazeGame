package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class PunishmentGenerator {
    private static final ArrayList<PunishmentRoadBlock> punishmentsList = new ArrayList<>();

    public static ArrayList<PunishmentRoadBlock> getPunishmentsList() {
        return punishmentsList;
    }

    GamePanel map;

    final int maxPunishment = 5;
    final int maxCordX = 25;
    final int maxCordY = 15;
    final int punishmentValue = 15;

    // Generating and adding the new rewards to the list
    public PunishmentGenerator(GamePanel map) {
        this.map = map;

        for (int i = 0; i <= maxPunishment; i++) {
            punishmentsList.add(generatePunishment());
        }
    }

    Random r = new Random();

    // Generate a punishment road block at some random point
    public PunishmentRoadBlock generatePunishment () {
        Image punishmentImg = new Image("Textures/Construction.png");

        int xCord = r.nextInt(maxCordX + 1);
        int yCord = r.nextInt(maxCordY + 1);

        PunishmentRoadBlock newPunishment = new PunishmentRoadBlock(punishmentValue, punishmentImg, new Point(xCord, yCord), map);

        // Checking if the generated reward's location is equal to another one's in the list, if it is, then we use recursion
        for (PunishmentRoadBlock punishment : punishmentsList) {
            if (newPunishment.getLocation() == punishment.getLocation())
                return generatePunishment();
        }
        return newPunishment;
    }
}

