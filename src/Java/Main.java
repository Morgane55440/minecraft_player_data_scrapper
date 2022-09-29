package Java;

import Java.stats.UserStats;

import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        System.out.println(MCUser.nameFromID("c185ba11-25f8-4dac-80ef-2af15b94a4d1"));


        UserStats stat = new UserStats(Path.of("C:\\Users\\baize\\Downloads\\stats\\68104c55-e614-4638-9ada-c175853b7226.json").toFile());
        System.out.println(stat.getUser());
        System.out.println(stat.getVersion());
    }
}
