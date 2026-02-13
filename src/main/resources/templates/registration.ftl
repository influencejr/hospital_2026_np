<#import "/spring.ftl" as s>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/auth.css">
    <title>Реєстрація - Hospital 2026</title>
</head>
<body>

<div class="auth-wrapper">
    <div class="auth-card">
        <h3 class="auth-title">Реєстрація</h3>

        <form method="post" action="/registration">
            <fieldset name="Registration Form">
                <@s.bind "users"/>
                <div class="form-group">
                    <label class="label">Ім'я користувача *</label>
                    <@s.formInput "users.username", "class='input' placeholder='Username' required"/>
                    <@s.showErrors "<br>", "error"/>
                </div>

                <div class="form-group">
                    <label class="label">Пароль користувача *</label>
                    <@s.formInput "users.password", "class='input' type='password' placeholder='Password' required"/>
                    <@s.showErrors "<br>", "error"/>
                </div>

                <hr>

                <@s.bind "patients"/>
                <div class="form-row">
                    <div class="form-col">
                        <div class="form-group">
                            <label class="label">Ім'я *</label>
                            <@s.formInput "patients.firstName", "class='input' required"/>
                            <@s.showErrors "<br>", "error"/>
                        </div>
                    </div>
                    <div class="form-col">
                        <div class="form-group">
                            <label class="label">Прізвище *</label>
                            <@s.formInput "patients.lastName", "class='input' required"/>
                            <@s.showErrors "<br>", "error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="label">Стать *</label>
                    <@s.formInput "patients.gender", "class='input' placeholder='Male/Female/Other' required"/>
                    <@s.showErrors "<br>", "error"/>
                </div>

                <div class="form-row">
                    <div class="form-col">
                        <div class="form-group">
                            <label class="label">Дата народження *</label>
                            <@s.formInput "patients.dateOfBirth", "class='input' type='date' required"/>
                            <div class="helper">Формат: yyyy-mm-dd</div>
                            <@s.showErrors "<br>", "error"/>
                        </div>
                    </div>
                    <div class="form-col">
                        <div class="form-group">
                            <label class="label">Вік *</label>
                            <@s.formInput "patients.age", "class='input' type='number' min='0' required"/>
                            <@s.showErrors "<br>", "error"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="label">Адреса *</label>
                    <@s.formInput "patients.address", "class='input' required"/>
                    <@s.showErrors "<br>", "error"/>
                </div>

                <div class="form-group">
                    <label class="label">Номер телефону</label>
                    <@s.formInput "patients.phoneNumber", "class='input' type='tel'"/>
                    <@s.showErrors "<br>", "error"/>
                </div>

                <div class="actions">
                    <button class="btn" type="submit">Зареєструватись</button>
                    <div class="note">Вже маєте аккаунт? <a class="link" href="/login">Увійти</a></div>
                </div>
            </fieldset>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>