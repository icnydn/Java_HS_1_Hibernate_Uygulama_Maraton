package com.can.utility;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructorlar
@Builder
public class ViewUrunArama {
    String kategori;
    String urunAdi;
    String fiyat;
    Integer stok;
}
