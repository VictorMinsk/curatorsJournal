<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="ru">
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
                         <form  action="/studentsList" method="post">
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">  Назад </a> </form>
<a href="/aboutCurator?groupId=${group.id}">Личная информация</a>
                             <a href="/">Выйти</a>
    </header>
       <form:errors class="form-control" path="username"> ${errorMessage}</form:errors>
     <h5 class="form-error">  ${errorMessage}</h5>
    <section>
             
            <section>
              <br />
                <h2>Карта персонифицированного учёта</h2>
                <br />
                <h4>Фамилия, имя, отчество</h4><p>| ${student.surname} ${student.name} ${student.patronymic}</p>
                <p>Дата рождения | ${student.birthDate}</p>
                <p>Паспортные данные | ${student.passport}</p>
                <p>Гражданство | ${student.citizenship}</p>
                <p>Окончил УО | ${student.graduated}</p>
                <p>Место и адрес проживания в период обучения | ${student.placeOfResidence}</p>
                <br />
                <h4>Сведения о состоянии здоровья</h4>
                <br />
                <p>Хронические заболевания | ${student.chronicDiseases}</p>
                <p>Группа по физической культуре | ${student.PEGroup}</p>
                <br />
                <h4>Сведения о родителях и/или родственников, законных представителях</h4>
                 <c:forEach items="${student.parents}" var="parent">
      <p style="text-align: left">${parent.relation}: ${parent.surname} ${parent.name} ${parent.patronymic} <br />
                ${parent.address} ${parent.placeOfWork} тел: ${parent.phoneNumber}
                <br />
      </p>
        </c:forEach>
                <p style="text-align: center">
                  ФИО; место жительства и/или место пребывания; место работы; занимаемые
                  должости; Телефон; другие сведения
                </p>
                <p>
                    
                </p>
                <br />
                <h4>Индвидульные сведения</h4>
                <br />
                <p style="text-align: center">
                  Участие в научных работах, олимпиадах, студенчиских конференциях,
                  спортивной и общественной жизни вуза, факультета, группы, общежития
                </p>
                <p>${student.individualInformation}</p>
              </section>
              <section>
      <h4>Поощрения студента</h4>
      <div class="block">
       
        <table border="1" cellpadding="5">
        <tr>
            <th style="width: 185px">Дата</th>
            <th style="width: 500px">За какие достижения</th>
             <th style="width: 1000px">Вид поощрения</th>
        </tr>
        <c:forEach items="${student.encouragements}" var="enc">
        <tr>
            <td>${enc.promotionDate}</td>
            <td>${enc.achievements}</td>
            <td>${enc.incentiveType}</td>
        </tr>
        </c:forEach>
        
    </table>  
         <form:form id="addEncForm" modelAttribute="encouragement" class="no-show" action="/addEnc?studentId=${student.id}" method="post" style="margin-top: 30px; text-align: center; width: 1400px; display:none">
              <form:input
              class="form-control"
              type="date"
              name="date"
              id="date"
              path="promotionDate"
              placeholder="Введите дату"
            />
            <br />
            <form:input
              class="form-control"
              type="text"
              name="name"
              id="name"
              path="achievements"
              placeholder="Введите достижения"
            />
            <br />
            <form:input
              class="form-control"
              type="text"
              name="comment"
              id="comment"
              path="incentiveType"
              placeholder="Введите вид поощрения"
            />
            <br />
            <button class="btn btn-success" type="submit">Добавить</button>
          </form:form>
          <div onclick="showEncFields()" class="activated" style="text-align:center; margin-top: 25px;"><svg
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
function showEncFields() {
        document.getElementById("addEncForm").style.display = "block";
}
</script>
      
    </section>
                           <section>
      <h4>Отметки о дисциплинарной ответственности</h4>
      <div class="block">
       
        <table border="1" cellpadding="5">
        <tr>
            <th style="width: 185px">Дата</th>
            <th style="width: 500px">За какой проступок</th>
             <th style="width: 1000px">Вид</th>
        </tr>
        <c:forEach items="${student.disciplinaryLiabilities}" var="disc">
        <tr>
            <td>${disc.promotionDate}</td>
            <td>${disc.crime}</td>
            <td>${disc.type}</td>
        </tr>
        </c:forEach>
        
    </table>  
         <form:form id="addDiscForm" modelAttribute="disciplinaryLiability" class="no-show" action="/addDisc?studentId=${student.id}" method="post" style="margin-top: 30px; text-align: center; width: 1400px; display:none">
              <form:input
              class="form-control"
              type="date"
              name="date"
              id="date"
              path="promotionDate"
              placeholder="Введите дату"
            />
            <br />
            <form:input
              class="form-control"
              type="text"
              name="crime"
              id="crime"
              path="crime"
              placeholder="Введите проступок"
            />
            <br />
            <form:input
              class="form-control"
              type="text"
              name="type"
              id="type"
              path="type"
              placeholder="Введите вид отвественности"
            />
            <br />
            <button class="btn btn-success" type="submit">Добавить</button>
          </form:form>
          <div onclick="showDiscFields()" class="activated" style="text-align:center; margin-top: 25px;"><svg
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
function showDiscFields() {
        document.getElementById("addDiscForm").style.display = "block";
}
</script>
              </div>
                <form action="/editStudent" method="post">
                       <input type="hidden" name="studentId" value="${student.id}"/>
                        <input type="hidden" name="groupId" value="${group.id}"/>
    <button class="btn btn-success" type="submit">Редактировать</button>
</form>
                 <form id="btnDelete" action="/delStudent" method="post">
                      <input type="hidden" name="studentId" value="${student.id}"/>
  <button class="btn btn-success"  onclick="confirmDelete()" type="submit">Удалить</button>
</form>
    <button class="btn btn-success"  onclick="location.href='/addParentForm?studentId=${student.id}'" type="submit">Добавить родителя</button>
     </br>       
              <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
               <script>
function confirmDelete() {
    if (confirm("Вы действительно хотите удалить карточку студента?")) {
        location.href='/delStudent?id=${student.id}';
        $("#btnDelete").submit();
    }
}
</script>
        </div>
    </section>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </body>
</html>
