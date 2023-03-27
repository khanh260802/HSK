package week3Tree;

import java.util.Objects;

public class NhanVien {
	private final String  maNV; 
	private String ho, ten; 
	private boolean phai; 
	private int tuoi; 
	private double luong;
	private PhongBan phongBan;
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) throws Exception {
		if(ho.isBlank())
			throw new Exception("Họ nhân viên là trường bắt buộc"); 
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten)throws Exception {
		if(ten.isBlank())
			throw new Exception("Tên Nhân viên là trường bắt buộc"); 
		this.ten = ten;
	}
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai)throws Exception {
		this.phai = phai;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi)throws Exception {
		if(tuoi < 15 || tuoi > 60) 
			throw new Exception("Tuổi nhân viên không hợp lệ");
		this.tuoi = tuoi;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong)throws Exception {
		if(luong < 0) 
			throw new Exception("Lương nhân viên không hợp lệ"); 
		this.luong = luong;
	}
	public PhongBan getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(PhongBan phongBan)throws Exception {
		this.phongBan = phongBan;
	}
	public String getMaNV() {
		return maNV;
	}
	
	public NhanVien(String maNV, String ho, String ten, boolean phai, int tuoi, double luong, PhongBan phongBan) throws Exception {
		super();
		this.maNV = maNV;
		if(maNV.isBlank()) 
			throw new Exception("Mã nhân viên là trường bắt buộc");
		
		setHo(ho);
		setTen(ten);
		setPhai(phai);
		setTuoi(tuoi); 
		setLuong(luong);
		setPhongBan(phongBan);
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
