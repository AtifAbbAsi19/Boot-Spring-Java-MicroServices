package io.database.course.api.courseapidatabase.network;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class MyErrorHandler implements ResponseErrorHandler {
	  @Override
	  public void handleError(ClientHttpResponse response) throws IOException {
	   
	  }

	  @Override
	  public boolean hasError(ClientHttpResponse response) throws IOException {
		return false;
	 
	  }
	}
