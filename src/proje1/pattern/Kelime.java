package proje1.pattern;

import proje1.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class Kelime { //KELİMELER ÜZERİNDE İŞLEM YAPABİLMEK VE KELİME TANIMLAMAK İÇİN OLUŞTURDUĞUMU SINIFIMIZ

    private String kelime;
    private int uzunluk;
    private ArrayList<Character> CharArrayList; //Kelimelerin karakterlerini karşılaştırmak için oluşturulan karakter arraylist'i
    private boolean isTrue; //kelimenin doğru yanlışlığını atamak için bir değer
    
   //*****constructor,tostring,getter ve setter metotları******

    public Kelime(String kelime) {
        CharArrayList=new ArrayList<>();
        this.kelime = kelime;
        this.uzunluk = kelime.length();
        for(int k=0;k<this.uzunluk;k++){
          CharArrayList.add(kelime.charAt(k));
        }
        Collections.sort(CharArrayList);
       isTrue=false;
    }

    public boolean isIsTrue() {
        return isTrue;
    }

    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

    public String getKelime() {
        return kelime;
    }

    public ArrayList<Character> getCharArrayList() {
        return CharArrayList;
    }

    public void setKelime(String kelime) {
        this.kelime = kelime;
    }

    public int getUzunluk() {
        return uzunluk;
    }

    @Override
    public String toString() {
        return "Kelime= " + kelime + " Uzunluk=" + uzunluk;
    }
 //*****constructor,tostring,getter ve setter metotları******
    
    public boolean equals(Kelime kelime2) { //iki kelime eşitliğini kontrol eder
        if (!this.kelime.equalsIgnoreCase(kelime2.getKelime())) {
            return false;
        }
        return true;
    }

    public int singleTransposition(Kelime kelime2) {
        StringBuilder copy = new StringBuilder(this.getKelime()); //kullanıcıdan alınan kelime ile words.txt dosyasındaki kelimeleri karşılaştırıp,single transposition işleminii yapan metot
        int kontrol=0; //kelime değiştiğinde 1,değişmediğinde 0 değeri döndürülür
        for (int i = 0; i < this.getUzunluk() - 1; i++) {
            char a = this.getKelime().charAt(i);
            char b = this.getKelime().charAt(i + 1);
            copy.setCharAt(i, b);
            copy.setCharAt(i + 1, a);
            if (copy.toString().equals(kelime2.getKelime())) {
                this.setKelime(copy.toString());
                System.out.println("Kelime değişti: " + this.getKelime());
                kontrol=1;
                break;
            } else {
                copy = new StringBuilder(this.getKelime());
            }

        }
        return kontrol;
    }

}
