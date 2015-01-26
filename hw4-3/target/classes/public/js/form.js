/**
 * Created by Akarsh Nagariya on 1/15/2015.
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