import javafx.scene.control.*;
/**
 * Die Klasse Erzeuger
 */
public class Erzeuger implements Runnable
{
    // Attribute
    private Puffer puffer;
    private TextArea ausgabe;

    // Konstruktor
    public Erzeuger(Puffer puffer_)
    {
        puffer = puffer_;

    }

    // Methoden    
    
    public void run()
    {
        for(int i = 0; i < 10; i ++)
        {
            String name = Thread.currentThread().getName();
            ausgabe.appendText("Stelle ein Element her. \n");
            for (int j = 3; j > 0; j--)
            {
                ausgabe.appendText("... noch " + j + " Sekunden..\n");
                try{
                    Thread.sleep(1000);
                }catch(Exception ex)
                {};
            }
            ausgabe.appendText("Füge das Element in den Puffer ein.\n");
            ausgabe.appendText("================\n");

            puffer.einfuegen(new Element());
            try{
                Thread.sleep(1000);
            }catch(Exception ex)
            {};
        }
    }
    
     public void setAusgabe(TextArea ausgabe_)
    {
        ausgabe = ausgabe_;
    }

}

