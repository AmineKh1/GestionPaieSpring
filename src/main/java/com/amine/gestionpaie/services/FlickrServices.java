package com.amine.gestionpaie.services;

import java.io.InputStream;

import com.flickr4java.flickr.FlickrException;

public interface FlickrServices {
	String savePhoto(InputStream photo, String title) throws FlickrException;

}
