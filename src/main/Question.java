package main;

public class Question {
	String questionText;
	String[] options;
	String correctAnswer;
	
	public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
	
	public String getQuestionText() {
		return questionText;
	}
	
	public String[] getOptions() {
		return options;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
}
