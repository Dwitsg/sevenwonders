package org.fundacionjala.sevenwonders.beans;

import org.fundacionjala.sevenwonders.core.rest.PlayerModel;

import java.security.SecureRandom;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dwits on 24/08/2016.
 */
public class AuthService {
    private final Map<Integer, PlayerModel> players = new TreeMap<>();
    private int autoIncrementId;


    public AuthService(){
        autoIncrementId = 1;
    }

    public PlayerModel login(PlayerModel playerModel){
        PlayerModel player = new PlayerModel();
        player.setId(autoIncrementId);
        player.setUserName(playerModel.getUserName());
        player.setToken(SecureRandom.);
    }
}
