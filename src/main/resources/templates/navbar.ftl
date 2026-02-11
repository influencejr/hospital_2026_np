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
                    <#--                    If not logged in, show "Log in", else: "My profile"-->
                    <a class="nav-link" href="/">Увійти в аккаунт</a>
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
