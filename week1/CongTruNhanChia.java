package week1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.*; 
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CongTruNhanChia extends JFrame implements ActionListener, ItemListener {
	private JButton 
		btnGiai = new JButton("Giải"),
		btnXoa = new JButton("Xóa"),
		btnThoat = new JButton("Thoát"); 
	
	private JTextField 
		txtNhapA = new JTextField(), 
		txtNhapB = new JTextField(),
		txtKq = new JTextField();
	
	private JRadioButton 
	    RadioCong = new JRadioButton("Cộng"), 
		RadioTru = new JRadioButton("Trừ"), 
		RadioNhan = new JRadioButton("Nhân"), 
		RadioChia = new JRadioButton("Chia"); 
	
	Object mathSymbol; 
	
	CongTruNhanChia() {
		
		createGUI(); 
		setVisible(true);
		setSize(500, 400); 
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cộng - Trừ - Nhân - Chia");
		setLocationRelativeTo(null);
	}
	
	private void createGUI() {
		JPanel 
			panelNorth = new JPanel(), 
			panelWest = new JPanel(),
			panelSouth = new JPanel(),
			panelCenter = new JPanel(); 
		add(panelNorth, BorderLayout.NORTH ); 
		add(panelWest, BorderLayout.WEST ); 
		add(panelSouth, BorderLayout.SOUTH ); 
		add(panelCenter, BorderLayout.CENTER ); 
		
//		North
		panelNorth.setBorder(new EmptyBorder(0, 0, 10, 0));
		JLabel labelTitle = new JLabel("Cộng Trừ Nhân Chia"); 
		labelTitle.setFont(new Font("Time new Roman", Font.BOLD, 25));
		panelNorth.add(labelTitle); 
		labelTitle.setForeground(Color.blue);
		
		
//		West
		int space = 10; 
		panelWest.setLayout(new GridLayout(6, 0, space, space));
		panelWest.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Chọn tác vụ"),
				BorderFactory.createEmptyBorder(space, space, 0, space)));
		panelWest.add(btnGiai); 
		panelWest.add(btnXoa);
		panelWest.add(btnThoat);
		panelWest.setBackground(Color.LIGHT_GRAY);
		
//		Center
		panelCenter.setLayout(null);
		panelCenter.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		panelCenter.add(txtNhapA); 
		panelCenter.add(txtNhapB); 
		panelCenter.add(txtKq);
		panelCenter.add(RadioCong); 
		panelCenter.add(RadioTru); 
		panelCenter.add(RadioNhan); 
		panelCenter.add(RadioChia); 
		JLabel nhapA, nhapB, ketQua; 
		panelCenter.add(nhapA = new JLabel("Nhập a: ")); 
		panelCenter.add(nhapB = new JLabel("Nhập b: ")); 
		panelCenter.add(ketQua = new JLabel("Kết quả: ")); 
		
		ButtonGroup gr = new ButtonGroup(); 
		JPanel math = new JPanel(); 
		panelCenter.add(math); 
		math.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		
		math.setLayout(new GridLayout(2, 2, 0, 0));
		
		gr.add(RadioCong);
		gr.add(RadioTru);
		gr.add(RadioNhan);
		gr.add(RadioChia);
		math.add(RadioCong); 
		math.add(RadioTru); 
		math.add(RadioNhan); 
		math.add(RadioChia); 
		int width = 250, height = 30, x = 50, y = 20, spaceY=40, spaceX=50; 
		int heightPhepToan = 100; 
		nhapA.setBounds(x, y, width, height);
		nhapB.setBounds(x, y+spaceY, width, height);
		txtNhapA.setBounds(x+spaceX, y, width, height);
		txtNhapB.setBounds(x+spaceX, y+spaceY, width, height);
		math.setBounds(x+spaceX, y+2*spaceY, width, heightPhepToan);
		txtKq.setBounds(x+spaceX, y+2*heightPhepToan, width, height);
		ketQua.setBounds(x, y+2*heightPhepToan, width, height);
		txtKq.setEditable(false);
//		South
		panelSouth.setBorder(new EmptyBorder(0, 0, 20, 0));
		panelSouth.setBackground(Color.pink);
		
		JPanel
			blue = new JPanel(), 
			red = new JPanel(), 
			yellow = new JPanel(); 
		blue.setBackground(Color.blue);
		red.setBackground(Color.red);
		yellow.setBackground(Color.yellow);
		
		int sp = 5; 
		blue.setBorder(new EmptyBorder(sp, sp+2, sp, sp+2));
		red.setBorder(new EmptyBorder(sp, sp+2, sp, sp+2));
		yellow.setBorder(new EmptyBorder(sp, sp+2, sp, sp+2));
		
		panelSouth.add(blue); 
		panelSouth.add(red); 
		panelSouth.add(yellow); 
		
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		
		RadioCong.addItemListener(this);
		RadioTru.addItemListener(this);
		RadioNhan.addItemListener(this);
		RadioChia.addItemListener(this);

	}
	
	public static void main(String[] args) {
		new CongTruNhanChia();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		Object o = e.getSource();
		float a, b, result = 0; 
		if(o.equals(btnThoat)) {
			System.exit(0);
		} else if( o.equals(btnXoa) ) {
			txtKq.setText("");
			txtNhapA.setText("");
			txtNhapB.setText("");
			txtNhapA.requestFocus();
			
		} else {
			try {
				a = Float.parseFloat(txtNhapA.getText()); 
				b = Float.parseFloat(txtNhapB.getText()); 
				if(mathSymbol==(null)) {
				  JOptionPane.showMessageDialog(this, "chưa chọn phép toán", "Error", 0);
				} else if (mathSymbol.equals(RadioCong)) {
					result = a+b; 
				} else if (mathSymbol.equals(RadioTru)) {
					result = a-b; 
				} else if (mathSymbol.equals(RadioNhan)) {
					result = a*b; 
				} else if (mathSymbol.equals(RadioChia)) {
					result = a/b; 
				}
				
				
				txtKq.setText(result+"");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Lỗi nhập liệu", "Error", 0);
			}
			
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		mathSymbol = e.getSource(); 
	}
	
}
