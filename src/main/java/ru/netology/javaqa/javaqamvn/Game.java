package ru.netology.javaqa.javaqamvn;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private Map<String, Player> players;

    public Game() {
        this.players = new HashMap<>();
    }

    public void register(Player player) {
        if (!registered(player.getName())) {
            players.put(player.getName(), player);
        }
    }

    public boolean registered(String name) throws NotRegisteredException {
        return players.containsKey(name);
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
        return players.get(name);
    }

}
