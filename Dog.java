/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FOX;

/**
 *
 * @author FELIPE.HERRERA
 */
public class Dog {
    
    private int idDog;
    private String nombre;
    private String breed;

    public Dog() {
    }

    public Dog(int idDog, String nombre, String breed) {
        this.idDog = idDog;
        this.nombre = nombre;
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getIdDog() {
        return idDog;
    }

    public void setIdDog(int idDog) {
        this.idDog = idDog;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "idDog=" + idDog + ", nombre=" + nombre + ", raza=" + breed;
    }
    
    
}
