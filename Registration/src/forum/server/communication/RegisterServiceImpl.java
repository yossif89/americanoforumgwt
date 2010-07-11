package forum.server.communication;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import forum.client.RegisterService;
import forum.server.domainlayer.ForumFacade;
import forum.server.domainlayer.ForumFacadeImpl;
import forum.shared.communication.ServerResponse;

public class RegisterServiceImpl extends RemoteServiceServlet implements
		RegisterService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5986836682502712055L;

	@Override
	public ServerResponse registerNewUser(String username, String password,
			String first, String last, String address, String email,
			String gender) {
		
		ForumFacade forum = ForumFacadeImpl.getInstance();
		ServerResponse res = forum.register(username, password, email, first, last, address, gender);
		
		return res;
		
	}

}
