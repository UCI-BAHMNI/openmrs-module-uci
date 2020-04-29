<% ui.decorateWith("appui", "standardEmrPage") %>


<% if (context.authenticated) { %>
    moses, $context.authenticatedUser.personName.fullName.
    Your roles are:
    <% context.authenticatedUser.roles.findAll { !it.retired }.each { %>
        $it.role ($it.description)
    <% } %>
<% } else { %>
    You are not logged in.
<% } %>

${ ui.includeFragment("ucionchology", "users") }