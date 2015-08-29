package com.simplyanalyticsblog;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

    private boolean realPlayer;

    public Player(boolean realPlayer) {
        this.realPlayer = realPlayer;
    }

    public void makeFirstGuess(ArrayList<Door> doors) {

        if (!this.realPlayer) {

            Random randomGenerator = new Random();
            int index = randomGenerator.nextInt(doors.size());
            doors.get(index).setPlayerGuess(true);
            System.out.println("Player first guess: " + doors.get(index).getName());

        } else {

            Scanner reader = new Scanner(System.in);
            System.out.println("What is your initial choice? [A, B, C]");
            String choice = reader.next();
            int index = "abc".indexOf(choice.toLowerCase());
            doors.get(index).setPlayerGuess(true);
            System.out.println("Player first guess: " + doors.get(index).getName());

        }
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

        // TODO: add logic for single player mode
    }
}
