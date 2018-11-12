
package model;

public class Cliente extends Pessoa{
    private float credito;
    
    public Cliente(){
        credito = 0;
    }

    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }

}
