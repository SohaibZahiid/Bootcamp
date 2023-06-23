const PPT = ['✂', '🥊', '🖐'];
let roundCounter = 1;
let playerPoints = 0;
let computerPoints = 0;

const roundWinner = (player, computer) => {
  if (player === computer) {
    return 'empatan';
  } else if (player === '🥊' && computer === '✂') {
    playerPoints++;
    return '🥊 gana a ✂';

  } else if (player === '✂' && computer === '🥊') {
    computerPoints++;
    return '🥊 gana a ✂';
  }  else if ((player === '✂' && computer === '🖐')) {
    playerPoints++;
    return '✂ gana a 🖐';
  } else if ((player === '🖐' && computer === '✂')) {
    computerPoints++;
    return '✂ gana a 🖐';
  }  else if ((player === '🖐' && computer === '🥊')) {
    playerPoints++;
    return '🖐 gana a 🥊';
  } else if((player === '🥊' && computer === '🖐')) {
    computerPoints++;
    return '🖐 gana a 🥊';
  } else {
    computerPoints++;
    return 'Computer wins';
  }
};

const createElements = (playerSelected, computerSelected) => {
  const gameContainer = document.querySelector('.game-container');
  const html = `
    <div class="game">
      <p>Player[${playerPoints}] <span class="player-choose">${playerSelected}</span></p>
      <p>Computer[${computerPoints}] <span class="computer-choose">${computerSelected}</span></p>
      <p>${roundWinner(playerSelected, computerSelected)}</p>
    </div>
  `;
  gameContainer.innerHTML += html;
};

const btns = document.querySelectorAll('.btn');
let playerSelected, computerSelected;

btns.forEach(btn => {
  btn.addEventListener('click', e => {
    const selected = e.target.dataset.id;
    if (selected && roundCounter <= 3) {
      playerSelected = selected;
      computerSelected = PPT[Math.floor(Math.random() * PPT.length)];
      createElements(playerSelected, computerSelected);
      roundCounter++;
    }
  });
});
