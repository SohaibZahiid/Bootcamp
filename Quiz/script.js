import Quiz from "./Quiz.js"

const btnBack = document.querySelector('.back')
const btnNext = document.querySelector('.next')
const quizEls = document.querySelectorAll('.quiz')
const containerEl = document.querySelector('.container')

let current = 1

const quizQuestions = [
    {
        id: 1,
        question: "What does HTML stand for?",
        possibleAnswers: ["Hyper Text Markup Language", "Home Tool Markup Language", "Hyperlinks and Text Markup Language", "Hyper Transfer Markup Language"]
    },
    {
        id: 2,
        question: "What is CSS used for?",
        possibleAnswers: ["Styling web pages", "Creating database queries", "Handling server-side logic", "Defining JavaScript functions"]
    },
    {
        id: 3,
        question: "Which of the following is not a JavaScript framework or library?",
        possibleAnswers: ["Python", "React", "Angular", "Vue"]
    },
    {
        id: 4,
        question: "What is the purpose of a media query in responsive web design?",
        possibleAnswers: ["To apply different styles based on the device's characteristics", "To fetch media files from a server", "To define the color palette of a website", "To create database queries"]
    },
    {
        id: 5,
        question: "What does API stand for?",
        possibleAnswers: ["Application Programming Interface", "Automated Programming Interface", "Algorithmic Programming Interface", "Advanced Protocol Interchange"]
    }
];

createQuizDOM(quizQuestions)

function createQuizDOM(quizQuestions) {
    let html = '';

    quizQuestions.forEach(quiz => {
        let possibleAnswers = '';

        quiz.possibleAnswers.forEach(ans => {
            possibleAnswers += `
                <div class="answer">${ans}</div>
            `;
        });

        html += `
            <div class="quiz" data-id="${quiz.id}">
                <div class="top">
                    <button class="btn back"><</button>
                    <div class="title">Quiz</div>
                    <button class="btn next">></button>
                </div>
                <div class="question">
                    ${quiz.question}
                </div>
                <div class="answers-container">
                    ${possibleAnswers}
                </div>
                <div class="pagination">
                    <p>Question 1 of ${quizQuestions.length}</p>
                </div>
            </div>
        `;
    });

    containerEl.innerHTML = html
}

