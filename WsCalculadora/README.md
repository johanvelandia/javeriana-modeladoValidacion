# RestCalculator


Creaci�n de un sevicio calculadora utilizando cualquier plataforma/framework de servicios bajos los sigueintes requisitos:
El servicio debe ser creado bajo los principios de REST
El servicio debe ser desplegado en un contenedor Docker
El recurso principal debe porder ser accedido desde la maquina host que corre el proceso Docker como: http://localhost:7593/api/v1/calculator
La calculadora va a soportar las cuatro operaciones b�sicas como recursos
http://localhost:7593/api/v1/calculator/add/
http://localhost:7593/api/v1/calculator/subs/
http://localhost:7593/api/v1/calculator/mult/
http://localhost:7593/api/v1/calculator/div/
Al utilizar una operaci�n, los par�metros se env�aran como parte del path, por ejemplo
http://localhost:7593/api/v1/calculator/add/2/-1
Se debe tener en cuenta que los n�meros pueden tener signo
Los n�meros en el path no tienen l�mite
http://localhost:7593/api/v1/calculator/mult/3/3/8/-5/-2


Para correr desde docker: 

docker pull jvelandia/modeladoarquitectura:v1

docker run -p 7593:8080 jvelandia/modeladoarquitectura:v1

docker run -p 7593:8080 -d --name tomcat8 tomcat8
