package Pedido;

import InicioInt.homee;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Pedido {
    private String nome_Cliente, endereco, bairro, hora, sabor, tamanho, bebidas;
    private int numero;
    
    
    public Pedido(String nome_Cliente, String endereco, String bairro, int nCasa, JLabel hora1, int numero, String hora, String sabor) {
        this.nome_Cliente = nome_Cliente;
        this.endereco = endereco;
        this.bairro = bairro;
        this.numero = numero;
        this.hora = hora;
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.bebidas = bebidas;
    }
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getBebidas() {
        return bebidas;
    }

    public void setBebidas(String bebidas) {
        this.bebidas = bebidas;
    }

    public String getNome_Cliente() {
        return nome_Cliente;
    }

    public void setNome_Cliente(String nome_Cliente) {
        this.nome_Cliente = nome_Cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    

    public Pedido() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void mostrar() {
        System.out.println(""
                + "Nome: " + this.nome_Cliente + "\n"
                + "Endereço: " + this.endereco + "\n"
                + "Bairro: " + this.bairro + "\n"
                + "Sabor: " + this.sabor + "\n"
                + "Tamanho: " + this.tamanho + "\n"
        );
    }
    
    /*public void inserirPedido() {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO `pedido`(`sabor`, `tamanho`, `bebida`, `nomeCliente`, `rua`, `bairro`, `numero`, `hora`, `precoFinal`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, this.getSabor());
            stmt.setString(2, this.getTamanho());
            stmt.setString(3, this.getBebidas());
            stmt.setString(4, this.getNome_Cliente());
            stmt.setString(5, this.getEndereco());
            stmt.setString(6, this.getBairro());
            stmt.setInt(7, this.getNumero());
            stmt.setString(8, this.getHora());
            
            stmt.executeQuery();
            
            homee h = new homee();
            h.listaPedidos();
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/
}