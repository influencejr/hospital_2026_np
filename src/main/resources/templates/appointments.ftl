<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hospital | Appointments</title>
    <link rel="stylesheet" href="/css/table.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
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


<table class="appointments-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Тип призначення</th>
        <th>Опис призначення</th>
        <th>Статус</th>
        <th>Створено</th>
        <th>Виконано</th>
        <th>Пацієнт</th>
        <th>Лікар</th>
        <th>Хто виконав</th>
    </tr>
    </thead>

    <#if appointments??>
        <#list appointments as appointment>

        <tbody>
        <tr>
            <th>${appointment.id}</th>
            <th>${appointment.type}</th>
            <th>${appointment.description}</th>
            <th>${appointment.status}</th>
            <th>${appointment.createdAt}</th>
            <th>${appointment.executedAt!"-"}</th>
            <th>${appointment.patient.firstName + ' ' + appointment.patient.lastName}</th>
            <th>${appointment.doctor.firstName + ' ' + appointment.doctor.lastName}</th>
            <th>${(appointment.executor.firstName + ' ' + appointment.executor.lastName)!"-"}</th>
        </tr>
        </#list>
    </#if>
    </tbody>
</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>
</html>