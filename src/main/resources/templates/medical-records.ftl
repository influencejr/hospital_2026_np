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
        <#if records??>
            <#list records as record>
                <div class="appointment-cube">
                    <div class="cube-header">
                        <span class="type-badge">Діагноз</span>
                        <span class="id-label">#${record.id}</span>
                    </div>

                    <div class="cube-content">
                        <h5 class="worker-name">${record.diagnosis}</h5>
                        <p><strong>Дата:</strong> ${record.appointmentDate}</p>
                        <p><strong>Ліки:</strong> ${record.prescription}</p>
                        <p><strong>Рекомендації:</strong> ${record.recommendation}</p>
                    </div>

                    <div class="cube-footer">
                        <small>Медична карта</small>
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