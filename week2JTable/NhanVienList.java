package week2JTable;

import java.io.Serializable;
import java.util.ArrayList;

public class NhanVienList implements Serializable{
	ArrayList<NhanVien> ls = new ArrayList<NhanVien>(); 
	
	public void add(NhanVien n) throws Exception {
		if(ls.contains(n)) {
			throw new Exception("Nhân viên đã tồn tại"); 
		} 
		ls.add(n); 
	}
	
	public void remove(NhanVien n) throws Exception {
		if(!ls.contains(n)) {
			throw new Exception("Không tồn tại nhân viên"); 
		} 
		ls.remove(n);
	}
	
	public NhanVien find(String ma) throws Exception {
		ma = ma.trim(); 
		for (NhanVien nhanVien : ls) {
			if(nhanVien.getMaNV().equals(ma)) 
				return nhanVien; 
		}
		throw new Exception("Không tồn tại nhân viên"); 
	}
	
	public int indexOf(String ma) throws Exception{
		ma = ma.trim(); 
		for(int i = 0; i < ls.size(); i++) {
			if(ls.get(i).getMaNV().equals(ma)) 
				return i; 
		}
		throw new Exception("Không tồn tại nhân viên"); 
	}
	
	public boolean update(NhanVien nhanVien) throws Exception {
		int index = ls.indexOf(nhanVien); 
		if(index < 0)
			return false; 
		ls.set(index, nhanVien); 
		return true; 
	}
	
	public ArrayList<NhanVien>  getList() {
		return ls; 
	}
 }
