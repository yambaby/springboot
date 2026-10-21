const fallbackProducts = [
    {
        name: "Adjustable dumbbell set",
        quantity: 18,
        unitPrice: 89.00,
        image: "https://images.unsplash.com/photo-1583454110551-21f2fa2afe61?auto=format&fit=crop&w=900&q=80",
        imageAlt: "Strength training with free weights"
    },
    {
        name: "Everyday training kit",
        quantity: 24,
        unitPrice: 42.00,
        image: "https://images.unsplash.com/photo-1598289431512-b97b0917affc?auto=format&fit=crop&w=900&q=80",
        imageAlt: "Training accessories ready for a workout"
    },
    {
        name: "Strength essentials",
        quantity: 12,
        unitPrice: 56.00,
        image: "https://images.unsplash.com/photo-1581009146145-b5ef050c2e1e?auto=format&fit=crop&w=900&q=80",
        imageAlt: "Athlete training with gym equipment"
    }
];

const productImages = fallbackProducts.map((product) => ({ image: product.image, imageAlt: product.imageAlt }));
const productGrid = document.querySelector(".product-grid");
const productSearch = document.querySelector("#product-search");
const searchFeedback = document.querySelector(".search-feedback");
let products = fallbackProducts;

function escapeHtml(value) {
    return String(value).replace(/[&<>"']/g, (character) => ({
        "&": "&amp;",
        "<": "&lt;",
        ">": "&gt;",
        '"': "&quot;",
        "'": "&#39;"
    })[character]);
}

function renderProducts(query = "") {
    const normalizedQuery = query.trim().toLocaleLowerCase();
    const filteredProducts = products
        .filter((product) => product.name.toLocaleLowerCase().includes(normalizedQuery))
        .slice(0, 3);

    searchFeedback.textContent = normalizedQuery
        ? `${filteredProducts.length} ${filteredProducts.length === 1 ? "item" : "items"} found`
        : "";

    if (!filteredProducts.length) {
        productGrid.innerHTML = '<p class="empty-results">No equipment matches that search. Try another term.</p>';
        return;
    }

    productGrid.innerHTML = filteredProducts.map((product, index) => {
        const image = product.image || productImages[index % productImages.length].image;
        const imageAlt = product.imageAlt || `Fitness equipment: ${product.name}`;
        const price = Number(product.unitPrice);
        const formattedPrice = Number.isFinite(price)
            ? new Intl.NumberFormat("en-US", { style: "currency", currency: "USD" }).format(price)
            : "See details";
        const stockLabel = Number(product.quantity) > 0 ? "In stock" : "Check availability";

        return `
            <article class="product-card">
                <a href="products.html" aria-label="View ${escapeHtml(product.name)}">
                    <div class="product-image">
                        <img src="${escapeHtml(image)}" alt="${escapeHtml(imageAlt)}" loading="lazy">
                        <span class="product-index">0${index + 1} / E-LIFT</span>
                    </div>
                    <div class="product-info">
                        <div>
                            <h3 class="product-name">${escapeHtml(product.name)}</h3>
                            <p class="product-meta">${escapeHtml(stockLabel)}</p>
                        </div>
                        <span class="product-price">${formattedPrice}</span>
                    </div>
                </a>
            </article>
        `;
    }).join("");
}

async function loadProducts() {
    try {
        const response = await fetch("http://localhost:8080/products");
        if (!response.ok) {
            throw new Error("Product service unavailable");
        }
        const catalog = await response.json();
        if (Array.isArray(catalog) && catalog.length) {
            products = catalog.map((product, index) => ({
                ...product,
                ...productImages[index % productImages.length]
            }));
        }
    } catch {
        products = fallbackProducts;
    }

    renderProducts(productSearch.value);
}

const initialQuery = new URLSearchParams(window.location.search).get("q") || "";
productSearch.value = initialQuery;
productSearch.addEventListener("input", () => renderProducts(productSearch.value));
document.querySelector(".site-search").addEventListener("submit", (event) => event.preventDefault());
renderProducts(initialQuery);
loadProducts();