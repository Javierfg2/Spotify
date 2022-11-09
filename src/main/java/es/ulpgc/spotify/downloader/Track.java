package es.ulpgc.spotify.downloader;

public class Track {
    String name;
    Boolean explicit;
    Integer duration_s;
    String artist;

    public Track(String name, Boolean explicit, Integer duration_s, String artist) {
        this.name = name;
        this.explicit = explicit;
        this.duration_s = duration_s;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    public Integer getDuration_s() {
        return duration_s;
    }

    public void setDuration_s(Integer duration_s) {
        this.duration_s = duration_s;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
