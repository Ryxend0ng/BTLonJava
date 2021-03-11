package BEAN;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SinhVien {
	private int maSv;
	private String hoDem;
	private String ten;
	private Date ns;
	private String gioiTinh;
	public int getMaSv() {
		return maSv;
	}
	public void setMaSv(int maSv) {
		this.maSv = maSv;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	// doi ngay sang dd/MM/yyyy
	static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	public String getNs() {
		return sdf.format(ns);
	}
	public void setNs(Date ns) {
		this.ns = ns;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public SinhVien(int maSv, String hoDem, String ten, Date ns, String gioiTinh) {
		super();
		this.maSv = maSv;
		this.hoDem = hoDem;
		this.ten = ten;
		this.ns = ns;
		this.gioiTinh = gioiTinh;
	}
	
	@Override
	public String toString() {
		return "SinhVien [maSv=" + maSv + ", hoDem=" + hoDem + ", ten=" + ten + ", ns=" + ns + ", gioiTinh=" + gioiTinh
				+ "]";
	}
	
}
