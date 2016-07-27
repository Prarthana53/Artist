/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.artist.dao;

import com.prarthana.artist.art.Artist;

/**
 *
 * @author Pavilion G4
 */
public interface ArtistDAO {
     boolean insert(Artist s);
  
    boolean delete(String name);
    Artist getByName(String name);
    Artist getByAlbum(String album);
    
    Artist[] getAll();

    
}
