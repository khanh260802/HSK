package week2JTable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Database {
	
	// lưu dữ liệu vào file
	public void saveFile(String fileName, Object o) {
		FileOutputStream fos = null; 
		ObjectOutputStream oos = null; 
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos); 
			oos.writeObject(o);
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "IO Error!");
		}
	}
	
	// Đọc dữ liệu từ file đưa lên table
	public Object readFile(String fileName) {
		Object o = null; 
		FileInputStream fis = null; 
		ObjectInputStream ois = null; 
		try {
			fis = new FileInputStream(fileName); 
			ois = new ObjectInputStream(fis); 
			o = ois.readObject(); 
			ois.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "IO Error!");
		}
		return o; 
	}
}
