function getCountElement(listString){
    let result = [];
    listString.forEach(str => {
        result[str] = (result[str] || 0) + 1;
    });
    console.log(result);
}
getCountElement(["one", "two", "three", "one", "one", "three"]);