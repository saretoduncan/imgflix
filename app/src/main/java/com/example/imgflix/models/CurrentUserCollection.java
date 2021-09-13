
package com.example.imgflix.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CurrentUserCollection {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("last_collected_at")
    @Expose
    private String lastCollectedAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("cover_photo")
    @Expose
    private Object coverPhoto;
    @SerializedName("user")
    @Expose
    private Object user;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CurrentUserCollection() {
    }

    /**
     * 
     * @param publishedAt
     * @param coverPhoto
     * @param lastCollectedAt
     * @param id
     * @param title
     * @param user
     * @param updatedAt
     */
    public CurrentUserCollection(Integer id, String title, String publishedAt, String lastCollectedAt, String updatedAt, Object coverPhoto, Object user) {
        super();
        this.id = id;
        this.title = title;
        this.publishedAt = publishedAt;
        this.lastCollectedAt = lastCollectedAt;
        this.updatedAt = updatedAt;
        this.coverPhoto = coverPhoto;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getLastCollectedAt() {
        return lastCollectedAt;
    }

    public void setLastCollectedAt(String lastCollectedAt) {
        this.lastCollectedAt = lastCollectedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(Object coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CurrentUserCollection.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("publishedAt");
        sb.append('=');
        sb.append(((this.publishedAt == null)?"<null>":this.publishedAt));
        sb.append(',');
        sb.append("lastCollectedAt");
        sb.append('=');
        sb.append(((this.lastCollectedAt == null)?"<null>":this.lastCollectedAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(',');
        sb.append("coverPhoto");
        sb.append('=');
        sb.append(((this.coverPhoto == null)?"<null>":this.coverPhoto));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
