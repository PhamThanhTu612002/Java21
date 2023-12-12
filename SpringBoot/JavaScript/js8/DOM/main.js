const quizes = [
    {
        id: 1,
        question: "1 + 1 = ?",
        answers: [1, 2, 3, 4],
    },
    {
        id: 2,
        question: "2 + 2 = ?",
        answers: [2, 3, 4, 5],
    },
    {
        id: 3,
        question: "3 + 3 = ?",
        answers: [3, 4, 5, 6],
    },
];
const quizItem = document.querySelector(".quiz-container");
const renderQuestion = (quizes) => {
    let html = "";
    quizes.forEach(quiz => {
        html += `<div class="quiz-item">
                    <h3>Câu ${quiz.id} : ${quiz.question}</h3>
                    <div class="quiz-answer">
                        <div class="quiz-answer-item">
                            <input type="radio" name="${quiz.id}">
                            <label>${quiz.answers[0]}</label>
                        </div>
                        <div class="quiz-answer-item">
                            <input type="radio" name="${quiz.id}">
                            <label>${quiz.answers[1]}</label>
                        </div>
                        <div class="quiz-answer-item">
                            <input type="radio" name="${quiz.id}">
                            <label>${quiz.answers[2]}</label>
                        </div>
                        <div class="quiz-answer-item">
                            <input type="radio" name="${quiz.id}">
                            <label>${quiz.answers[3]}</label>
                    </div>
                </div>`;
    })
    quizItem.innerHTML = html;
}
renderQuestion(quizes);
const btn = document.getElementById('btn');

btn.addEventListener('click', () => {
    quizes.forEach(question => {
        const randomIndex = Math.floor(Math.random() * question.answers.length);
        const quizList = document.querySelectorAll(`input[name="${question.id}"]`);
        quizList.checked = false;
        quizList[randomIndex].checked = true;
    })
});
