package backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import shared.Assignment;
import shared.FileObj;
import shared.Submission;

public class FileManager {
	private String root_path = "files";

	void storeFile(String filename, byte[] data) throws IOException {
		Files.write(Paths.get(filename), data);
	}

	void storeFile(FileObj fileObj) throws IOException {
		storeFile(fileObj.file.getName(),fileObj.data);
	}

	
	public FileObj readFile(String filename) throws IOException {
		return new FileObj(root_path,filename);
	}

	public String storeSubmission(Submission data) throws IOException {
		// TODO Auto-generated method stub
		String path = data.getAssignment().getCourse().getId() + "__" + data.getAssignment().getId() +"__" +data.getStudent().id +"__" +data.getTimeStamp() + "__" + data.getFile().file.getName();
		path = sanitizeFilename(path);
		File file = new File(root_path,path);
		storeFile(file.getAbsolutePath(), data.getFile().data);
		
		return path;
	}
	public String sanitizeFilename(String inputName) {
	    return inputName.replaceAll("[^a-zA-Z0-9-_\\.]", "_");
	}

	public String storeAssignment(Assignment data) throws IOException {
		String path = data.getCourse().getId() + "__" + data.getId() +"__"  + data.getFile().file.getName();
		path = sanitizeFilename(path);
		File file = new File(root_path,path);
		storeFile(file.getAbsolutePath(), data.getFile().data);
		
		return path;
	}

}
