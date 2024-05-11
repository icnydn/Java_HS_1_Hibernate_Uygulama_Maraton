package com.can.controller;

import com.can.entity.Urun;
import com.can.service.KategoriService;
import com.can.service.UrunService;
import com.can.utility.ViewUrunArama;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UrunController {
    private final UrunService urunService;
    private final KategoriService kategoriService;

    public UrunController() {
        urunService = new UrunService();
        kategoriService = new KategoriService();
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
        List<Urun> uruns = urunService.findAllByGivenValue(arananUrun)
                .stream().limit(10)
                .collect(Collectors.toList());
        List<ViewUrunArama> vwUrunArama = new ArrayList<>();
        for (Urun urun : uruns) {
            ViewUrunArama vw = ViewUrunArama.builder()
                    .kategori(kategoriService.findById(urun.getKategoriId()).getKategoriAdi())
                    .urunAdi(urun.getUrunAdi())
                    .fiyat(urunService.formatliFiyat(urun.getFiyat()))
                    .stok(urun.getStok())
                    .build();
            vwUrunArama.add(vw);
        }
        System.out.println(vwUrunArama);
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
