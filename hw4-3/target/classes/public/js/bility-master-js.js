/**
 * Created by Akarsh Nagariya on 1/16/2015.
 */
function startCalc(){
    interval = setInterval("calc()",1);}



function calc(){
    one = document.form.freight.value;
    two = document.form.hamali.value;
    three=document.form.surcharge.value;
    fourth=document.form.stSurcharge.value;
    fifth=document.form.stCharge.value;
    six=document.form.riskCharge.value;
    seven=document.form.doorDel.value;
    eight=document.form.miscCharge.value;
    document.form.total.value = (one * 1) + (two * 1) + (three * 1) + (fourth * 1)+(fifth * 1)+(six * 1)+(seven * 1)+(eight * 1);


}



function stopCalc(){
    clearInterval(interval);}






function addRow() {
    var tbody=document.getElementsByTagName('TBODY')[0];
    var table = document.getElementById('countTable');

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);
    var counts=rowCount-1;

    var cell1 = row.insertCell(0);
    var firstName = document.createElement("div");
    var firstInput = document.createElement("input");
    firstInput.type = "text";
    firstInput.className = "inputs";
    firstInput.value = "";
    firstInput.id = "id"+rowCount;
    firstInput.name="firstName"+rowCount;
    cell1.appendChild(firstInput);

    var cell2 = row.insertCell(1);
    var secondName = document.createElement("div");
    var secondInput = document.createElement("input");
    secondInput.type = "text";
    secondInput.className = "inputs";
    secondInput.value = "";
    secondInput.id = "id"+rowCount;
    secondInput.name="secondName"+rowCount;
    cell2.appendChild(secondInput);


    var cell3 = row.insertCell(2);
    var thirdName = document.createElement("div");
    var thirdInput = document.createElement("input");
    thirdInput.type = "text";
    thirdInput.className = "inputs";
    thirdInput.value = "";
    thirdInput.id = "id"+rowCount;
    thirdInput.name="thirdName"+rowCount;
    cell3.appendChild(thirdInput);

    var cell4 = row.insertCell(3);
    var fourthName = document.createElement("div");
    var fourthInput = document.createElement("input");
    fourthInput.type = "text";
    fourthInput.className = "inputs";
    fourthInput.value = "";
    fourthInput.id = "id"+rowCount;
    fourthInput.name="fourthName"+rowCount;
    cell4.appendChild(fourthInput);

    var cell5 = row.insertCell(4);
    var fifthName = document.createElement("div");
    var fifthInput = document.createElement("input");
    fifthInput.type = "text";
    fifthInput.className = "inputs";
    fifthInput.value = "";
    fifthInput.id = "id"+rowCount;
    fifthInput.name="fifthName"+rowCount;
    cell5.appendChild(fifthInput);





}









