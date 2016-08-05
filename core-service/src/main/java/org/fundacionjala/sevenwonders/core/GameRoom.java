package org.fundacionjala.sevenwonders.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Juan Manuel Barahona on 04/08/2016.
 */
public class GameRoom {
    public static final int NUMBER_OF_AGES = 3;

    private WonderProvider wonderProvider;
    private CardProvider cardProvider;
    private List<org.fundacionjala.sevenwonders.core.rest.Player> players;
    private int maxPlayers;

    public GameRoom(int maxPlayers) {
        wonderProvider = new WonderProvider();
        cardProvider = new CardProvider();
        players = new ArrayList<>();
        this.maxPlayers = maxPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Gets a list of rest players
     *
     * @return list of {@link org.fundacionjala.sevenwonders.core.rest.Player}
     */
    public List<org.fundacionjala.sevenwonders.core.rest.Player> getPlayers(){
        return players;
    }

    /**
     * Add players to game room
     *
     * @param player assigned a item of players.
     */
    public void addPlayer(org.fundacionjala.sevenwonders.core.rest.Player player) {
        this.players.add(player);
    }

    /**
     * Initialize players with {@link Wonder}, {@link Storage} and {@link StoragePoint}
     * @return list of {@link Player}
     */
    private List<Player> initializePlayers() {
        List<Player> gamePlayers = new ArrayList<>();
        List<Wonder> wonders = wonderProvider.getDefault();
        Random random = new Random();
        players.stream().forEach(item -> {
            Wonder currentWonder = wonders.remove(random.nextInt(wonders.size()));
            StoragePoint storagePoint = new StoragePoint();
            Storage storage = new Storage();
            City city = new City(currentWonder, storagePoint, storage);
            Player player = new Player(item.getName(), city);
            gamePlayers.add(player);
        });

        return gamePlayers;
    }


    /**
     * Create a game with basic values
     *
     * @return Game
     */
    public Game createGame(){
        List<Player> players = initializePlayers();
        GameBuilder builder = new GameBuilder();
        return builder.setPlayers(players)
                      .setDeck(new Deck(cardProvider.getDefault()), NUMBER_OF_AGES)
                      .createGame();
    }
}