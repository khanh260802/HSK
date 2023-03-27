package week3Tree;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmNhanVien extends JFrame {
	private ArrayList<NhanVien> dsnv; 
	private JTable table;
	private DefaultTableModel model;
	
	public frmNhanVien( ArrayList<NhanVien> dsnv, String title) {
		super(title);
		setSize(600, 400); 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		this.dsnv = dsnv; 
		String column[] = {"Mã","Họ","Tên", "Phái", "Tuổi","Tiền lương",}; 
		table = new JTable(model = new DefaultTableModel(column, 0));
		
		for (NhanVien nv : dsnv) {
			String[] row = {nv.getMaNV(), nv.getHo(), nv.getTen(), nv.getPhongBan()+"", nv.getTuoi()+"", nv.getLuong()+""}; 
			model.addRow(row);;
		}
		
		table.setRowHeight(30);
		add(new JScrollPane(table), BorderLayout.CENTER); 
	} 
}
