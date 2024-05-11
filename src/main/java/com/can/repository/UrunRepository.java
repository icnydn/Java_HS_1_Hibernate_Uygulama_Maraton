package com.can.repository;

import com.can.entity.Urun;
import com.can.utility.Repository;

public class UrunRepository extends Repository<Urun, Long> {
    public UrunRepository() {
        super(new Urun());
    }
}
