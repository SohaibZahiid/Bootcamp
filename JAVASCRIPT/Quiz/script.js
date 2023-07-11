import Quiz from "./Quiz.js"

const btnBack = document.querySelector('.back')
const btnNext = document.querySelector('.next')
const btnFinish = document.querySelector('.finish')
const quizEls = document.querySelectorAll('.quiz')
const containerEl = document.querySelector('.quiz-container')
const mainContainerEl = document.querySelector('.container')

let current = 1
let correctAnswers = 0
let wrongAnswers = 0

const quizQuestions = [
    {
        id: 1,
        question: "What does HTML stand for?",
        possibleAnswers: ["Hyper Text Markup Language", "Home Tool Markup Language", "Hyperlinks and Text Markup Language", "Hyper Transfer Markup Language"],
        correctAnswer: "Hyper Text Markup Language"
    },
    {
        id: 2,
        question: "What is CSS used for?",
        possibleAnswers: ["Styling web pages", "Creating database queries", "Handling server-side logic", "Defining JavaScript functions"],
        correctAnswer: "Styling web pages"
    },
    {
        id: 3,
        question: "Which of the following is not a JavaScript framework or library?",
        possibleAnswers: ["Python", "React", "Angular", "Vue"],
        correctAnswer: "Python"
    },
    {
        id: 4,
        question: "What is the purpose of a media query in responsive web design?",
        possibleAnswers: ["To apply different styles based on the device's characteristics", "To fetch media files from a server", "To define the color palette of a website", "To create database queries"],
        correctAnswer: "To apply different styles based on the device's characteristics"
    },
    {
        id: 5,
        question: "What does API stand for?",
        possibleAnswers: ["Application Programming Interface", "Automated Programming Interface", "Algorithmic Programming Interface", "Advanced Protocol Interchange"],
        correctAnswer: "Application Programming Interface"
    }
];

createQuizDOM(quizQuestions)

function createQuizDOM(quizQuestions) {

    containerEl.innerHTML = '';
    let html = '';


    quizQuestions.forEach(quiz => {
        if (quiz.id == current) {
            let possibleAnswers = '';

            quiz.possibleAnswers.forEach(ans => {
                possibleAnswers += `
                <div class="answer">${ans}</div>
            `;
            });

            html += `
            <div class="quiz" data-id="${quiz.id}">
                <div class="question">
                    ${quiz.question}
                </div>
                <div class="answers-container">
                    ${possibleAnswers}
                </div>
                <div class="pagination">
                    <p>Question ${current} of ${quizQuestions.length}</p>
                </div>
            </div>
        `;
        }
    });

    containerEl.insertAdjacentHTML('beforeend', html)

    const answerEls = document.querySelectorAll('.quiz[data-id="' + current + '"] .answer');
    answerEls.forEach(answerEl => {
        answerEl.addEventListener('click', handleAnswerSelection);
    });

    quizEls.forEach(quizEl => {
        if (quizEl.dataset.id == current) {
            quizEl.classList.remove('hidden');
        } else {
            quizEl.classList.add('hidden');
        }
    });
}

btnBack.addEventListener('click', e => {
    current--;
    if (current < 1) {
        current = quizQuestions.length;
    }
    createQuizDOM(quizQuestions);
})

btnNext.addEventListener('click', e => {
    current++
    if (current > quizQuestions.length) {
        current = 1
    }

    createQuizDOM(quizQuestions)
})

function handleAnswerSelection(event) {
    const selectedAnswer = event.target.textContent;
    const answerEls = document.querySelectorAll('.quiz[data-id="' + current + '"] .answer');
  
    answerEls.forEach(answerEl => {
      answerEl.removeEventListener('click', handleAnswerSelection); // Disable click event for all answers in the current quiz
      answerEl.classList.remove('selected'); // Remove 'selected' class from all answers in the current quiz
    });
  
    event.target.classList.add('selected'); // Add 'selected' class to the clicked answer
  
    if (selectedAnswer == quizQuestions[current - 1].correctAnswer) {
      correctAnswers++;
    } else {
      wrongAnswers++;
    }
  }
  


btnFinish.addEventListener('click', e => {
    mainContainerEl.innerHTML = ""
    createResultDOM()
})

function createResultDOM() {
 const html = `
    <h1>Results</h1>
    <p>Correct Answers: ${correctAnswers}</p>  
    <p>Wrong Answers: ${wrongAnswers}</p>  
 `
    mainContainerEl.innerHTML = html
}