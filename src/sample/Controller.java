package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable{

    @FXML
    public Button btnApples;

    @FXML
    public Button btnOranges;

    @FXML
    public Button btnBananas;

    @FXML
    public Button btnGrapes;

    @FXML
    public Text boxApples;

    @FXML
    public Text boxOranges;

    @FXML
    public Text boxBananas;

    @FXML
    public Text boxGrapes;

    @FXML
    public Text boxTimer;

    @FXML
    public Text feedbackText;

    @FXML
    public Text playerCash;

    @FXML
    public Text priceApple;

    @FXML
    public Text priceOrange;

    @FXML
    public Text priceBanana;

    @FXML
    public Text priceGrape;

    @FXML
    public Button btnSellApples;

    @FXML
    public Button btnSellOranges;

    @FXML
    public Button btnSellBananas;

    @FXML
    public Button btnSellGrapes;

    private int countApples = 0;
    private int countOranges = 0;
    private int countBananas = 0;
    private int countGrapes = 0;

    private int countTime = 0;




    Random diceRoll = new Random();
    int randomApple = diceRoll.nextInt(10);
    int randomOranges = diceRoll.nextInt(10);
    int randomBananas = diceRoll.nextInt(10);
    int randomGrapes = diceRoll.nextInt(10);


    private player person;

    DecimalFormat df = new DecimalFormat("0.00");





@Override
    public void initialize(URL location, ResourceBundle resources){


    person = new player(100, 0, 0, 0, 0);

    updateBoxes();
    setUpClock();

    person.setCash(Double.parseDouble(df.format(person.getCash())));
    person.getCash();



}

public void setUpClock(){
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            countTime++;
            String stringTime = String.valueOf(countTime);
            boxTimer.setText(stringTime);
            if(countTime == 15){
                countTime = 0;
                randomApple = diceRoll.nextInt(10);
                randomOranges = diceRoll.nextInt(10);
                randomBananas = diceRoll.nextInt(10);
                randomGrapes = diceRoll.nextInt(10);
                updateBoxes();

            }
        }
    };

    Timer moneyTimer = new Timer();
    moneyTimer.schedule(task, 1000L, 1000L);
}

public void updateBoxes(){
    boxApples.setText("Apples: " + countApples);
    boxOranges.setText("Oranges: " + countOranges);
    boxBananas.setText("Bananas: " + countBananas);
    boxGrapes.setText("Grapes:" + countGrapes);
    playerCash.setText("$" + String.valueOf(person.getCash()));
    priceApple.setText("Apple Price: $" + randomApple + " ");
    priceBanana.setText("Banana Price: $" + randomBananas + " ");
    priceGrape.setText("Grape Price: $" + randomGrapes + " ");
    priceOrange.setText("Orange Price: $" + randomOranges + " ");

    int appleCashSell = randomApple * countApples;
    int orangeCashSell = randomOranges * countOranges;
    int bananaCashSell = randomBananas * countBananas;
    int grapeCashSell = randomGrapes * countGrapes;

    //int totalCash = 100 - (appleCashSell + orangeCashSell + bananaCashSell + grapeCashSell);
    playerCash.setText("Cash Available: $" + person.getCash());





}

public void clickApples(ActionEvent actionEvent) {
    if (person.getCash() > randomApple) {
        countApples++;
        updateBoxes();
        feedbackText.setText(countApples + " " + "APPLE(S) PURCHASED");
        person.setCash(person.getCash() - randomApple);

    }
}

public void clickOranges(ActionEvent actionEvent){
    if(person.getCash() > randomOranges){
        countOranges++;
        updateBoxes();
        feedbackText.setText(countOranges + " " + "ORANGE(S) PURCHASED");
        person.setCash(person.getCash() - randomOranges);
    }

}

public void clickBananas(ActionEvent actionEvent){
    if(person.getCash() > randomBananas){
        countBananas++;
        updateBoxes();
        feedbackText.setText(countBananas + " " + "BANANA(S) PURCHASED");
        person.setCash(person.getCash() - randomBananas);
    }
}
public void clickGrapes(ActionEvent actionEvent){
    if(person.getCash() > randomGrapes){
        countGrapes++;
        updateBoxes();
        feedbackText.setText(countGrapes + " " + "GRAPE(S) PURCHASED");
        person.setCash(person.getCash() - randomGrapes);
    }
}





public void sellApples(ActionEvent actionEvent){
    if(countApples > 0){
        countApples--;
        person.setCash(person.getCash() + randomApple);
        updateBoxes();
        feedbackText.setText("SALE SUCCESSFUL");
    } else {
        feedbackText.setText("ERROR. CAN'T SELL MORE THAN YOU HAVE." );
    }

}
public void sellOranges(ActionEvent actionEvent){
    if(countOranges > 0){
        countOranges--;
        person.setCash(person.getCash() + randomOranges);
        updateBoxes();
        feedbackText.setText("SALE SUCCESSFUL");
    } else {
        feedbackText.setText("ERROR. CAN'T SELL MORE THAN YOU HAVE." );
    }
}
public void sellBananas(ActionEvent actionEvent){
    if(countBananas > 0){
        countBananas--;
        person.setCash(person.getCash() + randomBananas);
        updateBoxes();
        feedbackText.setText("SALE SUCCESSFUL");
    } else {
        feedbackText.setText("ERROR. CAN'T SELL MORE THAN YOU HAVE." );
    }
}
public void sellGrapes(ActionEvent actionEvent){
    if(countGrapes > 0){
        countGrapes--;
        person.setCash(person.getCash() + randomGrapes);
        updateBoxes();
        feedbackText.setText("SALE SUCCESSFUL");
    } else {
        feedbackText.setText("ERROR. CAN'T SELL MORE THAN YOU HAVE." );
    }
}
}
