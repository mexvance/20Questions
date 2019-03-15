
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        String sql = "Insert into tree2(" + node.Id + "," + node.nId + ","  + node.yId +  "," + "\""+string + "\"" + ") VALUES(int,int,int,varchar);";
        try (
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, node.Id);
            pstmt.setInt(2, node.nId);
            pstmt.setInt(2, node.yId);
            pstmt.setString(2, node.qString);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
