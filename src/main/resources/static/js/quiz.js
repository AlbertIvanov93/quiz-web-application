const next_btn = document.querySelectorAll(".next_btn");
let currentQuestion = 0;

for (let i = 0 ; i < next_btn.length ; i++) {
    const btn = next_btn[i];
    btn.addEventListener('click' , (e) => nextBtnOnClick())
}


function nextBtnOnClick() {
    const current_question_box = document.getElementById("question_" + currentQuestion);
    current_question_box.classList.remove("active_question_" + currentQuestion);
    currentQuestion = currentQuestion + 1;
    const next_question_box = document.getElementById("question_" + currentQuestion);
    next_question_box.classList.add("active_question_" + currentQuestion);
}