<%@ include file="common/header.jsp" %>
<%@ include file="common/navbar.jsp" %>

<div class="container my-5">
    <h2 class="text-center mb-4">Budgets</h2>
    <div class="row">
        <%@ include file="common/budgets.jsp" %>
    </div>

    <div class="text-center my-4">
        <a href="budget" class="btn btn-success mx-2">Add Budget</a>
    </div>
</div>

<%@ include file="common/footer.jsp" %>