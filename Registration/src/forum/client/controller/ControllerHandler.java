package forum.client.controller;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import forum.shared.communication.ServerResponse;


public class ControllerHandler {
	
	/**
	 * for creating the connection with the domain layer
	 */
	protected static RegisterServiceAsync registerSvc;
	

	public ControllerHandler() {
		registerSvc = GWT.create(RegisterService.class);
	}

	public void registerNewUser(String username, String password,
			String firstname, String lastname, String address, String mail,
			String gender, AsyncCallback<ServerResponse> callback) {
		registerSvc.registerNewUser(username, password, firstname, lastname, address, mail, gender, callback);
	}
}