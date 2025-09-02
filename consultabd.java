package consulta;

import javax.swing.JOptionPane;
import java.sql.*;

public class Consulta {
    static final String banco = "jdbc:mysql://localhost:3306/concessionaria";

    public static void main(String[] args) {
        Connection conexao = null;
        PreparedStatement minhaconsulta = null;
        ResultSet resultados = null;

        try {
            conexao = DriverManager.getConnection(banco, "root", "");
            String fabricante = JOptionPane.showInputDialog(null, "Pesquise pelo fabricante do veículo");

            minhaconsulta = conexao.prepareStatement("SELECT * FROM veiculo WHERE fabricante = ?");
            minhaconsulta.setString(1, fabricante);
            resultados = minhaconsulta.executeQuery();
            ResultSetMetaData colunas = resultados.getMetaData();
            int numeroColunas = colunas.getColumnCount();

            System.out.println("Informações dos veículos do fabricante: " + fabricante);
            for (int i = 1; i <= numeroColunas; i++) {
                System.out.print(colunas.getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultados.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
                    System.out.print(resultados.getObject(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException erro) {
            erro.printStackTrace();
        } finally {
            try {
                if (resultados != null) resultados.close();
                if (minhaconsulta != null) minhaconsulta.close();
                if (conexao != null) conexao.close();
            } catch (Exception erronovo) {
                erronovo.printStackTrace();
            }
        }
    }
}

