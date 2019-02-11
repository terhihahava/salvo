console.log("Hello");

var url = "http://localhost:8080/api/games";

fetch(url)
    .then(function (response) {
//    console.log(response) ("Request succeeded")
        return response.json();
    })
    .then(json => {
       let allGames = json;
       console.log(allGames);

       createGamesList(allGames);

    });

 function createGamesList(allGames){

    console.log(allGames.length);

     for (var i = 0; i < allGames.length; i++) {

    localDate = [];
    var localDate=allGames[i].date;
    console.log(localDate);

    var orderedList = document.getElementById("games_list");
    var list_item = document.createElement("li");
    list_item.innerHTML = "Game: "+ allGames[i].gameId+", "+"Date: " +localDate;
    list_item.setAttribute("class", "high_level_list");
    orderedList.appendChild(list_item);

    var gamePlayer_list = [];
    gamePlayer_list= allGames[i].gamePlayers;
    console.log(gamePlayer_list.length);

    for (var j = 0; j < gamePlayer_list.length; j++) {

    var lowerLevelList = document.getElementById("high_level_list");
    var lower_list_item = document.createElement("ul");
    lower_list_item.setAttribute("class", "low_level_list");
    var list= document.getElementById("low_level_list");
    var gamePlayerNameItem= document.createElement("li");
    gamePlayerNameItem.innerHTML= gamePlayer_list[j].player.email;

    lower_list_item.appendChild(gamePlayerNameItem);
    list_item.appendChild(lower_list_item);

    }




    }
 }



