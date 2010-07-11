package forum.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import forum.shared.communication.ServerResponse;


public interface RegisterServiceAsync {

	void registerNewUser(String username, String password, String firstname,
			String lastname, String address, String mail, String gender,
			AsyncCallback<ServerResponse> callback);

}
