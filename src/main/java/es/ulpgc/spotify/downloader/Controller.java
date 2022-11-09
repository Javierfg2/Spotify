package es.ulpgc.spotify.downloader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.util.*;

public class Controller {


    public static void get_all(String artist_path) throws Exception {

       ArrayList<String> all_albums_id = new ArrayList<String>();




        String path_artist = "/artists/"+artist_path;
        SpotifyAccessor accessor = new SpotifyAccessor();
        String json = accessor.get(path_artist, Map.of());

        JsonParser parser = new JsonParser();
        JsonObject jsonobject = (JsonObject) parser.parse(json);


        String artist_id = String.valueOf(jsonobject.getAsJsonObject().get("id"));
        String artist_name = String.valueOf(jsonobject.getAsJsonObject().get("name"));
        Integer popularity = Integer.valueOf(String.valueOf(jsonobject.getAsJsonObject().get("popularity")));
        Artist new_artist = new Artist(artist_name, artist_id, popularity);




        Database.insert_artist(new_artist);

        System.out.println("Got "+artist_name);




        String path_album = "/artists/"+artist_path+"/albums";
        SpotifyAccessor accessor1 = new SpotifyAccessor();
        String json1 = accessor1.get(path_album, Map.of());

        JsonParser parser1 = new JsonParser();
        JsonObject jsonobject1 = (JsonObject) parser1.parse(json1);

        JsonArray all_albums = (JsonArray) jsonobject1.get("items");
        for (JsonElement album : all_albums) {
            String album_id = String.valueOf(album.getAsJsonObject().get("id"));
            String album_name = String.valueOf(album.getAsJsonObject().get("name"));
            String album_type = String.valueOf(album.getAsJsonObject().get("album_type"));
            String release_date = String.valueOf(album.getAsJsonObject().get("release_date"));
            Integer total_tracks = Integer.valueOf(String.valueOf(album.getAsJsonObject().get("total_tracks")));
            String album_artist = artist_name;
            Album new_album = new Album(album_id, album_name, album_type, total_tracks, release_date, album_artist);
            all_albums_id.add(album_id);


            Database.insert_album(new_album);


            }

        System.out.println("Got albums of "+artist_name);





            for (String each_album_id : all_albums_id) {

                String path_tracks = "/albums/"+each_album_id+"/tracks";
                SpotifyAccessor accessor2 = new SpotifyAccessor();
                String json2 = accessor2.get(path_tracks.replaceAll("\"", ""), Map.of());


                JsonParser parser2 = new JsonParser();
                JsonObject jsonobject2 = (JsonObject) parser2.parse(json2);

                JsonArray all_tracks = (JsonArray) jsonobject2.get("items");
                for (JsonElement track : all_tracks) {
                    String track_name = String.valueOf(track.getAsJsonObject().get("name"));
                    Boolean explicit = Boolean.valueOf(String.valueOf(track.getAsJsonObject().get("explicit")));
                    Integer duration_s = Integer.valueOf(String.valueOf(track.getAsJsonObject().get("duration_ms"))) / 1000;
                    String track_artist = artist_name;
                    Track new_track = new Track(track_name, explicit, duration_s, track_artist);


                    Database.insert_track(new_track);
                }
            }

        System.out.println("Got tracks of "+artist_name);

    }

    }


