package com.can.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructorlar
@Builder
@Entity
@Table(name = "tblurun")
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id için otomatik artan bir HB sequence oluşturur.
    private Long id;
    @Column(name = "Kategori_Id")
    private Long kategoriId;
    @Column(name = "Urun_Adi")
    private String urunAdi;
    @Column(name = "Aciklama")
    private String aciklama;
    @Column(name = "Fiyat")
    private Double fiyat;
    @Column(name = "Stok")
    private Integer stok;

    public Urun(String urunAdi, Double fiyat, Integer stok) {
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    public String formatliFiyat() {
        // Fiyatı biçimlendirme için NumberFormat kullanalım
        NumberFormat formatter = new DecimalFormat("#,###.##", new DecimalFormatSymbols(new Locale("tr", "TR")));
        return formatter.format(fiyat) + " ₺"; // Türk Lirası sembolü ekleyelim
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Urun{");
        sb.append("urunAdi='").append(urunAdi).append('\'');
        sb.append(", fiyat=").append(formatliFiyat());
        sb.append(", stok=").append(stok);
        sb.append('}');
        return sb.toString();
    }
}
