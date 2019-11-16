package student.enterprise.project.service;

import java.io.File;
import java.nio.file.Path;

public interface FileService {

    boolean saveFile(File file);

    File getFile(Path path);
}
