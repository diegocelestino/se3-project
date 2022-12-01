software-engineering-3-final-project Final project for the software engineering 3 class on IFSP. Teacher: Ugo Henrique

##Project Description: 
O código aqui presente representa um sistema criado para a disciplina de Engenharia de Software 3, válida pelo quadro do terceiro semestre do curso Tecnólogo em Análise e Desenvolvimento de Sistemas do Instituto Federal de Educação, Ciência e Tecnologia. 

![Classes diagram](https://github.com/diegocelestino/se3-project/blob/master/software-engineering-3-project-Diagrama%20de%20Classes%20do%20Sistema.jpg)

A ideia do presente trabalho é simular um sistema de uma empresa de bares e eventos, utilizando os conhecimentos adquiridos nos estudos sobre Design Patterns. Ele foi feito utilizando Java e Spring Boot, com todas as requisições http sendo feitas através do Postman.

Esse é um sistema que auxilia no registro e organização de funcionários em uma empresa de bares de eventos. Nele são cadastrados eventos, bares e colaboradores com seus diversos papéis, responsabilidades e pagamentos. 

O uso comum desse sistema é feito pelo administrador da empresa. Em primeiro lugar é necessário o cadastro de Colaboradores, que possuem atributos como nome, documento e chave pix. No papel de Colaboradores, esses cadastros ficam salvos no banco, numa espécie de lista que podem ou não ser adicionados aos eventos, para que assumam o papel de Empregados.

Para o cadastro de Colaborador:<br/> 
Verbo: POST<br/>
URL: http://localhost:8080/api/v1/collaborator<br/>
Corpo: <br/>
{<br/>
    "name":"Alan de Zoka",<br/>
    "cpf":"12332112323",<br/>
    "pix":"adididi@uaheuhueh.com"<br/>
}<br/>

![collaborator request](https://github.com/diegocelestino/se3-project/blob/master/pics/1.jpg)

No momento da criação de um evento, o administrador adiciona as informações pertinentes ao evento como seu nome. Após isso os colaboradores podem ser adicionados à essa lista do evento.

Para o cadastro de Evento:<br/>
Verbo: POST<br/>
URL: http://localhost:8080/api/v1/event<br/>
Corpo:<br/>
{<br/>
    "name":"Bota Fora"<br/>
}<br/>

![event request](https://github.com/diegocelestino/se3-project/blob/master/pics/3.jpg)

Para o cadastro de Bar:<br/>
Verbo: POST<br/>
URL: http://localhost:8080/api/v1/bar<br/>
Corpo: <br/>
{<br/>
    "name":"Ativações",<br/>
    "eventId":"a5ae25af-4be3-4f94-ae16-d12b7f8df298"<br/>
}<br/>
![bar request](https://github.com/diegocelestino/se3-project/blob/master/pics/2.jpg)

Os colaboradores devem receber um papel como Empregados em um momento futuro. No momento desse cadastro, deve ser passado uma string com o role desse novo Empregado. São eles:

COORDINATOR (Coordenador do evento); <br/>
MOUTING (Montagem);<br/>
DEMOUTING (Desmontagem); <br/>
ATTENDANT (Atendente); <br/>
LEADER (Líder de bar);<br/>

![Classes roles](https://github.com/diegocelestino/se3-project/blob/master/pics/4.jpg)

As devidas funções são registradas como um enum Java chamado EmployeeRoles.
Esses enums são essenciais para o sistema poder instanciar as classes corretas utilizando-se dos design patterns devidamente escolhidos para a função de decidir e instaciar essas classes. Cada um desses papéis do enum representa uma classe que existe no sistema e herda de Employee, como no exemplo a seguir:

![Coordinato class](https://github.com/diegocelestino/se3-project/blob/master/pics/12.jpg)

Alguns papéis como COORDINATOR, MOUTING ou DEMOUTING são registrados diretamente no evento, já os papéis restantes ATTENDANT e LEADER são registrados em um bar do evento.

Para o registro no Bar:<br/>
Verbo: POST<br/>
URL:http://localhost:8080/api/v1/staff/registerOnBar<br/>
Corpo:<br/>
{<br/>
    "collaboratorId":"76145bcc-10be-4cb9-be51-ecbcdde16d4e",<br/>
    "barId":"b7c5d643-8041-4a00-a363-ba748c58c7bb",<br/>
    "employeeRole":"ATTENDANT",<br/>
    "pay":100.00<br/>
}

![Register on bar request](https://github.com/diegocelestino/se3-project/blob/master/pics/6.jpg)

Para o registro direto no Evento:<br/>
Verbo: POST<br/>
URL:http://localhost:8080/api/v1/staff/registerOnEvent<br/>
Corpo:<br/>
    "collaboratorId":"4b740704-122f-44c2-b0ad-985757dd4098",<br/>
    "eventId":"a5ae25af-4be3-4f94-ae16-d12b7f8df298",<br/>
    "employeeRole":"COORDINATOR",<br/>
    "pay":100.00<br/>
}

![Register on event request](https://github.com/diegocelestino/se3-project/blob/master/pics/5.jpg)

Essa string é passada para o sistema, que em seus métodos se utiliza dos patterns Chain Of Responsability, Template, Factory e Facade para fazer a instanciação da classe correta e seu devido registro no banco de dados. 

![Register on event request](https://github.com/diegocelestino/se3-project/blob/master/pics/7.jpg)
![Register on event request](https://github.com/diegocelestino/se3-project/blob/master/pics/8.jpg)
![Register on event request](https://github.com/diegocelestino/se3-project/blob/master/pics/9.jpg)
![Register on event request](https://github.com/diegocelestino/se3-project/blob/master/pics/10.jpg)
![Register on event request](https://github.com/diegocelestino/se3-project/blob/master/pics/11.jpg)


Members: Ana Paula Motta. Davi Fernandes Siqueira. Diego Celestino dos Santos. Sarah Santiago.
