package shared;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.file.Files;

public class FileObj implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4931993358502378768L;
	public File file = null;
	public byte[] data;

	public FileObj(String filename) throws IOException {
		file = new File("files",filename);
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

		data = Files.readAllBytes(file.toPath());

	}
}
