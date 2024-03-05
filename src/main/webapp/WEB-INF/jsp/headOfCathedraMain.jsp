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
           <form  action="/aboutHeadOfCathedra" method="post">
           
                      <input type="hidden" name="headId" value="${headOfDepartment.id}"/>
                      <a onclick="this.parentNode.submit()">Личная информация </a> </form>
                          <tab>
                             <a href="/">Выйти</a>
    </header>
                      <div class="tab">
  <button class="tablinks active" onclick="openTab(event, 'Specialities')">Специальности</button>
  <button class="tablinks" onclick="openTab(event, 'Curators')">Кураторы</button>
  <button class="tablinks" onclick="openTab(event, 'Tokyo')">Tokyo</button>
</div>
                      </br>
<div id="Specialities" class="tabcontent">
 <h1 style="text-align: center; margin-top: 30px">
      Список специальностей кафедры ${cathedra.title}
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
      <th style="width: 285px">Код</th>
      <th style="width: 185px">Hазвание</th>
      <th style="width: 385px">Группы</th>
      <tr>
      <c:forEach items="${cathedra.specialities}" var="s">
        <tr>
             <td>${s.code}</td>
             <td><a href="/disciplinesList?specId=${s.id}">${s.title}</a></td>
            <td> <c:forEach items="${s.groups}" var="g">
                    ${g.groupNumber}</br>
                    </c:forEach></td>
        </tr>
      </c:forEach>    
          </table>
    </section>
                      </div>
<div id="Curators" class="tabcontent" style="display: none">
    <h1 style="text-align: center; margin-top: 30px"> Список кураторов кафедры ${cathedra.title}
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
      <th style="width: 285px">Фамилия</th>
      <th style="width: 185px">Hазвание</th>
      <th style="width: 385px">Группы</th>
      <tr>
      <c:forEach items="${cathedra.curators}" var="c">
        <tr>
             <td>${c.surname}</td>
             <td>${c.surname}</td>
             <td> <c:forEach items="${curatorService.getGroups(c.id)}" var="g">
                    ${g.groupNumber}</br>
                    </c:forEach></td>
        </tr>
      </c:forEach>    
          </table>
    </section>
      <form action="/addCuratorForm" method="post">
                      <input type="hidden" name="cathedraId" value="${cathedra.id}"/>
  <button class="btn btn-success" type="submit">Добавить куратора</button>
</form>
  </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>function openTab(evt, cityName) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the link that opened the tab
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}</script>
  </body>
</html>
