<#macro pages>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hospital | Profile</title>
    <link rel="stylesheet" href="/css/profile.css">
    <link rel="stylesheet" href="/css/navbar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>

<#include "navbar.ftl">

<section class="profile-section">
    <div class="profile-container">
        <h1>User Profile</h1>
        <div class="profile-card">
            <div class="profile-info">
                <h3>Account Information</h3>
                <p><strong>Username:</strong> ${user.username}</p>
                <p><strong>User ID:</strong> ${user.id}</p>
                <p><strong>Role:</strong> ${role!"unknown"}</p>
            </div>
            <hr>
            <#if person??>
                <div class="personal-info">
                    <h3>Personal Details</h3>
                    <p><strong>First Name:</strong> ${person.firstName!""}</p>
                    <p><strong>Last Name:</strong> ${person.lastName!""}</p>
                    <#if person.dateOfBirth??>
                        <p><strong>Date of Birth:</strong> ${person.dateOfBirth?string("yyyy-MM-dd")}</p>
                    </#if>
                    <p><strong>Age:</strong> ${person.age!""}</p>
                    <p><strong>Gender:</strong> ${person.gender!""}</p>
                    <p><strong>Address:</strong> ${person.address!""}</p>
                    <#if role == "patient">
                        <p><strong>Phone Number:</strong> ${person.phoneNumber!""}</p>
                        <p><strong>Status:</strong> ${person.status!""}</p>
                    <#elseif role == "staff">
                         <#if person.specialization??>
                            <p><strong>Specialization:</strong> ${person.specialization}</p>
                         </#if>
                    </#if>
                </div>
            <#else>
                <p class="text-muted">No personal details found for this account.</p>
            </#if>
        </div>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>
</#macro>

<@pages />
