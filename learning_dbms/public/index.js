const sendRequest = function(method,url,callback,data){
  const req = new XMLHttpRequest();
  req.open(method,url);
  req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  req.addEventListener("load",callback);
  req.send(data);
};

const loadData = function(){
  const name = document.getElementById("name").value;
  const password = document.getElementById("password").value;
  const data = `name=${name}&password=${password}`;
  sendRequest('POST','/login',submittedData,data);
};

const submittedData = function(){
  let data = this.responseText;
  console.log(data);
}
