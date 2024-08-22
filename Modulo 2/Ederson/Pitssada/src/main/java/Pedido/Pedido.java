/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pedido;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Pedido {
    private String nome_Cliente, endereco, bairro, numero, hora, sabor, tamanho, bebidas;
    
    
    public Pedido(String nome_Cliente, String endereco, String bairro, int nCasa, JLabel hora1, String numero, String hora, String sabor) {
        this.nome_Cliente = nome_Cliente;
        this.endereco = endereco;
        this.bairro = bairro;
        this.numero = numero;
        this.hora = hora;
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.bebidas = bebidas;
    }
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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
    
    public void Inserir() {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO pedido (id_pedido, nome_cliente, endereco, bairro, numero, hora, sabor, tamanho, bedidas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setString(1, this.getNome_Cliente());
            stmt.setString(2, this.getEndereco());
            stmt.setString(3, this.getBairro());
            stmt.setString(4, this.getSabor());
            stmt.setString(5, this.getTamanho());
            
            stmt.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}