package BEAN;

import java.text.ParseException;
import java.util.Date;

public class BangDiem{
	private int maSv;
	private int maMH;
	private float diem;
	public int getMaSv() {
		return maSv;
	}
	public void setMaSv(int maSv) {
		this.maSv = maSv;
	}
	public int getMaMH() {
		return maMH;
	}
	public void setMaMH(int maMH) {
		this.maMH = maMH;
	}
	public float getDiem() {
		return diem;
	}
	public void setDiem(float diem) {
		this.diem = diem;
	}
	public BangDiem(int maSv, int maMH, float diem) {
		super();
		this.maSv = maSv;
		this.maMH = maMH;
		this.diem = diem;
	}
	
	public BangDiem() {
		super();
		// TODO Auto-generated constructor stub
	}
}
