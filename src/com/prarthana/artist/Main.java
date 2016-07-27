/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.artist;

import com.prarthana.artist.art.Artist;
import com.prarthana.artist.dao.ArtistDAO;
import com.prarthana.artist.dao.impl.ArtistDAOImpl;
import java.util.Scanner;

/**
 *
 * @author Pavilion G4
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  ArtistDAO artDAO = new ArtistDAOImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Artist Record ");
            System.out.println("........................................");
            System.out.println("1. Add an Artist");
            System.out.println("2. Delete Artist By Name");
            System.out.println("3. Show all Artist");
            System.out.println("4. Search Artist By Name");
            System.out.println("5. Search Artist By Album");
            System.out.println("6. Exit");
            System.out.println("Enter your choice[1-6]:");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Add Artist");
                    Artist s = new Artist();
                    System.out.println("Enter Artist Name: ");
                    s.setArtistName(sc.next());
                    System.out.println("Enter Album Name: ");
                    s.setAlbum(sc.next());
                    System.out.println("Enter Album Title: ");
                    s.setTitle(sc.next());
                    System.out.println("Enter Year of Album Released: ");
                    s.setYear(sc.nextInt());
                    
                    
                    System.out.println("Enter Status: ");
                    s.setStatus(sc.nextBoolean());

                    if (artDAO.insert(s)) {
                        System.out.println("Inserted Successfully!!");
                    } else {
                        System.out.println("Can't add more Artists. Data Full!!");
                    }

                    break;
                case 2:
                    System.out.println("Enter the name of the Artist you want to delete: ");
                    String str= sc.next();
                    if (artDAO.delete(str)) {
                        System.out.println("The artist :" + str + " is deleted successfully.");
                    } else {
                        System.out.println("Name not found.");
                    }

                    break;
                case 3:
                    System.out.println("Artist Record");
                    System.out.println(".................................");
                    Artist[] artists = artDAO.getAll();
                    for (int i = 0; i < artists.length; i++) {
                        Artist artist = artists[i];
                        if (artist != null) {
                            System.out.println("Artist Name = " + artist.getArtistName());
                            System.out.println("Album Name = " + artist.getAlbum());
                            System.out.println("Album Title = " + artist.getTitle());
                            System.out.println("Year of Album Released = " + artist.getYear()+" A.D");
                           
                            System.out.println("Status = " + artist.isStatus());

                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the name of the artist you want to search: ");
                   String string= sc.next();
                    Artist st = artDAO.getByName(string);

                    System.out.println("ARTIST NAME = " + st.getArtistName());
                    System.out.println("ALBUM NAME = " + st.getAlbum());
                    System.out.println("ALBUM TITLE = " + st.getTitle());
                    System.out.println("YEAR OF ALBUM RELEASED = " + st.getYear());
                    System.out.println("STATUS = " + st.isStatus());

                    break;
                          case 5:
                    System.out.println("Enter the name of the album you want to search: ");
                   String strings= sc.next();
                    Artist stt = artDAO.getByAlbum(strings);

                    System.out.println("ALBUM NAME = " + stt.getAlbum());
                    System.out.println("ARTIST NAME = " + stt.getArtistName());
                    
                    System.out.println("ALBUM TITLE = " + stt.getTitle());
                    System.out.println("YEAR OF ALBUM RELEASED = " + stt.getYear());
                    System.out.println("STATUS = " + stt.isStatus());

                    break;
                case 6:
                    System.out.println("Do you really want to exit [Y/N]");
                    if (sc.next().equalsIgnoreCase("y")) {
                        System.out.println("Thankyou, Visit Again.");
                        System.exit(0);
                    }
                    System.exit(0);
                    break;

            }

        }
    }

}
