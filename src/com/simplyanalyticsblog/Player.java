package com.simplyanalyticsblog;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    public void makeFirstGuess(ArrayList<Door> doors) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(doors.size());
        doors.get(index).setPlayerGuess(true);
        System.out.println("Player first guess: " + doors.get(index).getName());
    }

    public void makeSecondGuess(ArrayList<Door> doors) {
        // player decides if switching door
        String options = "yn";
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(options.length());
        char decision = options.charAt(index);

        System.out.println("Does the player switch door?: " + decision);

        char y = 'y';

        if (y == decision) {
            for (Door door : doors) {
                if (door.isOpenDoor()) {
                    continue;
                } else if (door.isPlayerGuess()) {
                    door.setPlayerGuess(false);
                } else {
                    door.setPlayerGuess(true);
                }
            }

        }

    }

}
