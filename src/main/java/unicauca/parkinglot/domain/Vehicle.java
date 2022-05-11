package unicauca.parkinglot.domain;

/**
 *
 * @author Milthon F Caicedo 
 */
public class Vehicle {
    
   /*
    Atributos 
    */
    private String placa; 
    private TypeEnum type;
    
    public Vehicle(){
        
    }
    public Vehicle(String placa, TypeEnum type){
        this.placa = placa; 
        this.type = type; 
    }
    
    /*
    Getters and setters 
    */
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }
    
}
