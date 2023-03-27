package week2JTable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector; 
public class GUI extends JFrame implements ActionListener, MouseListener{
	
	private NhanVienList list = new NhanVienList(); 
	private Database db;
	private JLabel 
		lbTitle, lbManv, lbHo, lbTen, lbTuoi, lbPhai, lbTienLuong, lbNhapMa; 
	private JTextField 
		txtManv, txtHo, txtTen, txtTuoi, txtNhapMa, txtTienLuong; 
	private JRadioButton 
		radNam, radNu; 
	private JButton 
		btnTim, btnThem, btnXoaTrang, btnXoa, btnLuu, btnSua; 
	private JTable table; 
	private DefaultTableModel model; 
	
	private JPanel 
		panelNorth, panelCenter, panelSouth; 
	
	Object evenNN = null; 
	boolean updating = false; 
	
	public void createGUI() throws Exception {
		add(panelNorth = new JPanel(), BorderLayout.NORTH); 
		add(panelCenter = new JPanel(), BorderLayout.CENTER); 
		add(panelSouth = new JPanel(), BorderLayout.SOUTH); 
		
		// North 
		lbTitle = new JLabel("THÔNG TIN NHÂN VIÊN"); 
		panelNorth.add(lbTitle); 
		lbTitle.setFont(new Font("Arial", Font.BOLD, 25)); 
		lbTitle.setForeground(Color.blue); 
		
		// Center
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		Box 
		b = Box.createVerticalBox(), 
		b1 = Box.createHorizontalBox(),  
		b2 = Box.createHorizontalBox(),  
		b3 = Box.createHorizontalBox(),  
		b4 = Box.createHorizontalBox();
		
		b.add(b1); b.add(Box.createVerticalStrut(5)); 
		b.add(b2); b.add(Box.createVerticalStrut(5)); 
		b.add(b3); b.add(Box.createVerticalStrut(5)); 
		b.add(b4); b.add(Box.createVerticalStrut(5)); 
		panelCenter.add(b); 
		panelCenter.add(Box.createVerticalStrut(10)); 
		
		b1.add(lbManv = new JLabel("Mã nhân viên: "));  b1.add(txtManv = new JTextField("01"));  
		b2.add(lbHo   = new JLabel("Họ: "));            b2.add(txtHo   = new JTextField("Nguyễn"));
		b2.add(lbTen  = new JLabel("Tên nhân viên: ")); b2.add(txtTen  = new JTextField("Khánh"));
		b3.add(lbTuoi = new JLabel("Tuổi: "));          b3.add(txtTuoi = new JTextField("25"));
		b3.add(lbPhai = new JLabel("Phái: ")); 
		
		b3.add(radNam = new JRadioButton("Nam")); 
		b3.add(radNu = new JRadioButton("Nữ"));  
		ButtonGroup gr = new ButtonGroup(); 
		gr.add(radNam); gr.add(radNu); 
		radNam.setSelected(true);
		
		b4.add(lbTienLuong = new JLabel("Tiền lương: ")); 
		b4.add(txtTienLuong = new JTextField("1000")); 
		
		// căn đều giữa các dòng 
		Dimension dmsLbManv = lbManv.getPreferredSize(); 
		lbHo.setPreferredSize(dmsLbManv);
		lbTuoi.setPreferredSize(dmsLbManv);
		lbTienLuong.setPreferredSize(dmsLbManv);
		
		taoBang();
		
		//South 
		panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.X_AXIS));
		Box 
			b5 = Box.createHorizontalBox(),
			b6 = Box.createHorizontalBox();
		int space = 10; 
		b5.add(Box.createHorizontalStrut(space)); 
		b5.add(lbNhapMa = new JLabel("Nhập mã số cần tìm: "));
		b5.add(Box.createHorizontalStrut(space)); 
		b5.add(txtNhapMa = new JTextField("04",20));
		b5.add(Box.createHorizontalStrut(space)); 
		b5.add(btnTim = new JButton("Tìm")); 
		b5.add(Box.createHorizontalStrut(space)); 
		b5.setBounds(0, 0, 500, space);
		
		b6.add(Box.createHorizontalStrut(2*space)); 
		b6.add(btnThem = new JButton("Thêm")); 
		b6.add(Box.createHorizontalStrut(space)); 
		b6.add(btnXoa = new JButton("Xóa")); 
		b6.add(Box.createHorizontalStrut(space)); 
		b6.add(btnSua = new JButton("Sửa")); 
		b6.add(Box.createHorizontalStrut(space)); 
		b6.add(btnXoaTrang = new JButton("Xóa trắng")); 
		b6.add(Box.createHorizontalStrut(space)); 
		b6.add(btnLuu = new JButton("Lưu")); 
		
		JSplitPane jspp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, b5, b6); 	
		panelSouth.add(jspp); 
		jspp.setDividerLocation(space*36);
		panelSouth.setBorder(new EmptyBorder(10,0,10,0));
		
// register events		
		//		txtManv, txtHo, txtTen, txtTuoi, txtNhapMa, txtTienLuong; 
		txtManv.addActionListener(this);
		txtHo.addActionListener(this);
		txtTen.addActionListener(this);
		txtTuoi.addActionListener(this);
		txtNhapMa.addActionListener(this);
		txtTienLuong.addActionListener(this);
		
		//		btnTim, btnThem, btnXoaTrang, btnXoa, btnLuu; 
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		table.addMouseListener(this);	
	}
	
	public void taoBang() throws Exception {
		// create table 
		model = new DefaultTableModel(); 
		model.addColumn("Mã NV");
		model.addColumn("Họ");
		model.addColumn("Tên");
		model.addColumn("Phái");
		model.addColumn("Tuổi");
		model.addColumn("Tiền lương");
		table = new JTable(model); 
		
		
		// comboBox cho phái
		TableColumn phaicolumn = table.getColumnModel().getColumn(3); 
		JComboBox cbb = new JComboBox();
		cbb.addItem("Nam");
		cbb.addItem("Nữ");
		phaicolumn.setCellEditor(new DefaultCellEditor(cbb)); 
		
		
		// thêm data từ list vào table 
		for(NhanVien nv : list.getList()) {
			String gender = "Nam"; 
			if(!nv.isPhai()) 
				gender = "Nữ"; 
			
			Object[] row = {nv.getMaNV(), nv.getHo(), nv.getTen(), gender, nv.getTuoi() , nv.getLuong() }; 
			model.addRow(row);
		}
		
		//scroll
		JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelCenter.add(sp); 
		sp.setPreferredSize(new Dimension(650, 250)); 
	}
	
	GUI() throws Exception {
		
		createGUI(); 
		setTitle("^-^"); 
		setSize(800, 500); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		db = new Database(); 
		try {
			loadData(); 
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
	}
	

	private void loadData() {
		// TODO Auto-generated method stub
		list = (NhanVienList)db.readFile("NhanVien.dat"); 
		if(list==null) 
			list = new NhanVienList(); 
		else {
			for(NhanVien nv : list.getList()) 
				model.addRow(convert(nv));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Object o = e.getSource();
			if(o.equals(btnXoaTrang)) {
				xoaTrang(); 
			} else if(o.equals(btnLuu)) {
				luu(); 
				xoaTrang();
				JOptionPane.showMessageDialog(this, (updating ? "Sửa" : "Lưu") + " thành công", "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
				updating = false; 
			} else if(o.equals(btnTim)) {
				tim();
			} else if(o.equals(btnXoa)) {
				
				// Xóa
				ArrayList<NhanVien> removeList = new ArrayList<NhanVien>(); 
				for(int o1 : table.getSelectedRows()) 
					removeList.add(list.getList().get(o1)); 
				if(removeList.isEmpty()) 
					throw new Exception("chưa chọn đối tượng cần xóa"); 
				
				int chacChua = JOptionPane.showConfirmDialog(this, "Bạn đã chắc chắn chưa ?", "question message", JOptionPane.YES_NO_OPTION); 
				if(chacChua==JOptionPane.YES_OPTION) {
						list.getList().removeAll(removeList); 
						loadTable();					
				}
				db.saveFile("NhanVien.dat", list);
				
			} else if(o.equals(btnThem)) {
				if(btnThem.getText().equals("Thêm")) {
					btnXoaTrang.doClick();
					btnThem.setText("Hủy");
					btnXoa.setEnabled(false); 
				} else {
					btnThem.setText("Thêm");
					btnXoa.setEnabled(true); 
				}
			} else if(o.equals(btnSua)) {
				sua(); 
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, e2.getMessage(), "error message", 0); 
		}
		
	}
	
	// chuyển từ objects sang kiểu row của table
	public Object[] convert( NhanVien nv ) {
		Object[] row = {nv.getMaNV(), nv.getHo(), nv.getTen(), 
				        nv.isPhai() ?"Nam" :"Nữ", nv.getTuoi() , nv.getLuong() }; 
		return row; 
	}
	
	public void loadTable() {
		model.setRowCount(0);
		for(NhanVien nv : list.getList()) {
			model.addRow(convert(nv));
		}
	}
	
	// lấy data từ text và convert thành object NHANVIEN
	public NhanVien getTextObject() throws Exception {
		int tuoi = 15; 
		double luong = 1000; 
		try {
			tuoi = Integer.parseInt(txtTuoi.getText().trim()); 
		} catch (Exception e) {
			// TODO: handle exception
			if(txtTuoi.getText().equals("")) 
				throw new Exception("Tuổi là trường bắt buộc"); 
			throw new Exception("Tuổi là kiểu nguyên"); 
		}
		try {
			luong = Double.parseDouble(txtTienLuong.getText().trim()); 
		} catch (Exception e) {
			// TODO: handle exception
			if(txtTienLuong.getText().equals("")) 
				throw new Exception("Lương là trường bắt buộc");
			throw new Exception("Lương là kiểu double"); 
		}
		
		NhanVien nv = new NhanVien(txtManv.getText(), txtHo.getText(), txtTen.getText(), radNam.isSelected(), 
				tuoi, luong);
		return nv; 
	}
	
	public void luu() throws NumberFormatException, Exception {
		NhanVien nv = getTextObject(); 
		if( !updating ) {
			list.add(nv);
			model.addRow(convert(nv)); 			
		} else {
			int row = table.getSelectedRow(); 
			if(row == -1) 
				throw new Exception("Chưa chọn hàng cần sửa"); 
			list.update(nv); 
			suaTable(row);
			txtManv.setEditable(true);	
			btnThem.setEnabled(true);
			btnXoa.setEnabled(true);
			btnSua.setText("Sửa");
		}
		
		db.saveFile("NhanVien.dat", list);
	}
	
	public void suaTable(int row) {
		table.setValueAt(txtHo.getText(), row, 1);
		table.setValueAt(txtTen.getText(), row, 2);
		table.setValueAt(radNam.isSelected() ? "Nam" : "Nữ", row, 3);
		table.setValueAt(txtTuoi.getText(), row, 4);
		table.setValueAt(txtTienLuong.getText(), row, 5);
	}
	
	public void tim() throws Exception {
		String ma = txtNhapMa.getText(); 
		if(ma.equals("")) 
			throw new Exception("chưa nhập mã nhân viên cần tìm"); 
		int id = list.indexOf(ma); 
		table.setRowSelectionInterval(id, id);
	}
	
	public void sua() throws Exception {		
		if( btnSua.getText().equals("Hủy")) {
			updating = false; 
			txtManv.setEditable(true);	
			btnThem.setEnabled(true);
			btnXoa.setEnabled(true);
			btnSua.setText("Sửa");
			return; 
		}
		xoaTrang();
		table.clearSelection();
		btnSua.setText("Hủy");
		btnThem.setEnabled(false);
		btnXoa.setEnabled(false);
		txtManv.setEditable(false);
		updating = true; 
	}
	
	public void xoaTrang() {
		txtManv.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		txtTienLuong.setText("");
		txtManv.requestFocus();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource(); 
		if(o == table) {
			int id = table.getSelectedRow(); 
			Vector data = model.getDataVector().get(id); 
			txtManv.setText( data.get(0)+"");
			txtHo.setText( data.get(1)+"");
			txtTen.setText( data.get(2)+"");

			String gender = (data.get(3) + "").trim(); 
			if(gender.equals("Nam")) radNam.setSelected(true); 
			else radNu.setSelected(true);		
			txtTuoi.setText(data.get(4)+"");
			txtTienLuong.setText(data.get(5)+"");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
