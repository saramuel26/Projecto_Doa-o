🌟 Aplicativo de Gestão de Doações Comunitárias








Desenvolvido por: Sara Samuel
Curso: Ciências da Computação - 3º Ano
Disciplina: Programação V
Professor: Msc. Helmer de J. Fumuassuca Capassola
Instituição: Instituto Superior Politécnico Metropolitano de Angola

📖 Resumo do Projeto

O aplicativo tem como objetivo organizar e gerenciar doações para comunidades carentes. Ele permite o registro de doadores, itens doados e acompanhamento de distribuições. Além disso, oferece transparência e sincronização em tempo real via API desenvolvida em Kotlin.

Registro centralizado de doações

Controle de estoque

Busca eficiente por categorias

Acompanhamento detalhado de cada doação

Sincronização com backend via API

🛠 Tecnologias Utilizadas

Kotlin – Linguagem principal

Jetpack Compose – Construção de interfaces modernas e reativas

Room Database – Persistência local de dados

Coroutines – Programação assíncrona

Navigation Component – Navegação entre telas

Material Design 3 – Sistema de design

MVVM Architecture – Organização do código

API Kotlin – Backend para sincronização de dados

📱 Funcionalidades
Telas Principais

Splash Screen

Animação de entrada e logo do app

Transição automática para login

Tela de Login

Autenticação de usuários

Validação de campos obrigatórios

Mensagens de erro personalizadas

Tela de Cadastro

Registro de novos usuários

Verificação de username/email únicos

Validação de senha

Home (Tela Principal)

Listagem de doações em cards

Contador de doações registradas

Opção de exclusão

Navegação para telas de cadastro e busca

Cadastro de Doação

Formulário completo: Doador, Item, Categoria, Quantidade, Descrição

Upload de fotos opcionais

Envio para API com sincronização

Tela de Busca

Pesquisa em tempo real

Filtragem por doador, item ou categoria

Contador de resultados

🏛 Arquitetura MVVM


⚙️ Instalação


Abra o projeto no Android Studio

Sincronize as dependências do Gradle

Configure o arquivo api/BaseUrl.kt com o endpoint da API

Rode o app em um dispositivo ou emulador


🌐 Exemplos de Requisições à API

Registrar Doação (POST)

POST /api/doacoes
Content-Type: application/json

{
  "doador": "Maria Silva",
  "item": "Roupas",
  "categoria": "Vestuário",
  "quantidade": 10,
  "descricao": "Roupas de inverno para crianças"
}

Buscar Doações (GET)

GET /api/doacoes?categoria=Alimentos

Autenticação de Usuário (POST)

POST /api/usuarios/login
Content-Type: application/json

{
  "email": "usuario@email.com",
  "senha": "senha123"
}
