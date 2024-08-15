//getting all required elements
const start_btn = document.querySelector(".start_btn button");
const info_box = document.querySelector(".info_box");
const exit_btn = info_box.querySelector(".buttons .quit");
const continue_btn = info_box.querySelector(".buttons .restart");
const quiz_box = document.querySelector(".quiz_box");
const next_btn = quiz_box.querySelector(".next_btn");
const option_list = document.querySelector(".option_list");
const timeCount = quiz_box.querySelector(".timer .timer_sec");
const timeLine = quiz_box.querySelector("header .time_line");
const result_box = document.querySelector(".result_box");
const restart_quiz = result_box.querySelector(".buttons .restart");
const quit_quiz = result_box.querySelector(".buttons .quit");
const timeOff = quiz_box.querySelector("header .time_text");
const login_box = document.querySelector(".login_box");
//const rules_btn = login_box.querySelector("footer button");

let userName;
let date;

let tickIcon = '<div class="icon tick"><i class="fa fa-check"></i></div>';
let crossIcon = '<div class="icon cross"><i class="fa fa-times"></i></div>';

let que_count = 0;
let que_numb = 1;
let counter;
let counterLine;
let timeValue = 60;
let widthValue = 0;
let userScore = 0;

//if start test button clicked
start_btn.onclick = ()=>{
    info_box.classList.add("activeInfo"); //show the info box

}

//if rules button clicked
/*rules_btn.onclick = ()=>{
    let userLastname = document.getElementById("lname").value;
    let userFirstname = document.getElementById("fname").value;
    userName = userLastname + " " + userFirstname;
    date = new Date();

    login_box.classList.remove("activeLogin"); // hide the login box
    info_box.classList.add("activeInfo"); //show the info box
}*/

//if exit button clicked
//exit_btn.onclick = ()=>{
//	info_box.classList.remove("activeInfo"); // hide the info box
//}

//if continue button clicked
continue_btn.onclick = ()=>{
    info_box.classList.remove("activeInfo"); // hide the info box
    quiz_box.classList.add("activeQuiz"); //show the quiz box
    showQuestions(que_count);
    queCounter(que_numb);
    startTimer(timeValue);
    startTimerLine(widthValue);
    result.beginDate = new Date();
}

function sendPostRequest(result) {
    fetch("/quiz/", {
        method: "POST",
        body: JSON.stringify(result),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    })
}

//if next button clicked
next_btn.onclick = ()=>{
    if (que_count < questions.length - 1) {
        que_count++;
        que_numb++;
        showQuestions(que_count);
        queCounter(que_numb);
        clearInterval(counter);
        startTimer(timeValue);
        clearInterval(counterLine);
        startTimerLine(widthValue);
        next_btn.style.display = "none";
        timeOff.textContent = "Осталось времени";
    } else {
        clearInterval(counter);
        clearInterval(counterLine);
        //console.log("Questions completed");
        result.endDate = new Date();
        sendPostRequest(result);
        showResultBox();
    }
}

//if quit button clicked
//quit_quiz.onclick = ()=>{
//	window.location.reload();
//}

//if restart button clicked
/*restart_quiz.onclick = ()=>{
	quiz_box.classList.add("activeQuiz");
	result_box.classList.remove("activeResult");
	let que_count = 0;
	let que_numb = 1;
	let timeValue = 60;
	let widthValue = 0;
	let userScore = 0;
	showQuestions(que_count);
	queCounter(que_numb);
	clearInterval(counter);
	startTimer(timeValue);
	clearInterval(counterLine);
	startTimerLine(widthValue);
	next_btn.style.display = "none";
	timeOff.textContent = "Осталось времени";
}*/

//getting questions and options from array
function showQuestions(index) {
    const que_text = document.querySelector(".que_text");
    //const que_image = document.querySelector(".que_image");
    let que_tag = '<span>' + (index + 1) + '. ' + questions[index].title + '</span>';
    //let image_tag = '<img src="' + questions[index].image + '">';
    let option_tag = '<div class="option"><span>' + questions[index].options[0] + '</span></div>'
        + '<div class="option"><span>' + questions[index].options[1] + '</span></div>'
        + '<div class="option"><span>' + questions[index].options[2] + '</span></div>'
        + '<div class="option"><span>' + questions[index].options[3] + '</span></div>';
    que_text.innerHTML = que_tag;
    //que_image.innerHTML = image_tag;
    option_list.innerHTML = option_tag;
    const option = option_list.querySelectorAll(".option");
    for (let i = 0; i < option.length; i++) {
        option[i].setAttribute("onclick", "optionSelected(this)");
    }
}

function showResultBox() {
    info_box.classList.remove("activeInfo"); // hide the info box
    quiz_box.classList.remove("activeQuiz"); //hide the quiz box
    result_box.classList.add("activeResult"); //show the result box
    const scoreText = result_box.querySelector(".score_text");
    const completeText = result_box.querySelector(".complete_text");
    const username_field = result_box.querySelector(".username");
    const date_field = result_box.querySelector(".date");
    username_field.innerHTML = userName;
    const shortDateTime = new Intl.DateTimeFormat("ru", {dateStyle: "short", timeStyle: "short"}).format(date);
    date_field.innerHTML = shortDateTime;
    if (userScore < 5) {
        completeText.textContent = "Вы не прошли тест";
        let scoreTag = '<span> К сожалению, набрали всего <p>' + userScore + '</p> из <p>' + questions.length + '</p></span>';
        scoreText.innerHTML = scoreTag;
    } else if (userScore < 7) {
        completeText.textContent = "Вы прошли тест";
        let scoreTag = '<span> но, к сожалению, набрали всего <p>' + userScore + '</p> из <p>' + questions.length + '</p></span>';
        scoreText.innerHTML = scoreTag;
    } else {
        completeText.textContent = "Вы прошли тест";
        let scoreTag = '<span> Поздравляем вы набрали <p>' + userScore + '</p> из <p>' + questions.length + '</p></span>';
        scoreText.innerHTML = scoreTag;
    }
}

function optionSelected(answer) {
    clearInterval(counterLine);
    clearInterval(counter);
    let userAns = answer.textContent;
    let correctAns = questions[que_count].answer;
    let allOptions = option_list.children.length;

    // add result to result object
    result.userAnswer[que_count] = userAns;
    result.question[que_count] = questions[que_count].title;
    console.log(result);


    if (userAns == correctAns) {
        userScore += 1;
        //console.log(userScore);
        answer.classList.add("correct");
        //console.log("Answer is correct");
        answer.insertAdjacentHTML("beforeend", tickIcon);
    } else {
        answer.classList.add("incorrect");
        //console.log("Answer is wrong");
        answer.insertAdjacentHTML("beforeend", crossIcon);

        //if answer is incorrect then automatically selected correct answer
        for (let i = 0; i < allOptions; i++) {
            if(option_list.children[i].textContent == correctAns) {
                option_list.children[i].setAttribute("class", "option correct");
                option_list.children[i].insertAdjacentHTML("beforeend", tickIcon);
            }
        }
    }

    //once user selected disalbe all options
    for (let i = 0; i < allOptions; i++) {
        option_list.children[i].classList.add("disabled");
    }
    next_btn.style.display = "block";
}

function queCounter(index) {
    const bottom_ques_counter = quiz_box.querySelector(".total_que");
    let totalQuesCountTag = '<span><p>' + index + '</p>из<p>' + questions.length + '</p>вопросов</span>';
    bottom_ques_counter.innerHTML = totalQuesCountTag;
}

function startTimer(time) {
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

            let correctAns = questions[que_count].answer;
            let allOptions = option_list.children.length;

            for (let i = 0; i < allOptions; i++) {
                if(option_list.children[i].textContent == correctAns) {
                    option_list.children[i].setAttribute("class", "option correct");
                    option_list.children[i].insertAdjacentHTML("beforeend", tickIcon);
                }
            }

            for (let i = 0; i < allOptions; i++) {
                option_list.children[i].classList.add("disabled");
            }

            next_btn.style.display = "block";
        }
    }
}

function startTimerLine(time) {
    counterLine = setInterval(timer, 50);
    function timer(){
        time += 1;
        timeLine.style.width = time*550/timeValue/20 + "px";
        if(time > 1198) {
            clearInterval(counterLine);
        }
    }
}