/**
 * Created by dwits on 01/08/2016.
 */

function GameRoom(wonders, maxPlayers){
    var wonders = wonders;
    var players = [];

    this.addPlayer = function(player){
        players.push(player);
    }

    this.getPlayer = function(position){
        return players[position];
    }

    this.getPlayers = function () {
        return players;
    }

    this.setWonders  = function () {
        players.forEach(function(element) {
            var random = Math.floor((Math.random() * wonders.length) + 1);
            element.city.wonder = wonders[random];
            wonders.splice(random, 1);
        }, this);
    }
}
