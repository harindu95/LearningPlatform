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

	public int[] readFile(String filename) throws IOException {
		BufferedReader br = null;
		try {
			File file = new File(path, filename);
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			int c = br.read();
			int length = 0;
			while (c != -1) {
				length++;
				c = br.read();
			}
			int[] array = new int[length];
			br.close();
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			for (int i = 0; i < array.length; i++) {
				array[i] = br.read();
			}

			return array;

		} finally {
			br.close();
		}
	}

}
