/* 
Mô hình Client -Server
Client - request - server : Xử lý - reponse - client
request : CRUD ( Create , Read, Update, Delete)
Response : JSON (Javascript Object Notation), XML, HTML,...

APi(Application Programming Interface) : Giao diện lập trình ứng dụng 
( giao tiếp giữa người dùng vs ứng dụng hoặc các service trong ứng dụng)

Khách hàng : Client
Nhân viên : Lấy menu, gọi món, hủy món, thêm món, thanh toán (API)
Nhà bếp : Server

Tài nguyên hệ thống : Món ăn

Hành động tương tác với tài nguyên : 

Phương thức: GET-READ, POST-CREATE, PUT-UPDATE, DELETE-DELETE,...

Response : Thành công - Thất bại (HTTP status code)

Informational responses (100 – 199)
Successful responses (200 – 299)
Redirection messages (300 – 399)
Client error responses (400 – 499)
Server error responses (500 – 599)

API examples : 
-GET /api/v1/posts : Lấy danh sách bài viết
-GET /api/v1/posts?limit=10&page=1: Lấy danh sách bài viết, mỗi trang 10 bài viết
-GET /api/v1/posts/1 : Lấy bài viết có id = 1

-DELETE /api/v1/posts/1 : Xóa bài viết id = 1

-POST /api/v1/posts : Tạo bài viết 
    request body - {title : 'abc',content : 'xyz'}

-PUT /api/v1/posts/1 : Cập nhật bài viết id = 1
    request body - {title : 'XYZ',content : 'xyz'}

Gọi API trong JS:
-fetch API : build-in method của JS
-axios : thư viện bên ngoài

*/

const btn = document.getElementById("btn");
const image = document.getElementById("image");
// Cách 1: fetch API
// Bấm nút  -> gọi API -> Lấy dữ liệu từ API -> hiển thị lên giao diện
// btn.addEventListener("click", () => {
//     // fetch("https://dog.ceo/api/breeds/image/random")
//     //   .then(rs => {
//     //         console.log(rs);
//     //         return rs.json();
//     //   })
//     //   .then(rs => {
//     //     console.log(rs); // {message,status}
//     //     image.src = rs.message;
//     //   })
//     //   .catch(err => {
//     //     console.log(err);
//     //   })
// })

//Cách 2: async Function
// btn.addEventListener("click", async () => {
//     try {
//         const rs = await fetch("https://dog.ceo/api/breeds/image/random");
//         const data = await rs.json();
//         image.src = data.message;
//     } catch (error) {
//         console.log(error);
//     }
// });

//Cách 3: axios
// btn.addEventListener("click", async () => {
//     axios.get('https://dog.ceo/api/breeds/image/random')
//     .then(function (response) {
//         // xử trí khi thành công
//         console.log(response);
//         image.src = response.data.message;
//     })
//     .catch(function (error) {
//         // xử trí khi bị lỗi
//         console.log(error);
//     })
// });

//Cách 4: axios/async Function
btn.addEventListener("click", async () => {
    try {
        const rs = await axios.get('https://dog.ceo/api/breeds/image/random');
        image.src = rs.data.message;
    } catch (error) {
        console.log(error);
    }
});