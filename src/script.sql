ALTER TABLE newdb.portata MODIFY COLUMN menu_id int NULL;
ALTER TABLE newdb.menu ADD portata_id int NULL;
ALTER TABLE newdb.menu ADD CONSTRAINT menu_FK FOREIGN KEY (portata_id) REFERENCES newdb.portata(portata_id);

