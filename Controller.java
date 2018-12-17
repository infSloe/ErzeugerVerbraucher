/**
 * Die Klasse Controller
 */
public class Controller
{
    // Attribute
    private View view;
    private Puffer puffer;
    private Erzeuger erz; 
    private Thread erzeuger; 
    private Verbraucher verb;
    private Thread verbraucher;

    // Konstruktor
    public Controller()
    {
        view = new View(this);
        init();
    }
    // Methoden
    public void init(){
        puffer = new Puffer();
        puffer.setAusgabe(view.getPufferAusgabe());

        erz = new Erzeuger(puffer);
        erz.setAusgabe(view.getErzeugerAusgabe());

        verb = new Verbraucher(puffer);
        verb.setAusgabe(view.getVerbraucherAusgabe());

    }

    public void erzeugerStarten()
    {
        erzeuger = new Thread(erz);
        erzeuger.setName("Erzeuger");
        erzeuger.start();
    }

    public void verbraucherStarten()
    {
        verbraucher = new Thread(verb);
        verbraucher.setName("Verbraucher");

        verbraucher.start();
    }

    public void erzeugerStoppen()
    {
        erzeuger.stop();
    }

    public void verbraucherStoppen()
    {
        verbraucher.stop();
    }

    public View getView()
    {
        return view;
    }

}
