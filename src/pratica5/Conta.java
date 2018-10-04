/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica5;

/**
 *
 * @author jaderson
 */
public class Conta {
    
    public String nomeCliente, agencia, numero;
    public String saldo, senha, md5;
       
    Conta(String agencia, String numero, String senha) {
        this.agencia = agencia;
        this.numero = numero;
        this.senha = senha;
        this.nomeCliente = null;
        this.saldo = null;
        this.md5 = SecurityProvider.md5ToServer(this);;
    }
    
    Conta(String agencia, String numero, String senha, String saldo, String nomeCliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.senha = senha;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
        this.md5 = null;
    }

    Conta(String nomeCliente, String saldo) {
        this.agencia = null;
        this.numero = null;
        this.senha = null;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
        this.md5 = SecurityProvider.md5ToServer(this);;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public String getSaldo() {
        return saldo;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public String getMD5(){
        return md5;
    }

    public void setNomeCliente(String nomeNovo) {
        this.nomeCliente = nomeNovo;
    }

    public void setAgencia(String numAgencia) {
        this.agencia = numAgencia;
    }

    public void setNumero(String num) {
        this.numero = num;
    }

    public void setSaldo(String saldoNvo) {
        this.saldo = saldoNvo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setMD5(String md5) {
        this.md5 = md5;
    }

    public String toString(){
        String conta = "AGENCIA: "+ getAgencia() + "\nCONTA: " + getNumero();
        conta+= "\nSENHA: " + getSenha() + "\nNOME CLIENTE: "+ getNomeCliente();
        conta+="\nSALDO: "+ getSaldo() + "\nMD5: " + getMD5() + "\n";
        return conta;
    }
    
    public static void test()
    {
        Conta c1 = new Conta("124", "333", "1234","10", "john doe");
        System.out.println(c1);
        Conta c2 = new Conta("John Doe", "10");
        System.out.println(c2);
        Conta c3 = new Conta("123", "321","666");
        System.out.println(c3);
    }
    
    public static void main(String[] args) {
        test();
    }
    
    
}
