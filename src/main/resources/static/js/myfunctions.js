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