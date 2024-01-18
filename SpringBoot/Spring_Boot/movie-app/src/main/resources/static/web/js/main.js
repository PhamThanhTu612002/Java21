const deleteReview = async (reviewId) => {
    const isConfirmed = confirm("Bạn có chắc chắn muốn xóa không")
    if(!isConfirmed) return
    axios.delete("http://localhost:8081/api/reviews/"+reviewId)
        .then(function(response) {
            alert("Xóa thành công")
            window.location.reload()
        }).catch(error =>{
            console.log(error)
        });
}
let countStar = 0;
document.addEventListener("DOMContentLoaded", function () {
    const ratingItems = document.querySelectorAll('.rating-item');

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
});
const createReview = async (movieId) => {
    const content = document.querySelector('#floatingTextarea2');
    axios.post("http://localhost:8081/api/reviews",{
        content: content.value,
        movieId: movieId,
        rating: countStar
    }).then(function(response) {
        alert("Bình luận thành công")
        window.location.reload()
    }).catch(error =>{
        console.log(error)
    });
}
let reivewIdUpdated =0;
const getIdReview = (reviewID) =>{
    reivewIdUpdated = reviewID;
}
const updateReview = async (movieId) => {
    console.log("123");
    const content = document.querySelector('#floatingTextarea3');
    axios.put("http://localhost:8081/api/reviews/"+reivewIdUpdated,{
        content: content.value,
        movieId: movieId,
        rating: countStar
    }).then(function(response) {
        alert("Cập nhật thành công")
        window.location.reload()
    }).catch(error =>{
        console.log(error)
    });
}


