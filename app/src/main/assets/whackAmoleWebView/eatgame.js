window.addEventListener('load', function(){
  const scoreBoard = document.getElementsByClassName("score")[0];
  const tables = Array.from(document.getElementsByClassName("table"));
  const kimchis = Array.from(document.getElementsByClassName("kimchi"));
  const kim = document.querySelectorAll('.kimchi');

  let lastTable;
  let timeUp = false;
  let score = 0;

  function randomTime(min, max) {
    return Math.round(Math.random() * (max - min) + min);
  };

  function randomTable(tables) {
    const idx = Math.floor(Math.random() * tables.length);
    const table = tables[idx];
    if (table === lastTable) {
      return randomTable(tables);
    }
    lastTable = table;
    return table;
  };

  function peep() {
    const time = randomTime(200, 1000);
    const table = randomTable(tables);
    table.classList.add('up');
    setTimeout(() => {
      table.classList.remove('up');
      if (!timeUp) peep();
    }, time);
  };

  window.startEatGame = function () {
    scoreBoard.textContent = 0;
    timeUp = false;
    score = 0;
    peep();
    setTimeout(() => timeUp = true, 10000)
  };

  function eat(e) {
    if(!e.isTrusted) return;
    score++;
    this.parentNode.classList.remove('up');
    scoreBoard.textContent = score;
  }

  kimchis.forEach(kimchi => kimchi.addEventListener('click', eat));
});
