<!DOCTYPE html>

<html>
  <head>
    <title>Home</title>
    <style type="text/css">
      .label {text-align: right}
      .error {color: red}
    </style>
  </head>

  <body>
   <#if username??>
       Welcome ${username} <a href="/logout">Logout</a> | <a href="/">Blog Home</a>

       <p>
   </#if>
<p>
<ul>

<li><a href="/consignment">Consignment</a></li>
<li>
<a href="/challan">Challan</a>
</li>
<li>
<a href="/unloading">Unloading</a>
</li>

<li>
<a href="/gatepass">Gate Pass</a>
</li>

  </body>

</html>
