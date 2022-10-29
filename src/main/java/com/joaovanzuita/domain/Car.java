package com.joaovanzuita.domain;

import java.io.Serializable;

public class Car implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long idCar;
	private String name;
	private String description;
	private String urlVideo;
	private String urlImage;
	private String latitude;
	private String longitude;
	private String type;
	
	public Car() {
	}
	
	public Car(Long idCar, String name, String description, String urlVideo, String urlImage, String latitude,
			String longitude, String type) {
		this.idCar = idCar;
		this.name = name;
		this.description = description;
		this.urlVideo = urlVideo;
		this.urlImage = urlImage;
		this.latitude = latitude;
		this.longitude = longitude;
		this.type = type;
	}

	public Long getIdCar() {
		return idCar;
	}
	public void setIdCar(Long idCar) {
		this.idCar = idCar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlVideo() {
		return urlVideo;
	}
	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Car [idCar=" + idCar + ", name=" + name + ", description=" + description + ", urlVideo=" + urlVideo
				+ ", urlImage=" + urlImage + ", latitude=" + latitude + ", longitude=" + longitude + ", type=" + type
				+ "]";
	}
}