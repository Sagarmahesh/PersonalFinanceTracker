<%@ include file="common/header.jsp" %>

<div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
    <div class="row justify-content-center">
        <div class="col-12"> <!-- Adjusted column sizes -->
            <div class="card p-4"> <!-- Set a minimum width for the card -->
                <h2 class="text-center mb-4">Register</h2>
                <form:form method="post" modelAttribute="user">

                    <div class="mb-3">
                        <form:label path="username" cssClass="form-label">Username</form:label>
                        <form:input path="username" cssClass="form-control" placeholder="Enter your username" />
                        <form:errors path="username" cssClass="text-danger" />
                    </div>
                    <div class="mb-3">
                        <form:label path="password" cssClass="form-label">Password</form:label>
                        <form:password path="password" cssClass="form-control" placeholder="Enter your password" />
                        <form:errors path="password" cssClass="text-danger" />
                    </div>
                    <div class="mb-3">
                        <form:label path="email" cssClass="form-label">Email</form:label>
                        <form:input path="email" cssClass="form-control" placeholder="Enter your email" type="email" />
                        <form:errors path="email" cssClass="text-danger" />
                    </div>

                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-primary">Register</button>
                    </div>

                </form:form>

                <p class="mt-3 text-center">Already have an account? <a href="/login">Login here</a>.</p>
            </div>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>