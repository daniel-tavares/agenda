# OAUTH 2.0

## PAPEIS DO OAUTH 2.0
   
   - **Resource Owner**: 
   	   - É o usuário que faz uso do serviço.
   	   - Este precisa se autenticar antes de autorizar um client a acessar um recurso(lista de contatos) em seu nome.
   	   - Pode também ser um sistema (quando uma aplicação acessa recursos em beneficio próprio)
   
   - **Client**: 
   	   - É a aplicação para qual o Resource Owner concede privilégio. Eles podem ser publicos ou confidencais.
   	   - O Client interage com o ResourceServer para acessar um recurso do ResourceOwner
   	   - O Client interage com o AuthorizationServer para solicitar a autorização do usuário para acessar os recursos. 
   	   - O Client interage com o AuthorizationServer para solicitar um token de acesso. 
   		
   - **ResourceServer**:
   	   - É responsável por validar se o Client que esta tentando acessar os recursos do usuário tem ou não permissão de acesso.
   	   - Valida o token de acesso fornecido pelo Client.
   	   - Pode com o AuthorizationServer para solicitar informações do token no banco de dados. Se o token for autocontido não precisa se comunicar com o AuthorizationServer.
   	       
   
   - **AuthorizationServer:**
 	   - Responsável por disponibilizar tokens de acesso para o client 

   **OAuth Provider:** É o servidor de autenticação do OAUTH2. É composto pelo **ResourceServer** e **AuthorizationServer**.

   

# FLUXO BÁSICO

- **(1) Autorização: ** 
	- o ResourceOwner fornece permissão para que o Client realize operações em seu nome. 
	- O ideal é uma autorização indireta, sem que o cliente saiba o login e a senha do ResourceOwner. 
	- Utilizando em GrantType **AuthorizationCode** ou **Implicit**
	
	
- **(2) solicitação	do token de acesso: ** O Client faz uma solicitação de obtenção do token.
- **(3) utilização do token propriamente dito:** Faz uso do Bearer token para poder acessar uma API no	Resource Server.
 
         

# AUTHORIZATION SERVER

### GrandTypes
    
    Define a forma de obtenção de um token de acesso junto ao AuthorizationServer. O fluxo vai depender do tipo de cliente (aplicação web, mobile, etc). O Auth2.0 define os seguintes grant types:
     
     
   - **Authorization	Code**;
   - **Resource	Owner	Password	Credentials**;
   - **Implicit**;
   - **Client	Credentials**. 
	

### Escopos
	
	Indica o que o client pode ACESSAR ou EXECUTAR. Define os escopos que	podem ser solicitados pelo Client e	possivelmente autorizados	pelo Resource Owner.
     
   - **read**
   - **write**
   - **trust**


### Refresh Token  	
	Através do refresh token o usuário poderá solicitar um novo token de acesso quando um token, que possui tempo de vida limitado, expirar. 



 
	
## PASSOS PARA ACESSO AOS RECURSO
	

### REQUISICAO


# Resposta para token invalido

	{
			"error":	"invalid_token",
			"error_description":	"Invalid	access	token:	d91b1973-18c8-4e4a-b04e-0128feff1d04"
	}

# Resposta para token expirado

	{
		"error":	"invalid_token",
		"error_description":	"Access	token	expired:	d91b1973-18c8-4e4a-b04e-0128feff1d04"
	}	


# RECOMENDAÇÕES

  - A API REST está configurada para ser a acessível pela aplicação frontend (http://localhost:4200)
  
  - Token não deve ser exibido no log da aplicação
  
  - Faça uso do **Refresh Token** para evitar que tokens capturados indevidamente não sejam mais utilizados
  
  - Faça uso de tecnicas que evitam ataques de força bruta:
  	- **Rate limite:** limitar o numero de requisições feitas durante um intervalo de tempo.
  
  - A comunicação entre client e AuthorizationServer deve utilizar SLL/TLS	
  
  - Fazer uso de tokens autocontidos evitando com que o ResourceServer se comunique com o AuthorizationServer.
  
  - Apesar do token poder ser enviado no corpo da requisição(parâmetro de um formulário) ou como parâmetro de uma URI, o ideal é que seja enviado no Header da requisição como Bearer Token (Header Authorization do	HTTP). 
  
  - Cripitografar o token para melhorar a segurança.
  
## -------------------------------------------------------------------------------------------------------##

# APLICAÇÃO AGENDA 
   CRUD  de uma agenda de contatos com autenticação OAuth2.0 com GrantType PASSWORD.

# Tecnologias utilizadas
 - **Java spring boot**
 - **Banco de dados H2:** http://localhost:9000/h2
 - **Autenticação:** Foi utilizando o padrão OAUTH2
 - **Flyway:** Utilizado para exportar a base inicial de teste

# Requisitos
  - Ide para Java
  - Instalação do Git: https://git-scm.com/downloads
  - Intalação do Maven: https://maven.apache.org/
  
# Executando aplicação
  - Realizar o download da aplicação atraves dos comandos abaixo:
     (1) git clone https://github.com/daniel-tavares/agenda.git
     (2) cd agenda
     (3) mvn install 
  - Abra a aplicação no ide e execute o metodo main da classe (br.com.agenda.AgendaApiApplication.java)
  - Teste a aplicação: http://localhost:9000/api/v1/user (este recurso esta liberado)
  - Pronto! a aplicação será iniciada.

# Acessando banco de dados H2

  - Digite no bowser: **http://localhost:9000/h2**
  - Informe  em JDBC URL a seguinte URL: **jdbc:h2:mem:agendadb;DB_CLOSE_DELAY=-1**
  - Clique em **connect**.
  - Deverá visualizar as tabelas criadas com o flyway (TAB_USER, TAB_PERFIL, TAB_USER_PERFIL, etc...).
  

# SERVICOS 

   GET: http://localhost:9000/api/v1/contacts  (url protegida): retorna todos os contatos de um usuário
   POST: http://localhost:9000/api/v1/contacts  (url protegida): cadastra um contato
   DELETE http://localhost:9000/api/v1/contacts/{id}  (url protegida): deleta um contato
   PUT http://localhost:9000/api/v1/contacts  (url protegida): atualiza um contato  



## PASSOS PARA AUTENTICAÇÃO

### 

#### Solicitação de token

	REQUISIÇÃO: HTTP POST:	http://localhost:8080/oauth/token
    
    Dados da Requisição:
    
    - **Corpo da requisição:** deverá ser passado os dados do usuário. 
	   
	   {
	      **"grant_type"**: "password",
	   	  **"username"**: "user@gmail.com",
	   	  **"password"**: "user",
	      **"scope (opcional)"**: "read write trust" 
	   }  
   
    - **Header da requisição:** por autenticação básica- Basic Authentication(username e password), deverá ser passada a identificação do Client registrado no AuthorizationServer. 
	  
	  - **cliente_id:** agenda_client_233668646673605 (usename)
	  - **client_secret:**  secret_56ytr4e3iujhgtd56789 (password)
        
        Após a codificação: Authorization Basic YWdlbmRhX2NsaWVudF8yMzM2Njg2NDY2NzM2MDU6c2VjcmV0XzU2eXRyNGUzaXVqaGd0ZDU2Nzg5

    Resposta	
	
	
		{
		    **"access_token"**: "447706c4-ba66-477d-bbda-178004bd3ed6",
		    **"token_type"**: "bearer",
		    **"refresh_token"**: "9c4ea383-5f8d-4e15-845e-7e3637a1a170",
		    **"expires_in"**: 3599,
		    **"scope"**:"read write trust"
		}
	
	
  	* Após 360 segundos o access_token expirará e será necessário realizar uma atualização do token(refreshToken)
  
  
### Refresh Token     	
	
	REQUISIÇÃO:	HTTP POST: http://localhost:8080/oauth/token
	
	Dados da requisição
		  
	   {
	      **"grant_type"**: "refresh_token",
	   	  **"refresh_token"**: "user@gmail.com",
	      **"scope (opcional)"**: "read write trust" 
	   }  

## TABELAS OAUTH2

  - **oauth_client_details**: 
  		Contém os	dados do Client	como **client_id**,	**client_secret** e redirect_url.

  - **oauth_access_token**:	
   		Contém os access tokens gerados	para cada Client, sendo indicado que os	tokens sejam armazenados 
  		de	maneira criptografada.

  - **oauth_client_token:**:
  		Tabela	que	relaciona	o	Client	com	os	tokens.
  		
  - **oauth_refresh_token**: 
        Armazena	os	dados	relacionados	aos	refresh	tokens	gerados	para o Client.
  
  - **oauth_code**:
  		Mantém	no	banco	de	dados	o	authorization_code	gerado	a	partir do	grant	type	Authorization	Code,	para	ser	utilizado
posteriormente	na	etapa	de	solicitação	de	token.

   - **oauth_approvals**:
  		Mantém	registro	de	todas	as	aprovações	que	o	Resource	Owner
deu	para	cada	Client.	Para	que	essa	tabela	seja	usada,	é	preciso
configurar	um	JdbcApprovalStore.
		
		