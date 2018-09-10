package servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FileItem{
	private String name;
	private String string;
	
	public FileItem(String name, String string) {
		super();
		this.name = name;
		this.string = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "FileItem [name=" + name + ", string=" + string + "]";
	}
	
}

public class Test {
	public static String getString(List<FileItem> list, String name) {
		for(FileItem fi : list) {
			if(fi.getName().equals(name)) {
				return fi.getString();
			}
		}
		return null;
	}
	
	public static void main(String args[]) {
		List<FileItem> fList = new ArrayList<FileItem>();
		FileItem fi = new FileItem("name","홍길동");
		fList.add(fi);
		fi = new FileItem("age","33");
		fList.add(fi);
		fi = new FileItem("address","서울");
		fList.add(fi);
		
		Map<String,String> map = new HashMap<String,String>();
		for(FileItem f:fList) {
			map.put(f.getName(), f.getString());
		}
		System.out.println(map.get("name"));
		System.out.println(map.get("age"));
		System.out.println(map.get("address"));
	}
}
