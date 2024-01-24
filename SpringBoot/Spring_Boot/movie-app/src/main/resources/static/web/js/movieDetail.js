let reviewIdUpdated = null;
const deleteReview = async (reviewId) => {
    const isConfirmed = confirm("Bạn có chắc chắn muốn xóa không")
    if(!isConfirmed) return
    axios.delete("http://localhost:8081/api/reviews/"+reviewId)
        .then(function(response) {
            toastr.success('Xóa review thành công.')

            // Xóa review có id = reviewId khỏi danh sách reviews
            reviews = reviews.filter(review => review.id !== reviewId)
            renderReview(reviews)
        }).catch(error =>{
        console.log(error)
    });
}
const openModalUpdate = (id) => {
    console.log("open modal update: " + id)
    // Tìm kiếm review có id = id
    const review = reviews.find(review => review.id === id)
    console.log(review)

    // Thay đổi title của modal
    document.getElementById("modal-title").innerHTML = "Cập nhật đánh giá";

    // Cập nhật dữ liệu cho modal
    resetStars();
    console.log(countStar)
    countStar = review.rating;
    console.log(countStar)
    highlightStars(countStar);

    ratingContentEl.value = review.content
    reviewIdUpdated = review.id

    // Mở modal
    modalReview.show();
}
//reder review
const renderReview = (reviews) => {
    const htmlReviews = reviews.map((review) =>{
        return `<div class="avatar d-flex" >
          <img class="rounded-circle" src="data:image/png;base64,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" alt="">
          <div class="cmt-detail ms-4">
            <div class="infor list-inline">
              <p class="fw-bold list-inline-item">${review.user.fullname}</p>
              <p class="fst-italic list-inline-item"></p>
              <p class="rating-number fw-semibold">${review.rating}/10<i class="fa fa-star text-warning me-2"></i>${review.ratingText}</p>
            </div>
            <p class="review-content">${review.content}</p>
            ${currentUser && currentUser.id === review.user.id ?
                `<div class="cmt-action mb-3">
                  <a id="updateReview" href="javascript:void(0)" class="text-primary text-decoration-underline me-2"  onclick="openModalUpdate(${review.id})" >Sửa</a>
                  <a id="deleteReview" href="javascript:void(0)" class="text-danger text-decoration-underline me-2" onclick="deleteReview(${review.id})" >Xóa</a>
                </div>`
                :``
        }
          </div>
        </div>`
    }).join('')
    document.querySelector(".review-list").innerHTML = htmlReviews;
}
let countStar = 0;
const ratingItems = document.querySelectorAll('.rating-item');
// Function to highlight stars up to the selected one
function highlightStars(starCount) {
    resetStars();
    for (var i = 0; i < ratingItems.length; i++) {
        if (parseInt(ratingItems[i].dataset.value,10) <= starCount) {
            ratingItems[i].classList.add('text-warning');
        }
    }
}

// Function to reset all stars
function resetStars() {
    for (var i = 0; i < ratingItems.length; i++) {
        ratingItems[i].classList.remove('text-warning');
    }
}
document.addEventListener("DOMContentLoaded", function () {


    for (let i = 0; i < ratingItems.length; i++) {
        // MouseHover event
        ratingItems[i].addEventListener('mouseover', function () {
            let currentStar = parseInt(this.dataset.value,10);
            highlightStars(currentStar);
        });

        // MouseClick event
        ratingItems[i].addEventListener('click', function () {
            var selectedStar = parseInt(this.dataset.value,10);
            // alert('You selected ' + selectedStar + ' stars!');
            highlightStars(selectedStar);
            countStar = selectedStar;
            // You can send the selected rating to the server or perform other actions here.
        });
    }
});
const btnHandleReview = document.getElementById('btn-handle-review')
const ratingContentEl = document.getElementById('rating-content')
btnHandleReview.addEventListener('click', function () {
    if(reviewIdUpdated) {
        // Cập nhật review
        updateReview()
    } else {
        createReview()
    }
});
const createReview = () => {
    // Kiểm tra xem người dùng đã đánh giá chưa?
    if(!countStar) {
        toastr.error('Bạn chưa đánh giá.')
        return;
    }

    // Kiểm tra ndung review có hợp lệ không?
    if(!ratingContentEl.value.trim()) {
        toastr.error('Bạn chưa nhập nội dung đánh giá.')
        return;
    }

    const data = {
        rating: countStar,
        content: ratingContentEl.value,
        movieId: movie.id
    }

    // Gọi API để tạo mới review sử dụng axios
    axios.post('/api/reviews', data)
        .then(function (response) {
            toastr.success('Tạo mới review thành công.')
            // Đóng modal
            modalReview.hide()

            // Thêm review vào danh sách reviews
            reviews.unshift(response.data)
            renderReview(reviews)
        })
        .catch(function (error) {
            console.log(error);
            toastr.error(error.message)
        });
}

const btnOpenModalReview = document.getElementById('btn-open-modal-review')
const modalReview = new bootstrap.Modal(document.getElementById('modal-review'), {
    keyboard: false
})
btnOpenModalReview.addEventListener('click', function () {
    console.log('click')
    // Mở modal
    modalReview.show();

    // Thay đổi title của modal
    document.getElementById("modal-title").innerHTML = "Viết bình luận";
})
document.getElementById('modal-review').addEventListener('hidden.bs.modal', function (event) {
    console.log('hidden modal')
    resetStars();
    ratingContentEl.value = "";
    reviewIdUpdated = null;
    countStar = 0;
})

const updateReview = () => {
    // Kiểm tra xem người dùng đã đánh giá chưa?
    if(!countStar) {
        toastr.error('Bạn chưa đánh giá.')
        return;
    }

    // Kiểm tra ndung review có hợp lệ không?
    if(!ratingContentEl.value.trim()) {
        toastr.error('Bạn chưa nhập nội dung đánh giá.')
        return;
    }

    const data = {
        rating: countStar,
        content: ratingContentEl.value,
        movieId: movie.id
    }

    // Gọi API để tạo mới review sử dụng axios
    axios.put(`/api/reviews/${reviewIdUpdated}`, data)
        .then(function (response) {
            toastr.success('Cập nhật review thành công.')
            // Đóng modal
            modalReview.hide()

            // Cập nhật review trong danh sách reviews
            const index = reviews.findIndex(review => review.id === reviewIdUpdated)
            reviews[index] = response.data

            // Render lại danh sách reviews
            renderReview(reviews)
        })
        .catch(function (error) {
            console.log(error);
            toastr.error(error.response.data.message)
        });
}




