package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import BEAN.MonHoc;
import BEAN.BangDiem;
import BEAN.SinhVien;
import BEAN.SvBangDiemMonHoc;

public class SinhVienDAO {
	public static SinhVien createSv(String line) throws ParseException {
		String part[] = line.split(";");
		String maSv = part[0];
		String hoDem = part[1];
		String ten = part[2];
		String ns = part[3];
		String gioiTinh = part[4];
		String maSVstr = maSv.substring(2);
		int maSvInt = Integer.valueOf(maSVstr);
		Date nsDate = sdf.parse(ns);

		SinhVien sv = new SinhVien(maSvInt, hoDem, ten, nsDate, gioiTinh);
		return sv;
	}

	// lay du lieu tu file
	public static List<SinhVien> inThongTinSV(List<SinhVien> listsv) {
		FileReader frd = null;
		BufferedReader brd = null;
		try {
			frd = new FileReader(new File("D:\\Data\\sinhvien_en.txt"));
			brd = new BufferedReader(frd);
			String line = "";
			while ((line = brd.readLine()) != null) {
				if (line.contains("#")) {
					continue;
				} else {

					listsv.add(createSv(line));
				}
			}
		} catch (Exception e) {
		} finally {
			if (frd != null)
				try {
					frd.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (brd != null)
				try {
					brd.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return listsv;
	}

	// ghi du lieu vao file
	public static void ghiDLvaoFile(List<SinhVien> listsv) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(new File("D:\\Data\\sinhvien_en.txt"));
			bw = new BufferedWriter(fw);
			for (int i = 0; i < listsv.size(); i++) {
				String svBw = "SV" + listsv.get(i).getMaSv() + ";" + listsv.get(i).getHoDem() + ";"
						+ listsv.get(i).getTen() + ";" + listsv.get(i).getNs() + ";" + listsv.get(i).getGioiTinh();
				bw.write(svBw);
				bw.newLine();
			}

			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
// them sinh vien

	public static void themSinhVien(List<SinhVien> listsv, Scanner sc) throws ParseException {
		int max = 0;

		for (SinhVien sv : listsv) {
			if (sv.getMaSv() > max) {
				max = sv.getMaSv();
			}
		}

		System.out.println("nhap ho dem:");
		// sc.nextLine();
		String hoDem = sc.nextLine();
		System.out.println("nhap ho ten:");
		String ten = sc.nextLine();
		System.out.println("nhap ngay sinh dd/MM/yyyy(2/2/2001):");
		String ns = sc.nextLine();
		if (!ns.contains("/")) {
			System.out.println("yc nhap lai ngay thang theo chuan dd/MM/yyyy( vi du : 2/2/2001)");
			ns = sc.nextLine();
		}
		Date nsSdf = sdf.parse(ns);

		System.out.println("nhap gioi tinh:");
		String gioiTinh = sc.nextLine();
		SinhVien sv = new SinhVien(max + 1, hoDem, ten, nsSdf, gioiTinh);
		ghiDLvaoFile(listsv);
		listsv.add(sv);

	}

	// xuat thong tin
	public static void xuatThongTin(List<SinhVien> listsv, int trang) {
		List<SvBangDiemMonHoc> lk = hienThiBangDiem();
		int page = trang;
		int next = 30;
		if (trang <= 0) {
			System.out.println(
					"--------------Trang" + 1 + "/" + (int) listsv.size() / 30 + "------------------------------");
			System.out.format("\n%-5s%-10s%-5s%-10s%5s", "|", "MASV", "|", "TEN SV", "|");
			for (int i = 0; i < next; i++) {
				System.out.format("\n%-5s%-10s%-5s%-10s%5s", "|", listsv.get(i).getMaSv(), "|", listsv.get(i).getTen(),
						"|");
			}
			System.out.println();
		} else {

			trang = trang;
			trang = trang - 1;
			trang = trang * next + 1;
			int pn = page * next;

			if (pn > listsv.size()) {
				pn = listsv.size();
				System.out.println("--------------Trang" + page + "/" + (int) listsv.size() / 30
						+ "------------------------------");
				System.out.format("\n%-5s%-10s%-5s%-10s%5s", "|", "MASV", "|", "TEN SV", "|");
				for (int i = trang - 1; i < pn; i++) {
					System.out.format("\n%-5s%-10s%-5s%-10s%5s", "|", listsv.get(i).getMaSv(), "|",
							listsv.get(i).getTen(), "|");

				}
				System.out.println("\n--------------Trang" + page + "/" + (int) listsv.size() / 30
						+ "------------------------------");

			} else {
				System.out.println("--------------Trang" + page + "/" + (int) listsv.size() / 30
						+ "------------------------------");
				System.out.format("\n%-5s%-10s%-5s%-10s%5s", "|", "MASV", "|", "TEN SV", "|");
				for (int i = trang - 1; i < pn; i++) {
					System.out.format("\n%-5s%-10s%-5s%-10s%5s", "|", listsv.get(i).getMaSv(), "|",
							listsv.get(i).getTen(), "|");
					System.out.println();
				}
				System.out.println("--------------Trang" + page + "/" + (int) listsv.size() / 30
						+ "------------------------------");
			}

		}
	}

// sua thong tin

	public static void suaThongTinhSv(List<SinhVien> listsv, Scanner sc) throws ParseException {
		System.out.println("nhap ma sinh vien muon sua:");
		// sc.nextLine();
		String maSvstr = sc.nextLine();
		String msv = maSvstr.substring(2);
		int masv = Integer.valueOf(msv);

		for (SinhVien sv : listsv) {
			if (masv == sv.getMaSv()) {
				System.out.println("nhap ho dem:");
				String hoDem = sc.nextLine();
				System.out.println("nhap ten:");
				String ten = sc.nextLine();
				System.out.println("nhap ngay sinh dd/MM/yyyy(2/2/2001):");
				String ns = sc.nextLine();
				if (!ns.contains("/")) {
					System.out.println("yc nhap lai ngay thang theo chuan dd/MM/yyyy( vi du : 2/2/2001)");
					ns = sc.nextLine();
				}

				Date nsSdf = sdf.parse(ns);

				System.out.println("nhap gioi tinh:");
				String gioiTinh = sc.nextLine();
				sv.setMaSv(masv);
				sv.setHoDem(hoDem);
				sv.setTen(ten);
				sv.setNs(nsSdf);
				sv.setGioiTinh(gioiTinh);
				ghiDLvaoFile(listsv);
			}
		}

	}

	// xoa sinh vien

	public static void xoaSinhVien(List<SinhVien> listsv, Scanner sc) {
		// sc.nextLine();
		List<BangDiem> bd = new ArrayList<BangDiem>();
		bd = BangDiemDAO.inThongTinBD();
		System.out.println("nhap ma sinh vien muon xoa:");
		// sc.nextLine();
		String maSvstr = sc.nextLine();
		String msv = maSvstr.substring(2);
		int masv = Integer.valueOf(msv);

		for (int i = 0; i < bd.size(); i++) {
			for (int j = 0; j < listsv.size(); j++) {
				if ((masv == listsv.get(j).getMaSv()) && (masv != bd.get(i).getMaSv())) {
					listsv.remove(masv - 1);
				} else if ((masv == listsv.get(j).getMaSv()) && (masv == bd.get(i).getMaSv())) {
					System.out.println("khong dc xoa sih vien da hoc");
				}
			}
		}
		ghiDLvaoFile(listsv);
	}

// sap xep theo ten sv
	public static void sapXepTheoTen(List<SinhVien> listsv) {
		listsv.sort((o1, o2) -> o1.getTen().compareTo(o2.getTen()));
	}

// sap xep teo ma sv
	public static void sapXepTheoMsv(List<SinhVien> listsv) {
		Comparator<SinhVien> com = new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				// TODO Auto-generated method stub
				if (o1.getMaSv() > o2.getMaSv())
					return 1;
				return 0;
			}
		};
		listsv.sort(com);
	}

	public static List<SvBangDiemMonHoc> hienThiBangDiem() {
		List<BangDiem> bd = BangDiemDAO.inThongTinBD();
		List<MonHoc> mh = MonHocDAO.inThongTinMH();
		List<SvBangDiemMonHoc> lk = new ArrayList<SvBangDiemMonHoc>();
		for (int i = 0; i < mh.size(); i++) {
			for (int j = 0; j < bd.size(); j++) {
				if (mh.get(i).getMaMH() == bd.get(j).getMaMH()) {
					SvBangDiemMonHoc sbd = new SvBangDiemMonHoc(bd.get(j).getMaSv(), mh.get(i).getMaMH(),
							mh.get(i).getTenMH(), bd.get(j).getDiem());
					lk.add(sbd);
				}
			}
		}
		return lk;
	}

// hien thi danh sach
	public static void HienThiDanhSach(List<SinhVien> listsv, int trang) {
		List<SvBangDiemMonHoc> lk = hienThiBangDiem();

		int next = 30;
		int page = trang;
		if (trang <= 0) {

			System.out.println(
					"--------------Trang" + 1 + "/" + (int) listsv.size() / 30 + "------------------------------");
			for (int i = 0; i < next; i++) {
				System.out.print("MASV:" + listsv.get(i).getMaSv() + "\t" + listsv.get(i).getHoDem() + " "
						+ listsv.get(i).getTen() + "\t\t  " + listsv.get(i).getNs() + "\n");
				float diem = 0;
				int count = 0;

				for (int j = 0; j < lk.size(); j++) {
					if (lk.get(j).getMaSv() == listsv.get(i).getMaSv()) {
						count++;
						diem += lk.get(j).getDiem();

						System.out.format("\n%-10s%-25s%10s", lk.get(j).getMaMh(), lk.get(j).getTenMh(),
								lk.get(j).getDiem());
					}

				}
				float s = (float) diem / count;
				if (count != 0) {
					System.out.println("\nDIEM TONG KET:\t\t\t\t" + s);
				} else {
					System.out.println("diem tong ket             0");
					System.out.println("sinh vien chua co diem mon nao");
				}
				System.out.println("--------------Trang" + 1 + "/" + ((int) listsv.size() / 30)
						+ "------------------------------");
			}
		} else {

			trang = trang;
			trang = trang - 1;
			trang = trang * next + 1;

			int pn = page * next;
			if (pn > listsv.size()) {
				System.out.println("--------------Trang" + page + "/" + (int) listsv.size() / 30
						+ "------------------------------");
				pn = listsv.size();
				for (int i = trang - 1; i < pn; i++) {
					System.out.print("MASV:" + listsv.get(i).getMaSv() + "\t" + listsv.get(i).getHoDem() + " "
							+ listsv.get(i).getTen() + "\t\t  " + listsv.get(i).getNs() + "\n");
					float diem = 0;
					int count = 0;

					for (int j = 0; j < lk.size(); j++) {
						if (lk.get(j).getMaSv() == listsv.get(i).getMaSv()) {
							count++;
							diem += lk.get(j).getDiem();

							System.out.format("\n%-10s%-25s%10s", lk.get(j).getMaMh(), lk.get(j).getTenMh(),
									lk.get(j).getDiem());
						}

					}
					float s = (float) diem / count;
					if (count != 0) {
						System.out.println("\nDIEM TONG KET:\t\t\t\t" + s);
					} else {
						System.out.println("diem tong ket             0");
						System.out.println("sinh vien chua co diem mon nao");
					}
					System.out.println("--------------Trang" + page + "/" + (int) listsv.size() / 30
							+ "------------------------------");
				}
			} else {
				System.out.println("--------------Trang" + page + "/" + (int) listsv.size() / 30
						+ "------------------------------");
				for (int i = trang - 1; i < page * next; i++) {
					System.out.print("MASV:" + listsv.get(i).getMaSv() + "\t" + listsv.get(i).getHoDem() + " "
							+ listsv.get(i).getTen() + "\t\t  " + listsv.get(i).getNs() + "\n");
					float diem = 0;
					int count = 0;

					for (int j = 0; j < lk.size(); j++) {
						if (lk.get(j).getMaSv() == listsv.get(i).getMaSv()) {
							count++;
							diem += lk.get(j).getDiem();

							System.out.format("\n%-10s%-25s%10s", lk.get(j).getMaMh(), lk.get(j).getTenMh(),
									lk.get(j).getDiem());
						}

					}
					float s = (float) diem / count;
					if (count != 0) {
						System.out.println("\nDIEM TONG KET:\t\t\t\t" + s);
					} else {
						System.out.println("diem tong ket             0");
						System.out.println("sinh vien chua co diem mon nao");
					}
					System.out.println("--------------Trang" + page + "/" + (int) listsv.size() / 30
							+ "------------------------------");
				}
			}
		}
	}

// tim kiem theo ma sv
	public static void timKiemTheoMaSv(List<SinhVien> listsv, Scanner sc) {
		// sc.nextLine();
		System.out.println("nhap ma sinh vien can tim kiem:");
		// sc.nextLine();
		String masvStr = sc.nextLine();
		String cutMasv = masvStr.substring(2);
		int masv = Integer.parseInt(cutMasv);
		List<SvBangDiemMonHoc> lk = hienThiBangDiem();
		int demTen = 0;
		for (int i = 0; i < listsv.size(); i++) {
			if (masv == listsv.get(i).getMaSv()) {
				demTen++;
				System.out.println("Ten sv:" + listsv.get(i).getTen());

			}

		}
		if (demTen == 0) {
			System.out.println("ma sv khong ton tai");
		} else {
			float diem = 0;
			int count = 0;
			for (int j = 0; j < lk.size(); j++) {
				if (lk.get(j).getMaSv() == masv) {
					count++;
					diem += lk.get(j).getDiem();

					System.out.format("\n%-10s%-25s%10s", lk.get(j).getMaMh(), lk.get(j).getTenMh(),
							lk.get(j).getDiem());
				}

			}
			if (count == 0) {
				System.out.println("ma sv khong co diem ");
			} else {
				System.out.println("\nDiem tk:" + (float) diem / count);
			}
		}

	}

	// tim kiem thoe ten sv
	public static void timKiemTheoTen(List<SinhVien> listsv, Scanner sc) {
		// sc.nextLine();
		System.out.println("nhap ten sinh vien:");
		// sc.nextLine();
		String tenSv = sc.nextLine();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.format("\n%10s%-10s%-20s%-10s%-15s%-10s%10s", "|", "MASV", " HODEM", "TEN", "NGAYSINH ", "GIOITINH",
				"|");
		for (int i = 0; i < listsv.size(); i++) {
			if (tenSv.equalsIgnoreCase(listsv.get(i).getTen())) {
				System.out.format("\n%10s%-10s%-20s%-10s%-15s%-10s%10s", "|", listsv.get(i).getMaSv(),
						listsv.get(i).getHoDem(), listsv.get(i).getTen(), listsv.get(i).getNs(),
						listsv.get(i).getGioiTinh(), "|");
			}
		}
		System.out.println("\n-------------------------------------------------------------------------------");
	}
}
