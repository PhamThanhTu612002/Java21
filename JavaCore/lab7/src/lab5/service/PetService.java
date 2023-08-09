package lab5.service;

import lab5.constant.TYPE;
import lab5.entities.Pet;
import lab5.handle.HandlePet;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PetService {
    HandlePet handlePet = new HandlePet();
    public Pet match(Scanner sc){
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập giống loài: ");
        String species = sc.nextLine();
        int age = handlePet.handleAge(sc);
        System.out.println("Nhập giới tính: ");
        String sex = sc.nextLine();
        System.out.println("Nhập mô tả: ");
        String description = sc.nextLine();
        System.out.println("Nhập type: ");
        TYPE type1 = handlePet.handleType(sc);
        System.out.println("Nhập images: ");
        String images = sc.nextLine();
        return new Pet(name,species,age,sex,description,type1,images);
    }
    public ArrayList<Pet> getSamePet(ArrayList<Pet> pets, Pet pet){
        ArrayList<Pet> pets1 = new ArrayList<>();
        for (Pet pet1 : pets){
            if (pet1.getType().equals(pet.getType()) && !pet1.getSex().equals(pet.getSex())){
                pets1.add(pet1);
            }
        }
        return pets1;
    }
    public void choosePet(Scanner scanner,ArrayList<Pet> pets){
        boolean isFalse = false;
        Random random = new Random();
        int randomIndex = random.nextInt(pets.size());
        System.out.println(pets.get(randomIndex));
        do {
            System.out.println("Bạn có muốn tìm pet khác ko(Y/N) ?");
            String choice = scanner.nextLine();
            switch (choice){
                case "Y":
                    int newIndex;
                    do {
                        newIndex = random.nextInt(pets.size());
                    }while (newIndex == randomIndex);
                    System.out.println(pets.get(newIndex));
                    break;
                case "N":
                    isFalse = true;
                    break;
            }
        }while (!isFalse);
    }
}
