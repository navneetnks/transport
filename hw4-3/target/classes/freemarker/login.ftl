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
    Need to Create an account? <a href="/signup">Signup</a><p></p>
    <h2>Login</h2>
    <form method="post">
      <table>
        <tr>
          <td class="label">
            Username
          </td>
          <td>
            <input type="text" name="username" value="${username}"> </input>
          </td>
          <td class="error">
          </td>
        </tr>

        <tr>
          <td class="label">
            Password
          </td>
          <td>
            <input type="password" name="password" value=""> </input>
          </td>
          <td class="error">
	    ${login_error}
            
          </td>
        </tr>

      </table>

      <input type="submit"> </input>
    </form>
    <h2>Spectacular Mountains</h2>
    <img src="pic_mountain.jpg" alt="Mountain View" style="width:304px;height:228px" />

     <h2>A </h2>
        <img src="a.jpg" alt="a" style="width:304px;height:228px" />
        <h2>b </h2>
                <img src="b.png" alt="b" style="width:304px;height:228px" />
        <h2>c </h2>
                        <img src="c.png" alt="c" style="width:304px;height:228px" />
  </body>

</html>
