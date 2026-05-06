<#macro pages>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hospital | Admin Panel</title>
    <link rel="stylesheet" href="/css/admin.css">
    <link rel="stylesheet" href="/css/navbar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<#include "navbar.ftl">

<section class="admin-section">
    <div class="admin-container">
        <h1>Admin Panel</h1>

        <div class="admin-card">
            <h3>Create New User</h3>
            <form action="/admin/create_user" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
                <div class="mb-3">
                    <label for="roleId" class="form-label">Role</label>
                    <select class="form-select" id="roleId" name="roleId" required>
                        <#list roles as role>
                            <option value="${role.id}">${role.role}</option>
                        </#list>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary w-100">Create User</button>
            </form>
        </div>

        <hr>

        <div class="admin-card">
            <h3>Update User Role</h3>
            <form action="/admin/update_role" method="post">
                <div class="mb-3">
                    <label for="userId" class="form-label">User ID</label>
                    <input type="number" class="form-control" id="userId" name="userId" required>
                </div>
                <div class="mb-3">
                    <label for="updateRoleId" class="form-label">New Role</label>
                    <select class="form-select" id="updateRoleId" name="roleId" required>
                        <#list roles as role>
                            <option value="${role.id}">${role.role}</option>
                        </#list>
                    </select>
                </div>
                <button type="submit" class="btn btn-success w-100">Update Role</button>
            </form>
        </div>

        <hr>

        <div class="admin-card">
            <h3>Delete User</h3>
            <form action="/admin/delete_user" method="post">
                <div class="mb-3">
                    <label for="deleteId" class="form-label">User ID</label>
                    <input type="number" class="form-control" id="deleteId" name="id" required>
                </div>
                <button type="submit" class="btn btn-danger w-100">Delete User</button>
            </form>
        </div>

        <hr>

        <div class="admin-card">
            <h3>User List</h3>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Roles</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list users as user>
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.username}</td>
                                <td>
                                    <#list user.roles as role>
                                        ${role.role}<#if role_has_next>, </#if>
                                    </#list>
                                </td>
                            </tr>
                        </#list>
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
