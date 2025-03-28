import React from 'react';
import { View, Text, StyleSheet, TouchableOpacity, ImageBackground } from 'react-native';
import { useRouter } from 'expo-router';

const HomeScreen = () => {
  const router = useRouter();

  return (
    <ImageBackground
      source={require('../../assets/images/background.jpg')} // Imagem do fundo
      style={styles.background}
    >
      <View style={styles.container}>
        <Text style={styles.title}>Starcatcher P.F</Text>
        <TouchableOpacity style={styles.button} onPress={() => router.push('/game')}>
          <Text style={styles.buttonText}>Jogar</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.button} onPress={() => console.log('Sair')}>
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
    backgroundColor: 'rgba(0, 0, 0, 0.5)', // Fundo semitransparente sobre a imagem
  },
  title: {
    fontSize: 32,
    fontWeight: 'bold',
    color: '#fff', // Texto na cor branca
    marginBottom: 20,
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

export default HomeScreen;