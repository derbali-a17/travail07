package ca.qc.bdeb.travail07.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Material implements Parcelable {
    private int id;
    private String nom;
    private float prix;
    private int imageResId;
    private String categorie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public Material(int id, String nom, float prix, int imageResId) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.imageResId = imageResId;
    }

    public Material(int id, String nom, float prix, int imageResId, String categorie) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.imageResId = imageResId;
        this.categorie = categorie;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nom);
        dest.writeFloat(this.prix);
        dest.writeInt(this.imageResId);
        dest.writeString(this.categorie);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.nom = source.readString();
        this.prix = source.readFloat();
        this.imageResId = source.readInt();
        this.categorie = source.readString();
    }

    protected Material(Parcel in) {
        this.id = in.readInt();
        this.nom = in.readString();
        this.prix = in.readFloat();
        this.imageResId = in.readInt();
        this.categorie = in.readString();
    }

    public static final Parcelable.Creator<Material> CREATOR = new Parcelable.Creator<Material>() {
        @Override
        public Material createFromParcel(Parcel source) {
            return new Material(source);
        }

        @Override
        public Material[] newArray(int size) {
            return new Material[size];
        }
    };
}
