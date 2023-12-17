import java.util.ArrayList;
import java.util.List;

class MenyuElementi {
    private final String ad;
    private final double qiymət;

    public MenyuElementi(String ad, double qiymət) {
        this.ad = ad;
        this.qiymət = qiymət;
    }

    public String getAd() {
        return ad;
    }

    public double getQiymət() {
        return qiymət;
    }
}

class Sifariş {
    private final List<MenyuElementi> elementlər;

    public Sifariş() {
        elementlər = new ArrayList<>();
    }

    public void elementƏlavəEt(MenyuElementi element) {
        elementlər.add(element);
    }

    public void elementSil(MenyuElementi element) {
        elementlər.remove(element);
    }

    public double cəmiHesabat() {
        double cəm = 0;
        for (MenyuElementi element : elementlər) {
            cəm += element.getQiymət();
        }
        return cəm;
    }
}

class Restoran {
    private final List<Sifariş> sifarişlər;

    public Restoran() {
        sifarişlər = new ArrayList<>();
    }

    public void sifarişQəbulEt(Sifariş sifariş) {
        sifarişlər.add(sifariş);
    }

    public void sifarişİmtinaEt(Sifariş sifariş) {
        sifarişlər.remove(sifariş);
    }

    public double hesabatHazırla() {
        double ümumiSatış = 0;
        for (Sifariş sifariş : sifarişlər) {
            ümumiSatış += sifariş.cəmiHesabat();
        }
        return ümumiSatış;
    }
}

public class Main {
    public static void main(String[] args) {
        // Restoranın yaradılması
        Restoran restoran = new Restoran();

        // Menyunun yaradılması
        MenyuElementi element1 = new MenyuElementi("Pizza", 12.99);
        MenyuElementi element2 = new MenyuElementi("Salat", 8.49);

        // Sifarişin yaradılması və əlavə olunması
        Sifariş sifariş = new Sifariş();
        sifariş.elementƏlavəEt(element1);
        sifariş.elementƏlavəEt(element2);

        // Sifarişin qəbul edilməsi və hesabatın hazırlanması
        restoran.sifarişQəbulEt(sifariş);
        double ümumiSatış = restoran.hesabatHazırla();
        System.out.println("Ümumi satış: $" + ümumiSatış);
    }
}
