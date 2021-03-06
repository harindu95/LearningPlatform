package shared;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class FileObj implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4931993358502378768L;
	public File file = null;
	public int[] data;

	public FileObj(String filename) throws IOException {
		file = new File(filename);
		readFile();
	}

	public FileObj(String path, String filename) throws IOException {
		file = new File(path, filename);
		readFile();
	}

	public FileObj(File selectedFile) throws IOException {
		this.file = selectedFile;
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
			if (br != null && file != null) {
				br.close();
			}
		}
	}
}
