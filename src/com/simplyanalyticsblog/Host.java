package com.simplyanalyticsblog;

import java.util.ArrayList;
import java.util.Random;

public class Host {

    public void hidePrize(ArrayList<Door> doors) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(doors.size());
        doors.get(index).setWinningDoor(true);
        System.out.println("Winning door: " + doors.get(index).getName());
    }

    public void openDoor(ArrayList<Door> doors) {
        for (Door door : doors) {
            if (!door.isWinningDoor() && !door.isPlayerGuess()) {
                door.setOpenDoor(true);
                System.out.println("Monty opens door: " + door.getName());
                break;
            }
        }
    }

    public String revealFinalResult(ArrayList<Door> doors) {
        for (Door door : doors) {
            if (door.isPlayerGuess()) {
                if (door.isWinningDoor()) {
                    System.out.println("Congratulations.. you WON!");
                    return "win";
                } else {
                    System.out.println("What a pity.. you LOST");
                    return "lost";
                }
            }
        }
        return "error";
    }
}
