<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<html lang="ru">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="resources/css/active.css" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Serif:wght@700&family=Roboto:wght@300;400;500&display=swap"
      rel="stylesheet"
    />
    <title>Электронный Журнал</title>
  </head>

  <body>
    <header>
                               <form  action="/group" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">  Назад </a> </form>
       <a href="/aboutCurator?groupId=${group.id}">Личная информация</a>
                             <a href="/">Выйти</a>

    </header>

    <section class="uspev">
      <a href="/progress?id=1">Успеваемость</a>
       <form  action="/studentsList" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">  Список группы </a> </form>
      <a href="/group">Информация о группе</a>
    </section>

    <section>
      <div style="display: flex; gap: 20px; align-items: center">
        <h1>Актив учебной группы</h1>
        <div
          class="activated"
          style="
            width: 97px;
            padding: 10px;
            background: #fff;
            border-radius: 20px;
            border: 1px solid #000;
            cursor: pointer;
          "
        >
       <a onclick="showFields()">Назначить</a>   
        </div>
      </div>

      <br />
     
      <div>Староста: <span> ${group.head.surname} ${group.head.name} ${group.head.patronymic} </span></div>
      <img src="img/Rectangle 21.png" alt="" /><br /><br />
      <div>Заместитель старосты: <span>${group.vicehead.surname} ${group.vicehead.name} ${group.vicehead.patronymic}   </span></div>
      <img src="img/Rectangle 23.png" alt="" /><br /><br />
      <div>Профорг: <span>${group.profOrg.surname} ${group.profOrg.name} ${group.profOrg.patronymic}  </span></div>
      <img src="img/Rectangle 25.png" alt="" />
    </section>
<form:errors id="formError" style="display: none" class="form-control" path="username">    Один и тот же студент не может быть...</form:errors>
      <form:form id="activeform" action="/addActive?groupId=${group.id}" style="display: none" modelAttribute="group"  method="post" class="no-show">
          Выберите старосту
      <form:select id="starosta"
       path="head.surname">
          <form:option value="${group.head.id}"> --Выберите из списка-- </form:option>
          <form:options items="${students}"></form:options>
    </form:select><br/>
     Выберите заместителя старосты
         <form:select id="zamstarosta" path="vicehead.surname">
      <form:option value="${group.vicehead.id}"> --Выберите из списка-- </form:option>
          <form:options  items="${students}"></form:options>
    </form:select><br/>  
      Выберите профорга 
      <form:select id="proforg"
         path="profOrg.surname">
         <form:option value="${group.profOrg.id}"> --Выберите из списка-- </form:option>
          <form:options items="${students}"></form:options>
    </form:select><br/>
      
      <button onclick="check()" class="btn btn-success" type="submit">Добавить</button>
    </form:form>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
function showFields() {
        document.getElementById("activeform").style.display = "block";
}
</script>
<script>
function check() {
    if (document.getElementById("starosta").value==document.getElementById("zamstarosta").value)
    { document.getElementById("formError").style.display = "block";
        alert("dfghj");
        document.getElementById("activeForm").action=none;
    }
}
</script>
  </body>
</html>
