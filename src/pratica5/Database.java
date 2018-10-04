/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica5;

import java.util.ArrayList;

/**
 *
 * @author jaderson
 */
class Database {
    public static final ArrayList<Letra> caracteres;

    static {
        caracteres = new ArrayList<>();
        char a = 'a';

        for (int i = 0; i < 26; i++) {
            caracteres.add(new Letra(Character.toString((char) (a + i))));
        }
        a = 'A';
        for (int i = 0; i < 26; i++) {
            caracteres.add(new Letra(Character.toString((char) (a + i))));
        }
        a = '0';
        for (int i = 0; i < 10; i++) {
            caracteres.add(new Letra(Character.toString((char) (a + i))));
        }
        caracteres.add(new Letra(" "));
    }
    
    public static Letra getLetra(String md5){
        for(int i=0;i<caracteres.size();i++){
            if(caracteres.get(i).getMd5Code().equals(md5)){
                return caracteres.get(i);
            }
        }
        return null;
     }
        
    public static Conta getConta(String s[]){
        Conta c = null;
        String nome = "";
        String saldo= "";
        
        for (String item : s) {
            
            String a = getLetra(item).getCaractere();
            if(a.charAt(0)>='0'&&a.charAt(0)<='9'){
                saldo += a;
            }else{
                nome += a;
            }
            
        }
        c = new Conta(nome,saldo);
        return c;        
    }
    
    public static void test6()
    {
        Letra l = new Letra("a");
        String md5 = l.getMd5Code();
        System.out.println(md5);
        Letra ll = Database.getLetra(md5);
        System.out.println(ll.getCaractere());
    }
    
    public static void test5()
    {
        Conta c = new Conta("124", "333", "1234","10", "john doe");
        ServerDatabase.insereConta(c);
        String chave = SecurityProvider.md5ToServer(c);
        Conta conta = ServerDatabase.getConta(chave);
        String chars[];
        chars = SecurityProvider.md5ToClient(conta);
        System.out.println(Database.getConta(chars));
    }
    
    public static void main(String[] args) {
        //test5();
        test6();
    }
}
