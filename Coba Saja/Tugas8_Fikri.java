package Tugas_8;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class Nasabah {
    private String nama;
    private String id;
    private String kontak;
    ArrayList<Rekening> rekeningList = new ArrayList<Rekening>();

    public Nasabah(String nama, String id, String kontak) {
        this.nama = nama;
        this.id = id;
        this.kontak = kontak;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getKontak() {
        return kontak;
    }
    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public void addRekening(Rekening rekening) {
        rekeningList.add(rekening);
    }
    public List<Rekening> getRekeningList() {
        return rekeningList;
    }

    @Override
    public String toString(){
        return "Nasabah{" +
                "nama='" + nama + '\'' +
                ", id='" + id + '\'' +
                ", kontak='" + kontak + '\'' +
                ", rekeningList=" + rekeningList +
                '}';
    }
}

class Rekening {
    private String nommorRekening;
    private double saldo;
    private String jenisRekening;

    public Rekening (String nommorRekening, double saldo, String jenisRekening) {
        this.nommorRekening = nommorRekening;
        this.saldo = saldo;
        this.jenisRekening = jenisRekening;
    }

    public String getNommorRekening() {
        return nommorRekening;
    }
    public void setNommorRekening(String nommorRekening) {
        this.nommorRekening = nommorRekening;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getJenisRekening() {
        return jenisRekening;
    }
    public void setJenisRekening(String jenisRekening) {
        this.jenisRekening = jenisRekening;
    }

    public void deposit(double jumlah) {
        saldo += jumlah;
        System.out.println("Deposit berhasil. Saldo baru: " + saldo);
    }

    public void withdraw(double jumlah) {
        saldo -= jumlah;
        System.out.println("Penarikan berhasil. Saldo baru: " + saldo);
    }

    @Override
    public String toString(){
        return "Rekening{" +
                "nomorRekening='" + nommorRekening + '\'' +
                ", saldo=" + saldo +
                ", jenisRekening='" + jenisRekening + '\'' +
                '}';
    }
}

class Pembayaran {
    private String idPembayaran;
    private double jumlah;
    LocalDate tanggalPembayaran;
    Rekening rekeningTujuan;

    public Pembayaran(String idPembayaran, double jumlah, LocalDate tanggalPembayaran, Rekening rekeningTujuan) {
        this.idPembayaran = idPembayaran;
        this.jumlah = jumlah;
        this.tanggalPembayaran = tanggalPembayaran;
        this.rekeningTujuan = rekeningTujuan;
    }

    public String getIdPembayaran() {
        return idPembayaran;
    }
    public void setIdPembayaran(String idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    public double getJumlah() {
        return jumlah;
    }
    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public LocalDate getTanggalPembayaran() {
        return tanggalPembayaran;
    }
    public void setTanggalPembayaran(LocalDate tanggalPembayaran) {
        this.tanggalPembayaran = tanggalPembayaran;
    }

    public Rekening getRekeningTujuan() {
        return rekeningTujuan;
    }
    public void setRekeningTujuan(Rekening rekeningTujuan) {
        this.rekeningTujuan = rekeningTujuan;
    }

    public void prosesPembayaran(){
        rekeningTujuan.withdraw(jumlah);
        System.out.println("Pembayaran dengan ID " + idPembayaran + " sebesar " + jumlah + " telah diproses pada " + tanggalPembayaran);
    }

    @Override
    public String toString(){
        return "Pembayaran{" +
                "idPembayaran='" + idPembayaran + '\'' +
                ", jumlah=" + jumlah +
                ", tanggalPembayaran=" + tanggalPembayaran +
                ", rekeningTujuan=" + rekeningTujuan +
                '}';
    }
}

public class Tugas8_Fikri {
    public static void main(String[] args) {
        //Membuat objek Nasabah
        Nasabah nasabah = new Nasabah("John Doe", "N001", "081234567890");
        System.out.println(nasabah);

        //Membuat objek Rekening
        Rekening rekening = new Rekening("R001", 1000000, "Tabungan");
        nasabah.addRekening(rekening);
        System.out.println(nasabah);

        Rekening rekening2 = new Rekening("R002", 500000, "Tabungan");
        nasabah.addRekening(rekening2);
        System.out.println(nasabah);

        //Deposit dan Withdraw
        rekening.deposit(500000);
        rekening.withdraw(200000);

        //Membuat objek Pembayaran
        //date 2025-04-10
        Pembayaran pembayaran = new Pembayaran("P001", 300000, LocalDate.of(2025,4,10), rekening2);
        pembayaran.prosesPembayaran();
        System.out.println(pembayaran);
    }
}
