import java.util.ArrayList;
import java.util.List;

public class Rubikal_Interview {
    static String solve(List<List<Integer>> board) {
    int row=board.size();
    int column=board.get(0).size();
    for (int i=0;i<row;i++)
    {
        for (int j=0;j<column;j++){
            int point=board.get(i).get(j);
            int right=(j+1<column)?board.get(i).get(j+1):-1;
            int down=(i+1<row)?board.get(i+1).get(j):-1;

            if ((point==1&&(right==1||down==1))||(point==0&&(right==0||down==0)))
            { return "NO";}
        }
    }
    return "YES";
}
 public static void main(String[] args) {
    List<Integer>l=new ArrayList<>();
    l.add(0);
    l.add(1);
     List<Integer>l1=new ArrayList<>();
     l1.add(1);
     l1.add(0);
     List<List<Integer>>ll=new ArrayList<>();
     ll.add(l);
     ll.add(l1);
     System.out.println(solve(ll));
}}