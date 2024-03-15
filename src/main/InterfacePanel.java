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
	int numQuestao = 1;
	
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
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println(i+" "+" "+j+" "+textos[i][j]);
			}
		}		
		botaoResp1.addActionListener(this);
				
		botaoResp2.addActionListener(this);
				
		botaoResp3.addActionListener(this);
				
		botaoRespCorreta.addActionListener(this);
				
		quizPanel.add(question);
		quizPanel.add(botaoResp1);
		quizPanel.add(botaoResp2);
		quizPanel.add(botaoResp3);
		quizPanel.add(botaoRespCorreta);
		
		for (int i=0; i < numQuestao; i++) {
			question.setText(this.textos[i][0]);
			botaoResp1.setText(this.textos[i][1]);
			botaoResp2.setText(this.textos[i][2]);
			botaoResp3.setText(this.textos[i][3]);
			botaoRespCorreta.setText(this.textos[i][4]);
		}
	}
	

	public void checkAnswer(ActionEvent e) {
		setQuizInterface();
		if (e.getSource() == botaoRespCorreta) {
			JOptionPane.showMessageDialog(quizInterface, "resposta correta");
			pontos = this.pontos + 1;
		} else {
			JOptionPane.showMessageDialog(quizInterface, "resposta errada");
		}
		
		this.numQuestao++;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actCmd = e.getActionCommand();
		
		mainInterface.setVisible(false);
		quizInterface.setVisible(true);
		
		checkAnswer(e);
	}
}
