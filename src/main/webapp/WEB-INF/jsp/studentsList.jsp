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
      <h1>Список группы ${group.groupNumber}</h1>
      <div class="block">
       
        <table border="1" cellpadding="5">
        <tr>
            <th style="width: 20%">Фамилия</th>
            <th style="width: 20%">Имя</th>
             <th style="width: 20%">Отчество</th>
            <th style="width: 20%">Дата рождения</th>
            <th style="width: 20%">Номер телефона</th>
             <th style="width: 20%">Электронная почта</th>
            <!--th>Номер паспорта</th>
            <th>Гражданство</th>
            <th>Оконченные УО</th>
             <th>Место и адрес проживания в период обучения</th>
            <th>Хронические заболевания</th>
            <th>Группа по физической культуре</th-->
        </tr>
        <c:forEach items="${studentList}" var="student">
             
            <td> <form  action="/studentCard" method="post">
                      <input type="hidden" name="studentId" value="${student.id}"/>
                        <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">${student.surname} </a> </form></td>
             
            <td>${student.name}</td>
            <td>${student.patronymic}</td>
            <td>${student.birthDate}</td>
            <td>${student.phone}</td>
            <td>${student.email}</td>
              <!--td>${student.passport}</td>
            <td>${student.citizenship}</td>
              <td>${student.graduated}</td>
                <td>${student.placeOfResidence}</td>
                  <td>${student.chronicDiseases}</td>
                    <td>${student.PEGroup}</td-->
        </tr>
        </c:forEach>
    </table>  
           
             <a href="/addStudentForm?groupId=${group.id}">
                   
          <svg
            style="cursor: pointer"
            fill="#000000"
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 50 50"
            width="50px"
            height="50px"
          >
            <path
              d="M 25 2 C 12.309295 2 2 12.309295 2 25 C 2 37.690705 12.309295 48 25 48 C 37.690705 48 48 37.690705 48 25 C 48 12.309295 37.690705 2 25 2 z M 25 4 C 36.609824 4 46 13.390176 46 25 C 46 36.609824 36.609824 46 25 46 C 13.390176 46 4 36.609824 4 25 C 4 13.390176 13.390176 4 25 4 z M 24 13 L 24 24 L 13 24 L 13 26 L 24 26 L 24 37 L 26 37 L 26 26 L 37 26 L 37 24 L 26 24 L 26 13 L 24 13 z"
            />
          </svg>
        </a>
      
    </section>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </body>
</html>
