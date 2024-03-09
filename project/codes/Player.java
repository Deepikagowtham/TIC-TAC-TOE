package player;

public class Player {
    private String name;
    private char symbol;
    private String address;
    private long contactNum;
    private String emailId;
    private int age;

    public void setPlayerDetails(String name, char symbol, String address, long contactNum, String emailId, int age) {
        this.name = name;
        this.symbol = symbol;
        this.address = address;
        this.contactNum = contactNum;
        this.emailId = emailId;
        this.age = age;
    }
    public String getPlayerName() {
        return name;
    }

    public char getPlayerSymbol() {
        return symbol;
    }
    public void getPlayerDetails() {
        System.out.println("Player : "+name);
        System.out.println(name+" chosen "+symbol);
        System.out.println(name+" address is "+address);
        System.out.println(name+" contantnum "+contactNum);
        System.out.println(name+" emailid "+emailId);
        System.out.println(name+"'s age is "+age);

    }


}
