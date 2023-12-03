const questions = [
    {
        title: "Việt nam có bao nhiêu dân tộc?",
        choices: ["54","55","56","57"],
        answer: "54",
    },
    {
        title: "Việt nam có bao nhiêu tỉnh?",
        choices: ["54","55","56","63"],
        answer: "63",
    },
    {
        title: "Việt nam có bao nhiêu múi giờ + mấy?",
        choices: ["5","6","7","8"],
        answer: "7",
    },
    {
        title: "Việt nam có thủ đô là gì?",
        choices: ["Hà Nội","Đà Nẵng","Hải Phòng","TP Hồ Chí Minh"],
        answer: "Hà Nội",
    }
];
const rounded = document.querySelector('.rounded');
let currIndex = 0;
let score = 0;
let yourAnswer = [];
let questionsStatus = questions.map((question, index) => {
    if(index <= currIndex) {
        return true;
    }
    return false;
});
console.log(questionsStatus);
const quesTitleEl = document.querySelector('p');
const choiceEl = document.querySelector('.choices');
const btnNext = document.getElementById("btn-next");
const btnFinish = document.getElementById("btn-finish");
const bar = document.querySelector(".progress-bar");
const questionNumber = document.querySelector('.question-number');
console.log(choiceEl);

const renderQuestion = () =>{
    const curQuestion = questions[currIndex];
    quesTitleEl.innerText = `Câu ${currIndex+1} : ${curQuestion.title}`;

    let htmlChoice = "";
    curQuestion.choices.forEach((choice, index) => {
        htmlChoice += `<div class="choice-item">
                            <input type="radio" name="choice" id="choice-${index}" value="${choice}" ${choice == yourAnswer[currIndex] ? 'checked':''}>
                            <label for="choice-${index}">${choice}</label>
                        </div>`;
    });
    choiceEl.innerHTML = htmlChoice;
    //Cập nhật progress bar
    bar.style.width = ((yourAnswer.length+1)/questions.length)*100 + "%";
    bar.innerText = ((yourAnswer.length+1)/questions.length)*100 + "%";
    //Cập nhật số câu hỏi
    renderQuestionNumber();
};
const renderQuestionNumber = () =>{
    let html = "";
    questions.forEach((qs,index) => {
        html += `<div class="rounded border py-2 px-3 me-2 ${index === currIndex ? 'border-primary' : ''} ${questionsStatus[index] == false ? 'disabled bg-black bg-opacity-10' : ''}"
                     onclick="renderQuestionNumberWithIndex(${index})";>
                    ${index+1}
                </div>`;
        index++;
    });
    questionNumber.innerHTML = html;
};
const renderQuestionNumberWithIndex = (questionNumber2) =>{
    if(questionsStatus[questionNumber2] == true){
        currIndex = questionNumber2;
    }
    renderQuestion();
};
btnNext.addEventListener('click',() =>{
    // Kiểm tra xem đã chọn đáp án chưa
    //Nếu chưa thì alert cảnh báo
    const checkedChoice = document.querySelector("input[type=radio]:checked");
    if(!checkedChoice){
        alert("Bạn chưa chọn đáp án");
        return;
    }else{
        yourAnswer[currIndex] = checkedChoice.value;
    }
    //Lưu lại đáp an đã trả lời
    
    currIndex++;
    questionsStatus[currIndex] = true;
    console.log(questionsStatus);
    console.log(yourAnswer);
    renderQuestion();
    if(currIndex === questions.length - 1){
        btnNext.classList.add("hide");
        btnFinish.classList.remove("hide");
    }
});
btnFinish.addEventListener('click',() =>{
    const checkedChoice = document.querySelector("input[type=radio]:checked");
    if(!checkedChoice){
        alert("Bạn chưa chọn đáp án");
        return;
    }
    //Lưu lại đáp an đã trả lời
    yourAnswer.push(checkedChoice.value);
    questionsStatus[currIndex] = true;
    // Tính điểm
    let num = 0;
    for (let i = 0; i < yourAnswer.length; i++) {
        if(questions[i].answer === yourAnswer[i]){
            score += 10;
            num++;
        }
    }
    alert("Điểm của bạn là: " + score + ". Đã đúng : " + num +"/"+yourAnswer.length);
    
});

renderQuestion();
