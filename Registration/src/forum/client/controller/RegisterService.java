package forum.client.controller;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import forum.shared.communication.ServerResponse;


 @RemoteServiceRelativePath("regService")
public interface RegisterService extends RemoteService{
	
	ServerResponse registerNewUser(String username, String password, String firstname, String lastname, String address, String mail, String gender);
	ServerResponse login(String username, String password);
	
}
