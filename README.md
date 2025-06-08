# API de Pagamentos 💳

## 📌 Sobre o Projeto
Esta API permite gerenciar pagamentos de maneira eficiente, seguindo padrões REST e boas práticas de desenvolvimento com **Spring Boot**.

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database**
- **Maven**

## 🛠 Configuração e Execução

### 1️⃣ **Clonar o Repositório**

git clone https://github.com/seuusuario/api-pagamentos.git
cd api-pagamentos

### #️⃣ **Configurar Banco de Dados (H2)**

spring.datasource.url=jdbc:h2:mem:pagamentos
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true

Para acessar o console H2, entre em:
http://localhost:8080/h2-console

🔗 Rotas da API

| Método | Endpoint | Descrição | 
| GET | /pagamentos | Lista os pagamentos ativos | 
| POST | /pagamentos | Registra um novo pagamento | 
| PUT | /pagamentos/{id}/status | Atualiza o status do pagamento | 
| DELETE | /pagamentos/{id} | Inativa um pagamento pendente | 


🔹 Exemplo de Requisição POST
{
    "codigoDebito": 1012,
    "cpfCnpj": "98752322720",
    "metodoPagamento": "CARTAO_CREDITO",
    "numeroCartao": "456478971231",
    "valor": 500.00
}

📌 Padrões de Projeto
✔ Strategy → Validação de métodos de pagamento
✔ Factory → Criação de objetos Pagamento
✔ State → Gerenciamento de status do pagamento
