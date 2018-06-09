INSERT INTO oauth_client_details (
 client_id,
 resource_ids,	
 client_secret,	
 scope,	
 authorized_grant_types,
 web_server_redirect_uri,
 authorities,	
 access_token_validity,	
 refresh_token_validity,
 additional_information,
 autoapprove)	
VALUES	
 ('agenda_client_233668646673605',
  'agenda_app',
  'secret_56ytr4e3iujhgtd56789',
  'read,write',	
  'password,refresh_token',
  'http://localhost:9000/callback',
  'ROLE_USER',
   3000,
   -1,	
   NULL,	
  'false')

