const next_btns = document.querySelectorAll(".next_btn");
const radio_btns = document.querySelectorAll(".radio_btn");
const quiz_box = document.querySelector(".outer_box .inner_box");
const timeCounts = quiz_box.querySelectorAll(".timer .timer_sec");
const timeOffs = quiz_box.querySelectorAll("header .time_text");

let currentQuestion = 0;
let counter;
let timer = 15;

showFirstQuestion();
showNextQuestion();
showNextButtonAfterChose();

function showFirstQuestion() {
    const firstQuestion = document.getElementById("question_0");
    firstQuestion.classList.add("active_question_0");
    let radio = createNewArray(radio_btns, 0);
    startTimer(timer, timeCounts[0], timeOffs[0], radio, next_btns[0]);
}
function showNextQuestion() {
    for (let i = 0 ; i < next_btns.length ; i++) {
        const btn = next_btns[i];
        btn.addEventListener('click' , (e) => nextBtnOnClick(i));
    }
}

function nextBtnOnClick() {
    const current_question_box = document.getElementById("question_" + currentQuestion);
    current_question_box.classList.remove("active_question_" + currentQuestion);
    currentQuestion = currentQuestion + 1;
    const next_question_box = document.getElementById("question_" + currentQuestion);
    next_question_box.classList.add("active_question_" + currentQuestion);
    let radio = createNewArray(radio_btns, currentQuestion * 4); // не работает
    startTimer(timer, timeCounts[currentQuestion], timeOffs[currentQuestion], radio, next_btns[currentQuestion]);
}

function showNextButtonAfterChose() {
    for (let i = 0 ; i < radio_btns.length - 4 ; i++) {
        const radio = radio_btns[i];
        const radioName = radio.getAttribute("name");
        const radioId = Number(radioName.substring(10));
        radio.addEventListener('click' , (e) => radioBtnOnClick(radioId));
    }

    for (let i = radio_btns.length - 4 ; i < radio_btns.length ; i++) {
        const radio = radio_btns[i];
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

function startTimer(time, timeCount, timeOff, radio, next_btn) {
    counter = setInterval(timer, 1000);
    function timer(){
        timeCount.textContent = time;
        time--;

        if (time < 9) {
            let addZero = timeCount.textContent;
            timeCount.textContent = "0" + addZero;
        }
        if(time < 0) {
            clearInterval(counter);
            timeCount.textContent = "00";
            timeOff.textContent = "Время вышло";

            for (let i = 0; i < radio.length; i++) {
                radio[i].classList.add("disabled");
                radio[i].disabled = true;
            }

            next_btn.style.display = "block";
        }
    }
}

function createNewArray(radio_btns, index) {
    let radio = [];
    for (let i = index; i < index + 4; i++) {
        radio.push(radio_btns[i]);
    }
    return radio;
}