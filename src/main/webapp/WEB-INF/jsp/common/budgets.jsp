<style>
    .card:hover {
        transform: scale(1.05);
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
        transition: transform 0.3s, box-shadow 0.3s;
    }
</style>

<div class="row">
    <c:forEach items="${budgets}" var="budget">
        <!-- Each Budget will be displayed as a card inside a responsive grid column -->
        <!--Three cards will be displayed in a large device in row, two cards in medium devices, and one card in small devices -->
        <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
            <div class="card d-flex flex-column h-100 shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h5 class="card-title mb-0">Budget Amount: ${budget.amount}</h5>
                </div>
                <div class="card-body">
                    <p class="card-text">
                        <strong class="text-success">Remaining Amount: </strong><span class="text-success">${budget.remainingAmount}</span><br>
                        <strong class="text-info">From Date: </strong><span class="text-info">${budget.fromDate}</span><br>
                        <strong class="text-info">To Date: </strong><span class="text-info">${budget.toDate}</span><br>
                        <strong class="text-muted">Description: </strong><span class="text-muted">${budget.description}</span><br>
                        <strong class="text-warning">Status: </strong><span class="text-warning">${budget.status}</span>
                    </p>
                    <div class="d-flex justify-content-between mt-3">
                        <a href="update-budget?id=${budget.id}" class="btn btn-primary btn-sm">Update</a>
                        <a href="delete-budget?id=${budget.id}" class="btn btn-danger btn-sm">Delete</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>