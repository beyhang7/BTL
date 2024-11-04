package ATM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDatabase {

    public static void CreateNewAcc(User user, Database database){
        String insert = "INSERT INTO `users`(`ID`, `Ho`, `Ten`, `ns`, "
            + "`Email`, `Std`, `PINcode`, `Balance`) VALUES"
            + "('"+user.getID()+"','"+user.getHo()+"','"+user.getTen()+"', "
            + "'"+user.getns()+"','"+user.getEmail()+"','"+user.getSdt()+"', "
            + "'"+user.getPINcode()+"','0');";
        
        try {
            database.getStatement().execute(insert);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static ArrayList<User> getAllUsers(Database database){
        ArrayList<User> users = new ArrayList<>();
        String select = "SELECT * FROM `users` ;";
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            while(rs.next()){
                User user = new User();
                user.setID(rs.getInt("ID"));
                user.setHo(rs.getString("ho"));
                user.setTen(rs.getString("ten"));
                user.setns(rs.getString("ns"));
                user.setEmail(rs.getString("email"));
                user.setSdt(rs.getString("sdt"));
                user.setPINcode(rs.getInt("PINcode"));
                user.setBalance(rs.getDouble("balance"));
                users.add(user);

            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return users;
    }

    public static int getNextID(Database database){
        int ID = 1000000;
        ArrayList<User> users = getAllUsers(database);
        int size = users.size();
        if(size!=0){
            User user = users.get(size-1);
            ID = user.getID() + 1;

        }
        return ID;
    }

    public static boolean login(int id, int pin, Database database){
        boolean login = false;
        String select = "SELECT `ID`, `PINcode` FROM `users` WHERE `ID` = ;";
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            rs.next();
            int ID = rs.getInt("ID");
            int PIN = rs.getInt("PINcode");
            if(id==ID && pin==PIN) login = true;
        } catch (SQLException e) {}

        return login;
    }
}

