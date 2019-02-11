function getGamePlayerID() {
let currentURL = window.location.search;
//console.log(currentURL)
let gamePlayerID= currentURL.split("=")[1];
//console.log(gamePlayerID);
return gamePlayerID;
}

var url = 'http://localhost:8080/api/game-view/'+getGamePlayerID();
console.log(url);

fetch(url)
    .then(response => {
//        console.log(response)
        return response.json();
    })
    .then(json => {
       let allMyGames = json;
//       console.log(allMyGames);

       createGamePlayerDetails(allMyGames);
    })
    .catch(err => console.log(err));



function createGamePlayerDetails(allMyGames) {



 let Player1=allMyGames[0].gamePlayers[0].player.email;
 let Player2=allMyGames[0].gamePlayers[1].player.email;
// console.log(Player2);

 let Player1_id=allMyGames[0].gamePlayers[0].id;
 let Player2_id=allMyGames[0].gamePlayers[1].id;

 if (Player1_id=getGamePlayerID()) {

   var gamePlayerParagraph = document.getElementById("gamePlayer-info");
   gamePlayerParagraph.innerHTML="The players are: "+Player1+" (you) and "+Player2;

   }

  if (Player2_id=getGamePlayerID()) {

   var gamePlayerParagraph = document.getElementById("gamePlayer-info");
   gamePlayerParagraph.innerHTML="The players are: "+Player1+" and "+Player2+" (you)";

   }
   }

