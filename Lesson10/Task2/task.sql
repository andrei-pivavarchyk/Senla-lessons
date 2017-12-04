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
/*
Задание 8  не работает ???
*/

SELECT DISTINCT maker 
FROM product 
WHERE type = 'pc' 
EXCEPT 
SELECT DISTINCT maker 
FROM product 
Where type = 'laptop'

/*
Задание 9 
*/

SELECT DISTINCT maker 
FROM product
INNER JOIN
pc ON product.model=pc.model
WHERE pc.speed>=450

/*
Задание 10
*/

SELECT model,price
FROM printer
WHERE price=(SELECT MAX(price) FROM printer)

/*
Задание 11
*/

SELECT AVG(speed)
FROM pc

/*
Задание 12
*/

SELECT AVG(speed)
FROM laptop
WHERE laptop.price>1000

/*
Задание 13
*/

SELECT AVG(pc.speed) 
FROM pc, product 
WHERE pc.model = product.model AND product.maker = 'firstm'

/*
Задание 14
*/









