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

    <link rel="stylesheet" href="/css/delete-app.css">
    <link rel="stylesheet" href="/css/navbar.css">
</head>
<body>



<#include "navbar.ftl">

<div class="medical-form-container">
    <h3>Видалення призначення</h3>

    <form action="/delete_appointment/delete" method="POST">

        <div class="mb-3">
            <label for="idInput" class="form-label">Введіть ID призначення</label>
            <input type="number" id="idInput" name="id" class="form-control" placeholder="Наприклад: 15" required>
        </div>

        <button type="submit" class="btn-submit">Видалити запис</button>

        <div class="text-center mt-3">
            <a href="/appointments" class="text-secondary" style="text-decoration: none;">Скасувати</a>
        </div>
    </form>
</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>

</body>
</html>