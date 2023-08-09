package lab5.data;

import lab5.entities.Pet;
import lab5.constant.TYPE;

import java.util.ArrayList;

public class DataPet {
    public ArrayList<Pet> createListPet(ArrayList<Pet> pets){
        Pet pet = new Pet("Miu","England",2,"Male","Hihi", TYPE.CAT,"images.png");
        Pet pet2 = new Pet("Cún","Việt Nam",2,"Female","Hihi",TYPE.DOG,"images.png");
        Pet pet3 = new Pet("Meo","USA",2,"Male","Hihi",TYPE.CAT,"images.png");
        Pet pet4 = new Pet("Dog","Việt Nam",2,"Male","Hihi",TYPE.DOG,"images.png");
        Pet pet5 = new Pet("Miu","England",2,"Male","Hihi",TYPE.CAT,"images.png");

        pets.add(pet);
        pets.add(pet2);
        pets.add(pet3);
        pets.add(pet4);
        pets.add(pet5);
        return pets;
    }
}
