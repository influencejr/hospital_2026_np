<#macro pages>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hospital | User Audit</title>
    <link rel="stylesheet" href="/css/user-audit.css">
    <link rel="stylesheet" href="/css/navbar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<#include "navbar.ftl">

<section class="audit-section">
    <div class="audit-container">
        <h1>Журнал аудиту користувачів</h1>

        <div class="filter-card">
            <h3>Фільтри</h3>
            <div class="filter-buttons">
                <a href="/admin/audit" class="btn btn-outline-primary">Всі записи</a>
                <button class="btn btn-outline-secondary" data-bs-toggle="collapse" data-bs-target="#usernameFilter">
                    Фільтр по користувачу
                </button>
                <button class="btn btn-outline-secondary" data-bs-toggle="collapse" data-bs-target="#actionFilter">
                    Фільтр по дії
                </button>
            </div>

            <div class="collapse mt-3" id="usernameFilter">
                <form action="/admin/audit" method="get" class="filter-form">
                    <div class="input-group">
                        <input type="text" class="form-control" name="username" placeholder="Введіть ім'я користувача" required>
                        <button type="submit" class="btn btn-primary">Застосувати</button>
                    </div>
                </form>
            </div>

            <div class="collapse mt-3" id="actionFilter">
                <form action="/admin/audit" method="get" class="filter-form">
                    <div class="input-group">
                        <select class="form-select" name="action" required>
                            <option value="">Оберіть дію</option>
                            <option value="LOGIN">Вхід</option>
                            <option value="LOGOUT">Вихід</option>
                            <option value="CREATE_USER">Створення користувача</option>
                            <option value="UPDATE_USER">Оновлення користувача</option>
                            <option value="DELETE_USER">Видалення користувача</option>
                            <option value="CREATE_APPOINTMENT">Створення призначення</option>
                            <option value="UPDATE_APPOINTMENT">Оновлення призначення</option>
                            <option value="DELETE_APPOINTMENT">Видалення призначення</option>
                        </select>
                        <button type="submit" class="btn btn-primary">Застосувати</button>
                    </div>
                </form>
            </div>

            <#if filterType??>
                <div class="alert alert-info mt-3">
                    <strong>Активний фільтр:</strong> ${filterType} = "${filterValue}"
                </div>
            </#if>
        </div>

        <div class="audit-card">
            <h3>Записи аудиту</h3>
            <div class="audit-stats">
                <div class="stat-item">
                    <span class="stat-label">Всього записів:</span>
                    <span class="stat-value">${audits?size}</span>
                </div>
            </div>

            <div class="table-responsive">
                <table class="table table-hover audit-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Користувач</th>
                            <th>Дія</th>
                            <th>Деталі</th>
                            <th>Час</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#if audits?? && (audits?size > 0)>
                            <#list audits as audit>
                                <tr class="audit-row">
                                    <td class="audit-id">#${audit.id}</td>
                                    <td class="audit-username">
                                        <span class="username-badge">${audit.username}</span>
                                    </td>
                                    <td class="audit-action">
                                        <span class="action-badge action-${audit.action?lower_case}">
                                            ${audit.action}
                                        </span>
                                    </td>
                                    <td class="audit-details">${audit.details!"-"}</td>
                                    <td class="audit-timestamp">
                                        ${audit.timestamp}
                                    </td>
                                </tr>
                            </#list>
                        <#else>
                            <tr>
                                <td colspan="5" class="text-center text-muted">
                                    Записів не знайдено
                                </td>
                            </tr>
                        </#if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
</#macro>

<@pages />
