package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfacePanel implements ActionListener{
	JFrame mainInterface = new JFrame();
	JFrame quizInterface = new JFrame();
	
	JPanel mainPanel = new JPanel();
	JPanel quizPanel = new JPanel();
	
	JButton botao = new JButton("Quiz de Java");
	JButton[] optionsButtons = new JButton[4]; //array de objetos jbutton
	
	JLabel questionText = new JLabel();
	
	Question[] questions = {
		    new Question("Quem foi o criador do Java?", 
		                 new String[]{"Bill Gates", "Linus Torvald", "Guido Von Rossum", "James Gosling"}, 
		                 "James Gosling"),
		    new Question ("Qual é o resultado da expressão Java 3 + 5 * 2?", 
		    			   new String[] {"16", "13", "11", "10"},
		    			   "13"),
		    new Question ("Qual é o propósito do modificador de acesso public ao declarar uma classe em Java?", 
	    			   new String[] {"Torna a classe acessível apenas dentro do mesmo pacote.", "Torna a classe acessível apenas dentro da mesma classe.", "Torna a classe acessível em qualquer lugar, tanto dentro quanto fora do pacote.", "Torna a classe acessível apenas em classes filhas."},
	    			   "Torna a classe acessível em qualquer lugar, tanto dentro quanto fora do pacote."),
		    new Question ("Como você cria um objeto em Java?", 
	    			   new String[] {"Usando o operador new.", "Usando o operador create.", "Usando o método instantiate.", "Usando o operador object."},
	    			   "Usando o operador new."),
		    new Question ("Qual estrutura de repetição em Java é mais apropriada quando você precisa executar um bloco de código um número fixo de vezes?", 
	    			   new String[] {"for", "while", "do-while", "foreach"},
	    			   "for")
		};

	
	int pontos = 0;
	int numQuestao = 0;
	
	InterfacePanel() {
		setInterface();
		//setQuizInterface();
	}
	
	public void setInterface() {
		//Propriedades da interface principal
		mainInterface.setSize(500, 500);
		mainInterface.add(mainPanel);
		
		JLabel title = new JLabel("Selecione o quiz que deseja realizar:");
		mainPanel.add(title);
		
		mainPanel.add(botao);
		botao.addActionListener(this);
		
		mainInterface.setVisible(true);
	}
	
	public void setQuizInterface() {
		mainInterface.setVisible(false);
		
		//Propriedades da interface de quiz
		quizInterface.setSize(600, 500);
		quizInterface.add(quizPanel);
		quizPanel.setLayout(new BorderLayout());
		
		quizPanel.add(questionText, BorderLayout.NORTH);
		questionText.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel respostaPanel = new JPanel(new GridLayout(2, 2));
		respostaPanel.setLayout(new BoxLayout(respostaPanel, BoxLayout.Y_AXIS));
        quizPanel.add(respostaPanel, BorderLayout.CENTER);

		for (int i = 0; i < optionsButtons.length; i++) {
            optionsButtons[i] = new JButton();
            optionsButtons[i].addActionListener(this);
            
            optionsButtons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            respostaPanel.add(Box.createVerticalStrut(15));
            
            respostaPanel.add(optionsButtons[i]);
        }
		
		numQuestao = 0;
		displayQuestion();
		quizInterface.setVisible(true);
	}
	
	public void displayQuestion() {
        if (numQuestao < questions.length) {
            Question question = questions[numQuestao];
            questionText.setText(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < optionsButtons.length; i++) {
                optionsButtons[i].setText(options[i]);
            }
        } else {
        	JOptionPane.showMessageDialog(quizInterface, "Quiz concluído! Sua pontuação final é: " + (pontos*100)/questions.length + "%");
            mainInterface.setVisible(true);
            quizInterface.dispose();
        }
    }

    public void checkAnswer(String resposta) {
        Question question = questions[numQuestao];
        if (resposta.equals(question.getCorrectAnswer())) {
            JOptionPane.showMessageDialog(quizInterface, "Resposta correta!");
            pontos++;
        } else {
            JOptionPane.showMessageDialog(quizInterface, "Resposta incorreta!");
        }
        numQuestao++;
        displayQuestion();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botao) {
            setQuizInterface();
        } else {
            for (JButton button : optionsButtons) {
                if (e.getSource() == button) {
                    checkAnswer(button.getText());
                    break;
                }
            }
        }
		
	}
}
