package RewardsAndPunishments;

import MazeGame.GamePanel;
import Textures.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Creates the reward objects, and it makes sure that none of the rewards are in the same cell
 * with punishment objects or with each other. Also, makes sure that none of the rewards spawn on the grass.
 *
 * @author Kerem Sarisen
 */
public class RewardGenerator {

    private static final ArrayList<Reward> rewardsList = new ArrayList<>();

    public static ArrayList<Reward> getRewardsList() {
        return rewardsList;
    }

    final int maxRegReward = 9;
    final int maxBonusReward = 1;
    final int maxCordX = 25;
    final int maxCordY = 15;
    final int regRewardVal = 10;
    final int bonusRewardVal = 25;

    /**
     * Generates and adds the new reward objects to the list with the given parameter
     *
     * @param map a game panel where reward should be created
     */
    public RewardGenerator(GamePanel map) {
        for (int i = 0; i <= maxRegReward; i++) {
            rewardsList.add(generateRegularReward(map));
        }

        for (int i = 0; i <= maxBonusReward; i++) {
            rewardsList.add(generateBonusReward(map));
        }
    }

    Random r = new Random();

    /**
     * Generates a regular reward at some random point with the given parameter
     *
     * @param map a game panel where regular reward should be created
     */
    public Reward generateRegularReward(GamePanel map) {
        Image regRewardImg = new Image("gas.png");

        int xCord = r.nextInt(maxCordX - 1);
        int yCord = r.nextInt(maxCordY - 1);

        Reward regReward = new RegularReward(regRewardVal, regRewardImg, new Point(xCord, yCord), map);

        // Checks if the generated reward's location is equal to another one's in the list, if it is, then we use recursion
        for (Reward reward : rewardsList) {
            if (regReward.getLocation().equals(reward.getLocation()))
                return generateRegularReward(map);
        }
        for (PunishmentRoadBlock punishment : map.getPunishmentsList()) {
            if (regReward.getLocation() == punishment.getLocation())
                return generateRegularReward(map);
        }
        if (!map.level.gameObjects[(int) regReward.getLocation().getY()][(int) regReward.getLocation().getX()].getClass().getSimpleName().equals("Road"))
            return generateRegularReward(map);
        return regReward;
    }

    /**
     * Generates a bonus reward at some random point with the given parameter
     *
     * @param map a game panel where this bonus reward should be created
     */
    public Reward generateBonusReward(GamePanel map) {
        Image bonusRewardImg = new Image("money.png");

        int xCord = r.nextInt(maxCordX - 1);
        int yCord = r.nextInt(maxCordY - 1);

        Reward bonusReward = new BonusReward(bonusRewardVal, bonusRewardImg, new Point(xCord, yCord), map);

        // Checks if the generated reward's location is equal to another one's in the list, if it is, then we use recursion
        for (Reward reward : rewardsList) {
            if (bonusReward.getLocation() == reward.getLocation())
                return generateBonusReward(map);
        }

        for (PunishmentRoadBlock punishment : map.getPunishmentsList()) {
            if (bonusReward.getLocation() == punishment.getLocation())
                return generateBonusReward(map);
        }

        // Checks if the location of the new punishment is same as any grass' location on the map, if it is, then recursion
        if (!map.level.gameObjects[(int) bonusReward.getLocation().getY()][(int) bonusReward.getLocation().getX()].getClass().getSimpleName().equals("Road"))
            return generateBonusReward(map);
        return bonusReward;
    }
}
