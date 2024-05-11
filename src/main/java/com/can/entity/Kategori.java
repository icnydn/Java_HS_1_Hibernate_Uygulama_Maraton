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
@Table(name = "tblkategori")
public class Kategori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id için otomatik artan bir HB sequence oluşturur.
    Long id;
    @Column(name = "Kategori_Adi")
    String kategoriAdi;
    @Column(name = "Ust_Kategori_Id")
    Long ustKategoriId;

}
