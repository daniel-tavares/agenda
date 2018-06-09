INSERT INTO TAB_USER (
	id, 
        name,
	username, 
	password,
        access_token,
	enabled
) VALUES(1,'usuario','user@gmail.com','$2a$10$Sq/2n.lgCefyNbdm44Ua3.aTKeEu2c0OnHSjyRsdXKXIwNr1UGlnS',null,true);


INSERT INTO TAB_USER (
	id,
        name,  
	username, 
	password,
	access_token,
	enabled) 
 VALUES(2,'administrador','admin@gmail.com','$2a$10$K89KLguscILlzuIk.jU1meGiaL5ThsLI.2VtSxGJdPbcl/YYA/bzG',null,true);

INSERT INTO TAB_PROFILE (id, name) VALUES(1,'ROLE_USER');
INSERT INTO TAB_PROFILE (id, name) VALUES(2,'ROLE_ADMIN');

INSERT INTO TAB_USER_PROFILE values(1,1);
INSERT INTO TAB_USER_PROFILE values(2,1);
INSERT INTO TAB_USER_PROFILE values(2,2);

INSERT INTO TAB_CONTACT (id, name, email, home_phone, cell_phone,fk_id_user) VALUES (1, 'Usuario Padrão','userpadrao@gmail.com','91323616676','9188876543',1);


