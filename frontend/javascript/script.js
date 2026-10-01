async function loadProducts() {
    const response = await fetch("http://localhost:8080/products");

    const products = await response.json();

    console.log(products);
}