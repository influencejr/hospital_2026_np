<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>
    <link rel="stylesheet" href="/css/auth.css" />
</head>
<body>
<div class="auth-wrapper">
    <div class="auth-card">
        <h1 class="auth-title">Увійти</h1>
        <form method="post" action="/login">
            <div class="form-group">
                <label class="label" for="username">Ім'я користувача</label>
                <input class="input" id="username" name="username" type="text" placeholder="Введіть ім'я користувача" required />
            </div>
            <div class="form-group">
                <label class="label" for="password">Пароль</label>
                <input class="input" id="password" name="password" type="password" placeholder="Введіть ваш пароль" required />
            </div>
            <div class="actions">
                <button class="btn" type="submit">Увійти</button>
                <div class="note">Немає аккаунту? <a class="link" href="/registration">Створити</a></div>
            </div>
        </form>
    </div>
</div>
</body>
</html>