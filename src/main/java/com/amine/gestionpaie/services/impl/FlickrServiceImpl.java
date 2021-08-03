package com.amine.gestionpaie.services.impl;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amine.gestionpaie.services.FlickrServices;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FlickrServiceImpl implements FlickrServices{
	/*@Value("${flickr.apiKey}")
	private String apiKey;
	@Value("${flickr.apiSecret}")
	private String apiSecret;
	@Value("${flickr.appKey}")
	private String appKey;
	@Value("${flickr.appSecret}")
	private String appSecret;*/
	
	private Flickr flickr;
	
	@Autowired
	public FlickrServiceImpl(Flickr flickr) {

		this.flickr = flickr;
	}


	@Override
	public String savePhoto(InputStream photo, String title) throws FlickrException{
		// TODO Auto-generated method stub
		UploadMetaData uploadMetaData = new UploadMetaData();
		uploadMetaData.setTitle(title);
		
		String photoId = flickr.getUploader().upload(photo, uploadMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}
	/*private void connect() {
		flickr = new Flickr (apiKey, apiSecret, new REST());
		Auth auth= new Auth();
		auth.setPermission(Permission.DELETE);
		auth.setToken(apiKey);
		auth.setTokenSecret(apiSecret);
		RequestContext requestContext = RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		flickr.setAuth(auth);
	}*/

}
