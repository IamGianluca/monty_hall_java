package com.simplyanalyticsblog;

public class Door {

    private String name;
    private boolean winningDoor = false;
    private boolean openDoor = false;
    private boolean playerGuess = false;

    public Door(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isWinningDoor() {
        return winningDoor;
    }

    public void setWinningDoor(boolean winningDoor) {
        this.winningDoor = winningDoor;
    }

    public boolean isPlayerGuess() {
        return playerGuess;
    }

    public void setPlayerGuess(boolean playerGuess) {
        this.playerGuess = playerGuess;
    }

    public boolean isOpenDoor() {
        return openDoor;
    }

    public void setOpenDoor(boolean openDoor) {
        this.openDoor = openDoor;
    }


}
