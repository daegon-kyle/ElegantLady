class LoginCheckController 
{
	private boolean state;
	
	public LoginCheckController()
	{
		state = LoginInfo.getLoginState();
	}
	public boolean loginCheck()
	{
		if(state == true)
			return true;
		else
			return false;
	}
}
