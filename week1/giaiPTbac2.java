package week1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class giaiPTbac2 extends JFrame implements ActionListener{
	private JTextField 
		inputA = new JTextField(),
		inputB = new JTextField(),
		inputC = new JTextField();
	JTextArea inputD = new JTextArea(); 
	private JButton buttonGiai, buttonXoaRong, buttonThoat; 
	
	private void CreateGUI() {
		JPanel 
			panelNorth = new JPanel(), 
			panelSouth = new JPanel(), 
			panelCenter = new JPanel();

		
		add(panelNorth, BorderLayout.NORTH);
		add(panelCenter, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);
		
		JLabel titleNorth = new JLabel("GIAI PHUONG TRINH BAC 2");
		titleNorth.setBorder( BorderFactory.createEmptyBorder(10, 5, 10, 5) );
		
		titleNorth.setFont(new Font("Times new Roman",Font.BOLD,20));
		panelNorth.add(titleNorth); 
		panelNorth.setBackground(Color.cyan);
		
		panelCenter.setLayout(null); // absolute layout
		JLabel 
			nhapA = new JLabel("Nhap a: "), 
			nhapB = new JLabel("Nhap b: "),
			nhapC = new JLabel("Nhap c: "),
			ketQua = new JLabel("ket qua: ");
		panelCenter.add(nhapA); 
		panelCenter.add(nhapB); 
		panelCenter.add(nhapC); 
		panelCenter.add(ketQua); 
		
		int x = 85, y = 0, width = 200, height = 30, space = 40; 
		nhapA.setBounds(x, y+=space, width, height);
		nhapB.setBounds(x, y+=space, width, height);
		nhapC.setBounds(x, y+=space, width, height);
		ketQua.setBounds(x, y+=space, width, height);
		
		panelCenter.add(inputA); 
		panelCenter.add(inputB); 
		panelCenter.add(inputC);
		panelCenter.add(inputD); 
		
		
		inputA.setBounds(x+100, y=space, width, height);
		inputB.setBounds(x+100, y+=space, width, height);
		inputC.setBounds(x+100, y+=space, width, height);
		inputD.setBounds(x+100, y+=space, width, height);
		inputD.setEditable(false);
		
		panelSouth.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Chon tac vu"),
				BorderFactory.createEmptyBorder(20, 0, 20, 0)));
		
		
		
		panelSouth.add(buttonGiai=new JButton("Giải"));
		panelSouth.add(buttonXoaRong=new JButton("Xoá"));
		panelSouth.add(buttonThoat=new JButton("Thoát"));
	
		buttonGiai.addActionListener(this);
		buttonXoaRong.addActionListener(this);
		buttonThoat.addActionListener(this);
		
		
	}
	
	public giaiPTbac2() {
		setSize(500, 400);
//		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("^-^");
		setVisible(true);
		CreateGUI();
	}
	
	public static void main(String[] args) {
		new giaiPTbac2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonThoat) {
			System.exit(0);
		} else if( e.getSource()==buttonXoaRong ) {
			inputA.setText("");
			inputB.setText("");
			inputC.setText("");
			inputD.setText("");
			inputA.requestFocus();
		} else {
			try { 
				float a = Float.parseFloat(inputA.getText()),
					  b = Float.parseFloat(inputB.getText()),
					  c = Float.parseFloat(inputC.getText());
				String result = ""; 
				if(a == 0) {
					if(b == 0) {
						if(c == 0) 
							inputD.setText("Vo so nghiem");
						else 
							inputD.setText("Vo nghiem");
					} else {
						inputD.setText("x = " + -b/c);
					}
				} else {
					float delta = b*b - 4*a*c; 
					if(delta < 0) 
						inputD.setText("Vo nghiem");
					else if(delta == 0)
						inputD.setText("x = " + -b/(2*a)); 
					else {
						double x1 = (-b + Math.sqrt(delta))/(2*a),
							   x2 = (-b - Math.sqrt(delta))/(2*a);
						inputD.setText("x1 = " + x1 + '\n'+ "x2 = " + x2); 
					}
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "nhap sai du lieu", "Error Message", 1);
			}
		}
		
	}  
}
