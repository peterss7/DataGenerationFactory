package creation.user;

import java.util.Random;

public class IsAdminGenerator {

    public static int generateIsAdmin(){
        Random rand = new Random();
        return rand.nextInt(2);
    }

}
