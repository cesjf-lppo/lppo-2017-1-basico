package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaRegistros2Servlet", urlPatterns = 
        {"/lista2.html"})
public class ListaRegistros2Servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/lppo-2017-1";
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            out.println("Conexão aberta com sucesso!");
            String sql = "SELECT nome, 200-qtd FROM produto WHERE qtd<200";
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery(sql);
            out.println("Consulta realizada!");
            out.println("Nome\t\tA comprar");
            while(resultado.next()){
                out.print(resultado.getString(1));
                out.print("\t");
                out.println(resultado.getInt(2));
            }
            
        } catch (ClassNotFoundException ex) {
            out.println("Driver indisponível!");
            Logger.getLogger(ListaRegistros2Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            out.println("Prouablema ao acessar o  banco!");
            Logger.getLogger(ListaRegistros2Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
 