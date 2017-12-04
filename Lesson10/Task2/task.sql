use somedevices;



SELECT model,speed,hd

FROM pc

WHERE price>500;

SELECT maker

FROM product

WHERE type='printer';

SELECT model,hd, screen

FROM laptop

WHERE price>1000;

SELECT*FROM printer

WHERE color='y';

SELECT model,speed,hd

FROM pc

WHERE cd='12x' OR cd='24x';

SELECT model,speed,hd

FROM pc

WHERE (cd='4x' OR cd='5x') AND price<600;

SELECT maker,type,speed

FROM product,laptop

WHERE product.model=laptop.model AND laptop.hd>10;

/*
Задание 7
*/
SELECT model, price 
FROM PC 
WHERE model IN (SELECT model 
 FROM Product 
 WHERE maker = 'firstm' AND 
 type = 'PC'
 )
UNION
SELECT model, price 
FROM Laptop 
WHERE model IN (SELECT model 
 FROM Product 
 WHERE maker = 'firstm' AND 
 type = 'Laptop'
 )
UNION
SELECT model, price 
FROM Printer 
WHERE model IN (SELECT model 
 FROM Product 
 WHERE maker = 'firstm' AND 
 type = 'Printer'
)
