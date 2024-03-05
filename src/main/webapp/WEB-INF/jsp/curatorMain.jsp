<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<html lang="ru">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="resources/css/group.css" />
    <link rel="preconnect" href="https://fonts.gstatic.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Serif:wght@700&family=Roboto:wght@300;400;500&display=swap"
      rel="stylesheet"
    />
    <title>Электронный Журнал</title>
  </head>

  <body>
    <header>
   
      <a href="/aboutCurator?groupId=${selGroup.id}">Личная информация</a>
      <h4>${pageContext.request.userPrincipal.name}</h4>
            <a href="/logout">Выйти</a>
    </header>
             
                   <c:choose>
                       <c:when test="${emp==true}">
                           <h1>У Вас нет курируемых групп</h1>
                                       </c:when>
                       <c:otherwise>
                             <div class="tab">
                      <c:forEach items="${groupsList}" var="g">
                          <button class="tablinks" onclick="openTab(event, ${g.groupNumber})">${g.groupNumber}</button>
      </c:forEach>    
</div>
    <section>  
         <c:forEach items="${groupsList}" var="group">
           <c:choose> 
                 <c:when test="${group.id==selGroup.id}">
                     <div id="${group.groupNumber}" class="tabcontent">
                     </c:when>
                     <c:otherwise>
                          <div id="${group.groupNumber}" class="tabcontent"  style="display: none">
                     </c:otherwise>
                          </c:choose>
      <h1>Информация о группе ${group.groupNumber}</h1>

      <div class="list">
          <form  action="/character" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()"> Психолого-педагогическая<br />
          характеристика учёбной<br />
          группы</a> </form>
          <form  action="/curator-time" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()"> Учёт идеологической и<br />
          воспитательной работы<br />
          куратора учёбной группы </a> </form>
                       <form  action="/clock" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">  Учёт информационных<br />
          часов </a> </form>
                      <form  action="/tradic" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">  Традиции ВУЗА,<br />
          Факультета, Группы </a> </form>
        <form  action="/healthCard" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">  Карта здоровья </a> </form>
          
   <form  action="/progress" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">  Учет итоговой успеваемости </a> </form>
          <form  action="/studentsList" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">  Список группы </a> </form>
                      
                         <form  action="/active" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">Актив учебной группы </a> </form>
      </div>
      </div>
                       </c:forEach>  
                         </c:otherwise>
                     </c:choose>
    </section>
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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </body>
</html>
