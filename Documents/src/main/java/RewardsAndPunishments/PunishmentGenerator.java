package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Creates the punishment objects, and it makes sure that none of the punishments are in the same cell
 * with each other. Also, makes sure that none of the punishments spawn on the grass.
 *
 * @author Kerem Sarisen
 */
public class PunishmentGenerator {

    private final ArrayList<PunishmentRoadBlock> punishmentsList = new ArrayList<>();

    /**
     * Accessor method
     *
     * @return the list for the punishments
     */
    public ArrayList<PunishmentRoadBlock> getPunishmentsList() {
        return punishmentsList;
    }

    GamePanel map;

    final int maxPunishment = 5;
    final int maxCordX = 25;
    final int maxCordY = 15;
    final int punishmentValue = 15;

    /**
     * Generates and adds the new punishment objects to the list with the given parameter
     *
     * @param map a game panel where punishment should be created
     */
    public PunishmentGenerator(GamePanel map) {
        this.map = map;

        for (int i = 0; i <= maxPunishment-1; i++) {
            punishmentsList.add(generatePunishment(map));
        }
    }

    Random r = new Random();

    /**
     * Generates a punishment road block at some random point with the given parameter
     *
     * @param map a game panel where punishment should be created
     */
    public PunishmentRoadBlock generatePunishment(GamePanel map) {
        Image punishmentImg = new Image("Construction.png");

        int xCord = r.nextInt(maxCordX - 1);
        int yCord = r.nextInt(maxCordY - 1);

        PunishmentRoadBlock newPunishment = new PunishmentRoadBlock(punishmentValue, punishmentImg, new Point(xCord, yCord), map);

        // Checks if the generated reward's location is equal to another one's in the list, if it is, then we use recursion
        for (PunishmentRoadBlock punishment : punishmentsList) {
            if (newPunishment.getLocation().equals(punishment.getLocation()))
                return generatePunishment(map);
        }

        // Checks if the location of the new punishment is same as any punishment's location on the map, if it is, then recursion
        if (!map.level.gameObjects[(int) newPunishment.getLocation().getY()][(int) newPunishment.getLocation().getX()].getClass().getSimpleName().equals("Road"))
            return generatePunishment(map);
        return newPunishment;
    }
}

