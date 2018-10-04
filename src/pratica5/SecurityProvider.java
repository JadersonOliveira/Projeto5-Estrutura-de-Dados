/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica5;
import java.security.*;
import java.math.BigInteger;
import java.util.logging.*;
/**
 *
 * @author jaderson
 */
class SecurityProvider {

    public static String salt = "5a1t";

    public static String md5(String stringToConvert) {
        String hashtext = "";
        stringToConvert += salt;
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(stringToConvert.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            hashtext = bigInt.toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecurityProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashtext;
    }

    public static String md5ToServer(Conta conta) {
        String cat = conta.agencia + conta.numero + conta.senha + SecurityProvider.salt;
        return md5(cat);
    }

    public static String[] md5ToClient(Conta conta) {
        String toCrypt = conta.getNomeCliente() + " " + conta.getSaldo();
        char c;
        String[] lista = new String[toCrypt.length()];
        for (int i = 0; i < toCrypt.length(); i++) {
            c = toCrypt.charAt(i);
            lista[i] = SecurityProvider.md5(String.valueOf(c));
        }
        return lista;
    }
    
     public static void test1()
    {
        System.out.println(SecurityProvider.md5("teste"));
    }
     
    public static void test2()
    {
        Conta c = new Conta("1234", "2222","1245");
        System.out.println(SecurityProvider.md5ToServer(c));
    }
    
    public static void test4()
    {
        Conta c = new Conta("124", "333", "1234","10", "john doe");
        ServerDatabase.insereConta(c);
        String chave = SecurityProvider.md5ToServer(c);
        Conta conta = ServerDatabase.getConta(chave);
        String chars[];
        chars = SecurityProvider.md5ToClient(conta);
        for(int i=0;i<chars.length;i++)
        {
            System.out.println(chars[i]);
        }
    }
    
    public static void main(String[] args) {
        test1();
        test2();
        test4();
    }
    
}
