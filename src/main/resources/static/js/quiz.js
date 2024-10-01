const nextBtns = document.querySelectorAll(".next_btn");
const radioBtns = document.querySelectorAll(".radio_btn");
const timeCounts = document.querySelectorAll(".timer_sec");
const timeOffs = document.querySelectorAll(".time_text");
const radioLabels = document.querySelectorAll("label");

let currentQuestion = 0;
let questionNumber = timeCounts.length;
let timeToAnswer = 60;
let interval;

showFirstQuestion();
showNextQuestion();
showNextButtonAfterChose();

function showFirstQuestion() {
    const firstQuestion = document.getElementById("question_0");
    firstQuestion.classList.add("active_question_0");
    let radio = createNewArray(radioBtns, 0);
    let radioLabel = createNewArray(radioLabels, 0);
    //startTimer(timer, timeCounts[0], timeOffs[0], radio, nextBtns[0], radioLabel);
    startTimer(0);
}

function showNextQuestion() {
    for (let i = 0; i < nextBtns.length; i++) {
        const btn = nextBtns[i];
        btn.addEventListener('click', (e) => nextBtnOnClick(i));
    }
}

function nextBtnOnClick() {
    clearInterval(interval);
    const current_question_box = document.getElementById("question_" + currentQuestion);
    current_question_box.classList.remove("active_question_" + currentQuestion);
    currentQuestion = currentQuestion + 1;
    const next_question_box = document.getElementById("question_" + currentQuestion);
    next_question_box.classList.add("active_question_" + currentQuestion);
    //let radio = createNewArray(radioBtns, currentQuestion * 4);
    //let radioLabel = createNewArray(radioLabels, currentQuestion * 4);
    //startTimer(timer, timeCounts[currentQuestion], timeOffs[currentQuestion], radio, nextBtns[currentQuestion], radioLabel);
    startTimer(currentQuestion);
}

function showNextButtonAfterChose() {
    for (let i = 0; i < radioBtns.length - 4; i++) {
        const radio = radioBtns[i];
        const radioName = radio.getAttribute("name");
        const radioId = Number(radioName.substring(10));
        radio.addEventListener('click', (e) => radioBtnOnClick(radioId));
    }

    for (let i = radioBtns.length - 4; i < radioBtns.length; i++) {
        const radio = radioBtns[i];
        radio.addEventListener('click', (e) => lastRadioButtonOnClick());
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

/*function startTimer(time, timeCount, timeOff, radio, next_btn, radioLabels) {
    interval = setInterval(timer, 1000);

    function timer() {
        timeCount.textContent = time;
        time--;

        if (time < 9) {
            let addZero = timeCount.textContent;
            timeCount.textContent = "0" + addZero;
        }
        if (time < 0) {
            clearInterval(interval);
            timeCount.textContent = "00";
            timeOff.textContent = "Время вышло";

            for (let i = 0; i < radio.length; i++) {
                radio[i].classList.add("disabled");
                radio[i].readOnly = true;
                radioLabels[i].classList.add("disabled");
                radioLabels[i].readOnly = true;
            }

            next_btn.style.display = "block";
        }
    }
}*/


function startTimer(index) {
    let time = timeToAnswer;
    let timeCount = timeCounts[index];
    let timeOff = timeOffs[index];
    let radio = createNewArray(radioBtns, index * 4);
    let nextBtn = nextBtns[index];
    let radioLabels = createNewArray(radioBtns, index * 4)

    interval = setInterval(timer, 1000);

    function timer() {
        timeCount.textContent = time;
        time--;

        if (time < 9) {
            let addZero = timeCount.textContent;
            timeCount.textContent = "0" + addZero;
        }
        if (time < 0) {
            clearInterval(interval);
            timeCount.textContent = "00";
            timeOff.textContent = "Время вышло";

            for (let i = 0; i < radio.length; i++) {
                radio[i].classList.add("disabled");
                radio[i].readOnly = true;
                radioLabels[i].classList.add("disabled");
                radioLabels[i].readOnly = true;
            }

            if (index == questionNumber - 1) {
                lastRadioButtonOnClick();
            } else {
                nextBtn.style.display = "block";
            }
        }
    }
}

function createNewArray(array, index) {
    let radio = [];
    for (let i = index; i < index + 4; i++) {
        radio.push(array[i]);
    }
    return radio;
}