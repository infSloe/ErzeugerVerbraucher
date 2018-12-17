import java.util.*;
import javafx.scene.text.*;
/**
 * Die Klasse Puffer
 */
public class Puffer
{
    // Attribute
    private ArrayList<Element> liste;
    private Text ausgabe;

    // Konstruktor
    public Puffer()
    {
        liste = new ArrayList<Element>();

    }

    // Methoden
    public synchronized void einfuegen(Element elem)
    {
        liste.add(elem);
        ausgabe.setText("" + liste.size());
    }

    public synchronized Element entnehmen()
    {
        int anzahl = liste.size();
        if (anzahl>0)
        {
            Element elem = liste.remove(anzahl-1);
            ausgabe.setText("" + liste.size());
            return elem;

        }
        return null;
    }

    public int getAnzahl()
    {
        return liste.size();
    }

    public void setAusgabe(Text ausgabe_)
    {
        ausgabe = ausgabe_;
    }
}
