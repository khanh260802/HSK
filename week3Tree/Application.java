package week3Tree;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class Application extends JFrame implements MouseListener{
	
	private DefaultMutableTreeNode root; 
	private JTree tree;
	private ArrayList<PhongBan> dspb; 
	public Application(ArrayList<PhongBan> dspb) {
		super("^-^"); 
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(800, 550));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		this.dspb = dspb; 
		
		root = new DefaultMutableTreeNode("Danh sách phòng ban"); 
		tree = new JTree(root); 
		tree.setShowsRootHandles(true); 
		int soPhongBan = dspb.size(); 
		
		for(PhongBan pb : dspb) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(pb); 
			root.add(node);
		}
		
		add(tree); 
		tree.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount()==2) {
			DefaultMutableTreeNode x = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent(); 
			if(x!=null) {
				Object gt = x.getUserObject(); 
				if(gt instanceof PhongBan) {
					PhongBan pb = (PhongBan) x.getUserObject(); 
					ArrayList<NhanVien> dsnv = pb.getDsnv(); 
					
					frmNhanVien gd = new frmNhanVien(dsnv, pb.getTenPhong()); 
					System.out.println("hello");
					gd.show();
				}
			} else {
				System.out.println("haha");
			}
			
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
	
	
	public static void main(String[] args) throws Exception {
		CongTy ct = new CongTy(); 
		PhongBan tc, kt, ns; 
		ct.ThemPhongBan(tc = new PhongBan("tc", "Phòng tổ chức"));
		ct.ThemPhongBan(kt = new PhongBan("kt", "Phòng Kỹ thuật"));
		ct.ThemPhongBan(ns = new PhongBan("ns", "Phòng Nhân sự"));
		
		tc.themNV("01", "Nguyễn", "Khánh", true, 25, 10000);
		tc.themNV("02", "Nguyễn", "Khánh", true, 25, 10000);
		tc.themNV("03", "Nguyễn", "Khánh", true, 25, 10000);
		
		kt.themNV("04", "Nguyễn", "Khánh", true, 25, 10000);
		kt.themNV("05", "Nguyễn", "Khánh", true, 25, 10000);
		kt.themNV("06", "Nguyễn", "Khánh", true, 25, 10000);
		
		ns.themNV("07", "Nguyễn", "Khánh", true, 25, 10000);
		ns.themNV("08", "Nguyễn", "Khánh", true, 25, 10000);
		ns.themNV("09", "Nguyễn", "Khánh", true, 25, 10000);
		
		ArrayList<PhongBan> dspb = ct.getDspb(); 
		new Application(dspb); 
		
	}
}
