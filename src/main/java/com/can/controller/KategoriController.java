package com.can.controller;

import com.can.entity.Kategori;
import com.can.service.KategoriService;

import java.util.Scanner;

public class KategoriController {
    private final KategoriService kategoriService;

    public KategoriController() {
        kategoriService = new KategoriService();
    }

    public void kategoriKaydet() {
        System.out.println("""
                *********************************
                ******** KATEGORİ EKLEME ********
                *********************************
                """);
        System.out.print("Kategori Adı......: ");
        String kategoriAdi = new Scanner(System.in).nextLine();
        System.out.print("Üst Kategori Id...: ");
        Long ustKategoriId = new Scanner(System.in).nextLong();
        kategoriService.save(Kategori.builder()
                .kategoriAdi(kategoriAdi)
                .ustKategoriId(ustKategoriId)
                .build());
    }

    public void kategoriListesi() {
        System.out.println("""
                *********************************
                ******* KATEGORİ LİSTESİ ********
                *********************************
                """);
        kategoriService.findAll().forEach(System.out::println);
        System.out.println("--------------------------------");
    }
}
