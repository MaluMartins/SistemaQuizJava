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
	JButton botaoResp4 = new JButton();
	
	InterfacePanel() {
		setInterface();
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
		
		//Propriedades da interface de quiz
		quizInterface.setSize(500, 500);
		quizInterface.add(quizPanel);

		JLabel question = new JLabel("Quem foi o criador do Java?"):
		botaoResp1.setText("Bill Gates");
		botaoResp1.addActionListener(this);
		botaoResp1.setActionCommand(1);
		
		botaoResp2.setText("Linus Torvald");
		botaoResp2.addActionListener(this);
		botaoResp2.setActionCommand(2);
		
		botaoResp3.setText("James Gosling");
		botaoResp3.addActionListener(this);
		botaoResp3.setActionCommand(3);
		
		botaoResp4.setText("Guido van Rossum");
		botaoResp4.addActionListener(this);
		botaoResp4.setActionCommand(4);
		
		quizPanel.add(botaoResp1, botaoResp2, botaoResp3, botaoResp4);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actCmd = e.getActionCommand();
		
		mainInterface.setVisible(false);
		quizInterface.setVisible(true);

		switch (actCmd) {
			case 1:
				System.out.println("Resposta errada");
				break;
			case 2: 
				System.out.println("Resposta errada");
				break;
			case 3: 
				System.out.println("Resposta correta");
				break;
			case 4:
				System.out.println("Resposta errada");
				break;
		}
		
	}
}
