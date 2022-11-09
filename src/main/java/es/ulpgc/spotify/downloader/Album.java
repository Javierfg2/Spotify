package es.ulpgc.spotify.downloader;

public class Album {
    String id;
    String name;
    String album_type;
    Integer total_tracks;
    String release_date;
    String artist;


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum_type() {
        return album_type;
    }

    public void setAlbum_type(String album_type) {
        this.album_type = album_type;
    }

    public Integer getTotal_tracks() {
        return total_tracks;
    }

    public void setTotal_tracks(Integer total_tracks) {
        this.total_tracks = total_tracks;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Album(String id, String name, String album_type, Integer total_tracks, String release_date, String artist) {
        this.id = id;
        this.name = name;
        this.album_type = album_type;
        this.total_tracks = total_tracks;
        this.release_date = release_date;
        this.artist = artist;



    }
}


