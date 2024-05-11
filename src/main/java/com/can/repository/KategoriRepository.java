package com.can.repository;

import com.can.entity.Kategori;
import com.can.utility.Repository;

public class KategoriRepository extends Repository<Kategori, Long> {
    public KategoriRepository() {
        super(new Kategori());
    }
}
