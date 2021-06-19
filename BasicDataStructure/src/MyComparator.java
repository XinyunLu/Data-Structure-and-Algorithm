
import java.util.Comparator;

public class MyComparator implements Comparator<Main.Pair>{

    @Override
    public int compare(Main.Pair p1, Main.Pair p2) {
        if(p1.val1 > p2.val1) return -1;
        else if(p1.val1 < p2.val2) return 1;
        else {
            if(p1.val2 > p2.val2) return -1;
            else if(p1.val2 < p2.val2) return 1;
            else return 0;
        }
    }
}
