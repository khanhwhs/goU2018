SELECT * from TRIP t where STR_TO_DATE(t.CREATED_ON,'%Y-%m-%d') >= CURDATE() -7