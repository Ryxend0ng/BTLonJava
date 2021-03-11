package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BEAN.BangDiem;
import BEAN.MonHoc;

public class BangDiemDAO {
	public static BangDiem createBD(String line)  {
		String part[]=line.split(";");
		String maSv=part[0];
		String maMh=part[1];
		String diem=part[2];
		String maSVstr=maSv.substring(2);
		int maSvInt=Integer.valueOf(maSVstr);
		float diem1=Float.valueOf(diem);
		int mmh=Integer.valueOf(maMh);
		BangDiem bd=new BangDiem(maSvInt, mmh, diem1);
		return bd;
	}
	public static List<BangDiem> inThongTinBD() {
		FileReader frd=null;
		BufferedReader brd=null;
		List<BangDiem> listbd=new ArrayList<BangDiem>();
		try {
			frd=new FileReader(new File("D:\\Data\\diem.txt"));
			brd=new BufferedReader(frd);
			String line="";
			while((line=brd.readLine())!= null) {
				if(line.contains("#")) {
					continue;
				}else {
					listbd.add(createBD(line));
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
		return listbd;
	}
	
}
