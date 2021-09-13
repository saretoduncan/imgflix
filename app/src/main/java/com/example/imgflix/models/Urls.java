
package com.example.imgflix.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Urls {

    @SerializedName("raw")
    @Expose
    private String raw;
    @SerializedName("full")
    @Expose
    private String full;
    @SerializedName("regular")
    @Expose
    private String regular;
    @SerializedName("small")
    @Expose
    private String small;
    @SerializedName("thumb")
    @Expose
    private String thumb;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Urls() {
    }

    /**
     * 
     * @param small
     * @param thumb
     * @param raw
     * @param regular
     * @param full
     */
    public Urls(String raw, String full, String regular, String small, String thumb) {
        super();
        this.raw = raw;
        this.full = full;
        this.regular = regular;
        this.small = small;
        this.thumb = thumb;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Urls.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("raw");
        sb.append('=');
        sb.append(((this.raw == null)?"<null>":this.raw));
        sb.append(',');
        sb.append("full");
        sb.append('=');
        sb.append(((this.full == null)?"<null>":this.full));
        sb.append(',');
        sb.append("regular");
        sb.append('=');
        sb.append(((this.regular == null)?"<null>":this.regular));
        sb.append(',');
        sb.append("small");
        sb.append('=');
        sb.append(((this.small == null)?"<null>":this.small));
        sb.append(',');
        sb.append("thumb");
        sb.append('=');
        sb.append(((this.thumb == null)?"<null>":this.thumb));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
