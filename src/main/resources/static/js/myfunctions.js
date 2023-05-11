$(function() {
    $(".add-to-cart").click(function() {
        var productId = $(this).data("id");
        $.ajax({
            url: "/cart/add",
            method: "POST",
            data: {
                productId: productId
            },
            success: function(response) {
                alert("Product added to cart");
            },
            error: function(xhr, status, error) {
                console.log("Error adding product to cart: " + error);
            }
        });
    });
});

function addtoWlist(productId) {
    alert("papaki?!"+productId);
    $.ajax({
        url: "/wishlist/add",
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
            alert("Product added to cart");
        },
        error: function(xhr, status, error) {
            console.log("Error adding product to cart: " + error);
        }
    });
    $(".table").load(location.href + " .table");
}