package joe.joeabk.carbee;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Joe Abraham on 15-Sep-16.
 */
public class Car {
    @SerializedName("Name")
    public String Name;
    @SerializedName("spec1")
    public String spec1;
    @SerializedName("spec2")
    public String spec2;
    @SerializedName("spec3")
    public String spec3;
    @SerializedName("imageurl")
    public String imageurl;
}
