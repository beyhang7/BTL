package ATM;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    private int ID;
    private String ho;
    private String ten;
    private LocalDate ns;
    private String email;
    private String sdt;
    private int PINcode;
    private double balance;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public User(){

    }

    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
       this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getns() {
        return formatter.format(ns);
    }

    public void setns(String ns) {
        this.ns = LocalDate.parse(ns, formatter);
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getSdt(){
        return sdt;
    }

    public void setSdt(String sdt){
        this.sdt =sdt;
    }

    public int getPINcode(){
        return PINcode;
    }
    public void setPINcode(int PINcode){
        this.PINcode = PINcode;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
}
