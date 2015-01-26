<!DOCTYPE html>

<html>
  <head>
    <title>Sign Up</title>
    <style type="text/css">
      .label {text-align: right}
      .error {color: red}
    </style>

  </head>

  <body>
    <#if logged_user??>
        Welcome ${logged_user} <a href="/logout">Logout</a> | <a href="/">Blog Home</a>

        <p>
    </#if>
    <p>
    <h2>Create New Admin User</h2>
    <form method="post">
      <table>



        <tr>
          <td class="label">
            First Name
          </td>
          <td>
            <input type="text" name="firstName" value="${firstName}">
          </td>
          <td class="error">
	    ${firstName_error!""}

          </td>
        </tr>

        <tr>
          <td class="label">
            Last Name
          </td>
          <td>
            <input type="text" name="lastName" value="${lastName}">
          </td>
          <td class="error">
	    ${lastName_error!""}

          </td>
        </tr>

        <tr>
          <td class="label">
            Username
          </td>
          <td>
            <input type="text" name="username" value="${username}">
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
            <input type="password" name="password" value="">
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
            <input type="password" name="verify" value="">
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
  </body>

</html>
