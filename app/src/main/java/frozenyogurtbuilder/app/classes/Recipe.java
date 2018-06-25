package frozenyogurtbuilder.app.classes;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Recipe implements Parcelable {
    private String name;
    private String desription;
    private String ingredients;
    private String imagePath = null;

    public Recipe(String name, String desription, String ingredients) {
        this.name = name;
        this.desription = desription;
        this.ingredients = ingredients;
    }
    public Recipe(String name, String desription, String ingredients, String imagePath) {
        this.name = name;
        this.desription = desription;
        this.ingredients = ingredients;
        this.imagePath = imagePath;
    }


    protected Recipe(Parcel in) {
        name = in.readString();
        desription = in.readString();
        ingredients = in.readString();
        imagePath = in.readString();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(desription);
        parcel.writeString(ingredients);
        parcel.writeString(imagePath);
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }
    public String getDesription() {
        return desription;
    }
    public String getIngredients() {
        return ingredients;
    }
    public String getImagePath(){
        return imagePath;
    }
    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }

    public Map<String, Object> toHash(){
        Map<String, Object> hash = new HashMap<>();
        hash.put("name", getName());
        hash.put("description", getDesription());
        hash.put("ingredients", getIngredients());
        hash.put("image", getImagePath());
        return hash;
    }
}
