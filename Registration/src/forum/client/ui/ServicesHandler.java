package forum.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

import forum.client.controller.RegisterService;
import forum.client.controller.RegisterServiceAsync;
import forum.shared.communication.ServerResponse;


public class ServicesHandler {
	
	/**
	 * for creating the connection with the domain layer
	 */
	protected static RegisterServiceAsync registerSvc;
	private String curr_username = "";
	
	public String getCurr_username() {
		return curr_username;
	}

	public void setCurr_username(String curr_username) {
		this.curr_username = curr_username;
	}

	public ServicesHandler() {
		registerSvc = GWT.create(RegisterService.class);
	}
	
	public void register(String username,String password,String firstname,String lastname,String address,String mail,String gender){
		//init the service proxy
	//	if(controllerHandler.registerSvc == null){
	//		controllerHandler.registerSvc = GWT.create(RegisterService.class);
	//	}
		
		//set up the callback object
		AsyncCallback<ServerResponse> callback = new AsyncCallback<ServerResponse>(){

			@Override
			public void onFailure(Throwable caught) {
				final DialogBox dialogBox = new DialogBox(false);
				//dialogBox.setStyleName("registrationError-DialogBox");
				dialogBox.setText("Error");
				dialogBox.setAnimationEnabled(true);
				dialogBox.setGlassEnabled(false);
				HTML message = new HTML("Error while registrating: "+caught.getMessage());
				message.setStyleName("registrationError-DialogBox-message");
				ClickHandler listener = new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						dialogBox.hide();
						dialogBox.removeFromParent();
					}
				};
				Button button = new Button("Close",listener);
				VerticalPanel DialogBoxContents = new VerticalPanel();
				
				DialogBoxContents.add(message);
				DialogBoxContents.add(button);
				dialogBox.setWidget(DialogBoxContents);
				dialogBox.center();
				
			}

			@Override
			public void onSuccess(ServerResponse result) {
				if((result.hasExecuted()) && (!result.getResponse().equals(""))){
					final DialogBox dialogBox = new DialogBox(false);
					//dialogBox.setStyleName("registrationSuccess-DialogBox");
					dialogBox.setText("Information");
					dialogBox.setAnimationEnabled(true);
					dialogBox.setGlassEnabled(false);
					HTML message = new HTML("Registration completed!");
					message.setStyleName("registrationSuccess-DialogBox-message");
					ClickHandler listener = new ClickHandler(){
						@Override
						public void onClick(ClickEvent event) {
							dialogBox.hide();
							dialogBox.removeFromParent();
						}
					};
					Button button = new Button("Close",listener);
					VerticalPanel DialogBoxContents = new VerticalPanel();
					
					DialogBoxContents.add(message);
					DialogBoxContents.add(button);
					dialogBox.setWidget(DialogBoxContents);
					dialogBox.center();	
					setCurr_username(result.getResponse());
				}
				
				else{
					final DialogBox dialogBox = new DialogBox(false);
					//dialogBox.setStyleName("registrationError-DialogBox");
					dialogBox.setText("Error");
					dialogBox.setAnimationEnabled(true);
					dialogBox.setGlassEnabled(false);
					HTML message = new HTML("Error while registrating: "+result.getEx().getMessage());
					message.setStyleName("registrationError-DialogBox-message");
					ClickHandler listener = new ClickHandler(){
						@Override
						public void onClick(ClickEvent event) {
							dialogBox.hide();
							dialogBox.removeFromParent();
						}
					};
					Button button = new Button("Close",listener);
					VerticalPanel DialogBoxContents = new VerticalPanel();
					
					DialogBoxContents.add(message);
					DialogBoxContents.add(button);
					dialogBox.setWidget(DialogBoxContents);
					dialogBox.center();
				}
			}
			
		};
		
		registerSvc.registerNewUser(username, password, firstname, lastname, address, mail, gender, callback);
	}
	
	public void login(String username, String password){
		AsyncCallback<ServerResponse> callback = new AsyncCallback<ServerResponse>(){

			@Override
			public void onFailure(Throwable caught) {
				final DialogBox dialogBox = new DialogBox(false);
				//dialogBox.setStyleName("registrationError-DialogBox");
				dialogBox.setText("Error");
				dialogBox.setAnimationEnabled(true);
				dialogBox.setGlassEnabled(false);
				HTML message = new HTML("Error while loging in: "+caught.getMessage());
				message.setStyleName("loginError-DialogBox-message");
				ClickHandler listener = new ClickHandler(){
					@Override
					public void onClick(ClickEvent event) {
						dialogBox.hide();
						dialogBox.removeFromParent();
					}
				};
				Button button = new Button("Close",listener);
				VerticalPanel DialogBoxContents = new VerticalPanel();
				
				DialogBoxContents.add(message);
				DialogBoxContents.add(button);
				dialogBox.setWidget(DialogBoxContents);
				dialogBox.center();
			}

			@Override
			public void onSuccess(ServerResponse result) {
				if((result.hasExecuted()) && (!result.getResponse().equals(""))){
					final DialogBox dialogBox = new DialogBox(false);
					//dialogBox.setStyleName("registrationSuccess-DialogBox");
					dialogBox.setText("Information");
					dialogBox.setAnimationEnabled(true);
					dialogBox.setGlassEnabled(false);
					HTML message = new HTML("You have successfully logged in!");
					message.setStyleName("loginSuccess-DialogBox-message");
					ClickHandler listener = new ClickHandler(){
						@Override
						public void onClick(ClickEvent event) {
							dialogBox.hide();
							dialogBox.removeFromParent();
						}
					};
					Button button = new Button("Close",listener);
					VerticalPanel DialogBoxContents = new VerticalPanel();
					
					DialogBoxContents.add(message);
					DialogBoxContents.add(button);
					dialogBox.setWidget(DialogBoxContents);
					dialogBox.center();	
					setCurr_username(result.getResponse());
				}
				else{
					final DialogBox dialogBox = new DialogBox(false);
					//dialogBox.setStyleName("registrationError-DialogBox");
					dialogBox.setText("Error");
					dialogBox.setAnimationEnabled(true);
					dialogBox.setGlassEnabled(false);
					HTML message = new HTML("Error while loging in: "+result.getEx().getMessage());
					message.setStyleName("loginError-DialogBox-message");
					ClickHandler listener = new ClickHandler(){
						@Override
						public void onClick(ClickEvent event) {
							dialogBox.hide();
							dialogBox.removeFromParent();
						}
					};
					Button button = new Button("Close",listener);
					VerticalPanel DialogBoxContents = new VerticalPanel();
					
					DialogBoxContents.add(message);
					DialogBoxContents.add(button);
					dialogBox.setWidget(DialogBoxContents);
					dialogBox.center();
				}
			}
			
		};
		
		registerSvc.login(username, password, callback);
	}
}