<#macro pages>

    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
              crossorigin="anonymous">
        <link href="/css/available-doctors.css" rel="stylesheet">
        <link href="/css/navbar.css" rel="stylesheet">
        <link href="/css/table.css" rel="stylesheet">
    </head>
    <body>

    <#include "navbar.ftl">


    <div class="appointments-grid">
        <#if staff??>
            <#list staff as worker>
                <div class="appointment-cube">
                    <div class="cube-header">
                        <span class="type-badge">${worker.specialization}</span>
                        <span class="id-label">#${worker.id}</span>
                    </div>

                    <div class="cube-content">
                        <h5 class="worker-name">${worker.firstName} ${worker.lastName}</h5>
                        <div class="schedule-box">
                            <strong>Розклад:</strong>
                            <div class="slots-list">
                                <#if slots[worker.id?string]??>
                                    <#list slots[worker.id?string] as slot>
                                        <span class="slot-badge">${slot}</span>
                                    </#list>
                                <#else>
                                    <span class="text-muted">Немає записів</span>
                                </#if>
                            </div>
                        </div>
                    </div>

                    <div class="cube-footer">
                        <form action="/create_appointment/doctor_id/${worker.id}" method="GET">
                            <button type="submit" class="btn-submit btn-create-app">Записатись</button>
                        </form>
                    </div>
                </div>
            </#list>
        </#if>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
            crossorigin="anonymous"></script>


    </body>
    </html>
</#macro>
<@pages />