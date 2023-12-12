function getStringHasMaxLength(strList){
    let maxLength = 0;
    strList.forEach(str =>{
        if(str.length > maxLength){
            maxLength = str.length;
        }
    })
    let maxLengthStringList = [];
    strList.forEach(string =>{
        if(string.length === maxLength){
            maxLengthStringList.push(string);
        }
    })
    console.log(maxLengthStringList);
}
getStringHasMaxLength(['aba', 'aa', 'ad', 'c', 'vcd']);