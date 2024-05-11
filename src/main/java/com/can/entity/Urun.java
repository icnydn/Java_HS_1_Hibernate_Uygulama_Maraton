package com.can.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructorlar
@Builder
@Entity
@Table(name = "tblurun")
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id için otomatik artan bir HB sequence oluşturur.
    Long id;
    @Column(name = "Kategori_Id")
    Long kategoriId;
    @Column(name = "Urun_Adi")
    String urunAdi;
    @Column(name = "Aciklama")
    String aciklama;
    @Column(name = "Fiyat")
    Double fiyat;
    @Column(name = "Stok")
    Integer stok;

    public Urun(String urunAdi, Double fiyat, Integer stok) {
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
        this.stok = stok;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Urun{");
        sb.append("urunAdi='").append(urunAdi).append('\'');
        sb.append(", fiyat=").append(fiyat);
        sb.append(", stok=").append(stok);
        sb.append('}');
        return sb.toString();
    }
}
