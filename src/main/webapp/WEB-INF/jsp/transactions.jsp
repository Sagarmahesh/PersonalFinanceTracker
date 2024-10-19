<%@ include file="common/header.jsp" %>
<%@ include file="common/navbar.jsp" %>

<div class="container my-5">
    <h2 class="text-center mb-4">Transactions</h2>
    <div class="row">
        <%@ include file="common/transactions.jsp" %>
    </div>

    <div class="text-center my-4">
        <a href="transaction" class="btn btn-success mx-2">Add Transaction</a>
    </div>
</div>

<%@ include file="common/footer.jsp" %>