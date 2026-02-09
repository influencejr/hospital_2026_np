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
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-custom">
    <div class="container-fluid">
        <a href="/"><img src="/img/pharmacy.png" alt="hospital" height="32px" href="/"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/">Мій профіль</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Призначення
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/appointments">Всі призначення</a></li>
                        <li><a class="dropdown-item" href="/create_appointment">Зробити запис</a></li>
                        <li><a class="dropdown-item" href="/delete_appointment">Видалити призначення</a></li>
                        <li><a class="dropdown-item" href="/update_appointment">Змінити призначення</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>


<div class="medical-form-container">
    <h2>Нове призначення</h2>




    <form action="/create_appointment/create" method="POST">

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

        <hr style="border: 0; border-top: 1px solid #eee; margin: 25px 0;">

        <div class="form-group">
            <label>Дані</label>
            <div class="row-two-cols">

                <label>
                    ID пацієнта
                    <input type="number" name="patientID" class="form-control" placeholder="ID пацієнта">
                </label>

                <label>
                    ID лікаря
                    <input type="number" name="doctorID" class="form-control" placeholder="ID лікаря">
                </label>
            </div>
        </div>
        <button type="submit" class="btn-submit">Створити призначення</button>

    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>
</html>