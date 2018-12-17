import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.effect.*;
import javafx.scene.Group;

import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;

public class View extends GridPane
{

    // private TextField eingabe;

    private TextArea erzeugerAusgabe;
    private TextArea verbraucherAusgabe;
    private Controller controller;
    private Text pufferAusgabe;

    public View(Controller contr)
    {
        controller = contr;
        guiErstellen();
    }

    public void guiErstellen()
    {   
        Text titel = new Text("Erzeuger - Verbraucher!");

        Text erzeugerTitel = new Text("Erzeuger");
        Text verbraucherTitel = new Text("Verbraucher");
        Text pufferTitel = new Text("Puffer");

        erzeugerAusgabe = new TextArea();
        erzeugerAusgabe.setEditable(false);

        verbraucherAusgabe = new TextArea();
        verbraucherAusgabe.setEditable(false);

        pufferAusgabe = new Text("0");

        Button btnVerbraucherStarten = new Button("Verbraucher starten");
        Button btnErzeugerStarten = new Button("Erzeuger starten");
        Button btnVerbraucherStoppen = new Button("Verbraucher stoppen");
        Button btnErzeugerStoppen = new Button("Erzeuger stoppen");

        // Das Grid bestücken: 
        add(titel,0,0);

        add(erzeugerTitel,0,1);
        add(pufferTitel,1,1);
        add(verbraucherTitel,2,1);

        add(erzeugerAusgabe,0,2);
        add(pufferAusgabe,1,2);
        add(verbraucherAusgabe,2,2);
        add(btnErzeugerStarten,0,3);
        add(btnVerbraucherStarten,2,3);

        add(btnErzeugerStoppen,0,4);
        add(btnVerbraucherStoppen,2,4);

        // Aussehen
        titel.setFont(new Font(30));
        titel.setFill(Color.WHITE);

        pufferAusgabe.setFont(new Font(50));

        setPadding(new Insets(20));
        setVgap(10);
        setHgap(30);
        setBackground(new Background(new BackgroundFill(Color.SKYBLUE, null, null)));

        erzeugerAusgabe.setMaxWidth(400);
        erzeugerAusgabe.setMinWidth(400);
        verbraucherAusgabe.setMaxWidth(400);
        verbraucherAusgabe.setMinWidth(400);

        btnVerbraucherStarten.setOnAction(e -> controller.verbraucherStarten());
        btnErzeugerStarten.setOnAction(e -> controller.erzeugerStarten());
        btnVerbraucherStoppen.setOnAction(e -> controller.verbraucherStoppen());
        btnErzeugerStoppen.setOnAction(e -> controller.erzeugerStoppen());
    }

    public void nachrichtAusgeben(String nachricht)
    {
        //   ausgabe.appendText(nachricht + "\n");
    }

    public TextArea getVerbraucherAusgabe()
    {
        return verbraucherAusgabe;
    }

    public TextArea getErzeugerAusgabe()
    {
        return erzeugerAusgabe;
    }

    public Text getPufferAusgabe()
    {
        return pufferAusgabe;
    }
}
