<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/edit-app.css">
    <link rel="stylesheet" href="/css/navbar.css">
</head>
<body>


<#include "navbar.ftl">

<div class="medical-form-container">
    <h3 class="text-center mb-4">Дані призначення</h3>

    <form action="/update_appointment/update" method="POST">

        <div class="mb-3">
            <label class="form-label">ID Призначення (яке редагуємо)</label>
            <input type="number" name="id" class="form-control" placeholder="Наприклад: 5">
        </div>

        <div class="mb-3">
            <label class="form-label">Тип призначення</label>
            <select name="type" class="form-control">
                <option value="consultation">Консультація</option>
                <option value="operation">Операція</option>
                <option value="examination">Обстеження</option>
                <option value="therapy">Терапія</option>
            </select>
            <label class="form-label">Статус призначення</label>
            <textarea name="status" class="form-control" rows="3" placeholder="Введіть статус"></textarea>
        </div>

        <div class="mb-3">
            <label class="form-label">Опис призначення</label>
            <textarea name="description" class="form-control" rows="3" placeholder="Введіть опис..."></textarea>
        </div>

        <div class="row">
            <div class="col-md-6">
                <label class="form-label">ID Пацієнта</label>
                <input type="number" name="patientID" class="form-control" placeholder="ID">
            </div>
            <div class="col-md-6">
                <label class="form-label">ID Лікаря</label>
                <input type="number" name="doctorID" class="form-control" placeholder="ID">
            </div>
            <div class="col-md-6">
                <label class="form-label">ID виконувача</label>
                <input type="number" name="executorID" class="form-control" placeholder="ID">
            </div>
        </div>

        <button type="submit" class="btn-submit">Зберегти</button>
    </form>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>

</body>
</html>