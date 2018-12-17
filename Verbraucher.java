import javafx.scene.control.*;
/**
 * Die Klasse Verbraucher
 */
public class Verbraucher implements Runnable
{
    // Attribute
    private Puffer puffer;
    private TextArea ausgabe;

    // Konstruktor
    public Verbraucher(Puffer puffer_)
    {
        puffer = puffer_;

    }

    // Methoden
    public void setAusgabe(TextArea ausgabe_)
    {
        ausgabe = ausgabe_;
    }

    public void run()
    {
        for(int i = 0; i < 10; i ++)
        {
            String name = Thread.currentThread().getName();
            ausgabe.appendText("Ich möchte mir ein Element nehmen! \n");
            Element elem = puffer.entnehmen();
            if (elem != null) // habe ein Element bekommen!
            {
                ausgabe.appendText("Ich habe eins bekommen\n und lege es in das Regal!\n");
                int dauer = (int) (6 * Math.random())+1;  //Es dauert zwischen 1 und 10 Sekunden
                for (int j = dauer; j > 0; j--)
                {
                    ausgabe.appendText(" .. noch " + j + " Sekunden\n");
                    try{
                        Thread.sleep(1000);
                    }catch(Exception ex)
                    {};
                }
                ausgabe.appendText("Das Element ist einsortiert!\n");
                ausgabe.appendText("====================\n");
            }

            try{
                Thread.sleep(1000);
            }catch(Exception ex)
            {};
        }
    }
}

