package model;

import java.util.Calendar;

public class Pessoa {

    private String nome;
    private String email;
    private String pws;
    private Calendar dataNasc;

    public Pessoa() {
        dataNasc = null;
    }

    public String validar(String confPws) {
        String erros = "";

        if (nome.equals("")) {
            erros += "Nome em branco.\n";
        }

        if (email.equals("")) {
            erros += "E-mail em branco.\n";
        } else if (!email.contains("@") && email.indexOf(".") == -1) {
            erros += "E-mail invalido.\n";
        }
        if (dataNasc == null){
            erros += "Data de nascimento em branco. .\n";
        }

        if (pws.equals("")) {
            erros += "Senha em branco.\n";
        } else if (pws.length() < 5) {
            erros += "Senha muito curta. Minimo de 6 caracteres.\n";
        } else if (!pws.equals(confPws)) {
            erros += "Senhas diferentes.\n";
        }

        return erros;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPws() {
        return pws;
    }

    public void setPws(String pws) {
        this.pws = pws;
    }

    public Calendar getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Calendar dataNasc) {
        this.dataNasc = dataNasc;
    }
    
    
}
