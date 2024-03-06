package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfacePanel implements ActionListener{
	JFrame mainInterface = new JFrame();
	JFrame quizInterface = new JFrame();
	JPanel mainPanel = new JPanel();
	JButton botao = new JButton("Quiz de Java");
	
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainInterface.setVisible(false);
		quizInterface.setVisible(true);
		
	}
}
