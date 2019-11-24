package student.enterprise.project.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public interface FileService {

    boolean saveFile(FileOutputStream stream, String path);

    FileInputStream getFile(String path);
}
