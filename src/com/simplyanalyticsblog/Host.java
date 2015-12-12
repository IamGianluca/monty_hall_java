package com.simplyanalyticsblog;

import java.util.ArrayList;
import java.util.Random;

public class Host {

    public void hidePrize(ArrayList<Door> doors, boolean verbose) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(doors.size());
        doors.get(index).setWinningDoor(true);
        if (verbose) {
            System.out.println("Winning door: " + doors.get(index).getName());
        }
    }

    public void openDoor(ArrayList<Door> doors, boolean verbose) {
        for (Door door : doors) {
            if (!door.isWinningDoor() && !door.isPlayerGuess()) {
                door.setOpenDoor(true);
                if (verbose) {
                    System.out.println("Monty opens door: " + door.getName());
                }
                break;
            }
        }
    }

    public String revealFinalResult(ArrayList<Door> doors, boolean verbose) {
        for (Door door : doors) {
            if (door.isPlayerGuess()) {
                if (door.isWinningDoor()) {
                    if (verbose) {
                        System.out.println("Congratulations.. you WON!");
                    }
                    return "win";
                } else {
                    if (verbose) {
                        System.out.println("What a pity.. you LOST");
                    }
                    return "lost";
                }
            }
        }
        return "error";
    }
}
