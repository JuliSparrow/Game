package ru.netology.javaqa.javaqamvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game;

    @BeforeEach
    private void setGame() {
        game = new Game();
        Player player1 = new Player(1, "Вася", 15);
        Player player2 = new Player(2, "Петя", 17);
        Player player3 = new Player(3, "Олег", 13);
        Player player4 = new Player(4, "Витя", 15);

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    void shouldRegisterPlayer() {
        Player player5 = new Player(5, "Аноним", 17);

        Assertions.assertFalse(game.registered(player5.getName()));

        game.register(player5);
        Assertions.assertTrue(game.registered(player5.getName()));

        game.register(player5);
        Assertions.assertTrue(game.registered(player5.getName()));
    }

    @Test
    void shouldThrowNotRegisteredException() {
        Player notRegisteredPlayer = new Player(6, "Игорь", 12);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вася", "Игорь"));
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Игорь", "Вася"));
    }

    @Test
    void shouldPlayRoundWithResult0() {
        int expected = 0;
        int actual = game.round("Вася", "Витя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldPlayRoundWithResult1() {
        int expected = 1;
        int actual = game.round("Вася", "Олег");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldPlayRoundWithResult2() {
        int expected = 2;
        int actual = game.round("Олег", "Петя");
        Assertions.assertEquals(expected, actual);
    }
}