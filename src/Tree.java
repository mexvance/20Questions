
import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;

public class Tree implements Iterator {

    int nodeNum = 0;


    public Tree (Connection conn){
        Question head = new Question("Is It an Animal?", nodeNum);
        head.yId = updateTree("Is it a dog?", nodeNum, conn);
        head.nId = updateTree("Is it a rock?", nodeNum, conn);
    }
    public int updateTree(String string, int parentId, Connection conn){
       // Statement statement = conn.createStatement();

        Question node = new Question(string, ++nodeNum);
        //save stuff to database here

        return nodeNum;
    }

    //getAnswer

    //

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
