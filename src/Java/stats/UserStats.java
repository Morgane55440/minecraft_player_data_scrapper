package Java.stats;




import Java.MCUser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserStats {

    MCUser user;
    String raw;
    Integer version;

    public UserStats(File input) {
            user = new MCUser(Arrays.stream(input.getName().split("\\.")).findFirst().orElse(""));
            try {
                raw = new BufferedReader(new FileReader(input)).lines().reduce((a,b) -> a + " " + b).orElse("");
            } catch (FileNotFoundException e) {
                raw = "";
                e.printStackTrace();
            }
            if (!raw.equals("")){
                Matcher m = Pattern.compile("^.*\"DataVersion\":([0-9]+)[ \t\n]*}[ \t\n]*$").matcher(raw);
                m.find();
                version = Integer.valueOf(m.group(1));
            }
    }

    public MCUser getUser() {
        return user;
    }

    public String getRaw() {
        return raw;
    }

    public Integer getVersion() {
        return version;
    }
}
