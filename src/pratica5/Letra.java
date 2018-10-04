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
class Letra {
    private String caractere, md5Code;

    Letra(String caractere) {
        this.caractere = caractere;
        this.md5Code = SecurityProvider.md5(caractere);
    }

    public String getCaractere() {
        return caractere;
    }

    public String getMd5Code() {
        return md5Code;
    }
    public void setCaractere(String c){
        this.caractere = c;
    }
}
