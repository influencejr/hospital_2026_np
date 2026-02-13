<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hospital | Створення призначення</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/create-app.css">
    <link rel="stylesheet" href="/css/navbar.css">
</head>
<body>


<#include "navbar.ftl">


<div class="medical-form-container">
    <h2>Нове призначення</h2>




    <form action="/create_appointment/doctor_id/${doctorId}" method="POST">

        <div class="form-group">
            <label for="type">Тип призначення</label>
            <select id="type" name="appointmentType" class="form-control">
                <option value="" disabled selected>Оберіть тип...</option>
                <option value="consultation">Консультація</option>
                <option value="operation">Операція</option>
                <option value="examination">Обстеження</option>
                <option value="therapy">Видача ліків</option>
            </select>
        </div>

        <div class="form-group">
            <label for="description">Опис призначення</label>
            <textarea id="description" name="description" class="form-control" placeholder="Введіть деталі призначення..."></textarea>
        </div>
        <div class="form-group">
            <label for="description">Час призначення (Година:хвилини)</label>
            <textarea id="appointmentTime" name="appointmentTime" class="form-control" placeholder="Введіть час запису..."></textarea>
        </div>
        <div class="form-group">
            <label>Доступні часи для запису: </label>
            <div class="slots-list">
                <#list slots as slot>
                    <span class="slot-badge">${slot}</span>
                </#list>
            </div>
        </div>

        <hr style="border: 0; border-top: 1px solid #eee; margin: 25px 0;">

        <button type="submit" class="btn-submit">Створити призначення</button>

    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>
</html>