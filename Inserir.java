package inserir;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inserir {
static final String banco="jdbc:mysql://localhost:3306/concessionaria";
    public static void main(String[] args) {
        Connection conexao= null;
        Statement consulta = null;
        ResultSet resultados= null;
        PreparedStatement minhainclusao= null;
        try{
        conexao =DriverManager.getConnection(banco, "root", "");
        consulta=conexao.createStatement();
        resultados=consulta.executeQuery("Select fabricante from vecuilo");
        ResultSetMetaData colunas=resultados.getMetaData();
        int numeroColunas=colunas.getColumnCount();
        System.out.println("Info do banco de dados");
        minhainclusao=conexao.prepareStatement("select vecuilo(descricao,fabricante)");
        String fabricante = JOptionPane.showInputDialog(null, "procure pelo fabricante do veiculo");
        String descricao = null;
            System.out.println("Consulta: \n"+fabricante + descricao);
        }
        catch(SQLException erro){
        }
        finally{
        try{
        resultados.close();
        consulta.close();
        conexao.close();
        }
        catch (Exception erronovo){
        erronovo.printStackTrace();
        }}
    }
