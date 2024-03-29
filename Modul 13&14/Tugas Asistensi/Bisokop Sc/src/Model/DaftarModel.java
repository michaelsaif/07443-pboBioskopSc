package Model;
import Entity.daftarpembeli;
import Entity.FilmEntity;
import java.text.ParseException;
import java.util.ArrayList;

public class DaftarModel implements ModelInterface {
    private ArrayList<daftarpembeli> daftarArrayList;
    
    public DaftarModel() {
        daftarArrayList = new ArrayList<daftarpembeli>(); 
    }
    public void insertDataDaftar(daftarpembeli daftar) {
        daftarArrayList.add(daftar);
    }
    public ArrayList<daftarpembeli>getDaftarArrayList() {
        return daftarArrayList;
    }
    public int size() {
        return daftarArrayList.size();
    }

    @Override
     public void view() {
        for (daftarpembeli daftar : daftarArrayList) {
            System.out.println("==============================================");
            System.out.println("nama : " + daftar.getPembeli().getNama()+"\nPassword : " + daftar.getPembeli().getPassword() + "\nNo telp : "+daftar.getPembeli().getNotelp()+"\n Film : "+FilmEntity.film[daftar.getIndexFilm()] + "\n isVerified : ");
            if(daftar.isIsVerified()==false) {
                System.out.println("Belum Di Verifikasi Penjual");
            } else {
                System.out.println("Sudah Di Verifikasi Penjual");
            }
            System.out.println("==============================================");
        }
    }
     @Override
    public int cekData(String nama, String password) {
        int loop = 0;
        if(daftarArrayList.size() == 0) {
            loop = -1;
        } else {
            for (int i=0; i<daftarArrayList.size(); i++) {
                if (daftarArrayList.get(i).getPembeli().getNama().equals(nama)) {
                    loop = i;
                    break;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }
    
    public daftarpembeli showDaftarPembeli(int index) {
        return daftarArrayList.get(index);
    }
    public void updateIsVerified(int index,daftarpembeli DaftarPembeli) {
        daftarArrayList.set(index, DaftarPembeli);
    }
    public void hapuspembeliModel(int index) {
        daftarArrayList.remove(daftarArrayList.get(index));
    }
            
    public ArrayList <daftarpembeli> alldatapembeli() {
        return daftarArrayList;
    }
    
    private int cariBaju(String Baju){
        int index=-1;
        for(int i=0;i <daftarArrayList.size();i++) {
           if(Baju.equals(daftarArrayList.get(i).getPembeli().getNama()))
               index=i;
       }
       return index;
    }
    
    public void update(String Baju, int Bajuupdate){
            int data;
        if(cariBaju(Baju)!=-1){
             
            daftarArrayList.get(cariBaju(Baju)).setIndexBaju(Bajuupdate);
            data = 1;
        }
        else {
            data = 0;
           
        }
    } 
    
}