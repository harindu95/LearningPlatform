package shared;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileObj {
	public File file  = null;
	public int[] data;
	
	FileObj(String filename) throws IOException{
		file = new File(filename);
		readFile();
	}
	public FileObj(String path,String filename) throws IOException{
		file = new File(path,filename);
		readFile();
	}
	
	void readFile() throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			int c = br.read();
			int length = 0;
			while (c != -1) {
				length++;
				c = br.read();
			}
			data = new int[length];
			br.close();
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			for (int i = 0; i < data.length; i++) {
				data[i] = br.read();
			}

		} finally {
			br.close();
		}
	}
}
