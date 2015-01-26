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
    var table1 = document.getElementById("myTable").length;
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
    cell3.appendChild(row);
}
function addRow(){
    var table=document.getElementById('countTable');
    var tbody=document.getElementsByTagName('TBODY')[0];

    var row=document.createElement('TR');
    var cell1 = document.createElement('TD');
    var cell2 = document.createElement('TD');
    var cell3 = document.createElement('TD');
    var cell4 = document.createElement('TD');
    var cell5 = document.createElement('TD');

    var cell1value='';
    cell1value+='<div name="text1" id="text1"><input class="inputs" type="text"  id="text1" name="input" /></div>';

    var cell2value='';
    cell2value+='<div name="text2" id="text2"><input class="inputs" type="text"  id="text1" name="input" /></div>';

    var cell3value='';
    cell3value+='<div name="text3" id="text3"><input class="inputs" type="text"  id="text1" name="input" /></div>';

    var cell4value='';
    cell4value+='<div name="text4" id="text4"><input class="inputs" type="text"  id="text1" name="input" /></div>';

    var cell5value='';
    cell5value+='<div name="text5" id="text5"><input class="inputs" type="text"  id="text1" name="input" /></div>';



    cell1.innerHTML=cell1value;
    cell2.innerHTML=cell2value;
    cell3.innerHTML=cell3value;
    cell4.innerHTML=cell4value;
    cell5.innerHTML=cell5value;

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);

    tbody.appendChild(row);
    //alert(table+' '+row+' ');
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




