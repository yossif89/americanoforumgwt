package forum.client.controller;

import forum.shared.communication.ServerResponse;
import com.google.gwt.user.client.rpc.AsyncCallback;


 public interface ForumViewServiceAsync{
	public void forumView(String username, AsyncCallback<ServerResponse> callback);	
}
