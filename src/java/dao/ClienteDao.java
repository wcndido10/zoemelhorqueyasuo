package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;

public class ClienteDao extends Conecta{
    PreparedStatement stman = null;
    public void cadastrar(Cliente cliente) throws SQLException{
        getConnection();
        String sql = "" 
                   + "insert into "
                   + "pessoa(nome, email, pws, dataNasc)"
                   + "values (?, ?, ?, ?)";
        
        stman = connection.prepareStatement(sql);
        stman.setString(1, cliente.getNome());
        stman.setString(2, cliente.getEmail());
        stman.setString(3, cliente.getPws());
        stman.setDate(4,new Date(cliente.getDataNasc().getTimeInMillis()));
        
        stman.execute();
        stman.close();
        close();
    }
}
