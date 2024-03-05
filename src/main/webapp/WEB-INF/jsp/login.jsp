<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html lang="ru">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="resources/css/style.css" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Serif:wght@700&family=Roboto:wght@300;400;500&display=swap"
      rel="stylesheet"
    />
    <title>Электронный Журнал</title>
  </head>

  <body>
    <div class="container">
        <div class="col show">
          <h1>Войти</h1>
          <br />
        <span id="e_login" class="form-error" style="display: none; color: #c00;">Неверный логин и/или пароль</span></td></tr>
         <form method="POST" action="/login">
            <input class="form-control" name="username" type="text" placeholder="Введите логин"
             autofocus="true"/>
            <br />
      <input id="myInput" class="form-control" name="password" type="password" placeholder="Введите пароль"/>
     <p> <input type="checkbox" onclick="showPassword()">Показать пароль</p>
      
            <br />
            <button class="btn btn-success" type="submit" >Войти</button>
          </form>
          <br>
          <br>
          <p><a class="registr-link" href="/registration">Настройка программы для первого использования</a></p>
        </div>
      </div>
    </div>

    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        function showPassword() {
  var x = document.getElementById("myInput");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
    </script>
  </body>
</html>
