<!DOCTYPE html>

<html>
  <head>
    <title>Welcome</title>
    <style type="text/css" media="screen">
    #mymenu { margin: 0; padding: 0; }
    #mymenu li { margin: 0; padding: 0;
    list-style: none; float: left; }
    #mymenu li a { display: block; margin: 0 1px 0 0; padding: 4px 10px; width: 80px; background:
    #bbbaaa; color: #ffffff; text-align: center; }
    #mymenu li a:hover { background: #aaddaa }
    #mymenu ul { position: absolute; visibility: hidden; margin: 0; padding: 0; background:
    #eeebdd; border: 1px solid #ffffff }
    #mymenu ul a { position: relative; display: block; margin: 0; padding: 5px 10px; width: 80px;
    text-align: left;  background: #eeebdd;  color: #000000; }
    #mymenu ul a:hover { background: #aaffaa; }
    </style>

  <script type="text/javascript" > <#include "js/test3.js"> </script>
<#-- <script type="text/javascript" src="/js/test.js"></script> -->
  </head>

  <body>
    Welcome ${username}
<p>
<ul id="mymenu">
    <li><a href="http://siteground.com/">Home</a></li>
    <li>
        <a href="http://www.siteground.com/tutorials/" onmouseover="openelement('menu2')">Tutorials</a>
        <ul id="menu2" onmouseover="keepsubmenu()" onmouseout="closeelement()">
            <a href="http://www.siteground.com/tutorials/cssbasics/index.htm">CSS</a>
            <a href="http://www.siteground.com/tutorials/flash/index.htm">Flash</a>
        </ul>
    </li>
    <li>
        <a href="#" onmouseover="openelement('menu3')" onmouseout="closeelement()">More</a>
        <ul id="menu3" onmouseover="keepsubmenu()" onmouseout="closeelement()">
            <a href="http://www.siteground.com/about_us.htm">About Us</a>
            <a href="http://www.siteground.com/contact_us.htm">Contact Us</a>
        </ul>
    </li>
</ul>
<div >
</div>

<form action="/welcome" method="GET" >
<input type="submit" name="sub"  value="Submit">
<input type="submit" name="sea"  value="search">
<input type="submit" name="upd"  value="update">
</form>
  </body>

</html>
