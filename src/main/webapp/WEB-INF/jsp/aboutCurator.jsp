<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="resources/css/about.css" />
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
  
                             <a href="/">Выйти</a>
    </header>

    <section>
      <h1>Личная информация куратора</h1>
      <br />
      <div class="info">
        <img src="img/Rectangle 41.png" alt="" />
        <div>
          <p>${curator.surname} ${curator.name} ${curator.patronymic}</p>
          <p>${curator.position}, ${curator.rank}</p>
          <p>${curator.email}</p>
          <p>Учебные группы</p>
             <c:forEach items="${groupList}" var="group">
          <p>${group.groupNumber}</p>
                  </c:forEach>

        </div>
      </div>
    </section>
    <section>
      <p class="title">Замечания</p>
      <div class="flex">
        <p>Дата <br />29 апреля 2022</p>
        <p>Кто оставил <br />Диковицкий Р.М.</p>
        <p>Суть <br />Не выключены пк в аудитории 405 после занятия</p>
      </div>
    </section>
   <form action="/showEditCurator" method="post">
                       <input type="hidden" name="curatorId" value="${curator.id}"/>
                          <input type="hidden" name="groupId" value="${group.id}"/>
    <button class="btn btn-success" type="submit">Редактировать</button>
</form>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </body>
</html>
