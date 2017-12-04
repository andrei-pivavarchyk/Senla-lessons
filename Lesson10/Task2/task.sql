use somedevices;


/*Задание 1*/
SELECT model,speed,hd

FROM pc

WHERE price>500;

/*Задание 2*/

SELECT maker

FROM product

WHERE type='printer';

/*Задание 3*/

SELECT model,hd, screen

FROM laptop

WHERE price>1000;

/*Задание 4*/

SELECT*FROM printer

WHERE color='y';

/*Задание 5*/

SELECT model,speed,hd

FROM pc

WHERE cd='12x' OR cd='24x';


/*Задание 6*/
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
Задание 14  условие не понятно
*/

SELECT speed,AVG(price)
FROM pc
GROUP BY speed

/*
Задание 15  условие не понятно
*/

SELECT hd 
FROM pc

group by hd

HAVING COUNT(model)>=2

/*Задание 16*/

SELECT DISTINCT A.model, B.model, A.speed,A.ram
FROM pc AS A,pc AS B
WHERE A.speed=B.speed AND A.ram=B.ram AND A.model>B.model

/*Задание 17*/
SELECT DISTINCT product.type,laptop.model,laptop.speed
FROM product,laptop
WHERE laptop.speed<ANY
(SELECT MIN(speed) FROM pc)
AND product.model=laptop.model

/*Задание 18*/
SELECT DISTINCT maker,price
FROM product,printer
WHERE printer.color='y'
AND product.model=printer.model
AND printer.price=
(SELECT MIN(price)
FROM printer
WHERE color='y'
)

/*Задание 19*/
SELECT maker,AVG(screen)
FROM product
INNER JOIN
laptop 
ON laptop.model=product.model
GROUP BY maker

/*Задание 20*/
SELECT maker, COUNT(model)
FROM product
WHERE product.type='pc'
GROUP BY maker
HAVING COUNT(DISTINCT model)>=3


/*Задание 21*/
SELECT product.maker,MAX(pc.price)
FROM product,pc
WHERE product.model=pc.model
GROUP BY maker


/*Задание 22*/
SELECT speed,AVG(price)
FROM pc
WHERE speed>600
GROUP BY speed

/*Задание 23*/
SELECT maker
FROM product,pc
WHERE pc.speed>=750 AND product.model=pc.model
INTERSECT
SELECT maker
FROM product,laptop
WHERE laptop.speed>=750 AND product.model=laptop.model

/*Задание 24*/








