function myFunction() {
    var table = document.getElementById("myTable");
    var table1 = document.getElementById("myTable").length;
    var row = table.insertRow(0);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var textf1 = '<div id="text1"><label>FirstName:</label><input type="text" value="Enter Your Name" id="text1" name="input" /></div>';
    var textf2 = '<div id="text2"><label>SecondName:</label><input type="text" value="Enter Your Surname" id="text2" name="input" /></div>';
    cell1.innerHTML = textf1;
    cell2.innerHTML = textf2;

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



