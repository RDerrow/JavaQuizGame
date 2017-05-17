import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 * Created by DerrowR on 5/17/2017.
 */
public class readQuizInfo {

    private String path = "C:\\Users\\DerrowR\\IdeaProjects\\Quiz\\src\\quizInfo.txt";

    public String[] openFile() throws IOException {

        FileReader fileR = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fileR);

        int numberOfLines = fileSize();
        String[] textData = new String[numberOfLines];

        for(int i = 0; i < numberOfLines; i++) {
            textData[i] = textReader.readLine();
        }

        textReader.close();
        return textData;
    }

    public int fileSize() throws IOException {
        String lines;
        int fileSize = 0;

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        while((lines = br.readLine()) != null) {
            fileSize++;
        }
        br.close();
        return fileSize;
    }

    public quizInfoObject[] getQuizInfo() throws IOException {
        int totalQuestions = openFile().length/5;
        quizInfoObject[] quizFileData = new quizInfoObject[totalQuestions];
        String[] fileData = openFile();

        for (int a = 0; a < quizFileData.length; a++) {
            quizFileData[a] = new quizInfoObject();
        }

        for(int i = 0, j = 0; i < openFile().length; i = i + 5, j++) {
            quizFileData[j].question = fileData[i];
            quizFileData[j].answer = fileData[i + 1];
            quizFileData[j].wrongAnswer1 = fileData[i + 2];
            quizFileData[j].wrongAnswer2 = fileData[i + 3];
            quizFileData[j].wrongAnswer3 = fileData[i + 4];
        }

        return quizFileData;
    }
}
