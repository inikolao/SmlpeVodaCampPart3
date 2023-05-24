function addtoCart(productId) {
    $.ajax({
        url: "/cart/add",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            productId: productId
        }),
        success: function(response) {
            alert("Product added to cart");
        },
        error: function(xhr, status, error) {
            console.log("Error adding product to cart: " + error);
        }
    });
    $("#navbarNav").load(location.href + " #navbarNav");
}

function removeFromCart(productId) {
    $.ajax({
        url: "/cart/remove",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            productId: productId
        }),
        success: function(response) {
            alert("Product removed from cart");
        },
        error: function(xhr, status, error) {
            console.log("Error removing product from cart: " + error);
        }
    });
    $(".table").load(location.href + " .table");
    $("#navbarNav").load(location.href + " #navbarNav");
}

function addtoWlist(productId) {
    $.ajax({
        url: "/wishlist/add",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            productId: productId
        }),
        success: function(response) {
            alert("Product added to WishList");
        },
        error: function(xhr, status, error) {
            console.log("Error adding product to WishList: " + error);
        }
    });
    $("#navbarNav").load(location.href + " #navbarNav");
}

function removetoWlist(productId) {
    $.ajax({
        url: "/wishlist/remove",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            productId: productId
        }),
        success: function(response) {
            alert("Product removed from wishlist");
        },
        error: function(xhr, status, error) {
            console.log("Error removing product from wishlist: " + error);
        }
    });
    $(".table").load(location.href + " .table");
    $("#navbarNav").load(location.href + " #navbarNav");
}

function getmyprods() {
    var input = $('#search').val();
    if (input.length >= 2) {
        $.ajax({
            type: "POST",
            url: "/search/name",
            contentType: "application/json",
            data: JSON.stringify({
                search: input
            }),
            success: function(result) {
                var value1 = result['products'];
                var value2 = result['totalPages'];
                var value3 = result['page'];
                $('#searchResults').load(location.href + " #searchResults");
            },
            error: function(xhr, status, error) {
                console.log("Error responding: " + error);
            }
        });
    }
function togglePaymentFields() {
        var paymentType = document.getElementById("paymentType").value;
        var cardFields = document.getElementById("cardFields");
        var expirationFields = document.getElementById("expirationFields");
        var cvvFields = document.getElementById("cvvFields");

        if (paymentType === "Cash" || paymentType === "Delivery") {
            cardFields.style.display = "none";
            expirationFields.style.display = "none";
            cvvFields.style.display = "none";
        } else {
            cardFields.style.display = "block";
            expirationFields.style.display = "block";
            cvvFields.style.display = "block";
        }
    }
}