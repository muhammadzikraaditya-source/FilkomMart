package method_void;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DataBarang {
    private static final Map<String, Double> HARGA;
    static {
        Map<String, Double> m = new HashMap<>();
        m.put("beras", 55000d);
        m.put("gula", 10000d);
        m.put("minyak goreng", 56000d);
        m.put("sabun", 15000d);
        m.put("telur", 2500d);
        HARGA = Collections.unmodifiableMap(m);
    }

    public static Double getHarga(String namaBarang) {
        if (namaBarang == null) return null;
        return HARGA.get(namaBarang.trim().toLowerCase());
    }

    public static Map<String, Double> semua() {
        return HARGA;
    }
}
