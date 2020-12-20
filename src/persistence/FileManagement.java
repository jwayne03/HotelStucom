package persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManagement {

    private final String SEPARATOR = File.separator;
    private final String LINE_SEPARATOR = "line.separator";
    private final String FOLDER_DATA = "data";
    private final String FILE_OUTPUT = "FileOutput";

    private final File fileoutput;

    public FileManagement() {
        fileoutput = new File(route() + FILE_OUTPUT + ".txt");
        setFileEmpty(fileoutput);
    }

    public String route() {
        String route = System.getProperty("user.dir") + SEPARATOR + FOLDER_DATA;
        File folder = new File(route);
        if (!folder.exists()) folder.mkdir();
        return route + SEPARATOR;
    }

    public void saveData(String data) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileoutput, true));
            bufferedWriter.write(data + System.getProperty(LINE_SEPARATOR));
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setFileEmpty(File fileEmpty) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileEmpty));
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
