package main;

import javax.swing.*;

public class MainInterface {

	public static void main(String[] args) {
		JFrame mainInterface = new JFrame();
		mainInterface.setSize(500, 500);
		
		JPanel painel = new JPanel();
		
		JLabel title = new JLabel();
		title.setText("Selecione o quiz que deseja realizar:");
		painel.add(title);
		
		JButton botao = new JButton("Quiz de Java");
		painel.add(botao);
		
		mainInterface.add(painel);
		mainInterface.setVisible(true);
	}

}
