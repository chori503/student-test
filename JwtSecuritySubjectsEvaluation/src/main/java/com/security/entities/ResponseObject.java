package com.security.entities;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

//Esta clase es ResponseBody, creo una estandarizacion de respuesta para ciertas peticiones
public class ResponseObject {
	// fecha, hora y minutos de la peticion http
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date dateTime;
	// el estatus de respuesta
	private HttpStatus status;
	// mensaje de respuesta
	private String message;
	// url de la peticion
	private String path;
	// lo que envio como respuesta a solicitud
	private Object object;

	// constructor
	public ResponseObject() {

	}

	public ResponseObject(Date date, HttpStatus status, String mensaje, String path, Object object) {
		this.dateTime = date;
		this.status = status;
		this.message = mensaje;
		this.path = path;
		this.object = object;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}	
}
