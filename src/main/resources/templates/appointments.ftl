<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hospital | Appointments</title>
    <link rel="stylesheet" href="/css/table.css">
    <link rel="stylesheet" href="/css/navbar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>


<#include "navbar.ftl">
<div class="appointments-grid">
    <#if appointments??>
        <#list appointments as appointment>
            <#if appointment.status != "executed">
                <div class="appointment-cube">
                    <div class="cube-header">
                        <span class="type-badge">${appointment.type}</span>
                        <span class="id-label">#${appointment.id}</span>
                    </div>
                    <div class="cube-content">
                        <p><strong>Пацієнт:</strong> ${appointment.patient.firstName} ${appointment.patient.lastName}
                        </p>
                        <p><strong>Опис:</strong> ${appointment.description}</p>
                        <p><strong>ID лікаря:</strong> ${appointment.doctor.id}</p>
                        <p><strong>ID пацієнта: </strong> ${appointment.patient.id}</p>
                        <p><strong>Час:</strong> ${appointment.startTime}</p>
                        <p><strong>Статус:</strong> <span class="status-text">${appointment.status}</span></p>
                    </div>
                    <div class="cube-footer">
                        <small>${appointment.createdAt}</small>
                    </div>
                </div>
            </#if>
        </#list>
    </#if>
</div>

<#if Session.lastViewedDoctorId??>
    <div class="alert alert-info mt-3" style="border: 1px solid #bee5eb; padding: 15px; background-color: #d1ecf1; color: #0c5460; border-radius: 4px;">
        <span>Ви нещодавно переглядали графік: </span>
        <strong>
            <#-- Створюємо динамічне посилання -->
            <a href="/create_appointment/doctor_id/${Session.lastViewedDoctorId}" style="color: #0c5460; text-decoration: underline;">
                ${Session.lastViewedDoctorName}
            </a>
        </strong>
        <p style="margin-top: 5px; font-size: 0.85em;">
            Ви можете швидко повернутися до створення запису.
        </p>
    </div>
</#if>


<#--<table class="appointments-table">-->
<#--    <thead>-->
<#--    <tr>-->
<#--        <th>ID</th>-->
<#--        <th>Тип призначення</th>-->
<#--        <th>Опис призначення</th>-->
<#--        <th>Статус</th>-->
<#--        <th>Створено</th>-->
<#--        <th>Виконано</th>-->
<#--        <th>Пацієнт</th>-->
<#--        <th>Лікар</th>-->
<#--        <th>Хто виконав</th>-->
<#--    </tr>-->
<#--    </thead>-->

<#--    <#if appointments??>-->
<#--        <#list appointments as appointment>-->

<#--        <tbody>-->
<#--        <tr>-->
<#--            <th>${appointment.id}</th>-->
<#--            <th>${appointment.type}</th>-->
<#--            <th>${appointment.description}</th>-->
<#--            <th>${appointment.status}</th>-->
<#--            <th>${appointment.createdAt}</th>-->
<#--            <th>${appointment.executedAt!"-"}</th>-->
<#--            <th>${appointment.patient.firstName + ' ' + appointment.patient.lastName}</th>-->
<#--            <th>${appointment.doctor.firstName + ' ' + appointment.doctor.lastName}</th>-->
<#--            <th>${(appointment.executor.firstName + ' ' + appointment.executor.lastName)!"-"}</th>-->
<#--        </tr>-->
<#--        </#list>-->
<#--    </#if>-->
<#--    </tbody>-->
<#--</table>-->


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>
</html>