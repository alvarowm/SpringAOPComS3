<h1 align="center"> Spring AOP com S3 </h1>

<p align="justify"> Usando programação orientada à aspectos é criado um bucket no AWS S3. </p>

<p align="justify">A programação orienteda à aspectos ou AOP cria pontos onde chamadas de métodos que serão inseridas sem a chamada explicita, ou seja, sem o acoplamento.

  A AOP pode ser usada para diminuir a dependência com os cross-cutting concerns que são partes do sistemas que permeiam toda a aplicação e não se comportam de maneira adequada e uniforme quando de trata de programação orientada a objetos ou procedural.

Ex: Logs.

Esse exemplo direciona um log ao S3, mas é possível usar qualquer outro serviço AWS ou de qualqer outro CSP (Cloud Service Provider).</p>


Como rodar:

```
Criar uma conta IAM na AWS para fazer os acessos.
```

```
Dê a permissão Programmatic access para ele.
```

```
Criar um arquivo cahamdo credentials e colocar dentro do diretório do usuário na pasta .aws.
Ex: ~/.aws/credentials
```

```
Modificar o .properties com sua senha.
```

```
Execute via classe principal ou Maven.
```


