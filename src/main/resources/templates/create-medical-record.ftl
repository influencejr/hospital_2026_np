<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hospital | Медична картка</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/create-app.css">
    <link rel="stylesheet" href="/css/navbar.css">
</head>
<body>

<#include "navbar.ftl">

<div class="medical-form-container">
    <h2>Запис у медичну картку</h2>

    <form action="/create_medical_record" method="POST">

        <div class="form-group mb-3">
            <label for="patientId">ID Пацієнта</label>
            <input type="number" id="patientId" name="patientId" class="form-control" placeholder="Введіть ID (наприклад: 15)" required min="1">
        </div>

        <div class="form-group mb-3">
            <label for="appointmentDate">Дата прийому</label>
            <input type="date" id="appointmentDate" name="appointmentDate" class="form-control" required>
        </div>

        <div class="form-group mb-3">
            <label for="diagnosis">Діагноз</label>
            <textarea id="diagnosis" name="diagnosis" class="form-control" rows="2" placeholder="Опис діагнозу..." required></textarea>
        </div>

        <div class="form-group mb-3">
            <label for="prescription">Призначення / Ліки</label>
            <textarea id="prescription" name="prescription" class="form-control" rows="3" placeholder="Список ліків..."></textarea>
        </div>

        <div class="form-group mb-3">
            <label for="recommendation">Рекомендації</label>
            <textarea id="recommendation" name="recommendation" class="form-control" rows="3" placeholder="Рекомендації для пацієнта..."></textarea>
        </div>

        <hr style="border: 0; border-top: 1px solid #eee; margin: 25px 0;">

        <button type="submit" class="btn-submit">Зберегти запис</button>

    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>

</body>
</html>