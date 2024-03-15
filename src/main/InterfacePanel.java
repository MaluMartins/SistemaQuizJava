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
	JButton botaoResp1 = new JButton();
	JButton botaoResp2 = new JButton();
	JButton botaoResp3 = new JButton();
	JButton botaoRespCorreta = new JButton();
	
	JLabel question = new JLabel();
	
	String[][] textos = {
			{"Quem foi o criador do Java?", "Bill Gates", "Linus Torvald", "Guido Von Rossum", "James Gosling"},
			{"Quem foi o criador do Java?1", "Bill Gates", "Linus Torvald", "Guido Von Rossum", "James Gosling"},
			{"Quem foi o criador do Java?2", "Bill Gates", "Linus Torvald", "Guido Von Rossum", "James Gosling"},
			{"Quem foi o criador do Java?3", "Bill Gates", "Linus Torvald", "Guido Von Rossum", "James Gosling"},
			{"Quem foi o criador do Java?4", "Bill Gates", "Linus Torvald", "Guido Von Rossum", "James Gosling"}
	};
	
	
	int pontos = 0;
	int numQuestao = 0;
	
	InterfacePanel() {
		setInterface();
		setQuizInterface();
	}
	
	public void setInterface() {
		//Propriedades da interface principal
		mainInterface.setSize(500, 500);
		
		mainInterface.add(mainPanel);
		mainInterface.setVisible(true);
		
		JLabel title = new JLabel();
		title.setText("Selecione o quiz que deseja realizar:");
		mainPanel.add(title);
		
		mainPanel.add(botao);
		
		botao.addActionListener(this);
	}
	
	public void setQuizInterface() {
		
		//Propriedades da interface de quiz
		quizInterface.setSize(500, 500);
		quizInterface.add(quizPanel);
		quizPanel.setLayout(new GridLayout(5,1));
		
		botaoResp1.addActionListener(this);
		botaoResp1.setActionCommand("1");
				
		botaoResp2.addActionListener(this);
		botaoResp2.setActionCommand("2");
				
		botaoResp3.addActionListener(this);
		botaoResp3.setActionCommand("3");
				
		botaoRespCorreta.addActionListener(this);
		botaoRespCorreta.setActionCommand("4");
				
		quizPanel.add(question);
		quizPanel.add(botaoResp1);
		quizPanel.add(botaoResp2);
		quizPanel.add(botaoResp3);
		quizPanel.add(botaoRespCorreta);
		
		numQuestao = 0;
		displayQuestion();
	}
	
	private void displayQuestion() {
        if (numQuestao < textos.length) {
        	question.setText(textos[numQuestao][0]);
            botaoResp1.setText(textos[numQuestao][1]);
            botaoResp2.setText(textos[numQuestao][2]);
            botaoResp3.setText(textos[numQuestao][3]);
            botaoRespCorreta.setText(textos[numQuestao][4]);
        } else {
            JOptionPane.showMessageDialog(quizInterface, "Quiz concluído! Sua pontuação final é: " + pontos);
            mainInterface.setVisible(true); 
            quizInterface.dispose(); 
        }
    }

	public void checkAnswer(ActionEvent e) {
		String actCmd = e.getActionCommand();
		
		switch (actCmd) {
        case "1":
        case "2":
        case "3":
            JOptionPane.showMessageDialog(quizInterface, "Resposta incorreta");
            break;
        case "4":
            JOptionPane.showMessageDialog(quizInterface, "Resposta correta");
            pontos++;
            break;
    }

		displayQuestion();
		numQuestao++;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actCmd = e.getActionCommand();
		
		mainInterface.setVisible(false);
		quizInterface.setVisible(true);
		
		checkAnswer(e);
		
	}
}
