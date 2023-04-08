package s6copy;

import java.util.HashSet;
import java.util.Scanner;
import s6copy.Laptop;


public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashSet<Laptop> startSet = new HashSet<>();
        
        Laptop l1 = new Laptop();
        l1.id = 1;
        l1.issuer = "MSI";
        l1.screenType = "IPS";
        l1.screenSize = 17;
        l1.ram = 16;
        l1.ssdSize = 512;
        l1.CPU = "Intel Core i5-12450H";
        l1.videoCard = "GeForce RTX 3050";
        l1.os = null;
        l1.color = "black";
        startSet.add(l1);

        Laptop l2 = new Laptop();
        l2.id = 2;
        l2.issuer = "ASUS";
        l2.screenType = "IPS";
        l2.screenSize = 15;
        l2.ram = 8;
        l2.ssdSize = 512;
        l2.CPU = "AMD Ryzen 5 5600H";
        l2.videoCard = "GeForce GTX 1650";
        l2.os = null;
        l2.color = "blue";
        startSet.add(l2);

        Laptop l3 = new Laptop();
        l3.id = 3;
        l3.issuer = "Apple";
        l3.screenType = "IPS";
        l3.screenSize = 13;
        l3.ram = 8;
        l3.ssdSize = 256;
        l3.CPU = "Apple M1";
        l3.videoCard = "Apple M1 7-core";
        l3.os = "macOS";
        l3.color = "grey";
        startSet.add(l3);

        for (Laptop comp: startSet)
            System.out.println(comp);

        System.out.println("\nWhat do you wish to do?\n0: Filter the search\n1: Add a laptop\n2:Delete a laptop");
        int k = scan.nextInt();
        if (k == 0)
            Laptop.filtrationChoice(startSet, scan);
        if (k == 1)
            Laptop.addLaptop(scan);
        if (k == 2)
            Laptop.deleteLaptop(startSet, scan);
        
        scan.close();
    }

    
}
