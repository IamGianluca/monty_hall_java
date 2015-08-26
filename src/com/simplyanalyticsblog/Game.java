package com.simplyanalyticsblog;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        if (args.length != 0 && args.length != 2) {
            System.out.println("You can play only on 'single player' mode or 'simulation'. If you want to play in " +
                    "single player do not add any argument. If you want to use the simulation mode, type --simulation and" +
                    "an integer number representing how many iteration you want to run as arguments.");
        }

        // if no arguments are passed, start a single player game
        if (args.length == 0) {
            single_player_game();
        } else if ("--simulation".equals(args[0])) {
            // if the "--simulation" argument is passed run a simulation using "args[1]" repetitions


            simulate(Integer.parseInt(args[1]));
        } else {
            System.out.println("Sorry, at the moment this game to run just on simulation mode. Stay tuned, a single " +
                    "player version is coming soon!");
        }
    }

    public static void simulate(int repetitions) {

        for (int n = 0; n < repetitions; n++) {
            System.out.println(n + 1 + " / " + repetitions);

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
            for (int i = 0; i < doors.size(); i++) {
                System.out.println("Door " + doors.get(i).getName() + " --> is winning door: " +
                        doors.get(i).isWinningDoor() + ", is player choice : " + doors.get(i).isPlayerGuess());
            }
            monty.revealFinalResult(doors);
        }
    }

    public static void single_player_game() {

        System.out.println("Hi! You entered the 'single player' mode. The game is simple, just read the commands " +
                "printed on your command line and stay with us.");

        Scanner reader = new Scanner(System.in);
        System.out.println("What's your name?");
        String a = reader.next();

        char initials = a.charAt(0);
        System.out.println(initials);
    }
}
