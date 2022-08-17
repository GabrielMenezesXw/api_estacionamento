

Antes de tudo, alterar o application.properties para que consiga acessar tudo corretamente na linha 4, que seria essa 
logo abaixo.
```code
spring.datasource.password= alterar senha!
```

Depois disso, criar banco de dados da seguinte forma e com o seguinte nome

```sql
DROP DATABASE PROJETO_LP2;

CREATE DATABASE PROJETO_LP2;

USE PROJETO_LP2;
```

o projeto já tem arquivos .sql que inserem dados no  banco logo que a api é
inicializada, por isso a importancia de tudo isso.

para acessar e testar a api, utilize a seguinte url :

```link
http://localhost:8080/swagger-ui/index.html
```