package com.can.controller;

import com.can.entity.Urun;
import com.can.service.UrunService;

import java.util.Scanner;

public class UrunController {
    private final UrunService urunService;

    public UrunController() {
        urunService = new UrunService();
    }

    public void urunKaydet() {
        System.out.println("""
                ********************************
                ********* ÜRÜN EKLEME **********
                ********************************
                """);
        System.out.print("Ürün Adı...........: ");
        String urunAdi = new Scanner(System.in).nextLine();
        System.out.print("Ürün Açıklaması....: ");
        String aciklama = new Scanner(System.in).nextLine();
        System.out.print("Ürün Kategorisi....: ");
        Long kategoriId = new Scanner(System.in).nextLong();
        System.out.print("Ürün Fiyatı........: ");
        Double fiyat = new Scanner(System.in).nextDouble();
        System.out.print("Ürün Stoğu.........: ");
        Integer stok = new Scanner(System.in).nextInt();
        urunService.save(Urun.builder()
                .urunAdi(urunAdi)
                .kategoriId(kategoriId)
                .aciklama(aciklama)
                .fiyat(fiyat)
                .stok(stok)
                .build());
    }

    public void urunAra() {
        System.out.println("""
                ****************************
                ******** ÜRÜN ARAMA ********
                ****************************
                """);
        System.out.print("Aramak istediğiniz ürün adını giriniz...: ");
        String arananUrun = new Scanner(System.in).nextLine();
        urunService.findAllByGivenValue(arananUrun)
                .stream().limit(10)
                .forEach(System.out::println);

    }

    public void urunListesi() {
        System.out.println("""
                ****************************
                ******* ÜRÜN LİSTESİ *******
                ****************************
                """);
        urunService.findAll().forEach(System.out::println);
        System.out.println("-----------------------------");
    }
}
