package lab5;

import lab5.data.DataPet;
import lab5.entities.Pet;
import lab5.service.PetService;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetService petService = new PetService();
        ArrayList<Pet> pets = new ArrayList<>();
        DataPet dataPet = new DataPet();
        dataPet.createListPet(pets);
        Pet pet = petService.match(scanner);
        ArrayList<Pet> pets1 = petService.getSamePet(pets,pet);
        System.out.println(pets1);
        petService.choosePet(scanner,pets1);
    }
}
