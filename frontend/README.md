# 🌟 Starcatcher-PF

Este é o frontend da aplicação **Starcatcher-PF**, um jogo interativo de perguntas e respostas sobre astronomia. Desenvolvido com **React Native** e **Expo**, o frontend proporciona uma experiência de usuário dinâmica e fluida, conectando-se ao backend para obter dados como perguntas e validar respostas.

---

## 📋 Índice
- [✨ Funcionalidades](#-funcionalidades)
- [🧰 Ferramentas e Tecnologias Utilizadas](#-ferramentas-e-tecnologias-utilizadas)
- [📂 Estrutura do Projeto](#-estrutura-do-projeto)
- [💻 Pré-requisitos](#-pré-requisitos)
- [⚙️ Como Configurar o Frontend](#-como-configurar-o-frontend)
- [🚀 Como Executar o Frontend](#-como-executar-o-frontend)
- [🖼️ Funcionalidades Detalhadas](#-funcionalidades-detalhadas)
- [📖 Licença](#-licença)
- [📌 Notas Finais](#-notas-finais)

---

## ✨ Funcionalidades

### 📌 **Tela Inicial (HomeScreen)**
- Apresenta o nome do jogo.
- Permite iniciar o jogo ou sair do aplicativo.

### 🎮 **Tela de Jogo (GameScreen)**
- Exibe perguntas de múltipla escolha sobre astronomia.
- Mostra feedback visual de respostas corretas ou erradas.
- Permite avançar para a próxima pergunta após uma resposta ser selecionada.
- Calcula e exibe a pontuação acumulada.

### 🏆 **Tela de Resultados (ResultScreen)**
- Mostra o número de respostas corretas e o total de perguntas respondidas.
- Oferece opções para jogar novamente ou sair.

---

## 🧰 Ferramentas e Tecnologias Utilizadas

- **React Native** – Framework para criação de aplicativos móveis multiplataforma.
- **Expo** – Plataforma que simplifica o desenvolvimento e teste de apps React Native.
- **TypeScript** – Superset do JavaScript que adiciona tipagem estática para maior confiabilidade.
- **Expo Router** – Sistema de roteamento baseado em arquivos para organização das telas.
- **Axios** – Biblioteca para requisições HTTP, usada para comunicação com o backend.
- **React Navigation** – Gerenciamento de navegação entre as telas do aplicativo.
- **React Native Reanimated** – Biblioteca para animações fluidas e interativas.
- **Expo Haptics** – Adiciona feedback tátil para melhorar a experiência do usuário.

---

## 📂 Estrutura do Projeto

```plaintext
frontend/
├── app/                        # Roteamento e telas do app
│   ├── _layout.tsx             # Layout principal (Expo Router)
│   ├── index.tsx               # Tela inicial (HomeScreen)
│   ├── game.tsx                # Tela do jogo (GameScreen)
│   ├── result.tsx              # Tela de resultados (ResultScreen)
│   └── screens/                # Diretório com as telas do app
│       ├── HomeScreen.tsx
│       ├── GameScreen.tsx
│       └── ResultScreen.tsx
├── assets/                     # Imagens e fontes do projeto
│   ├── images/                 # Imagens como plano de fundo e ícones
│   └── fonts/                  # Fontes personalizadas (se necessário)
├── components/                 # Componentes reutilizáveis
│   ├── ui/                     # Componentes de interface (botões, ícones, etc.)
│   ├── Collapsible.tsx         # Componente de colapsar conteúdo
│   ├── ThemedText.tsx          # Componente de texto estilizado
│   └── ThemedView.tsx          # Componente de layout estilizado
├── constants/                  # Definições de cores e temas
│   └── Colors.ts
├── src/                        # Código-fonte adicional
│   ├── services/               # Comunicação com o backend
│   │   └── api.ts              # Serviço para requisições HTTP
│   ├── hooks/                  # Hooks personalizados
│   │   └── useThemeColor.ts    # Hook para gerenciar cores temáticas
│   └── navigation/             # Tipos de navegação
├── package.json                # Configuração de dependências e scripts
├── tsconfig.json               # Configuração do TypeScript
└── app.json                    # Configuração do Expo
```

---

## 💻 Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- **Node.js** – Para gerenciar dependências do projeto.
- **Expo CLI** – Para executar e testar o aplicativo.
- **Emulador Android/iOS** ou dispositivo físico com o aplicativo **Expo Go** instalado.

---

## ⚙️ Como Configurar o Frontend

Clone o repositório:

```bash
git clone https://github.com/seu-usuario/starcatcher-pf.git
cd starcatcher-pf/frontend
```

Instale as dependências:

```bash
npm install
```

Configure a URL do backend no arquivo `src/services/api.ts`:

```typescript
const api = axios.create({
  baseURL: 'http://192.168.15.48:8080/api', // Substitua pelo IP do backend
});
```

---

## 🚀 Como Executar o Frontend

Inicie o servidor de desenvolvimento do Expo:

```bash
npm start
```

Execute o aplicativo:

- Escaneie o QR Code com o aplicativo **Expo Go**.
- Ou utilize um **emulador Android/iOS** configurado.

---

## 📖 Licença

Este projeto está licenciado sob a **Apache License 2.0**. Consulte o arquivo `LICENSE` para mais detalhes.

---

## 📌 Notas Finais

- Este frontend foi projetado para funcionar em conjunto com o **backend do Starcatcher-PF**.
- Certifique-se de que o backend esteja em execução antes de iniciar o frontend.
- Sinta-se à vontade para contribuir com melhorias, relatando problemas ou sugerindo novas funcionalidades. 🚀