<%@ include file="common/header.jsp" %>
<%@ include file="common/navbar.jsp" %>

<div class="container my-5">
    <h1 class="text-center">Hello, ${username}</h1>

    <h2 class="text-center my-4">Current Active Budgets</h2>
    <div class="row">
        <%@ include file="common/budgets.jsp" %>
    </div>

    <h2 class="text-center my-4">Recent Ten Transactions</h2>
    <div class="row">
        <%@ include file="common/transactions.jsp" %>
    </div>
</div>

<%@ include file="common/footer.jsp" %>