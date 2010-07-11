package forum.shared.communication;

import java.io.Serializable;


/**
 *
 * @author Ilya
 */
public  class ServerResponse implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4096896997221736815L;
	
	private String _response;
	private Exception _ex;
	private boolean _executed;

	public ServerResponse() {
		this._response = "";
		this._executed = false;
		this._ex = null;
	}

	public String getResponse() {
		return _response;
	}

	public boolean hasExecuted() {
		return _executed;
	}


	public void setResponse(String _response) {
		this._response = _response;
		this._executed = true;
	}

	public void setEx(Exception _ex) {
		this._ex = _ex;
	}

	public Exception getEx() {
		return _ex;
	}
}
