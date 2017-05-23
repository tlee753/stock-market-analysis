import java.io.*;

public class Key {
    private String password;
    private InputStream is;

    public String getPassword() {
        try {
            is = new FileInputStream("password.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error, password file not found");
            e.printStackTrace();
        }

        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            password = buf.readLine();
        } catch (IOException e) {
            System.out.println("Error reading password input");
            e.printStackTrace();
        }

        return password;
    }
}
