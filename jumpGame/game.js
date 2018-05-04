let moveKnifeForward = function(){
  let knife = document.getElementById("knife");
  let apple = document.getElementById("apple");
  let pos = knife.offsetLeft;
  knife.style.left = `${pos-50}px`;
  if(pos<40){
    pos = 1188;
    knife.style.left = `${pos+500}px`;
  }
}

let jumpHeight = 300;

let moveAppleUp = function(){
  let apple = document.getElementById("apple");
  let applePosition = apple.offsetTop;
  apple.style.top = `${applePosition-jumpHeight}px`;
}

let moveAppleDown = function(){
  let apple = document.getElementById("apple");
  let applePosition = apple.offsetTop;
  apple.style.top = `${applePosition+jumpHeight}px`;
}

let interval = 0;

let controlMovement = function(event){
  let knife = document.getElementById("knife");
  let apple = document.getElementById("apple");
  if(apple.offsetTop==knife.offsetTop&&apple.offsetLeft==knife.offsetLeft){
    alert("GAME OVER !!!")
  }
  if(event.keyCode==37){
    clearInterval(interval);
    interval = setInterval(moveKnifeForward,70);
  }
  if(event.keyCode==38 && apple.offsetTop==370){
    moveAppleUp();
    setTimeout(moveAppleDown,500);
  }
}

window.onkeydown = controlMovement;
