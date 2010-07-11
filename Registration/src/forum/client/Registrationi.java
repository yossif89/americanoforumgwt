package forum.client;



import forum.server.persistencelayer.main;
import forum.shared.communication.ServerResponse;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.NamedFrame;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.FormPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Registrationi implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	
	/**
	 * for creating the connection with the domain layer
	 */
	private RegisterServiceAsync registerSvc = GWT.create(RegisterService.class);
	
//	/**
//	 * error label for registration failure. 
//	 */
//	private Label errorMsgLabel = new Label();
	


	@Override
	public void onModuleLoad() {
		final VerticalPanel mainPanel = new VerticalPanel();
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		mainPanel.add(horizontalPanel);
		horizontalPanel.setSize("558px", "33px");
		
		Button button = new Button("New button");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				registrationWindow();
			}
		});
		button.setText("Register");
		horizontalPanel.add(button);
		
		Button button_1 = new Button("New button");
		button_1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				loginWindow();
			}
		});
		button_1.setText("Login");
		horizontalPanel.add(button_1);
		
		Button button_2 = new Button("New button");
		button_2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				logoff();
			}
		});
		button_2.setText("Logoff");
		horizontalPanel.add(button_2);
		
		Button button_3 = new Button("New button");
		button_3.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				searchWindow();
			}
		});
		button_3.setText("Search");
		horizontalPanel.add(button_3);
		
		RootPanel.get("frameContainer").add(mainPanel);
		
		
				
	}


	public void searchWindow() {
		final VerticalPanel mainPanel = new VerticalPanel();
		
		final TextBox phraseField = new TextBox();
		final Label phraseLabel = new Label("Phrase:   ");
		
		final TextBox fromField = new TextBox();
		final Label fromLabel = new Label("From:   ");
		
		final TextBox toField = new TextBox();
		final Label toLabel = new Label("To:   ");
		
		final Label searchLabel = new Label("Search By:   ");
		final RadioButton contentRadio = new RadioButton("searchBy","Content");
		final RadioButton authorRadio = new RadioButton("searchBy","Author");
		contentRadio.setEnabled(true);
		
		final Button searchButton = new Button("Search");
		final Button cancelButton = new Button("Cancel");
		
		final DialogBox searchDialog = new DialogBox();
		searchDialog.setText("Search Form");
	
		HTMLTable phraseTable = new Grid(1,2);
		HTMLTable fromToTable = new Grid(1,4);
		HTMLTable searchByTable = new Grid(1,3);
		HTMLTable actionTable = new Grid(1,2);
		
		phraseTable.setWidget(0, 0, phraseLabel);
		phraseTable.setWidget(0, 1, phraseField);
		
		fromToTable.setWidget(0, 0, fromLabel);
		fromToTable.setWidget(0, 1, fromField);
		fromToTable.setWidget(0, 2, toLabel);
		fromToTable.setWidget(0, 3, toField);
		
		searchByTable.setWidget(0, 0, searchLabel);
		searchByTable.setWidget(0, 1, authorRadio);
		searchByTable.setWidget(0, 2, contentRadio);
		
		actionTable.setWidget(0, 0, searchButton);
		actionTable.setWidget(0, 1, cancelButton);
		
		mainPanel.add(phraseTable);
		mainPanel.add(fromToTable);
		mainPanel.add(searchByTable);
		mainPanel.add(actionTable);

		searchDialog.setWidget(mainPanel);
		
		searchButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				//search!
			}
		});
		
		cancelButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				searchDialog.hide();
				searchDialog.clear();
			}
		});
		
		searchDialog.center();
		searchDialog.show();
	}
	
	public void logoff(){
		//needs to do logoff
	}
	
	public void loginWindow(){
		HTMLTable loginTable = new Grid(3,2);
		final TextBox usernameField = new TextBox();
		final Label usernameLabel = new Label("User name:   ");
		
		final PasswordTextBox passwordField = new PasswordTextBox();
		final Label passLabel = new Label("Password:   ");
		
		final Button loginButton = new Button("Login");
		final Button cancelButton = new Button("Cancel");
		
		loginTable.setCellSpacing(5);
		
		loginTable.setWidget(0, 0, usernameLabel);
		loginTable.setWidget(0, 1, usernameField);
		
		loginTable.setWidget(1, 0, passLabel);
		loginTable.setWidget(1, 1, passwordField);
		
		loginTable.setWidget(2, 0, loginButton);
		loginTable.setWidget(2, 1, cancelButton);
		
		final DialogBox loginDialog = new DialogBox();
		loginDialog.setText("Login Form");
		loginDialog.setWidget(loginTable);	
		
		
		loginButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				
				//login(username, password, firstname, lastname, address, mail, gender);
			}
			
		});
		
		cancelButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				loginDialog.hide();
				loginDialog.clear();
			}
		});
		
		loginDialog.center();
		loginDialog.show();

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void registrationWindow() {
		
		//final VerticalPanel mainPanel = new VerticalPanel();
		
		final HorizontalPanel firstPanel = new HorizontalPanel();
		
		final HorizontalPanel secondPanel = new HorizontalPanel();
		
		final HorizontalPanel usernamePanel = new HorizontalPanel();
		
		final HorizontalPanel passPanel = new HorizontalPanel();
		
		final HorizontalPanel addressPanel = new HorizontalPanel();
		
		final HorizontalPanel mailPanel = new HorizontalPanel();
		
		final HorizontalPanel genderPanel = new HorizontalPanel();
		
		
		final TextBox nameField = new TextBox();
		final Label firstNameLabel = new Label("First name:   ");
		
		final TextBox lastField = new TextBox();
		final Label lastNameLabel = new Label("Last name:   ");
		
		final TextBox usernameField = new TextBox();
		final Label usernameLabel = new Label("User name:   ");
		
		final PasswordTextBox passwordField = new PasswordTextBox();
		final Label passLabel = new Label("Password:   ");
		
		final TextBox addressField = new TextBox();
		final Label addressLabel = new Label("Address:   ");
		
		final TextBox mailField = new TextBox();
		mailField.setText("@");
		final Label mailLabel = new Label("Mail Address:   ");
		
		final RadioButton male = new RadioButton("gender","male");
		final RadioButton female = new RadioButton("gender","female");
		
		final Button registerButton = new Button("Register");
		final Button cancelButton = new Button("Cancel");
		
		
		male.setEnabled(true);
		
		HTMLTable table = new Grid(8,2);
		
//		errorMsgLabel.setStyleName("errorMessage");
//	    errorMsgLabel.setVisible(false);
//
//	    mainPanel.add(errorMsgLabel);

		
		
		table.setCellSpacing(5);
		
		table.setWidget(0, 0, firstNameLabel);
		table.setWidget(0, 1, nameField);
		
		table.setWidget(1, 0, lastNameLabel);
		table.setWidget(1, 1, lastField);
		
		table.setWidget(2, 0, usernameLabel);
		table.setWidget(2, 1, usernameField);
		
		table.setWidget(3, 0, passLabel);
		table.setWidget(3, 1, passwordField);
		
		table.setWidget(4, 0, addressLabel);
		table.setWidget(4, 1, addressField);
		
		table.setWidget(5, 0, mailLabel);
		table.setWidget(5, 1, mailField);
		
		table.setWidget(6, 0, male);
		table.setWidget(6, 1, female);
		
		table.setWidget(7, 0, registerButton);
		table.setWidget(7, 1, cancelButton);
		
		
		
	
//		firstPanel.setHorizontalAlignment(mainPanel.ALIGN_CENTER);
//		firstPanel.add(firstNameLabel);
//		firstPanel.add(nameField);
//		firstPanel.setSpacing(10);
//		
//		secondPanel.setHorizontalAlignment(mainPanel.ALIGN_CENTER);
//		secondPanel.add(lastNameLabel);
//		secondPanel.add(lastField);
//		secondPanel.setSpacing(10);
//		
//		usernamePanel.setHorizontalAlignment(mainPanel.ALIGN_CENTER);
//		usernamePanel.add(usernameLabel);
//		usernamePanel.add(usernameField);
//		usernamePanel.setSpacing(10);
//		
//		passPanel.setHorizontalAlignment(mainPanel.ALIGN_CENTER);
//		passPanel.add(passLabel);
//		passPanel.add(passwordField);
//		passPanel.setSpacing(13);
//
//		addressPanel.setHorizontalAlignment(mainPanel.ALIGN_CENTER);
//		addressPanel.add(addressLabel);
//		addressPanel.add(addressField);
//		addressPanel.setSpacing(17);
//		
//		mailPanel.setHorizontalAlignment(mainPanel.ALIGN_CENTER);
//		mailPanel.add(mailLabel);
//		mailPanel.add(mailField);
//		mailPanel.setSpacing(10);
//
//		secondPanel.setHorizontalAlignment(mainPanel.ALIGN_CENTER);
//		secondPanel.add(lastNameLabel);
//		secondPanel.add(lastField);
//		secondPanel.setSpacing(8);
//		
//		
//		mainPanel.add(firstPanel);
//		mainPanel.add(secondPanel);
//		mainPanel.add(usernamePanel);
//		mainPanel.add(passPanel);
//		mainPanel.add(addressPanel);
//		mainPanel.add(mailPanel);



		//RootPanel.get("frameContainer").add(table);
		final DialogBox registrationDialog = new DialogBox();
		registrationDialog.setText("Registration Form");
		registrationDialog.setWidget(table);	
		
		
		registerButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				String firstname = nameField.getText();
				String lastname = lastField.getText();
				String address = addressField.getText();
				String mail = mailField.getText();
				String gender="";
				if (male.getValue()){
					gender="male";
				}
				else{
					if(female.getValue()){
						gender = "female";
					}
					else{
						//may god be with us
					}
				}
				
				register(username, password, firstname, lastname, address, mail, gender);				
			}
			
		});
		
		cancelButton.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				registrationDialog.hide();
				registrationDialog.clear();
			}
		});
		
		registrationDialog.center();
		registrationDialog.show();
//		final Button sendButton = new Button("Send");
//		final TextBox nameField = new TextBox();
//		nameField.setText("GWT User");
//		final Label errorLabel = new Label();
//
//		// We can add style names to widgets
//		sendButton.addStyleName("sendButton");
//
//		// Add the nameField and sendButton to the RootPanel
//		// Use RootPanel.get() to get the entire body element
//		RootPanel.get("nameFieldContainer").add(nameField);
//		RootPanel.get("sendButtonContainer").add(sendButton);
//		RootPanel.get("errorLabelContainer").add(errorLabel);
//
//		// Focus the cursor on the name field when the app loads
//		nameField.setFocus(true);
//		nameField.selectAll();
//
//		// Create the popup dialog box
//		final DialogBox dialogBox = new DialogBox();
//		dialogBox.setText("Remote Procedure Call");
//		dialogBox.setAnimationEnabled(true);
//		final Button closeButton = new Button("Close");
//		// We can set the id of a widget by accessing its Element
//		closeButton.getElement().setId("closeButton");
//		final Label textToServerLabel = new Label();
//		final HTML serverResponseLabel = new HTML();
//		VerticalPanel dialogVPanel = new VerticalPanel();
//		dialogVPanel.addStyleName("dialogVPanel");
//		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
//		dialogVPanel.add(textToServerLabel);
//		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
//		dialogVPanel.add(serverResponseLabel);
//		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
//		dialogVPanel.add(closeButton);
//		dialogBox.setWidget(dialogVPanel);
//
//		// Add a handler to close the DialogBox
//		closeButton.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				dialogBox.hide();
//				sendButton.setEnabled(true);
//				sendButton.setFocus(true);
//			}
//		});
//
//		// Create a handler for the sendButton and nameField
//		class MyHandler implements ClickHandler, KeyUpHandler {
//			/**
//			 * Fired when the user clicks on the sendButton.
//			 */
//			public void onClick(ClickEvent event) {
//				sendNameToServer();
//			}
//
//			/**
//			 * Fired when the user types in the nameField.
//			 */
//			public void onKeyUp(KeyUpEvent event) {
//				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
//					sendNameToServer();
//				}
//			}
//
//			/**
//			 * Send the name from the nameField to the server and wait for a response.
//			 */
//			private void sendNameToServer() {
//				// First, we validate the input.
//				errorLabel.setText("");
//				String textToServer = nameField.getText();
//				if (!FieldVerifier.isValidName(textToServer)){
//					errorLabel.setText("Please enter at least four characters");
//					return;
//				}
//
//				// Then, we send the input to the server.
//				sendButton.setEnabled(false);
//				textToServerLabel.setText(textToServer);
//				serverResponseLabel.setText("");
//				greetingService.greetServer(textToServer,
//						new AsyncCallback<String>() {
//							public void onFailure(Throwable caught) {
//								// Show the RPC error message to the user
//								dialogBox
//										.setText("Remote Procedure Call - Failure");
//								serverResponseLabel
//										.addStyleName("serverResponseLabelError");
//								serverResponseLabel.setHTML(SERVER_ERROR);
//								dialogBox.center();
//								closeButton.setFocus(true);
//							}
//
//							public void onSuccess(String result) {
//								dialogBox.setText("Remote Procedure Call");
//								serverResponseLabel
//										.removeStyleName("serverResponseLabelError");
//								serverResponseLabel.setHTML(result);
//								dialogBox.center();
//								closeButton.setFocus(true);
//							}
//						});
//			}
//		}
//
//		// Add a handler to send the name to the server
//		MyHandler handler = new MyHandler();
//		sendButton.addClickHandler(handler);
//		nameField.addKeyUpHandler(handler);
	}
	
	private void register(String username,String password,String firstname,String lastname,String address,String mail,String gender){
		//init the service proxy
		if(registerSvc == null){
			registerSvc = GWT.create(RegisterService.class);
		}
		
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
				Button button = new Button("close",listener);
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
					Button button = new Button("close",listener);
					VerticalPanel DialogBoxContents = new VerticalPanel();
					
					DialogBoxContents.add(message);
					DialogBoxContents.add(button);
					dialogBox.setWidget(DialogBoxContents);
					dialogBox.center();	
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
					Button button = new Button("close",listener);
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
}
