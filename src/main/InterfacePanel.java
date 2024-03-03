package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfacePanel implements ActionListener{
	JFrame mainInterface = new JFrame();
	JPanel painel = new JPanel();
	JButton botao = new JButton("Quiz de Java");
	
	InterfacePanel() {
		setInterface();
	}
	
	public void setInterface() {
		
		mainInterface.setSize(500, 500);
	
		
		
		mainInterface.add(painel);
		mainInterface.setVisible(true);
		
		JLabel title = new JLabel();
		title.setText("Selecione o quiz que deseja realizar:");
		painel.add(title);
		
		
		painel.add(botao);
		
		botao.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		painel.setBackground(Color.pink);
		
	}
}
