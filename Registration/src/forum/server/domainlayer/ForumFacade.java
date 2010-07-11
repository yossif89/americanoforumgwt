package forum.server.domainlayer;

import org.compass.core.CompassHit;

import forum.shared.communication.ServerResponse;

/**
 * With this interface the Controller layer of the server communicates with the
 * domain layer of the server.  
 * 
 * @author 
 */
public interface ForumFacade {
	
               ServerResponse viewForum();
               ServerResponse addMessage(String aSubj,String aCont,String u);
               ServerResponse login(String user,String pass);
               ServerResponse logoff(String u);
               ServerResponse register(String username,String password,String email,String first,String last , String address,String gender);
               ServerResponse deleteMessage(long id,String u);
               ServerResponse promoteMessage(String u, String a);
               ServerResponse modifyMessage(long messageId,String cont,String u) ;
               ServerResponse reply(String subj,String cont,String u , long id);
               ServerResponse searchByAuthor(String username, int from, int to);
               ServerResponse searchByContent(String toSearch, int from, int to);
               String encode_msgs(CompassHit[] msgs); //for decoding the msgs returning to the cliend
               ServerResponse encode_allUsers();
}
