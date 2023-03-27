package week3Tree;

import java.util.ArrayList;

public class CongTy {
	ArrayList<PhongBan> dspb;

	public CongTy() {
		dspb = new ArrayList<PhongBan>() ;
	} 
	
	public void ThemPhongBan(PhongBan p) throws Exception {
		if(!dspb.contains(p))
			dspb.add(p); 
		else 
			throw new Exception("Mã phòng ban này đã tồn tại"); 
	}

	public ArrayList<PhongBan> getDspb() {
		return dspb;
	}
	
}
