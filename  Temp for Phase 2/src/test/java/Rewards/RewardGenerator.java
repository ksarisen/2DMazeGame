package test.java.Rewards;

import test.java.Textures.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RewardGenerator {

    private ArrayList<Reward> rewardsList = new ArrayList<>();
    final int maxRegReward = 10;
    final int maxBonusReward = 2;
    final int maxCordX = 25;
    final int maxCordY = 15;
    final int regRewardVal = 10;
    final int bonusRewardVal = 25;

    public RewardGenerator() {

    }

    Random r = new Random();

    // Generate a regular reward at some  point
    public Reward generateRegularReward () {
        Image regRewardImg = new Image("Textures/gas.png");

        int xCord = r.nextInt(maxCordX + 1);
        int yCord = r.nextInt(maxCordY + 1);

        Reward regReward = new RegularReward(regRewardVal, regRewardImg, new Point(xCord, yCord));

        // Checking if the generated reward's location is equal to another one's in the list, if it is, then we use recursion
        for (int i = 0; i < rewardsList.size(); i++) {
            if (regReward.getLocation() == rewardsList.get(i).getLocation())
                return generateRegularReward();
        }
        return regReward;
    }

    // Generate a bonus reward at some random point
    public Reward generateBonusReward () {
//        Image bonusRewardImg = new Image("Textures/money.png");
//
//        int xCord = r.nextInt(maxCordX + 1);
//        int yCord = r.nextInt(maxCordY + 1);
//
//        return new BonusReward(bonusRewardVal, bonusRewardImg, new Point(xCord, yCord));
    }

}
