package week1;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
public class SoNguyenTo extends JFrame implements ActionListener{
	
	private JTextField input = new JTextField(); 
	private JTextArea result = new JTextArea(); 
	private JButton btn = new JButton("Generate"); 
	private void createGUI() {
		JPanel panel = new JPanel(); 
		panel.add(input); 
		panel.add(btn); 
		panel.add(result); 
		
		
		add(panel, BorderLayout.CENTER); 
		panel.setLayout(null);
		int x = 50, y = 0, width = 250, height = 30; 
		input.setBounds(x, y+=15, width, height);
		btn.setBounds(x+width, y, 150, height);
		result.setBounds(x, y+=50, 400, 250);
		btn.setFont(new Font("Times new Roman",Font.BOLD,20));
		input.setFont(new Font("Times new Roman",Font.BOLD,20));
		result.setFont(new Font("Times new Roman",Font.BOLD,20));
		
		JScrollPane sp = new JScrollPane(result);
		add(sp); 
		
		btn.addActionListener(this);
	}
	
	SoNguyenTo() {
		setTitle("Primes"); 
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setResizable(false);
		createGUI(); 
	}
	
	public static void main(String[] args) {
		new SoNguyenTo(); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		try {
			String rs = ""; 
			int n = Integer.parseInt(input.getText());
			if(n <= 0) {
				JOptionPane.showMessageDialog(this, "hay nhap so lon hon 0", "Error messege", JOptionPane.ERROR_MESSAGE);
			}
			int count = 0, val=2; 
			while(count < n) {
				while(!isPrime(val)) val++; 
				rs += val + "\n"; 
				val++; 
				count++; 
			}
			result.setText(rs);
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "nhap sai du lieu", "Error messege", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean isPrime(int x) {
		if(x < 2) return false; 
		if(x == 2) return true; 
		for(int i = 2; i*i <= x; i++) {
			if(x % 2==0) 
				return false; 
		}
		return true; 	
	}
}
