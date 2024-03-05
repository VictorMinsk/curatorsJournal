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
                      <input type="hidden" name="groupId" value="${group.id}"/>
                      <a onclick="this.parentNode.submit()">Назад </a> </form>
<a href="/aboutCurator?groupId=${group.id}">Личная информация</a>
                             <a href="/">Выйти</a>
    </header>

    <section>
      <h1>${action} студента</h1>
      <br /><br /><br />

      <form:form action="/addStudent?groupId=${group.id}" modelAttribute="student" method="post">
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
          type="date"
          name="birthDate"
            path="birthDate"
          id="date"
          placeholder="Введите дату рождения"
        />
        <br />
           <form:input
          class="form-control phone1"
          type="tel"
          name="phone"
            path="phone"
          id="phone"
          placeholder="Введите номер телефона"
        />
        <br />
          <form:input
          class="form-control"
          type="email"
          name="email"
            path="email"
          id="email"
          placeholder="Введите адрес электронной почты"
        />
        <br />
        <form:input
          class="form-control"
          type="text"
          name="passport"
          path="passport"
          id="passport"
          placeholder="Введите данные паспорта"
        />
        <br />
        <form:input
          class="form-control"
          type="text"
          path="citizenship"
          name="citizenship"
          id="citizenship"
          placeholder="Введите гражданство"
        />
        <br />
        <form:textarea
          class="form-control"
          name="graduated"
          id="graduated"
          path="graduated"
          placeholder="Введите оконченые УО"
        />
        <br />
         <form:textarea
          class="form-control"
          name="place"
          id="place"
          path="placeOfResidence"
          placeholder="Введите место проживания"
        />
        <br />
  <form:textarea
          class="form-control"
          name="disease"
          id="disease"
          path="chronicDiseases"
          placeholder="Введите данные о хронических заболеваниях"
        />
        <br />
        <form:input
          class="form-control"
          type="text"
          name="physical"
          id="physical"
           path="PEGroup"
          placeholder="Введите группу по физкультуре"
        />
          <br /> 
          <form:textarea
             style="height: 400px"
          class="form-control"
          name="individualInformation"
          id="individualInformation"
           path="individualInformation"
          placeholder="Введите индивидуальную информацию"
        />
         <br />
         Пол:
         Мужской
          <form:radiobutton
         path="gender"
         value="true"
        />Женский
           <form:radiobutton
         path="gender"
         value="false"
        />
            <br />
        Член БРСМ
          <form:checkbox
         path="BRSMmember"
         value="true"
        />
            <br />
        Дети-сироты
          <form:checkbox
         path="orphan"
         value="true"
        />
            <br />
        Дети, оставшиеся без попечения родителей
          <form:checkbox
         path="withoutParentCare"
         value="true"
        />
            <br />
        Студенты с особенностями психофизического развития
          <form:checkbox
         path="psychophysical"
         value="true"
        />
            <br />
        Имеющие родителей инвалидов 1, 2 группы
          <form:checkbox
         path="invalidParents"
         value="true"
        />
            <br />
        Из многодетных семей
          <form:checkbox
         path="largeFamily"
         value="true"
        />
            <br />
        Из неполных семей
          <form:checkbox
         path="singleFamily"
         value="true"
        />
           <br />
        Из регионов, пострадавших от катастрофы на Чернобыльской АЭС
          <form:checkbox
         path="affectedRegions"
         value="true"
        />
           <br />
        Из семей, отсленнных из зон радиоактивного загрязнения
          <form:checkbox
         path="expelledFamilies"
         value="true"
        />
           <br />
        Иногородние
          <form:checkbox
         path="outOfTowner"
         value="true"
        />
          <br />
         Проживает:
        С родителями
          <form:radiobutton
         path="residence"
         value="1"
        />
          В общежитии
           <form:radiobutton
         path="residence"
         value="2"
        />
            У родственников
          <form:radiobutton
         path="residence"
         value="3"
        />
           На частной квартире
          <form:radiobutton
         path="residence"
         value="4"
        />
        <br />
        <br />
        <button class="btn btn-success" type="submit">${action1}</button>
      </form:form>
       <form  action="/studentCard" method="post">
                      <input type="hidden" name="studentId" value="${student.id}"/>
                      <input type="hidden" name="groupId" value="${groupId.id}"/>
                      <button class="btn btn-success" onclick="this.parentNode.submit()">Отмена </button> </form>
    </section>
                      <script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>
<script>
    $(".phone1").mask("+375(99)999-99-99");
    </script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </body>
</html>
