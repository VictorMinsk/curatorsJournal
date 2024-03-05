<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html lang="ru">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="resources/css/registration.css" />
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
      <form:form method="POST" modelAttribute="userForm">
      <div class="row">
        <div class="col no-show">
          <h1>Регистрация</h1>
              <div>
      <form:input class="form-control" type="text" path="username" placeholder="Логин"
                  autofocus="true"></form:input>
      <form:errors class="form-error" path="username"></form:errors>
          <h5 class="form-error">  ${usernameError}</h5>
    </div>
    <br>
    <div>
      <form:input class="form-control" type="password" path="password" placeholder="Пароль"></form:input>
    </div>
    <br>
    <div>
      <form:input class="form-control" type="password" path="passwordConfirm"
                  placeholder="Подтвердите пароль"></form:input>
      <form:errors class="form-error" path="password"></form:errors>
      <h5 class="form-error">  ${passwordError}</h5>
        <br>
            <button class="btn btn-success" type="submit">
              Зарегистрироваться
            </button>
        </div>
        </div>

  </form:form>
          
    </div>
       </div>

    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="src/js/main.js"></script>
       </body>
</html>
