import React from 'react';
import { View, Text, StyleSheet, TouchableOpacity, BackHandler, ImageBackground } from 'react-native';
import { useRouter, useLocalSearchParams } from 'expo-router';

const ResultScreen = () => {
  const router = useRouter();

  // Use o hook `useLocalSearchParams` para obter os parâmetros da rota
  const { score, total } = useLocalSearchParams() as { score: string; total: string };

  // Converta os valores para números, se necessário
  const numericScore = parseInt(score, 10);
  const numericTotal = parseInt(total, 10);

  return (
    <ImageBackground
      source={require('../../assets/images/background.jpg')} // Imagem de fundo
      style={styles.background}
    >
      <View style={styles.container}>
        <Text style={styles.title}>Resultado</Text>
        <Text style={styles.text}>Você acertou {numericScore} de {numericTotal} perguntas!</Text>
        <TouchableOpacity style={styles.button} onPress={() => router.push('/game')}>
          <Text style={styles.buttonText}>Jogar Novamente</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.button} onPress={() => BackHandler.exitApp()}>
          <Text style={styles.buttonText}>Sair</Text>
        </TouchableOpacity>
      </View>
    </ImageBackground>
  );
};

const styles = StyleSheet.create({
  background: {
    flex: 1, // Ocupa toda a tela
    resizeMode: 'cover', // Redimensiona para cobrir a tela
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'rgba(0, 0, 0, 0.5)', // Fundo semitransparente para melhorar a legibilidade
  },
  title: {
    fontSize: 32,
    fontWeight: 'bold',
    color: '#fff', // Texto na cor branca
    marginBottom: 20,
  },
  text: {
    fontSize: 18,
    color: '#fff', // Texto na cor branca
    marginVertical: 10,
  },
  button: {
    backgroundColor: '#fff', // Botão com fundo branco
    padding: 15,
    borderRadius: 10,
    marginVertical: 10,
    width: 200,
    alignItems: 'center',
  },
  buttonText: {
    color: '#000', // Texto do botão na cor preta
    fontSize: 18,
    fontWeight: 'bold',
  },
});

export default ResultScreen;