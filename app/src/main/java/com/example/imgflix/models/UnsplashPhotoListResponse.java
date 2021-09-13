
package com.example.imgflix.models;

import java.util.List;


import com.example.imgflix.models.Urls;
import com.example.imgflix.models.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UnsplashPhotoListResponse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("blur_hash")
    @Expose
    private String blurHash;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("liked_by_user")
    @Expose
    private Boolean likedByUser;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("current_user_collections")
    @Expose
    private List<CurrentUserCollection> currentUserCollections = null;
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("links")
    @Expose
    private Links__1 links;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UnsplashPhotoListResponse() {
    }

    /**
     * 
     * @param likedByUser
     * @param color
     * @param description
     * @param createdAt
     * @param urls
     * @param blurHash
     * @param currentUserCollections
     * @param width
     * @param links
     * @param id
     * @param user
     * @param updatedAt
     * @param height
     * @param likes
     */
    public UnsplashPhotoListResponse(String id, String createdAt, String updatedAt, Integer width, Integer height, String color, String blurHash, Integer likes, Boolean likedByUser, String description, User user, List<CurrentUserCollection> currentUserCollections, Urls urls, Links__1 links) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.width = width;
        this.height = height;
        this.color = color;
        this.blurHash = blurHash;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.description = description;
        this.user = user;
        this.currentUserCollections = currentUserCollections;
        this.urls = urls;
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBlurHash() {
        return blurHash;
    }

    public void setBlurHash(String blurHash) {
        this.blurHash = blurHash;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CurrentUserCollection> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<CurrentUserCollection> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Links__1 getLinks() {
        return links;
    }

    public void setLinks(Links__1 links) {
        this.links = links;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UnsplashPhotoListResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(',');
        sb.append("width");
        sb.append('=');
        sb.append(((this.width == null)?"<null>":this.width));
        sb.append(',');
        sb.append("height");
        sb.append('=');
        sb.append(((this.height == null)?"<null>":this.height));
        sb.append(',');
        sb.append("color");
        sb.append('=');
        sb.append(((this.color == null)?"<null>":this.color));
        sb.append(',');
        sb.append("blurHash");
        sb.append('=');
        sb.append(((this.blurHash == null)?"<null>":this.blurHash));
        sb.append(',');
        sb.append("likes");
        sb.append('=');
        sb.append(((this.likes == null)?"<null>":this.likes));
        sb.append(',');
        sb.append("likedByUser");
        sb.append('=');
        sb.append(((this.likedByUser == null)?"<null>":this.likedByUser));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("currentUserCollections");
        sb.append('=');
        sb.append(((this.currentUserCollections == null)?"<null>":this.currentUserCollections));
        sb.append(',');
        sb.append("urls");
        sb.append('=');
        sb.append(((this.urls == null)?"<null>":this.urls));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
