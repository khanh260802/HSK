package week3Tree;

import java.util.ArrayList;
import java.util.Objects;

public class PhongBan {
	private String maPhong, tenPhong; 
	private ArrayList<NhanVien> dsnv;
	
	public PhongBan(String maPhong, String tenPhong) throws Exception {
		super();
		setMaPhong(maPhong);
		setTenPhong(tenPhong);
		dsnv = new ArrayList<NhanVien>(); 
	}
	
	public PhongBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) throws Exception {
		if(maPhong.isEmpty()) 
			throw new Exception("Mã phòng là trường bắt buộc"); 
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) throws Exception{
		if(tenPhong.isEmpty()) 
			throw new Exception("Tên phòng là trường bắt buộc"); 
		this.tenPhong = tenPhong;
	}
	
	public ArrayList<NhanVien> getDsnv() {
		return dsnv;
	}
	
	public void themNV(String maNV, String ho, String ten, boolean phai, int tuoi, double luong) throws Exception {
		NhanVien nv = new NhanVien(maNV, ho, ten, phai, tuoi, luong, this); 
		if(!dsnv.contains(nv))
			dsnv.add(nv); 
		else 
			throw new Exception("Mã nhân viên này đã tồn tại"); 
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongBan other = (PhongBan) obj;
		return Objects.equals(maPhong, other.maPhong);
	}

	@Override
	public String toString() {
		return this.tenPhong;
	}
	
	
	
}
