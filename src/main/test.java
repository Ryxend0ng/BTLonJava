package main;
import java.text.ParseException;
import java.util.*;

import BEAN.BangDiem;
import BEAN.MonHoc;
import BEAN.SinhVien;
import BEAN.SvBangDiemMonHoc;
import DAO.BangDiemDAO;
import DAO.MonHocDAO;
import DAO.SinhVienDAO;
import veiw.VeiwMenu;
public class test {
	public static int nextTrang=1;
	public static int nextTrang1=1;
	public static List<SinhVien> list=new ArrayList<SinhVien>();
	public static List<MonHoc>listmh=new ArrayList<MonHoc>();
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
	
		list=SinhVienDAO.inThongTinSV(list);
		listmh=MonHocDAO.inThongTinMH();
		int choose;
		
		do {
			VeiwMenu.menuChinh();
			System.out.println("nhap y/c chon:");
			 choose = Integer.parseInt(sc.nextLine());
			 
			switch (choose) {
			case 1:
				
				int j;
				do {
					VeiwMenu.menu1();
					System.out.println("nhap y/c chon:");
					 j=Integer.parseInt(sc.nextLine());
					switch (j) {
					case 1:
						try {
							SinhVienDAO.themSinhVien(list,sc);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 2:
						try {
							SinhVienDAO.suaThongTinhSv(list,sc);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 3:
					SinhVienDAO.xoaSinhVien(list,sc);
						break;
					case 4:
						SinhVienDAO.sapXepTheoTen(list);
						SinhVienDAO.xuatThongTin(list,0);
						int chon1;
						do {
							VeiwMenu.phanTrang();
							System.out.println("nhap yeu cau chon:");
							chon1=Integer.parseInt(sc.nextLine());
							switch (chon1) {
							case 1:
								nextTrang1++;
								SinhVienDAO.xuatThongTin(list, nextTrang1);
								break;
							case 2:
								nextTrang1--;
								if(nextTrang1<=0) nextTrang1=1;
								SinhVienDAO.xuatThongTin(list, nextTrang1);
								
								break;
							case 3:
								System.out.println("nhap trang muon xem:");
								int trang=Integer.parseInt(sc.nextLine());
								SinhVienDAO.xuatThongTin(list, trang);
								break;
							case 0:
								menucase();
								break;
							default:
								System.out.println("yc nhap sai");
								break;
							}
							
						}while(chon1>-1);
						break;
					case 5:
						MonHocDAO.sapXepMonHoc(listmh);
						MonHocDAO.hienThidsMonHoc(listmh);
						break;
					case 0:
						menu();
						break;
					default:
						System.out.println("yc nhap sai");
						break;
					}
				
				}while(j>-1);
				break;
			case 2:
				SinhVienDAO.sapXepTheoMsv(list);
				
				SinhVienDAO.HienThiDanhSach(list, 0);
				int chon;			
				do {
					VeiwMenu.phanTrang();
					System.out.println("nhap yeu cau chon:");
					chon=Integer.parseInt(sc.nextLine());
					switch (chon) {
					case 1:
						nextTrang++;
						SinhVienDAO.HienThiDanhSach(list, nextTrang);
						break;
					case 2:
						nextTrang--;
						if(nextTrang<=0) nextTrang=1;
						SinhVienDAO.HienThiDanhSach(list, nextTrang);
						break;
					case 3:
						System.out.println("nhap trang muon xem:");
						int trang1=Integer.parseInt(sc.nextLine());
						SinhVienDAO.HienThiDanhSach(list, trang1);
						break;
					case 0:
						menu();
						break;
					default:
						System.out.println("yc nhap sai");
						break;
					}
					
				}while(chon>-1);
				break;
			case 3:
				int b;
				do {
					VeiwMenu.menu3();
					System.out.println("nhap yc chon:");
					b=Integer.parseInt(sc.nextLine());
					switch (b) {
					case 1:
						SinhVienDAO.timKiemTheoMaSv(list, sc);
						break;
					case 2:
						SinhVienDAO.timKiemTheoTen(list,sc);
						break;
					case 0:
						menu();
						break;
					default:
						System.out.println("yc nhap sai");
						break;
					}
					
				}while(b>-1);
				break;
			
			case 0:
				System.out.println("ban da thoat");
				break;
			
			}
		if(choose>4 || choose <0) System.out.println("yc nhap sai");
		}while(choose>4||choose<0);
	}
		// menu case
	public static void menucase() {
		int j;
		do {
			VeiwMenu.menu1();
			System.out.println("nhap y/c chon:");
			 j=Integer.parseInt(sc.nextLine());
			switch (j) {
			case 1:
				try {
					SinhVienDAO.themSinhVien(list,sc);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					SinhVienDAO.suaThongTinhSv(list,sc);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
			SinhVienDAO.xoaSinhVien(list,sc);
				break;
			case 4:
				SinhVienDAO.sapXepTheoTen(list);
				//SinhVienDAO.xuatThongTin(list,1);
				int chon1;
				do {
					VeiwMenu.phanTrang();
					System.out.println("nhap yeu cau chon:");
					chon1=sc.nextInt();
					switch (chon1) {
					case 1:
						nextTrang1++;
						SinhVienDAO.xuatThongTin(list, nextTrang1++);
						break;
					case 2:
						nextTrang1--;
						if(nextTrang1<=0) nextTrang1=1;
						SinhVienDAO.xuatThongTin(list, nextTrang1--);
						
						break;
					case 3:
						System.out.println("nhap trang muon xem:");
						int trang=sc.nextInt();
						SinhVienDAO.xuatThongTin(list, trang);
					case 0:
						menucase();
						break;
					default:
						System.out.println("yc nhap sai");
						break;
					}
					
				}while(chon1>-1);
				break;
			case 5:
				MonHocDAO.sapXepMonHoc(listmh);
				MonHocDAO.hienThidsMonHoc(listmh);
				break;
			case 0:
				menu();
				break;
			default:
				System.out.println("yc nhap sai");
				break;
			}
		
		}while(j>-1);
	}
	// menu chinh
	public static void menu() {
		int k;
		do {
			VeiwMenu.menuChinh();
			System.out.println("nhap y/c chon:");
			 k = Integer.parseInt(sc.nextLine());
			 
			switch (k) {
			case 1:
				
				int j;
				do {
					VeiwMenu.menu1();
					System.out.println("nhap y/c chon:");
					 j=Integer.parseInt(sc.nextLine());
					switch (j) {
					case 1:
						try {
							SinhVienDAO.themSinhVien(list,sc);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 2:
						try {
							SinhVienDAO.suaThongTinhSv(list,sc);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 3:
					SinhVienDAO.xoaSinhVien(list,sc);
						break;
					case 4:
						SinhVienDAO.sapXepTheoTen(list);
						SinhVienDAO.xuatThongTin(list,0);
						int chon1;
						do {
							VeiwMenu.phanTrang();
							System.out.println("nhap yeu cau chon:");
							chon1=Integer.parseInt(sc.nextLine());
							switch (chon1) {
							case 1:
								nextTrang1++;
								SinhVienDAO.xuatThongTin(list, nextTrang1++);
								break;
							case 2:
								nextTrang1--;
								if(nextTrang1<=0) nextTrang1=1;
								SinhVienDAO.xuatThongTin(list, nextTrang1--);
								
								break;
							case 3:
								System.out.println("nhap trang muon xem:");
								int trang=Integer.parseInt(sc.nextLine());
								SinhVienDAO.xuatThongTin(list, trang);
								break;
							case 0:
								menucase();
								break;
							default:
								System.out.println("yc nhap sai");
								break;
							}
							
						}while(chon1>-1);
						break;
					case 5:
						MonHocDAO.sapXepMonHoc(listmh);
						MonHocDAO.hienThidsMonHoc(listmh);
						break;
					case 0:
						menu();
						break;
					default:
						System.out.println("yc nhap sai");
						break;
					}
				
				}while(j>-1);
				break;
			case 2:
				SinhVienDAO.sapXepTheoMsv(list);
				
				SinhVienDAO.HienThiDanhSach(list, 0);
				int chon;			
				do {
					VeiwMenu.phanTrang();
					System.out.println("nhap yeu cau chon:");
					chon=Integer.parseInt(sc.nextLine());
					switch (chon) {
					case 1:
						nextTrang++;
						SinhVienDAO.HienThiDanhSach(list, nextTrang);
						break;
					case 2:
						nextTrang--;
						if(nextTrang<=0) nextTrang=1;
						SinhVienDAO.HienThiDanhSach(list, nextTrang);
						break;
					case 3:
						System.out.println("nhap trang muon xem:");
						int trang=Integer.parseInt(sc.nextLine());
						SinhVienDAO.HienThiDanhSach(list, trang);
						break;
					case 0:
						menu();
						break;
					default:
						System.out.println("yc nhap sai");
						break;
					}
					
				}while(chon>-1);
				break;
			case 3:
				int b;
				do {
					VeiwMenu.menu3();
					System.out.println("nhap yc chon:");
					b=Integer.parseInt(sc.nextLine());
					switch (b) {
					case 1:
						SinhVienDAO.timKiemTheoMaSv(list, sc);
						break;
					case 2:
						SinhVienDAO.timKiemTheoTen(list,sc);
						break;
					case 0:
						menu();
						break;
					default:
						System.out.println("yc nhap sai");
						break;
					}
					
				}while(b>-1);
				break;
			
			case 0:
				System.out.println("ban da thoat");
				break;
			
			}
		if(k>4 || k <0) System.out.println("yc nhap sai");
		}while(k>4||k<0);
}
}
