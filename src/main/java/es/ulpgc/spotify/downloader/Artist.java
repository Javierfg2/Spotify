package es.ulpgc.spotify.downloader;

public class Artist {
    String name;
    String id;
    Integer Popularity;

    public Artist(String name, String id, Integer popularity) {
        this.name = name;
        this.id = id;
        Popularity = popularity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPopularity() {
        return Popularity;
    }

    public void setPopularity(Integer popularity) {
        Popularity = popularity;
    }
}
