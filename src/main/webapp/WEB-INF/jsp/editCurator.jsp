<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="resources/css/pavel.css" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Serif:wght@700&family=Roboto:wght@300;400;500&display=swap"
      rel="stylesheet"
    />
    <title>Электронный Журнал</title>
  </head>

  <body>
    <header>
                            <a href="/aboutCurator?groupId=${group.id}">Назад</a>
     
                             <a href="/">Выйти</a>
    </header>

    <section>
      <h1>Редактировать личную информацию</h1>
      <br /><br /><br />

      <form:form action="/editCurator?groupId=${group.id}" modelAttribute="curator" method="post">
           <form:input
          class="form-control"
          type="number"
          name="id"
          id="id"
          path="id"
          placeholder="id"
         style="display: none"
        /> 
        
        <form:input
          class="form-control"
          type="text"
          name="surname"
          id="surname"
          path="surname"
          placeholder="Введите фамилию"
        />
        <br />
        <form:input
          class="form-control"
          type="text"
          name="name"
           path="name"
          id="name"
          placeholder="Введите имя"
        />
        <br />
        <form:input
          class="form-control"
          type="text"
          name="patronymic"
          id="patronymic"
            path="patronymic"
          placeholder="Введите отчество"
        />
        <br />
        <form:input
          class="form-control"
          type="text"
          name="position"
            path="position"
          id="position"
          placeholder="Введите должность"
        />
        <br />
        <form:input
          class="form-control"
          type="text"
          name="rank"
          path="rank"
          id="rank"
          placeholder="Введите звание"
        />
        <br />
        <form:input
          class="form-control"
          type="email"
          path="email"
          name="email"
          id="email"
          placeholder="Введите адрес электронной почты"
        />
        <br /> 
        <br />
          <input type="checkbox" id="toggle-button" class="toggle-button">
            <label for="toggle-button" class="text">Сменить пароль</label>
            <div id="changePass">
           <form:input readonly="true" class="form-control" type="text" path="user.username" placeholder="Логин"
                  autofocus="true"></form:input>
      <form:errors class="form-error" path="user.username"></form:errors>
          <h5 class="form-error">  ${usernameError}</h5>
    <br>
      <form:input class="form-control" type="password" path="user.password" placeholder="Пароль"></form:input>
    <br>
      <form:input class="form-control" type="password" path="user.passwordConfirm"
                  placeholder="Подтвердите пароль"></form:input>
      <form:errors class="form-error" path="user.password"></form:errors>
      <h5 class="form-error">  ${passwordError}</h5>
            </div>
        <br>
        <br />
        <button class="btn btn-success" type="submit">Сохранить изменения</button>
      </form:form>
    </section>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     <script>
       $(document).ready(function()
{
    $('#changePass').hide();
  $('#toggle-button').change(function() 
  {
    if(this.checked)
    {
        $('#changePass').show();
    }
    else
    {
         $('#changePass').hide();
    }
  });   
});
        </script>
  </body>
</html>
