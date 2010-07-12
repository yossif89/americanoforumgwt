package forum.client.controller;

import forum.shared.communication.ServerResponse;
import com.google.gwt.user.client.rpc.AsyncCallback;


 public interface RegisterServiceAsync{
	
	void registerNewUser(String username, String password, String firstname, String lastname, String address, String mail, String gender, AsyncCallback<ServerResponse> callback);
	void login(String username, String password, AsyncCallback<ServerResponse> callback);
	
}
