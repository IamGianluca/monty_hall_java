package com.simplyanalyticsblog;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        Door a = new Door("A");
        Door b = new Door("B");
        Door c = new Door("C");

        ArrayList<Door> doors = new ArrayList<Door>(3);
        doors.add(a);
        doors.add(b);
        doors.add(c);

        Host monty = new Host();
        Player player = new Player();

        // let Monty Hall hide the prize and the player pick its first guess
        monty.hidePrize(doors);
        player.makeFirstGuess(doors);

        // Monty Hall opens one door
        monty.openDoor(doors);

        // player has a chance to switch door
        player.makeSecondGuess(doors);

        // print state after the player made his final choice
        for (int i=0; i < doors.size(); i++) {
            System.out.println("Door " + doors.get(i).getName() + " --> is winning door: " + doors.get(i).isWinningDoor() + ", is player choice : " + doors.get(i).isPlayerGuess());
        }

        monty.revealFinalResult(doors);
    }
}
