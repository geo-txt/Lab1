public class Courier {
    private String name;
    private String transport;
    private boolean availability;

    public Courier(String name, String transport) {
        this.name = name;
        this.transport = transport;
        this.availability = true;
    }

    public String getCourierName() {return this.name;}
    public String getCourierTransport() {return this.transport;}
    public boolean isAvailable() {return availability;}
    public void busy() {availability = false;}
    public void available() {availability = true;}
}