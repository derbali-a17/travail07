package ca.qc.bdeb.travail07.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Materials implements Parcelable {
    private List<Material> materialList;

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public Materials(List<Material> materialList) {
        this.materialList = materialList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.materialList);
    }

    public void readFromParcel(Parcel source) {
        this.materialList = source.createTypedArrayList(Material.CREATOR);
    }

    protected Materials(Parcel in) {
        this.materialList = in.createTypedArrayList(Material.CREATOR);
    }

    public static final Parcelable.Creator<Materials> CREATOR = new Parcelable.Creator<Materials>() {
        @Override
        public Materials createFromParcel(Parcel source) {
            return new Materials(source);
        }

        @Override
        public Materials[] newArray(int size) {
            return new Materials[size];
        }
    };
}
