/**
 * Created by Akarsh Nagariya on 1/19/2015.
 */

$(function() {
    var index = [
    "Akarsh",
    "Akanksha",
    "Suyash",
    "Prashant",
    "Elephant",
    "Take",
    "Priyam",
    "Chatrpur",
    "Ant",
    "England",
    "Russia",
    "Synchronization",
    "Taken1",
    "Taken2",
    "Taken3",
    "Java",
    "Perl",
    "PHP",
    "Shailesh",
    "Dharmendra",
    "Netbeans",
    "Navneet",
    "Aspiring",
    "Inspiration",
    "Tahoma",
    "text",
    "Form",
    "Abhishek",
    "Alpha",
    "Beta",
    "Gamma",
    "Hcl",
    "Thyuto"

    ];
    $( "#f,#t" ).autocomplete({
    source: index
    });
    });


$(function() {
    $( "#datepicker,#bo" ).datepicker();
});
var changeYear = $( "#datepicker,#bo" ).datepicker( "option", "changeYear" );

// Setter
$( "#datepicker,#bo" ).datepicker( "option", "changeYear", true );