package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import BEAN.MonHoc;
import BEAN.SinhVien;

public class MonHocDAO {
	public static MonHoc createMH(String line)  {
		String part[]=line.split(";");
		String maMH=part[0];
		String tenMH=part[1];
		String heSo=part[2];
		float hs=Float.valueOf(heSo);
		int maMHInt=Integer.valueOf(maMH);
		MonHoc mh=new MonHoc(maMHInt, tenMH, hs);
		return mh;
	}
	public static List<MonHoc> inThongTinMH() {
		FileReader frd=null;
		BufferedReader brd=null;
		List<MonHoc> listmh=new ArrayList<MonHoc>();
		try {
			frd=new FileReader(new File("D:\\Data\\monhoc_en.txt"));
			brd=new BufferedReader(frd);
			String line="";
			while((line=brd.readLine())!= null) {
				if(line.contains("#")) {
					continue;
				}else {
				
					listmh.add(createMH(line));
				}
			}
		}catch(Exception e) {}
		finally {
			if(frd != null)
				try {
					frd.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(brd!= null)
				try {
					brd.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return listmh;
	}

	public static void sapXepMonHoc(List<MonHoc> mh) {
		mh.sort((o1,o2) -> o1.getTenMH().compareTo(o2.getTenMH()));
	}
	public static void hienThidsMonHoc(List<MonHoc> listmh) {
		System.out.format("\n%-10s%-25s%-10s","Ma MH","ten MH","HE SO");
		for (MonHoc mh : listmh) {
			
			System.out.format("\n%-10s%-25s%-10s",mh.getMaMH(),mh.getTenMH(),mh.getHeSoMH());
			
		}
		System.out.println();
	}
}

