package es.ulpgc.spotify.downloader;

import java.sql.*;

public class Database {

        public static void createNewDatabase(String fileName) throws ClassNotFoundException {

            String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;

            try (Connection conn = DriverManager.getConnection(url)) {
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println("The driver name is " + meta.getDriverName());
                    System.out.println("A new database has been created.");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    public static void create_Artists_table() {

        String url = "jdbc:sqlite:C://sqlite/db/spotify.db";

        String sql = "CREATE TABLE IF NOT EXISTS Artists (\n"
                + "	name TEXT,\n"
                + "	id TEXT,\n"
                + "	popularity INTEGER\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void create_albums_table() {

        String url = "jdbc:sqlite:C://sqlite/db/spotify.db";

        String sql = "CREATE TABLE IF NOT EXISTS Albums (\n"
                + "	name TEXT,\n"
                + "	id TEXT,\n"
                + "	artist TEXT,\n"
                + "	album_type TEXT,\n"
                + "	release_date TEXT,\n"
                + "	total_tracks INTEGER\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void create_tracks_table() {

        String url = "jdbc:sqlite:C://sqlite/db/spotify.db";

        String sql = "CREATE TABLE IF NOT EXISTS Tracks (\n"
                + "	Track_name TEXT,\n"
                + "	artist TEXT,\n"
                + "	explicit BOOL,\n"
                + "	duration_s INTEGER\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection connect() {
        String url = "jdbc:sqlite:C://sqlite/db/spotify.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void insert_artist(Artist artist) {
        String sql = "INSERT INTO Artists(name,id,popularity) VALUES(?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, artist.getName());
            pstmt.setString(2, artist.getId());
            pstmt.setInt(3, artist.getPopularity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insert_album(Album album) {
        String sql = "INSERT INTO Albums(name,id,artist,album_type,release_date,total_tracks) VALUES(?,?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, album.getName());
            pstmt.setString(2, album.getId());
            pstmt.setString(3, album.getArtist());
            pstmt.setString(4, album.getAlbum_type());
            pstmt.setString(5, album.getRelease_date());
            pstmt.setInt(6, album.getTotal_tracks());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insert_track(Track track) {
        String sql = "INSERT INTO Tracks(Track_name,artist,explicit,duration_s) VALUES(?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, track.getName());
            pstmt.setString(2, track.getArtist());
            pstmt.setBoolean(3, track.getExplicit());
            pstmt.setInt(4, track.getDuration_s());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}

