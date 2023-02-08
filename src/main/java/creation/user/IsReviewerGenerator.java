package creation.user;

import java.util.Random;

public class IsReviewerGenerator {
    public static int generateIsReviewer(){
        Random rand = new Random();
        return rand.nextInt(2);
    }
}
