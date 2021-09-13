
package com.example.imgflix.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("portfolio_url")
    @Expose
    private String portfolioUrl;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("total_likes")
    @Expose
    private Integer totalLikes;
    @SerializedName("total_photos")
    @Expose
    private Integer totalPhotos;
    @SerializedName("total_collections")
    @Expose
    private Integer totalCollections;
    @SerializedName("instagram_username")
    @Expose
    private String instagramUsername;
    @SerializedName("twitter_username")
    @Expose
    private String twitterUsername;
    @SerializedName("profile_image")
    @Expose
    private ProfileImage profileImage;
    @SerializedName("links")
    @Expose
    private Links links;

    /**
     * No args constructor for use in serialization
     * 
     */
    public User() {
    }

    /**
     * 
     * @param bio
     * @param totalCollections
     * @param profileImage
     * @param portfolioUrl
     * @param twitterUsername
     * @param instagramUsername
     * @param name
     * @param location
     * @param totalPhotos
     * @param links
     * @param id
     * @param totalLikes
     * @param username
     */
    public User(String id, String username, String name, String portfolioUrl, String bio, String location, Integer totalLikes, Integer totalPhotos, Integer totalCollections, String instagramUsername, String twitterUsername, ProfileImage profileImage, Links links) {
        super();
        this.id = id;
        this.username = username;
        this.name = name;
        this.portfolioUrl = portfolioUrl;
        this.bio = bio;
        this.location = location;
        this.totalLikes = totalLikes;
        this.totalPhotos = totalPhotos;
        this.totalCollections = totalCollections;
        this.instagramUsername = instagramUsername;
        this.twitterUsername = twitterUsername;
        this.profileImage = profileImage;
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(Integer totalLikes) {
        this.totalLikes = totalLikes;
    }

    public Integer getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(Integer totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public Integer getTotalCollections() {
        return totalCollections;
    }

    public void setTotalCollections(Integer totalCollections) {
        this.totalCollections = totalCollections;
    }

    public String getInstagramUsername() {
        return instagramUsername;
    }

    public void setInstagramUsername(String instagramUsername) {
        this.instagramUsername = instagramUsername;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public ProfileImage getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(ProfileImage profileImage) {
        this.profileImage = profileImage;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("username");
        sb.append('=');
        sb.append(((this.username == null)?"<null>":this.username));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("portfolioUrl");
        sb.append('=');
        sb.append(((this.portfolioUrl == null)?"<null>":this.portfolioUrl));
        sb.append(',');
        sb.append("bio");
        sb.append('=');
        sb.append(((this.bio == null)?"<null>":this.bio));
        sb.append(',');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("totalLikes");
        sb.append('=');
        sb.append(((this.totalLikes == null)?"<null>":this.totalLikes));
        sb.append(',');
        sb.append("totalPhotos");
        sb.append('=');
        sb.append(((this.totalPhotos == null)?"<null>":this.totalPhotos));
        sb.append(',');
        sb.append("totalCollections");
        sb.append('=');
        sb.append(((this.totalCollections == null)?"<null>":this.totalCollections));
        sb.append(',');
        sb.append("instagramUsername");
        sb.append('=');
        sb.append(((this.instagramUsername == null)?"<null>":this.instagramUsername));
        sb.append(',');
        sb.append("twitterUsername");
        sb.append('=');
        sb.append(((this.twitterUsername == null)?"<null>":this.twitterUsername));
        sb.append(',');
        sb.append("profileImage");
        sb.append('=');
        sb.append(((this.profileImage == null)?"<null>":this.profileImage));
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
