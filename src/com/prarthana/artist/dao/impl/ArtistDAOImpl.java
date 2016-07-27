/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prarthana.artist.dao.impl;

import com.prarthana.artist.art.Artist;
import com.prarthana.artist.dao.ArtistDAO;

/**
 *
 * @author Pavilion G4
 */
public class ArtistDAOImpl implements ArtistDAO {
     private int counter=0;
    private Artist[] artistList=new Artist[5];

    @Override
    public boolean insert(Artist s) {
        if(counter==artistList.length){
            return false;
        }
      artistList[counter]=s;
      counter++;
        return true;
        
    }

    @Override
    public boolean delete(String name) {
         for(int i=0;i<artistList.length;i++){
        Artist s=artistList[i]; 
        if(s!=null && s.getArtistName().equalsIgnoreCase(name)){
            artistList[i]=null;
            return true;
        }
        
        }
        return false;
        
    }

    @Override
    public Artist getByName(String name) {
        
            for(int i=0;i<artistList.length;i++){
        Artist s=artistList[i]; 
        if(s!=null && s.getArtistName().equalsIgnoreCase(name)){
            
            return s;
        }
        
        }
        return null;
    }

    @Override
    public Artist getByAlbum(String album) {
        
             for(int i=0;i<artistList.length;i++){
        Artist s=artistList[i]; 
        if(s!=null && s.getAlbum().equalsIgnoreCase(album)){
            
            return s;
        }
        
        }
        return null;
    }

    @Override
    public Artist[] getAll() {
        return artistList;
    }
    
}
