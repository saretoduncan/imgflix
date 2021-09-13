
package com.example.imgflix.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Links__1 {

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("html")
    @Expose
    private String html;
    @SerializedName("download")
    @Expose
    private String download;
    @SerializedName("download_location")
    @Expose
    private String downloadLocation;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links__1() {
    }

    /**
     * 
     * @param download
     * @param self
     * @param html
     * @param downloadLocation
     */
    public Links__1(String self, String html, String download, String downloadLocation) {
        super();
        this.self = self;
        this.html = html;
        this.download = download;
        this.downloadLocation = downloadLocation;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getDownloadLocation() {
        return downloadLocation;
    }

    public void setDownloadLocation(String downloadLocation) {
        this.downloadLocation = downloadLocation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Links__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("self");
        sb.append('=');
        sb.append(((this.self == null)?"<null>":this.self));
        sb.append(',');
        sb.append("html");
        sb.append('=');
        sb.append(((this.html == null)?"<null>":this.html));
        sb.append(',');
        sb.append("download");
        sb.append('=');
        sb.append(((this.download == null)?"<null>":this.download));
        sb.append(',');
        sb.append("downloadLocation");
        sb.append('=');
        sb.append(((this.downloadLocation == null)?"<null>":this.downloadLocation));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
