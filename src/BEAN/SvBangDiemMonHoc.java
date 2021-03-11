package BEAN;

public class SvBangDiemMonHoc {
	private int maSv;
	private int maMh;
	private String tenMh;
	
	private float diem;
	
	public SvBangDiemMonHoc(int maSv, int maMh, String tenMh, float diem) {
		super();
		this.maSv = maSv;
		this.maMh = maMh;
		this.tenMh = tenMh;
		this.diem = diem;
	
	}
	public int getMaSv() {
		return maSv;
	}
	public void setMaSv(int maSv) {
		this.maSv = maSv;
	}
	public int getMaMh() {
		return maMh;
	}
	public void setMaMh(int maMh) {
		this.maMh = maMh;
	}
	public String getTenMh() {
		return tenMh;
	}
	public void setTenMh(String tenMh) {
		this.tenMh = tenMh;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
	
	
}
