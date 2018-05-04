const addItem = function(){
  console.log("hello");
  let item = document.createElement('INPUT');
  item.id = 'item';
  document.getElementByClass('items').appendChild(item);
}
