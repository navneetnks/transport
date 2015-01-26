<!DOCTYPE html>

<html>
  <head>
    <title>Sign Up</title>
    <style type="text/css">
      .label {text-align: right}
      .error {color: red}
    </style>
    <script>
    function preFill(){
        document.getElementsByName('b1').value="text1";
        document.getElementsByName('b2').value="text2";
    }
    </script>

  </head>

  <body onload=preFill()>

    Already a user? <a href="/login">Login</a><p>
    <h2>Signup</h2>
    <form method="post">
      <table>







        <tr>
          <td class="label">
            Username
          </td>
          <td>
            <input type="text" name="a1" value="${a1}">
          </td>
          <td class="error">
	    ${username_error!""}

          </td>
        </tr>

        <tr>
          <td class="label">
            Password
          </td>
          <td>
            <input type="text" name="b1" value="">
          </td>
          <td class="error">
	    ${password_error!""}
            
          </td>
        </tr>

        <tr>
          <td class="label">
            Verify Password
          </td>
          <td>
            <input type="text" name="b2" value="">
          </td>
          <td class="error">
	    ${verify_error!""}
            
          </td>
        </tr>

        <tr>
          <td class="label">
            Email (optional)
          </td>
          <td>
            <input type="text" name="email" value="${email}">
          </td>
          <td class="error">
	    ${email_error!""}
            
          </td>
        </tr>
      </table>

      <input type="submit">
    </form>

    <input type="submit" onClick="preFill()">
  </body>

</html>
