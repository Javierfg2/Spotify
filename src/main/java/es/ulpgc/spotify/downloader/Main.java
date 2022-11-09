package es.ulpgc.spotify.downloader;

import com.google.gson.*;


import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception {


        Database.createNewDatabase("spotify.db");
        Database.create_Artists_table();
        Database.create_albums_table();
        Database.create_tracks_table();


        String Paths[] = {"52iwsT98xCoGgiGntTiR7K","2AsusXITU8P25dlRNhcAbG","1pi7nGhOM7PTHR5YEgXVGq",
                "2dd5mrQZvg6SmahdgVKDzh","1DxLCyH42yaHKGK3cl5bvG"};

        for (String artist_path : Paths) {
            Controller.get_all(artist_path);
        }

    }

}


