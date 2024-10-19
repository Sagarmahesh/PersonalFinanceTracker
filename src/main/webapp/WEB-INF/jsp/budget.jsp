<%@ include file="common/header.jsp" %>

<%@ include file="common/navbar.jsp" %>

<div class="container ">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="card p-4">

                <h2 class="text-center mb-4">${add_or_update} Budget</h2>

                <form:form method="post" modelAttribute="budget">

                    <!-- Amount -->
                    <div class="mb-3">
                        <form:label path="amount" cssClass="form-label">Amount</form:label>
                        <form:input path="amount" cssClass="form-control" type="number" step="0.01" placeholder="Enter amount" />
                        <form:errors path="amount" cssClass="text-warning" />
                    </div>

                    <!-- Dates -->
                    <div class="mb-3">
                        <form:label path="fromDate" cssClass="form-label">Date</form:label>
                        <form:input path="fromDate" cssClass="form-control" type="date" />
                        <form:errors path="fromDate" cssClass="text-warning" />
                    </div>


                    <div class="mb-3">
                        <form:label path="toDate" cssClass="form-label">Date</form:label>
                        <form:input path="toDate" cssClass="form-control" type="date" />
                        <form:errors path="toDate" cssClass="text-warning" />
                    </div>

                    <!-- Description -->
                    <div class="mb-3">
                        <form:label path="description" cssClass="form-label">Description</form:label>
                        <form:textarea path="description" cssClass="form-control" rows="3" placeholder="Optional description" />
                        <form:errors path="description" cssClass="text-warning" />
                    </div>

                    <!-- Submit Button -->
                    <div class="d-grid gap-2">
                        <button type="submit" class="btn btn-primary">${add_or_update} Budget</button>
                    </div>
                </form:form>

            </div>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>