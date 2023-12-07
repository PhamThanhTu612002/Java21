const btn = document.getElementById('btn');
const image = document.getElementById('image');
const select = document.getElementById('breed-list');
const form = document.querySelector('.form');
const optionValue = document.querySelector('option');
console.log(optionValue);

async function getBreedList() {
    let res = await axios.get("https://dog.ceo/api/breeds/list/all")
    renderBreed(res.data.message)
}
function renderBreed(breeds) {
    var keys = Object.keys(breeds);
    keys.forEach(function (key) {
        var option = document.createElement('option');
        option.value = key;
        option.innerHTML = key;
        select.appendChild(option);
    });
}
getBreedList();
btn.addEventListener("click", async () => {
    try {
        var selectedOption = select.options[select.selectedIndex];
        var selectedValue = selectedOption.value;
        var api = "https://dog.ceo/api/breed/" + selectedValue + "/images/random";
        const rs = await axios.get(api);
        image.src = rs.data.message;
    } catch (error) {
        console.log(error);
    }
});