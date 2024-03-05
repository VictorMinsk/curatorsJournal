<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
  <!DOCTYPE html>
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
                              <form  action="/tradic" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">  Назад </a> </form>
<a href="/aboutCurator?groupId=${group.id}">Личная информация</a>
                             <a href="/">Выйти</a>
    </header>
 <h1 style="text-align: center; margin-top: 30px">
      ${action} традицию
    </h1>
 
          <form:form action="/addTradic?groupId=${group.id}" modelAttribute="tradition" method="post" style="margin-top: 30px; text-align: center; width: 1400px;">
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
              name="name"
              id="name"
              path="name"
              placeholder="Введите название"
            />
            <br />
            <form:input
              class="form-control"
              type="date"
              name="date"
              id="date"
              path="hostDate"
              placeholder="Введите дату"
            />
            <br />
            <form:input
              class="form-control"
              type="text"
              name="form"
              id="form"
              path="formOfPart"
              placeholder="Форма участия группы"
            />
            <br />
              <form:textarea
            style="height: 400px"
              class="form-control"
              name="comment"
              id="comment"
              path="notes"
              placeholder="Введите Примечания"
            />
            <br />
            <button class="btn btn-success" type="submit">${action1}</button>
          </form:form>
         

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

  </body>
</html>
