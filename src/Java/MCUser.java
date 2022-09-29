package Java;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class MCUser {


    String UUID;

    String Username;

    public MCUser(String UUID) {
        this.UUID = UUID;
        this.Username = nameFromID(UUID);
    }


    @Override
    public String toString() {
        return "User " + Username + " (id:" + UUID + ')';
    }

    public static String nameFromID(String UUID) {
        try {
            Scanner scan = new Scanner((new URL("https://mcuuid.net//?q=" + UUID)).openStream());
            String name = scan.findAll("<input id=\"results_username\"[^>]*value=\"([^\"]*)\"[^>]*>").map(x -> x.group(1)).findFirst().orElse("");
            return (name.equals("")) ? "Not a User" : name;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "User Not found";
    }
}
