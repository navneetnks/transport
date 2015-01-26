/**
 * Created by Akarsh Nagariya on 1/12/2015.
 */
var text = '{"employees":[' +
    '{"firstName":"Akarsh","lastName":"Nagariya","Address":"199 Purani Pasrat","id":"1"  },' +
    '{"firstName":"Anna","lastName":"Smith","Address":"183 Tipu Sultan marg","id":"2" },' +
    '{"firstName":"Peter","lastName":"Jones""Address":"163 Sarafa Bazaar","id":"3" }]}';

obj = JSON.parse(text);
document.getElementById("demo").innerHTML = obj.employees[2].id +" "+ obj.employees[2].firstName + " " + obj.employees[2].lastName + " " + obj.employees[2].Address;


