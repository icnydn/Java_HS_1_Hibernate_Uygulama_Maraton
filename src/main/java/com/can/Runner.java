package com.can;

import com.can.controller.KategoriController;
import com.can.controller.UrunController;

import java.util.Scanner;

public class Runner {
    private static KategoriController kategoriController;
    private static UrunController urunController;

    public static void main(String[] args) {
        kategoriController = new KategoriController();
        urunController = new UrunController();
        int secim;
        do {
            System.out.println("""
                    **********************************
                    *********** ANA SAYFA ************
                    **********************************
                    1- Kategori Ekle
                    2- Kategori Listele
                    3- Ürün Ekle
                    4- Ürün Ara
                    5- ÇIKIŞ                
                    """);
            System.out.print("Lütfen işlem seçiniz...: ");
            secim = new Scanner(System.in).nextInt();
            switch (secim) {
                case 1:
                    kategoriController.kategoriKaydet();
                    break;
                case 2:
                    kategoriController.kategoriListesi();
                    break;
                case 3:
                    urunController.urunKaydet();
                    break;
                case 4:
                    urunController.urunAra();
                    break;
                case 5:
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Hatalı seçim yaptınız. Lütfen listeden seçim yapınız.");
            }
        } while (secim != 5);
    }// main end
}//class end
