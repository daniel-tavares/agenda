package br.com.agenda.security;

public abstract class SecurityConstants {
	public static final String RESOURCE_ID = "agenda_app";
	public static final String CLIENT_ID = "agenda_client_233668646673605";
	public static final String CLIENT_SECRET = "secret_56ytr4e3iujhgtd56789";
	public static final String GRANT_TYPE_PASSWORD = "password";
	public static final String AUTHORIZATION_CODE = "authorization_code";
	public static final String REFRESH_TOKEN = "refresh_token";
	public  static final String IMPLICIT = "implicit";
	public static final String SCOPE_READ = "read";
	public static final String SCOPE_WRITE = "write";
	public  static final String TRUST = "trust";
	public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1*60*60;
	public  static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6*60*60;
	public static final String API_ROOT_URL = "/**";
    public static final String ALLOWED_ORIGIN = "*";
    public static final String ALLOWED_HEADER = "*";
    
    public static final String ACCESS_DENIED = "Acesso negado. Você deve estar logado para acessar o URL solicitado.";
		
}
