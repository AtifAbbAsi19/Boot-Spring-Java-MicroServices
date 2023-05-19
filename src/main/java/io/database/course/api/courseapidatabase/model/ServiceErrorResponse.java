package io.database.course.api.courseapidatabase.model;

import java.io.Serializable;

public class ServiceErrorResponse implements Serializable {

  //setter and getters
  private Object errorMessage;
  private Object errorBody;
  
  
  public Object getErrorBody() {
	return errorBody;
}
public void setErrorBody(Object errorBody) {
	this.errorBody = errorBody;
}
@Override
public int hashCode() {
	// TODO Auto-generated method stub
	return super.hashCode();
}
@Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
}
@Override
protected Object clone() throws CloneNotSupportedException {
	// TODO Auto-generated method stub
	return super.clone();
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}
@SuppressWarnings("deprecation")
@Override
protected void finalize() throws Throwable {
	// TODO Auto-generated method stub
	super.finalize();
}
private String errorCode;
  private String requestTime;
  
  
  
public Object getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(Object errorMessage) {
	this.errorMessage = errorMessage;
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}
public String getRequestTime() {
	return requestTime;
}
public void setRequestTime(String requestTime) {
	this.requestTime = requestTime;
}
  
  
  
  
  
 
}
