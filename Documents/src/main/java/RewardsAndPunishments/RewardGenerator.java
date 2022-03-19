package RewardsAndPunishments;

import MazeGame.GameObject;
import MazeGame.GamePanel;
import MazeGame.LevelGenerator;
import Objects.BarrierGrass;
import Textures.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RewardGenerator {

    private static final ArrayList<Reward> rewardsList = new ArrayList<>();

    public static ArrayList<Reward> getRewardsList() {
        return rewardsList;
    }

    GamePanel map;

    final int maxRegReward = 10;
    final int maxBonusReward = 2;
    final int maxCordX = 25;
    final int maxCordY = 15;
    final int regRewardVal = 10;
    final int bonusRewardVal = 25;

    // Generating and adding the new rewards to the list
    public RewardGenerator(GamePanel map) {
        this.map = map;
        for (int i = 0; i <= maxRegReward; i++) {
            rewardsList.add(generateRegularReward(map));
        }

        for (int i = 0; i <= maxBonusReward; i++) {
            rewardsList.add(generateBonusReward(map));
        }
    }

    Random r = new Random();

    // Generate a regular reward at some  point
    public Reward generateRegularReward (GamePanel map) {
        Image regRewardImg = new Image("gas.png");

        int xCord = r.nextInt(maxCordX - 1);
        int yCord = r.nextInt(maxCordY - 1);

        Reward regReward = new RegularReward(regRewardVal, regRewardImg, new Point(xCord, yCord), map);

        // Checking if the generated reward's location is equal to another one's in the list, if it is, then we use recursion
        for (Reward reward : rewardsList) {
            if (regReward.getLocation().equals(reward.getLocation()))
                return generateRegularReward(map);
        }
        if(!map.level.gameObjects[(int)regReward.getLocation().getY()][(int)regReward.getLocation().getX()].getClass().getSimpleName().equals("Road"))
            return generateRegularReward(map);
        return regReward;
    }

    // Generate a bonus reward at some random point
    public Reward generateBonusReward (GamePanel map) {
        Image bonusRewardImg = new Image("money.png");

        int xCord = r.nextInt(maxCordX - 1);
        int yCord = r.nextInt(maxCordY - 1);

        Reward bonusReward = new BonusReward(bonusRewardVal, bonusRewardImg, new Point(xCord, yCord), map);

        // Checking if the generated reward's location is equal to another one's in the list, if it is, then we use recursion
        for (Reward reward : rewardsList) {
            if (bonusReward.getLocation() == reward.getLocation())
                return generateBonusReward(map);
        }

        for (PunishmentRoadBlock punishment : map.getPunishmentsList()) {
            if (bonusReward.getLocation() == punishment.getLocation())
                return generateBonusReward(map);
        }

        if(!map.level.gameObjects[(int)bonusReward.getLocation().getY()][(int)bonusReward.getLocation().getX()].getClass().getSimpleName().equals("Road"))
            return generateBonusReward(map);
        return bonusReward;
    }
}
