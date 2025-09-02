package excluir;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.ResultSetMetaData; 
import java.sql.SQLException; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import javax.swing.JOptionPane;
 
/**
*
* @author Aluno
*/
public class Excluir {
 
   static final String banco = "jdbc:mysql://localhost:3306/agenciaViagem";
 
    public static void main(String[] args) {
 
        Connection conexao = null;
        PreparedStatement minhaexclusao = null;
        ResultSet resultados = null;
 
        try {
            // Estabelecendo a conexão
            conexao = DriverManager.getConnection(banco, "root", "");
 
            // Solicitando ao usuário o nome do fabricante
            String turista = JOptionPane.showInputDialog(null, "Pesquise pelo codigo do turista");
 
            // Preparando a consulta SQL com parâmetro
            String sql = "DELETE  FROM turista WHERE codigo = ?";
            minhaexclusao = conexao.prepareStatement(sql);
            minhaexclusao.setString(1, turista);
 
           int linhasAfetadas = minhaexclusao.executeUpdate();
 
            if (linhasAfetadas > 0) {
                System.out.println("Turista com código " + turista + " foi excluído com sucesso.");
}           else {
                 System.out.println("Nenhum turista encontrado com o código: " + turista);
}
 
 
        } catch (SQLException erro) {
            erro.printStackTrace();
 
        } finally {
            // Fechando recursos
            try {
                if (resultados != null) resultados.close();
                if (minhaexclusao != null) minhaexclusao.close();
                if (conexao != null) conexao.close();
            } catch (Exception erronovo) {
                erronovo.printStackTrace();
            }
        }
    }
}
