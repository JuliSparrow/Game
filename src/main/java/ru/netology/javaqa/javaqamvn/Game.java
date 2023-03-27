package ru.netology.javaqa.javaqamvn;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void register(Player player) {
        if (!registered(player.getName())) {
            players.add(player);
        }
    }

    public boolean registered(String name) throws NotRegisteredException {
        for (Player player : players) {
            if (name.equals(player.getName())) {
                return true;
            }
        }
        return false;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException();
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()){
            return 2;
        } else {
            return 0;
        }
    }

    public Player findByName(String name) throws NotRegisteredException {
        for (Player player : players) {
            if (name.equals(player.getName())) {
                return player;
            }
        }
        return null;
    }

}
