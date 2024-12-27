package com.jump2java_test_task.home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class GuessNumController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button playBtn;

    @FXML
    private Button checkBtn;

    @FXML
    private TextArea textArea;

    @FXML
    private Label textOutLabel;

    @FXML
    private Button tryBtn;

    private int randomNum = 0;
    private int userNum = 0;
    private int counter = 0;

    @FXML
    void onHelloButtonClick(ActionEvent event) {
    }

    @FXML
    void initialize() throws IOException {

        //по нажатию кнопки играть, записали рандомное число в переменную и вывели в консоль
        playBtn.setOnAction(actionEvent -> {
            randomNum = getRandomNum();
            System.out.println(randomNum);
        });

        //по нажатию кнопки проверить, сверяем результаты и выводим сообщения.
        checkBtn.setOnAction(actionEvent -> {
            counter++;
            getNumFromUser();
            setResultMessage();
        });


        tryBtn.setOnAction(actionEvent -> {
            getTryQuantity();
        });
    }

    /**
     * Метод генерирует рандомные числа от 1 до 100 включительно и возвращает их.
     *
     * @return int
     */
    private int getRandomNum() {
        return (int) (Math.random() * 100);
    }

    /**
     * Метод записывает в переменную {@link GuessNumController#userNum} число полученное от юзера, предварительно сменив его тип.
     *
     */
    private void getNumFromUser() {

        //получаем число из текстового поля в текстовом формате
        String userText = textArea.getText();

        //парсим текст в числовой формат
        int tempUserNum = Integer.parseInt(userText);

        //если число выбивается из интервала от 1 до 100, то присваиваем в переменную userNum -1
        //и далее используем его как флаг
        if (tempUserNum < 1 || tempUserNum > 100) {
            userNum = -1;
        } else {
            userNum = tempUserNum;
        }
    }

    /**
     * Метод получает результат деления числа пользователя на рандомное число.
     * Можно получить дробное число больше, меньше или равное еденице.
     *
     * @return double
     */
    private double calculateNumbers() {
        return (double) userNum / (double) randomNum;
    }

    /**
     * Метод определяет больше, меньше или равно, загаданное пользователем число, единице.
     * Если результат меньше единицы, то загаданное пользователем число меньше рандомного числа.
     * Если результат больше единицы, то - больше рандомного числа.
     * А если результат равен единице, то значит загаданное число равно рандомному.
     */
    private void setResultMessage() {

        //получаем коэффициент
        double calcNumb = calculateNumbers();

        //выводим соответствующие сообщения если коэф. больше, меньше либо равен 1
        if (calcNumb > 1) {
            System.out.println(Constants.NUM_MORE);
            textOutLabel.setText(Constants.NUM_MORE);
        } else if (calcNumb < 1) {
            System.out.println(Constants.NUM_LESS);
            textOutLabel.setText(Constants.NUM_LESS);
        } else {
            System.out.println(Constants.NUM_MATCH);
            textOutLabel.setText(Constants.NUM_MATCH);
        }

        //используем -1 в переменной как маркер того, что число задано неверно
        if(userNum == -1){
            System.out.println(Constants.WRONG_NUM);
            textOutLabel.setText(Constants.WRONG_NUM);
        }
    }

    /**
     * Метод выводит количество попыток в поле сообщений в окне и в консоль
     */
    private void getTryQuantity(){
        switch(counter){
            case 1:
                printTryText(" попытку");
                break;
            case 2, 3, 4:
               printTryText(" попытки");
                break;
            default:
                printTryText(" попыток");
                break;
        }
    }

    /**
     * Метод используется для получения верного склонения слова в сообщении о попытках.
     * @param word
     */
    private void printTryText(String word){
        System.out.println(Constants.YOU_DID_IT + counter + word);
        textOutLabel.setText(Constants.YOU_DID_IT + counter + word);
    }
}
