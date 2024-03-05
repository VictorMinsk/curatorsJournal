<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   s
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
                            <form  action="/group" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">  Назад </a> </form>
<a href="/aboutCurator?groupId=${group.id}">Личная информация</a>
                             <a href="/">Выйти</a>
    </header>
       <h1 style="text-align: center; margin-top: 30px">
      Учет идеологической и воспитательной работы
    </h1>
<section
      style="
        margin: 30px auto 0;
        max-width: 1200px;
        display: flex;
        justify-content: space-between;
      "
    >
      <table border="1" cellpadding="5">
             <tr>
      <th style="width: 185px">Срок выполнения</th>
      <th style="width: 955px">Содержание работы</th>
      </tr>
      <c:forEach items="${ideologicalWorkList}" var="iw">
        <tr>
             <td>${iw.deadline}</td>
            <td>${iw.content}</td>
        </tr>
        </c:forEach>
      </table>
    </section>
      </br>
          <form:form id="addForm" modelAttribute="ideologicalWork" class="no-show" action="/addIdWork?groupId=${group.id}" method="post" style="text-align: center; width: 600px; display:none">
          <form:input
              class="form-control"
              type="date"
              name="date"
              id="date"
              path="deadline"
              placeholder="Введите срок выполнения"
            />
            <br />
            <form:textarea
            style="height: 600px"
              class="form-control"
              name="kurator"
              id="kurator"
              path="content"
              placeholder="Введите содержание работы"
            />
            <br />
            <button class="btn btn-success" type="submit">Добавить</button>
          </form:form>
      <div class="activated" onclick="showFields()" style="text-align:center; margin-top: 25px; display:block"><svg
            style="cursor: pointer"
            fill="#000000"
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 50 50"
            width="50px"
            height="50px">
            <path
              d="M 25 2 C 12.309295 2 2 12.309295 2 25 C 2 37.690705 12.309295 48 25 48 C 37.690705 48 48 37.690705 48 25 C 48 12.309295 37.690705 2 25 2 z M 25 4 C 36.609824 4 46 13.390176 46 25 C 46 36.609824 36.609824 46 25 46 C 13.390176 46 4 36.609824 4 25 C 4 13.390176 13.390176 4 25 4 z M 24 13 L 24 24 L 13 24 L 13 26 L 24 26 L 24 37 L 26 37 L 26 26 L 37 26 L 37 24 L 26 24 L 26 13 L 24 13 z"/>
            </svg>
            </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script>
function showFields() {
        document.getElementById("addForm").style.display = "block";
}
</script>
  </body>
</html>
