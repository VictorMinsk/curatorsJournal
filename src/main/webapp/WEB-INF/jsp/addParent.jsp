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
        <form  action="/studentCard" method="post">
                      <input type="hidden" name="studentId" value="${student.id}"/>
                        <input type="hidden" name="studentId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">Назад </a> </form>
   <a href="/aboutCurator?groupId=${group.id}">Личная информация</a>
                             <a href="/">Выйти</a>
    </header>

    <section>
      <h1>Добавить родителя для студента ${student.surname} ${student.name} ${student.patronymic}</h1>
      <br /><br /><br />

      <form:form action="/addParent?studentId=${student.id}" modelAttribute="parent" method="post">
          <form:input
           
          class="form-control"
          type="text"
          name="relation"
          id="relation"
          path="relation"
          placeholder="Введите степень родства (отношение)?????"
       />
                  <select class="form-control" name="relationList" onChange="combo(this, 'relation')">
   <option>Мать</option>
   <option>Отец</option>
   <option>Опекун</option>
 </select>
        <br />
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
          name="address"
            path="address"
          id="address"
          placeholder="Введите место жительства"
        />
        <br />
        <form:textarea
          class="form-control"
          name="placeOfWork"
          path="placeOfWork"
          id="placeOfWork"
          placeholder="Введите место работы"
        />
        <br />
        <form:input
           class="form-control phone1"
          type="tel"
          path="phoneNumber"
          name="phoneNumber"
          id="phoneNumber"
          placeholder="Введите номер телефона"
        />
        <br />
        <button class="btn btn-success" type="submit">Добавить</button>
      </form:form>
    </section>
       <form  action="/studentCard" method="post">
                      <input type="hidden" name="studentId" value="${student.id}"/>
                      <button class="btn btn-success" onclick="this.parentNode.submit()">Отмена </button> </form>
 <script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>
<script>
    $(".phone1").mask("+375(99)999-99-99");
    </script>
    <script>
   function combo(thelist, theinput) {
     theinput = document.getElementById(theinput);
     var idx = thelist.selectedIndex;
     var content = thelist.options[idx].innerHTML;
     theinput.value = content;
 }
    </script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </body>
</html>
