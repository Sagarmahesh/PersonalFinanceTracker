<%@ include file="common/header.jsp"%>

<%@ include file="common/navbar.jsp" %>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="card p-4">
                <h2 class="text-center mb-4">${add_or_update} Transaction</h2>

                <form:form method="post" modelAttribute="transaction">

                    <!-- Type -->
                    <div class="mb-3">
                        <form:label path="type" cssClass="form-label">Type</form:label>
                        <form:select path="type" cssClass="form-select">
                            <form:option value="" label="-- Select Type --" />
                            <form:option value="Income" label="Income" />
                            <form:option value="Expense" label="Expense" />
                        </form:select>
                        <form:errors path="type" cssClass="text-warning" />
                    </div>

                    <!-- Category -->
                    <div class="mb-3">
                        <form:label path="category" cssClass="form-label">Category</form:label>
                        <form:input path="category" cssClass="form-control" placeholder="e.g., Groceries, Rent" />
                        <form:errors path="category" cssClass="text-warning" />
                    </div>

                    <!-- Amount -->
                    <div class="mb-3">
                        <form:label path="amount" cssClass="form-label">Amount</form:label>
                        <form:input path="amount" cssClass="form-control" type="number" step="0.01" placeholder="Enter amount" />
                        <form:errors path="amount" cssClass="text-warning" />
                    </div>

                    <!-- Description -->
                    <div class="mb-3">
                        <form:label path="description" cssClass="form-label">Description</form:label>
                        <form:textarea path="description" cssClass="form-control" rows="3" placeholder="Optional description" />
                        <form:errors path="description" cssClass="text-warning" />
                    </div>

                    <!-- Date -->
                    <div class="mb-3">
                        <form:label path="date" cssClass="form-label">Date</form:label>
                        <form:input path="date" cssClass="form-control" type="date" />
                        <form:errors path="date" cssClass="text-warning" />
                    </div>

                    <!-- Submit Button -->
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-primary">Add Transaction</button>
                    </div>

                </form:form>

                <!-- Back to Transactions List -->
                <div class="mt-3 text-center">
                    <a href="/dashboard" class="btn btn-secondary">Back to Dashboard</a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>