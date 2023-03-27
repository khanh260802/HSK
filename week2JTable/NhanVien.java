package week2JTable;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable{
	private final String  maNV; 
	private String ho, ten; 
	private boolean phai; 
	private int tuoi; 
	private double luong;
	public NhanVien(String maNV, String ho, String ten, boolean phai, int tuoi, double luong) throws Exception {
		if(maNV.equals(""))
			throw new Exception("Mã nhân viên là trường bắt buộc"); 
		this.maNV = maNV;
		setHo(ho);
		setTen(ten);
		setPhai(phai);
		setTuoi(tuoi);
		setLuong(luong);
	}
	
	public NhanVien() {
		this.maNV = "";
		// TODO Auto-generated constructor stub
	}

	public String getMaNV() {
		return maNV;
	}

	public String getHo() {
		return ho;
	}
	public void setHo(String ho) throws Exception {
		ho=ho.trim(); 
		if(ho.equals("")) 
			throw new Exception("Họ nhân viên là trường bắt buộc"); 
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) throws Exception {
		ten=ten.trim(); 
		if(ten.equals("")) 
			throw new Exception("Tên nhân viên là trường bắt buộc"); 
		this.ten = ten;
	}
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai) throws Exception {
		this.phai = phai;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) throws Exception {
		if(tuoi < 15 || tuoi > 60) 
			throw new Exception("Tuổi không hợp lệ (15-60)"); 
		this.tuoi = tuoi;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) throws Exception {
		if(luong < 0) 
			throw new Exception("Lương phải là số lớn hơn 0"); 
		this.luong = luong;
	}



	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	} 
	
	
}
