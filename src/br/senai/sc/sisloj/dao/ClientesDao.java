
package br.senai.sc.sisloj.dao;

import br.senai.sc.sisloj.modelo.Clientes;
import static java.lang.reflect.Array.set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ClientesDao extends ConnectionFactory {
    
    private Connection con;
    
    public ClientesDao(){
        this.con = this.getConnection();
    }
    public void inserir(Clientes cli) throws SQLException{
        String sql = "insert into clientes (nomeC, enderecoC, bairroC, complementoC, cepC, celC)values(?, ?, ?, ?, ?, ?)";
        
        
        try(PreparedStatement st= this.con.prepareStatement(sql)){
            st.setString(1, cli.getNomeC());
            st.setString(2, cli.getEnderecoC());
            st.setString(3, cli.getBairroC());
            st.setString(4, cli.getComplementoC());
            st.setLong(5, cli.getCepC());
            st.setLong(6, cli.getCelC());
            
            st.execute();
            st.close();
        }
        this.con.close();
       
        
    }
        public void alterar(Clientes cli) throws SQLException{
        //String sql2 = "update into clientes (nomeC, enderecoC, bairroC, complementoC, cepC, celC)values(?, ?, ?, ?, ?, ?)";
        
        String sql = "update clientes set nomeC = ?, enderecoC = ?, bairroC = ?, complementoC = ?, cepC = ?, celC = ? where codigo = ?";
        try(PreparedStatement st= this.con.prepareStatement(sql)){
            st.setString(1, cli.getNomeC());
            st.setString(2, cli.getEnderecoC());
            st.setString(3, cli.getBairroC());
            st.setString(4, cli.getComplementoC());
            st.setLong(5, cli.getCepC());
            st.setLong(6, cli.getCelC());
            st.setInt(7, cli.getCodigo());
            
            st.execute();
            st.close();
        }
        
        this.con.close();
      
    }
        public void eliminar (int codigo)throws SQLException{
            String sql="delete from clientes where codigo = ?";
            
            try(PreparedStatement st = this.con.prepareStatement(sql)){
                st.setInt(1, codigo);
                st.execute();
                st.close();
            }
            this.con.close();
        }
 public List<Clientes> listarClientes() throws SQLException{
     String sql ="select * from clientes";
     
     try(PreparedStatement st= this.con.prepareStatement(sql)){
         ResultSet rs = st.executeQuery();
         
         List<Clientes> clientes = new ArrayList<Clientes>();
         
         while(rs.next()){
             Clientes c = new Clientes();
             c.setCodigo(rs.getInt("codigo"));
             c.setNomeC(rs.getString("nomeC"));
             c.setEnderecoC(rs.getString("enderecoC"));
             c.setBairroC(rs.getString("bairroC"));
             c.setComplementoC(rs.getString("complementoC"));
             c.setCepC(rs.getLong("cepC"));
             c.setCelC(rs.getLong("celC"));
             
             clientes.add(c);
         }
        rs.close();
        st.close();
        this.con.close();
        return clientes;
    }
 }
 public Clientes getCliente(int codcli) throws SQLException {
       String sql = "select * from clientes where codigo = ?";
       Clientes cliente = null;

       try (PreparedStatement st = this.con.prepareStatement(sql)) {
           st.setInt(1, codcli);
           try (ResultSet rs = st.executeQuery()) {
               if (rs.next()) {
                   cliente = new Clientes();
                   cliente.setCodigo(rs.getInt("codigo"));
                   cliente.setNomeC(rs.getString("nomeC"));
                   cliente.setEnderecoC(rs.getString("enderecoC"));
                   cliente.setBairroC(rs.getString("bairroC"));
                   cliente.setComplementoC(rs.getString("complementoC"));
                   cliente.setCepC(rs.getLong("cepC"));
                   cliente.setCelC(rs.getLong("celC"));
               }
           }
           st.close();
       }

       this.con.close();
       return cliente;
   }

}

