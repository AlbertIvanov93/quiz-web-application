const next_btn = document.querySelectorAll(".next_btn");
const radio_btn = document.querySelectorAll(".radio_btn");
let currentQuestion = 0;

showFirstQuestion();
showNextQuestion();
showNextButtonAfterChose();

function showFirstQuestion() {
    const firstQuestion = document.getElementById("question_0");
    firstQuestion.classList.add("active_question_0");
}
function showNextQuestion() {
    for (let i = 0 ; i < next_btn.length ; i++) {
        const btn = next_btn[i];
        btn.addEventListener('click' , (e) => nextBtnOnClick());
    }
}

function nextBtnOnClick() {
    const current_question_box = document.getElementById("question_" + currentQuestion);
    current_question_box.classList.remove("active_question_" + currentQuestion);
    currentQuestion = currentQuestion + 1;
    const next_question_box = document.getElementById("question_" + currentQuestion);
    next_question_box.classList.add("active_question_" + currentQuestion);
}

function showNextButtonAfterChose() {
    for (let i = 0 ; i < radio_btn.length - 4 ; i++) {
        const radio = radio_btn[i];
        const radioName = radio.getAttribute("name");
        const radioId = Number(radioName.substring(10));
        radio.addEventListener('click' , (e) => radioBtnOnClick(radioId));
    }

    for (let i = radio_btn.length - 4 ; i < radio_btn.length ; i++) {
        const radio = radio_btn[i];
        radio.addEventListener('click' , (e) => lastRadioButtonOnClick());
    }
}

function radioBtnOnClick(radioId) {
    const nextButton = document.querySelector("#button_" + radioId);
    nextButton.classList.add("active_button_" + radioId);
}

function lastRadioButtonOnClick() {
    const submitButton = document.getElementById("send_result");
    submitButton.classList.add("active_send_result");
}