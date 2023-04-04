package ca.qc.bdeb.travail07.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Etudiant implements Parcelable {

    private String nom;
    private int age;
    private int noDA;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNoDA() {
        return noDA;
    }

    public void setNoDA(int noDA) {
        this.noDA = noDA;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nom);
        dest.writeInt(this.age);
        dest.writeInt(this.noDA);
    }

    public void readFromParcel(Parcel source) {
        this.nom = source.readString();
        this.age = source.readInt();
        this.noDA = source.readInt();
    }

    public Etudiant() {
    }

    public Etudiant(String nom, int age, int noDA) {
        this.nom = nom;
        this.age = age;
        this.noDA = noDA;
    }

    protected Etudiant(Parcel in) {
        this.nom = in.readString();
        this.age = in.readInt();
        this.noDA = in.readInt();
    }

    public static final Parcelable.Creator<Etudiant> CREATOR = new Parcelable.Creator<Etudiant>() {
        @Override
        public Etudiant createFromParcel(Parcel source) {
            return new Etudiant(source);
        }

        @Override
        public Etudiant[] newArray(int size) {
            return new Etudiant[size];
        }
    };
}
