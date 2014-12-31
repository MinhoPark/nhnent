CREATE TABLE guestbook_list(
	id integer AUTO_INCREMENT(1,1) NOT NULL,
	email character varying(255) COLLATE utf8_ko_cs ,
	[password] character varying(128) COLLATE utf8_ko_cs ,
	article character varying(4096) COLLATE utf8_ko_cs ,
	firstdate character varying(32) COLLATE utf8_ko_cs ,
	lastmodifydate character varying(32) COLLATE utf8_ko_cs 
) COLLATE utf8_bin  REUSE_OID ;

