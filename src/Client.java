public class Client {
    private String address;
    private String name;
    private String phoneNumber;

    public Client(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getClientName() {return this.name;}
    public String getClientAddress() {return this.address;}
    public String getClientPhoneNumber() {return this.phoneNumber;}
}