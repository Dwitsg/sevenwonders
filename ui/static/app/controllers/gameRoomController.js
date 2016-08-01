/**
 * Created by dwits on 01/08/2016.
 */

angular.module('gameModule')
    .controller('createGame', function ($scope, $http) {

        $scope.wonders = [new Wonder("Rome"),
            new Wonder("Great Wall of China")
        ]

        var gameRoom = new GameRoom($scope.wonders, $scope.maxPlayers);

        $scope.addPlayer = function (player) {
            gameRoom.addPlayer(player);
            if(gameRoom.getPlayers() == $scope.maxPlayers){
                gameRoom.setWonders()
                createGame()
            }
        }

        function createGame(){
            var playersList = {
                players : gameRoom.getPlayer()
            };

            $http.post('', playersList)
                .success(function (data) {
                    console.log(data);
                })
        }

    });