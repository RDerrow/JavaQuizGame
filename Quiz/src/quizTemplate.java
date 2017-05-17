import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.io.IOException;

/**
 * Created by DerrowR on 5/15/2017.
 */

public class quizTemplate {
    //MARK: Variables
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int points = 0;
    readQuizInfo readQuiz = new readQuizInfo();
    quizInfoObject[] quizObjests = new quizInfoObject[readQuiz.getQuizInfo().length];
    JFrame quizFrame;
    private Label questionLabel;
    private Label pointsLabel;
    private int iterateQuestion;
    private Label winLabel;
    JFrame quizFrameWin = new JFrame();

    public quizTemplate() throws IOException {
        questionLabel = new Label("Who created this game?");
        pointsLabel = new Label(getPoints());
        iterateQuestion = 0;
        quizFrame = new JFrame("Quiz Frame");
        BoxLayout boxLayout = new BoxLayout(quizFrame.getContentPane(), BoxLayout.PAGE_AXIS);
        quizFrame.setLayout(boxLayout);
        winLabel = new Label("Congrats! You won the quiz! your score is:" +  getPoints());
        quizFrameWin = new JFrame();
        try {
            quizObjests = readQuiz.getQuizInfo();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    JButton answer = new JButton(new AbstractAction("Robert Derrow") {
        //Add point if correct answer is chosen
        @Override
        public void actionPerformed(ActionEvent e) {
            points++;
            pointsLabel.setText(Integer.toString(points));
            updateQuiz(iterateQuestion);
            iterateQuestion++;
        }
    });

    //MARK: Wrong answer
    JButton wrongAnswer1 = new JButton(new AbstractAction("Bob Ryan") {
        //Subtract points if wrong answer is chosen
        @Override
        public void actionPerformed(ActionEvent e) {
            points--;
            pointsLabel.setText(Integer.toString(points));
            updateQuiz(iterateQuestion);
            iterateQuestion++;
        }
    });
    JButton wrongAnswer2 = new JButton(new AbstractAction("Tim Cook") {
        //Subtract points if wrong answer is chosen
        @Override
        public void actionPerformed(ActionEvent e) {
            points--;
            pointsLabel.setText(Integer.toString(points));
            updateQuiz(iterateQuestion);
            iterateQuestion++;
        }
    });
    JButton wrongAnswer3 = new JButton(new AbstractAction("Adam Taff") {
        //Subtract points if wrong answer is chosen
        @Override
        public void actionPerformed(ActionEvent e) {
            points--;
            pointsLabel.setText(Integer.toString(points));
            updateQuiz(iterateQuestion);
            iterateQuestion++;
        }
    });

    //Set points value to a string then return value
    public String getPoints() {
        return Integer.toString(this.points);
    }


    //Update the quiz after an answer is given
    private void updateQuiz(int i) {

        if (i < quizObjests.length) {
            this.questionLabel.setText(quizObjests[i].question);
            answer.setText(quizObjests[i].answer);
            wrongAnswer1.setText(quizObjests[i].wrongAnswer1);
            wrongAnswer2.setText(quizObjests[i].wrongAnswer2);
            wrongAnswer3.setText(quizObjests[i].wrongAnswer3);
            createFrame();
        } else {
            winLabel = new Label("Congrats! You Finished! Your score is:" +  getPoints());
            quizFrame.getContentPane().removeAll();
            quizFrame.revalidate();
            quizFrame.repaint();
            quizFrame.setBounds((screenSize.width / 2) - 150, (screenSize.height / 2)-150, 300, 300);
            quizFrame.add(winLabel);
            quizFrame.setVisible(true);
        }

    }

    //Setting the initial values of the quiz
    public void createFrame() {
        Random randomNumber = new Random();
        int order = randomNumber.nextInt(4);

        switch (order) {
            case 0:
                quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                quizFrame.setBounds((screenSize.width / 2) - 150, (screenSize.height / 2)-150, 300, 300);
                quizFrame.add(pointsLabel);
                quizFrame.add(questionLabel);
                quizFrame.add(answer, BorderLayout.WEST);
                quizFrame.add(wrongAnswer1);
                quizFrame.add(wrongAnswer2);
                quizFrame.add(wrongAnswer3);
                quizFrame.setVisible(true);
                break;
            case 1:
                quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                quizFrame.setBounds((screenSize.width / 2) - 150, (screenSize.height / 2)-150, 300, 300);
                quizFrame.add(pointsLabel);
                quizFrame.add(questionLabel);
                quizFrame.add(wrongAnswer1);
                quizFrame.add(answer);
                quizFrame.add(wrongAnswer2);
                quizFrame.add(wrongAnswer3);
                quizFrame.setVisible(true);
                break;

            case 2:
                quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                quizFrame.setBounds((screenSize.width / 2) - 150, (screenSize.height / 2)-150, 300, 300);
                quizFrame.add(pointsLabel);
                quizFrame.add(questionLabel);
                quizFrame.add(wrongAnswer1);
                quizFrame.add(wrongAnswer2);
                quizFrame.add(answer);
                quizFrame.add(wrongAnswer3);
                quizFrame.setVisible(true);
                break;
            case 3:
                quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                quizFrame.setBounds((screenSize.width / 2) - 150, (screenSize.height / 2)-150, 300, 300);
                quizFrame.add(pointsLabel);
                quizFrame.add(questionLabel);
                quizFrame.add(wrongAnswer1);
                quizFrame.add(wrongAnswer2);
                quizFrame.add(wrongAnswer3);
                quizFrame.add(answer);
                quizFrame.setVisible(true);
                break;
        }
    }
}
