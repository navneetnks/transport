/**
 * Created by Akarsh Nagariya on 1/16/2015.
 */
function findTotal(){
    var arr = document.getElementsByName('qty');
    var tot=0;
    for(var i=0;i<arr.length;i++){
        if(parseInt(arr[i].value))
            tot += parseInt(arr[i].value);
    }
    document.getElementById('total').value = tot;
}   var alert= alert(tot);

function clearInput(element){
    element.value="";
}

function myFunction() {
    var table = document.getElementById("myTable");
    var row = table.insertRow(0);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var textf1 = '<div id="text1"><label><input placeholder="Please Enter Your Name" class="inputs" type="text"  id="text1" name="firstname" /></div>';
    var textf2 = '<div id="text2"><input type="text" placeholder="Please Enter Your Surname" class="inputs"  id="text2" name="lastname" /></div>';
    var textf3 = '<div id="text3"><input type="text" placeholder="Please Enter Your Add" class="inputs"  id="text3" name="address" /></div>';
    cell1.innerHTML = textf1;
    cell2.innerHTML = textf2;
    cell3.innerHTML = textf3;
}

/*function first(){
 var x = document.getElementById("myTable");
 var inputElements = x.querySelectorAll('select,input,textarea');
 for(var i = 0; i < inputElements.length; i++){

 var take =inputElements[i].value;



 }

 }
 function alert() {
 document.getElementsByTagName("input");
 alert(take[i]);
 }
 */

function first(){
    var x = document.getElementById("myTable");
    var inputElements = x.querySelectorAll('select,input,textarea');
    for(var i = 0; i < inputElements.length; i++){

        alert(inputElements[i].value);
    }

}




/*function first(){
 var x = table.insertRow(0);
 var textn = "";
 var texts= "";
 var i;
 var a;
 for (i = 0; i < x.length ;i++) {
 textn += text1[i].value + "<br>";
 }
 for (a = 0; i < x.length ;i++) {
 texts += text2[i].Name + "<br>";
 }
 alert("First Name:"+textn+"Second Name:"+texts);

 /*var table1 = document.getElementById("myTable").length;
 for(var row = 0; row <= table1;row++ ) {
 alert("Hello" + text1.value(i) + "Your Surname Is " + text2.value(i) + " You Have Chosen");
 }
 return myFunction()
 }*/




