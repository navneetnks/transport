<!DOCTYPE html>

<html>
  <head>
    <title>Login</title>
    <style type="text/css">
      .label {text-align: right}
      .error {color: red}
    </style>

  </head>

  <body>

    <h2>Login</h2>
    <form method="post">
      <table>
        <tr>
          <td class="label">
            First Name
          </td>
          <td>
            <input type="text" name="firstName" value="${firstName}"> </input>

        </tr>

        <tr>
          <td class="label">
            Last Name
          </td>
          <td>
           <input type="text" name="lastName" value="${lastName}"> </input>
          </td>

        </tr>

      </table>

      <input type="submit"> </input>
    </form>

  </body>

</html>
