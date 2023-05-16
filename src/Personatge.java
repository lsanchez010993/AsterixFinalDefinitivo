abstract class Personatge extends Element implements Moviment{
    int energia;
    int velocitat;

    public Personatge(char nom, Coordenades coord, int velocitat) {
        super(nom, coord);
        this.velocitat=velocitat;
    }
    public void mouD(){

    }
    public void mouL(){

    }
    public void mouR(){

    }
    public void mouU(){

    }
    public void setVelocitat(int velocitat){

    }

}
