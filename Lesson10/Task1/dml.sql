use somedevices

INSERT INTO product ( maker, model,type ) VALUES
( 'firstm',0001,'pc'),
( 'secondm',0002,'laptop'),
( 'thirdm',0003,'printer'),
( 'firstm',0004,'pc'),
( 'secondm',0005,'laptop'),
( 'firstm',0006,'printer'),
( 'thirdm',0007,'pc'),
( 'secondm',0008,'laptop'),
( 'thirdm',0009,'printer'),
( 'firstm',0010,'pc'),
( 'secondm',0011,'laptop'),
( 'firstm',0012,'printer'),
( 'secondm',0013,'pc'),
( 'thirdm',0014,'laptop'),
( 'thirdm',0015,'printer'),
( 'firstm',0016,'pc'),
( 'secondm',0017,'laptop');



INSERT INTO pc ( model,speed,ram,hd,cd,price ) VALUES
( 0001,1600,2000,100,'4x',200),
( 0004,1700,3000,200,'5x',300),
( 0007,1800,3500,300,'6x',400),
( 0010,1900,3600,400,'7x',500),
( 0013,2000,3700,500,'8x',600),
( 0016,2100,3800,600,'9x',700);



INSERT INTO laptop ( model,speed,ram,hd,price,screen) VALUES
( 0002,1600,2000,100,100,14),
( 0005,1700,3000,200,200,17),
( 0008,1800,3500,300,300,21),
( 0011,1900,3600,400,400,25),
( 0014,2000,3700,500,500,26),
( 0017,2100,3800,600,600,32);

INSERT INTO printer ( model,color,type,price) VALUES
( 0003,'y','Laser',100),
( 0006,'n','Jet',200),
( 0009,'y','Matrix',300),
( 0012,'n','Laser',400),
( 0015,'y','Jet',500);
