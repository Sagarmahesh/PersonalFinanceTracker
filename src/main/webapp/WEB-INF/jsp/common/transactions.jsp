<style>
    .card:hover {
        transform: scale(1.05);
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);
        transition: transform 0.3s, box-shadow 0.3s;
    }
</style>

<div class="row">
    <c:forEach items="${transactions}" var="transaction">
        <!-- Each transaction will be displayed as a card inside a responsive grid column -->
        <!--Three cards will be displayed in a large device in row, two cards in medium devices, and one card in small devices -->
        <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
            <div class="card d-flex flex-column h-100 shadow-sm">
                <div class="card-header bg-secondary text-white">
                    <h5 class="card-title mb-0">Transaction Type: ${transaction.type}</h5>
                </div>
                <div class="card-body">
                    <p class="card-text">
                        <strong class="text-primary">Category:</strong> <span class="text-primary">${transaction.category}</span><br>
                        <strong class="text-success">Amount:</strong> <span class="text-success">${transaction.amount}</span><br>
                        <strong class="text-muted">Description:</strong> <span class="text-muted">${transaction.description}</span><br>
                        <strong class="text-info">Date:</strong> <span class="text-info">${transaction.date}</span>
                    </p>
                    <div class="d-flex justify-content-between mt-3">
                        <a href="update-transaction?id=${transaction.id}" class="btn btn-primary btn-sm">Update</a>
                        <a href="delete-transaction?id=${transaction.id}" class="btn btn-danger btn-sm">Delete</a>
                    </div>
                </div>
            </div>

        </div>
    </c:forEach>
</div>