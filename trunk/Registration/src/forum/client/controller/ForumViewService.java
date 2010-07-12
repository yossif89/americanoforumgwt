package forum.client.controller;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import forum.shared.communication.ServerResponse;


 @RemoteServiceRelativePath("regService")
public interface ForumViewService extends RemoteService{
	public ServerResponse forumView(String username);	
}
