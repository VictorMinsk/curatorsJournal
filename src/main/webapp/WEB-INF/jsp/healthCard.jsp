<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<html lang="ru">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="resources/css/list.css" />
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

    <section>
      <h1>Карта здоровья студентов</h1>
      <div class="block">
       
        <table border="1" cellpadding="5">
        <tr>
            <th>Фамилия имя отчество</th>
            <th>Пропущено занятий</th>
             <th>Примечания</th>
        </tr>
        <c:forEach items="${studentList}" var="student">
        <tr>
           <c:if test="${student.healthCards.size()!=0}">
            <td>${student.surname} ${student.name} ${student.patronymic}</td>
            <td>${student.healthCards.get(0).missed}</td>
              <td>${student.healthCards.get(0).notes}</td>
            </c:if>
        </tr>
        </c:forEach>
        
    </table>  

      
    </section>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </body>
</html>
