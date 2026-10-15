import java.util.LinkedList;
import java.util.Scanner;

public class PetDaycareSystem {
    // Menggunakan Linked List untuk menyimpan daftar hewan
    private LinkedList<Pet> petList = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n=====================================");
            System.out.println("      PET DAYCARE SYSTEM (DYNAMIC)   ");
            System.out.println("=====================================");
            System.out.println("1. Daftarkan Hewan Baru (Check-In)");
            System.out.println("2. Lihat Data Seluruh Hewan");
            System.out.println("3. Cek Rincian Biaya  ");
            System.out.println("4. Checkout Hewan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Masukkan angka yang valid (1-5): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    registerPet();
                    break;
                case 2:
                    viewPets();
                    break;
                case 3:
                    checkCost();
                    break;
                case 4:
                    checkoutPet();
                    break;
                case 5:
                    System.out.println("\nTerima kasih telah menggunakan Pet Daycare System!");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 5);
    }

    private void registerPet() {
        System.out.println("\n--- REGISTRASI HEWAN BARU ---");
        System.out.print("Masukkan ID Hewan (contoh: P001): ");
        String id = scanner.nextLine();

        // Validasi ID agar tidak kembar menggunakan iterasi Linked List
        for (Pet p : petList) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.println("Error: ID hewan tersebut sudah terdaftar di sistem!");
                return;
            }
        }

        System.out.print("Nama Hewan: ");
        String name = scanner.nextLine();
        
        // Input bebas jenis hewan (bisa Anjing, Kucing, Kelinci, Burung, dll)
        System.out.print("Jenis Hewan (misal: Kucing, Kelinci, Burung): ");
        String species = scanner.nextLine();
        
        System.out.print("Nama Pemilik: ");
        String ownerName = scanner.nextLine();
        
        System.out.print("Umur Hewan (tahun): ");
        int age = scanner.nextInt();
        
        System.out.print("Lama Titip (hari): ");
        int stayDays = scanner.nextInt();
        
        System.out.print("Tarif Per Hari (Rp): ");
        double ratePerDay = scanner.nextDouble();
        scanner.nextLine(); // clear buffer

        // Membuat objek baru dan memasukkannya ke Linked List
        Pet newPet = new Pet(id, name, species, ownerName, age, stayDays, ratePerDay);
        petList.add(newPet);
        
        System.out.println("\nSukses! Hewan " + name + " (" + species + ") berhasil didaftarkan.");
    }

    private void viewPets() {
        System.out.println("\n--- DATA HEWAN DI DAYCARE ---");
        if (petList.isEmpty()) {
            System.out.println("Belum ada data hewan yang tersimpan di dalam Linked List.");
            return;
        }

        int index = 1;
        // Melakukan Traversal pada Linked List
        for (Pet p : petList) {
            System.out.println("\n[Data Hewan ke-" + index + "]");
            p.displayInfo();
            System.out.println("-----------------------------------");
            index++;
        }
    }

    private void checkCost() {
        System.out.println("\n--- CEK RINCIAN BIAYA ---");
        if (petList.isEmpty()) {
            System.out.println("Belum ada hewan di dalam sistem.");
            return;
        }

        System.out.print("Masukkan ID Hewan yang ingin dicek: ");
        String id = scanner.nextLine();

        Pet foundPet = findPetById(id);
        if (foundPet != null) {
            System.out.println("\n--- Rincian Tagihan Sementara ---");
            foundPet.displayInfo();
            System.out.println("===================================");
            System.out.println("Total Biaya (" + foundPet.getStayDays() + " hari) : Rp " + (int)foundPet.calculateCost());
        } else {
            System.out.println("Hewan dengan ID " + id + " tidak ditemukan.");
        }
    }

    private void checkoutPet() {
        System.out.println("\n--- CHECKOUT HEWAN ---");
        if (petList.isEmpty()) {
            System.out.println("Belum ada hewan di dalam sistem.");
            return;
        }

        System.out.print("Masukkan ID Hewan yang akan checkout: ");
        String id = scanner.nextLine();

        Pet foundPet = findPetById(id);
        if (foundPet != null) {
            System.out.println("\n--- Struk Pembayaran Akhir ---");
            foundPet.displayInfo();
            System.out.println("===================================");
            System.out.println("Total Bayar : Rp " + (int)foundPet.calculateCost());
            System.out.println("-----------------------------------");
            
            // Menghapus data dari Linked List
            petList.remove(foundPet);
            System.out.println("Checkout Berhasil! Data hewan telah dihapus dari sistem.");
        } else {
            System.out.println("Hewan dengan ID " + id + " tidak ditemukan.");
        }
    }

    // Helper method untuk mencari data di Linked List berdasarkan ID
    private Pet findPetById(String id) {
        for (Pet p : petList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}