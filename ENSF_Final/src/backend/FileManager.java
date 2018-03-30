package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

import shared.FileObj;

public class FileManager {
	private String path = "files";

	void storeFile(String filename, int[] data) throws IOException {
		BufferedWriter bw = null;
		try {
			File newFile = new File(path, filename);
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)));
			for (int c : data) {
				bw.write(c);
			}
		} finally {
			bw.close();
		}
	}

	void storeFile(FileObj fileObj) throws IOException {
		storeFile(fileObj.file.getName(),fileObj.data);
	}

	
	public FileObj readFile(String filename) throws IOException {
		return new FileObj(path,filename);
	}

}
