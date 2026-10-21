public class Courier {
    private String name;
    private String transport;

    public Courier(String name, String transport) {
        this.name = name;
        this.transport = transport;
    }

    public String getCourierName() {return this.name;}
    public String getCourierTransport() {return this.transport;}
}