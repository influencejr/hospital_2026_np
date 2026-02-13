<nav class="navbar navbar-expand-lg navbar-light bg-custom">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">
            <img src="/img/pharmacy.png" alt="hospital" height="32px">
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <#if currentUser??>
                        <a class="nav-link" href="/profile">
                            Мій профіль (${currentUser.username})
                        </a>
                    <#else>
                        <a class="nav-link" href="/login">Увійти в аккаунт</a>
                    </#if>
                </li>

                <li>
                    <a class="nav-link" href="/available_doctors">Доступні лікарі</a>
                </li>

                <li><a class="nav-link" href="/appointments">Всі призначення</a></li>

                <li><a class="nav-link" href="/delete_appointment">Видалити призначення</a></li>

                <li><a class="nav-link" href="/update_appointment">Змінити призначення</a></li>

                <#if userRoles?? && (userRoles?seq_contains("ADMIN") || userRoles?seq_contains("ROLE_DOCTOR"))>
                    <li><a class="nav-link" href="/create_medical_record">Створити діагноз</a></li>
                </#if>


                <#if userRoles?? && (userRoles?seq_contains("ROLE_PATIENT"))>
                    <#if currentPatientId??>
                        <li><a class="nav-link" href="/get_medical_records/${currentPatientId}">Переглянути мою медичну
                                картку</a></li>
                    </#if>
                </#if>

            </ul>

            <#if currentUser??>
                <div class="d-flex">
                    <form action="/logout" method="post">
                        <button type="submit" class="btn btn-outline-danger btn-sm">Вийти</button>
                    </form>
                </div>
            </#if>

            <div style="width: 32px;" class="d-none d-lg-block"></div>
        </div>
    </div>
</nav>