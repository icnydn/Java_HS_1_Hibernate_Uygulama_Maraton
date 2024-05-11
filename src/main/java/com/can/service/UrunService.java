package com.can.service;

import com.can.entity.Urun;
import com.can.repository.UrunRepository;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class UrunService {
    private final UrunRepository urunRepository;

    public String formatliFiyat(Double fiyat) {
        // Fiyatı biçimlendirme için NumberFormat kullanalım
        NumberFormat formatter = new DecimalFormat("#,###.##", new DecimalFormatSymbols(new Locale("tr", "TR")));
        return formatter.format(fiyat) + " ₺"; // Türk Lirası sembolü ekleyelim
    }

    public UrunService() {
        urunRepository = new UrunRepository();
    }

    public void save(Urun urun) {
        urunRepository.save(urun);
    }

    public List<Urun> findAll() {
        return urunRepository.findAll();
    }

    public List<Urun> findAllByGivenValue(Object value) {
        return urunRepository.findAllByGivenValue(value);
    }
}
