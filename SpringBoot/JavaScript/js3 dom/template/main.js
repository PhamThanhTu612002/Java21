let products = [
    {
        id: 1,
        name: "Iphone 20 pro max",
        price: 2000,
        brand: "Apple",
        thumbnail: "iphone15.png",
        rating: 5,
    },
    {
        id: 2,
        name: "Iphone 20 pro max",
        price: 2000,
        brand: "Apple",
        thumbnail: "iphone15.png",
        rating: 5,
    },
    {
        id: 3,
        name: "Iphone 20 pro max",
        price: 2000,
        brand: "Apple",
        thumbnail: "iphone15.png",
        rating: 5,
    },
    {
        id: 4,
        name: "Iphone 20 pro max",
        price: 2000,
        brand: "Apple",
        thumbnail: "iphone15.png",       
        rating: 5,
    },
    {
        id: 5,
        name: "Iphone 20 pro max",
        price: 2000,
        brand: "Apple",
        thumbnail: "iphone15.png",        
        rating: 5,
    },
    {
        id: 6,
        name: "Iphone 20 pro max",
        price: 2000,
        brand: "Apple",
        thumbnail: "iphone15.png",        
        rating: 5,
    },
    {
        id: 7,
        name: "Iphone 20 pro max",
        price: 2000,
        brand: "Apple",
        thumbnail: "iphone15.png",        
        rating: 5,
    },
]

// const listImg = document.querySelectorAll(".course-item .course-item-image img");
// const listName = document.querySelectorAll(".course-item-info h2");
// const listPrice = document.querySelectorAll(".price span:nth-child(1)");
// const listBrand = document.querySelectorAll(".type");
// const listRating = document.querySelectorAll(".rating span:nth-child(1)");
// console.log(listRating);
// for (let i = 0; i < products.length; i++) {
//     listImg[i].src = products[i].thumbnail;
//     listName[i].innerText = products[i].name;
//     listBrand[i].innerText = products[i].brand;
//     listRating[i].innerText = products[i].rating;
//     listPrice[i].innerText = products[i].price;
// }
const formatPrice = (number) =>{
    return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD' }).format(number);
}
const productList = document.querySelector(".product-list");
const renderProduct = (products) => {
    let html = "";
    products.forEach(product => {
        html += `<div class="col-md-3">
                    <div class="course-item shadow-sm rounded mb-4">
                        <div class="course-item-image">
                            <img src="${product.thumbnail}" alt="${product.name}">
                        </div>
                        <div class="course-item-info p-3">
                            <h2 class="fs-5 mb-4 text-dark">${product.name}</h2>
                            <div class="d-flex justify-content-between align-items-center fw-light text-black-50">
                                <p class="type">${product.brand}</p>
                                <p class="rating">
                                    <span>${product.rating}</span>
                                    <span class="text-warning"><i class="fa-solid fa-star"></i></span>
                                </p>
                            </div>
                            <p class="price text-danger fs-5">
                                <span>${formatPrice(product.price)}</span>
                            </p>
                        </div>
                    </div>
                </div>`;
    });
    productList.innerHTML = html;
}
renderProduct(products);